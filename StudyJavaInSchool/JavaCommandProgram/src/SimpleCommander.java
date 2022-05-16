import java.io.File;
import java.util.Scanner;

public class SimpleCommander {
	
	protected final Scanner scanner;
	
	protected File currentDirectory;
	
	public SimpleCommander() {
		this.scanner = new Scanner(System.in);
		this.currentDirectory = new File("C:/");
	}

	public void execute() {
		
		System.out.println("Simple commander started");

		/* Loop */
		AbstractCommand command = null;
		while (true) {
			/* Prompt */
			this.showPrompt();
			
			/* Command ��� */
			try {
				command = receiveCommand();
			} catch (Exception e) {
				System.out.println("Invalid command");
				continue;
			}
			
			this.currentDirectory = command.executeCommand();

			if (command.isExitCondition()) {
				break;
			}
		}
		
		this.scanner.close();

		System.out.println("Simple commander terminated");
	}
	
	protected AbstractCommand receiveCommand() throws UnknownCommandException {
		String line = this.scanner.nextLine();
		return AbstractCommand.build(this.currentDirectory, line);
	}
	
	protected void showPrompt() {
		StringBuilder buffer = new StringBuilder();
		
		String path = this.currentDirectory.getAbsolutePath();
		
		buffer.append(path);
		buffer.append("> ");
		
		System.out.print(buffer.toString());
	}
	
}
