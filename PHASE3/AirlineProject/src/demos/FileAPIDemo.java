package demos;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAPIDemo {

	public static void main(String[] args) {

		Path helloPath = Path.of("hello.txt");

		try {
			Path pathTemp = Files.createFile(helloPath);

			boolean fileExist = Files.exists(helloPath);

			System.out.println(fileExist);

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			Charset charset = Charset.forName("ISO-8859-3");
			Files.writeString(helloPath, "Great Sunday", charset);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		//Files.re

	}

}
