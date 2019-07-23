package imgDeepLearning;
import org.python.util.PythonInterpreter;

public class pyTest {

	private static PythonInterpreter interpreter;
	
	public static void main(String[] args) {
		interpreter = new PythonInterpreter();
        interpreter.exec("from java.lang import System");
        interpreter.exec("s = 'Hello World'");
        interpreter.exec("System.out.println(s)");
        interpreter.exec("print(s)");
        interpreter.exec("print(s[1:-1])");

	}

}
