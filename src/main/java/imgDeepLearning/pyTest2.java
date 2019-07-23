package imgDeepLearning;

import java.io.File;
import java.io.FileNotFoundException;

import org.python.util.PythonInterpreter;
import org.springframework.util.ResourceUtils;

public class pyTest2 {
	
	private static PythonInterpreter interp;

	public static void main(String[] args) {
		File file;
		try {
			file = ResourceUtils.getFile("classpath:jython/test.py");
		
        
		interp = new PythonInterpreter();				
		interp.execfile(file.getPath());
		interp.exec("print(sum(7,8))");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
