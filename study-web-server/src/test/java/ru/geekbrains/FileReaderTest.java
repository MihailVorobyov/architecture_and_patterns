package ru.geekbrains;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReaderTest {
	
	@Test
	public void testFileReading() {
		Path path = Paths.get("src/test/test-www/test-page.html");
		FileReader reader = new FileReader();
		
		Assert.assertEquals("<h1>TestPage</h1>", reader.readFile(path));
	}
}
