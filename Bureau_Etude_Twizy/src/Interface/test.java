package Interface;

import java.nio.file.Path;
import java.nio.file.Paths;

public class test {

	static Path currentDirPath = Paths.get("");
	public static String currentDir = currentDirPath.toAbsolutePath().toString().replace("\\", "/");

	public static void main(String[] args) {
		System.out.println("sa"+"br");

	}

}
