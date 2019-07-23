package web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
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
	public Map<String, Integer> cloth_add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		Map<String, Integer> map = new HashMap<String, Integer>();
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
				boolean fileexists = f.exists();

				if (fileexists) {
					UUID uuid = UUID.randomUUID();
					fileName = uuid.toString() + fileName;
					f = new File(path + fileName);
				}
			}

			file.transferTo(f);
			System.out.println("업로드 완료");
			map.put("result", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", 0);
		}

		return map;

	}

}
