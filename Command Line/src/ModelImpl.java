import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ModelImpl implements Model {
	
	private final View view;
	
	public ModelImpl(View view) {
		this.view = view;
	}
	
	@Override
	public void listCurrentDirectory(Path path) {
		File file = path.toFile();
		if (file.exists() && file.isDirectory()) {
			view.print(Arrays.stream(Objects.requireNonNull(file.list())).collect(Collectors.toList()));
		} else {
			view.print("\n");
		}
	}
	
	@Override
	public void readFile(Path path) throws IOException {
		BufferedReader br = null;
		FileReader fr = null;
		
		File file = path.toFile();
		
		try {
			if (file.exists() && !path.toFile().isDirectory()) {

				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				if (br.ready()) {
					view.print(br.lines().collect(Collectors.toList()));
				}
				
			} else view.print("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
