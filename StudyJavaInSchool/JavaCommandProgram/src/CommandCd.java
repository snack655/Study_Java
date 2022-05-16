
import java.io.File;
import java.util.Objects;

public class CommandCd extends AbstractCommand {

	public CommandCd(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		String[] command = commandLine.split(" ");

		if (findDir(command[1])) {
			try {
				return new File(makeDirPath(command[1]));
			} catch (NullPointerException e) {
				System.out.println("cannot find the path");
				return new File(currentDirectory.getAbsolutePath());
			}
		} else {
			System.out.println("cannot find the path");
			return new File(currentDirectory.getAbsolutePath());
		}
	}

	/**
	 * 파일을 생성할 경로를 만드는 함수
	 * .. 이라면 부모의 경로의 반환
	 * @param dirName
	 * @return
	 */
	private String makeDirPath(String dirName) {
		if (Objects.equals(dirName, "..")) {
			return currentDirectory.getParent();
		}
		return currentDirectory.getAbsolutePath() + "/" + dirName;
	}

	/**
	 * 같은 이름의 폴더가 있다면 true 값을 반환하고
	 * 같은 이름의 폴더가 없다면 false 값을 반환
	 *
	 * 기본적으로 파일이라면 false 값을 반환
	 */
	private Boolean findDir(String dirName) {
		if (Objects.equals(dirName, ".."))
			return true;
		for (File dir: Objects.requireNonNull(currentDirectory.listFiles())) {
			if (Objects.equals(dirName, dir.getName())) {
				return dir.isDirectory();
			}
		}
		return false;
	}
}
