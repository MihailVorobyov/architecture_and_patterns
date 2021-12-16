package ru.geekbrains;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
	
	public String readFile(Path path) {
		StringBuilder sb = new StringBuilder();
		
		try {
			Files.readAllLines(path).forEach(sb::append);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		
		return sb.toString();
	}
}
