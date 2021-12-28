import java.io.IOException;
import java.nio.file.Path;

public interface Model {
	
	void listCurrentDirectory(Path path);
	
	void readFile(Path path) throws IOException;
}
