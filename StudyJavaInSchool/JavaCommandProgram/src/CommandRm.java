import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class CommandRm extends AbstractCommand {
    private final Scanner scanner;

    public CommandRm(File currentDirectory, String commandLine) {
        super(currentDirectory, commandLine);
        scanner = new Scanner(System.in);
    }


    @Override
    public File executeCommand() {
        String[] commands = commandLine.split(" ");
        File file;
        try {
            file = new File(currentDirectory + File.separator + commands[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("명령어 형식이 잘못되었습니다.");
            return currentDirectory;
        }

        if (!askDelete())
            return currentDirectory;

        if(file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();

                if (files == null)
                    return currentDirectory;

                for (File entry : files)
                    if (!entry.delete())
                        System.out.println(entry.getName() + " 삭제 실패");
            }
            if (!file.delete())
                System.out.println("파일 삭제 실패");
        } else{
            System.out.println("파일을 찾을 수 없습니다.");
        }
        return currentDirectory;
    }

    private boolean askDelete() {
        System.out.print("정말로 삭제하시겠습니까?(y/n) : ");
        String answer = scanner.next();
        return answer.toLowerCase(Locale.ROOT).equals("y");
    }
}
