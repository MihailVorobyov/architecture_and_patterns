import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ControllerImpl {
	
	private final View view;
	private final Model model;
	
	public ControllerImpl(View view, Model model) {
		this.view = view;
		this.model = model;
	}
	
	public void start() {
		final Path currentPath = FileSystems.getDefault().getRootDirectories().iterator().next();
		
		Scanner scanner = new Scanner(System.in);
		
		view.print("Команды: list <путь>; open <имя файла>");
		view.print(currentPath.toString());
		view.print("Введите команду...");


		while (true) {
			String cp = currentPath.toString();
			Path p;
			
			while (scanner.hasNextLine()) {
				String command = scanner.nextLine();
				scanner.reset();
				
				if (command.startsWith("list")) {
					p = Paths.get(cp);
					model.listCurrentDirectory(p);
				} else if (command.startsWith("open ")) {
					String path = command.replaceFirst("open ", "");
					p = Paths.get(cp, path);
					try {
						model.readFile(p);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
