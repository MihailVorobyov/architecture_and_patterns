public class StartCommandLine {
	
	public static void main(String[] args) {
		
		View view = new ConsoleView();
		Model model = new ModelImpl(view);
		ControllerImpl controller = new ControllerImpl(view, model);
		
		controller.start();
	}
}
