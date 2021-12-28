import java.util.List;

public class ConsoleView implements View {
	@Override
	public void print(String line) {
		System.out.println(line);
	}
	
	@Override
	public void print(List<String> text) {
		text.forEach(System.out::println);
	}
}
