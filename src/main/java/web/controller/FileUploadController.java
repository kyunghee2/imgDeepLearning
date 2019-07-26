package web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value = "/api/imgupload.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> imgUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		String fileName = file.getOriginalFilename();
		String detailpath = "/upload/";

		try {
			String path = request.getRealPath(detailpath);

			File destdir = new File(path);
			System.out.println(path);

			if (!destdir.exists()) {
				destdir.mkdirs();
			}

			File f = new File(path + fileName);

			if (!file.isEmpty()) {				
				if (f.exists()) {
					UUID uuid = UUID.randomUUID();
					fileName = uuid.toString() + fileName;
					f = new File(path + fileName);
				}
			}

			file.transferTo(f);
			System.out.println(f.getPath());
			String msg = imgPredict(f.getPath());
			System.out.println("업로드 완료");
			map.put("status", "1");
			map.put("resultMsg", msg);

		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "0");
		}

		return map;

	}

	private String imgPredict(String imgPath) throws Exception {
		File file;
		file = ResourceUtils.getFile("classpath:jython/imgPredict.py");
		String model_path = ResourceUtils.getFile("classpath:model").getPath();

		System.out.println(">>" + file.getPath());
		String[] cmd = { "C:\\\\ProgramData\\Anaconda3\\python.exe", file.getPath(),model_path, imgPath };

		Process p = Runtime.getRuntime().exec(cmd);

		BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = bfr.readLine()) != null) {
			System.out.println(line);
			sb.append(line);
		}
		return sb.toString();
	}
}
