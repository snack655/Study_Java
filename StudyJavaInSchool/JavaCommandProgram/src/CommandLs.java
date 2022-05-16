
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLs extends AbstractCommand {

	public CommandLs(File currentDirectory, String commandLine) {
		super(currentDirectory, commandLine);
	}

	@Override
	public File executeCommand() {
		File[] listFiles = currentDirectory.listFiles();
		for (File file: listFiles) {
			System.out.println(getDateTime(file) + "  " + isDirectory(file) + "    " + String.format("%-7s", getFileSize(file)) + getFileName(file));
		}

		return currentDirectory;
	}

	private String getDateTime(File file) {
		long time = file.lastModified();
		return formatDate(convertToDate(time));
	}

	// 폴더인지 확인한다.
	private String isDirectory(File file) {
		if (file.isDirectory()) {
			return "<DIR>";
		} else {
			return "     ";
		}
	}

	/**
	 * 맥북은 폴더 사이즈도 있기에
	 * 폴더라면 사이즈를 반환하지 않는다.
	 * @param file
	 * @return
	 */
	private String getFileSize(File file) {
		if (file.isDirectory()) {
			return "";
		}
		return String.valueOf(file.length());
	}

	// 파일명을 반환하는 함수
	private String getFileName(File file) {
		return file.getName();
	}

	public String formatDate(Date date) {
		SimpleDateFormat dateFormat =
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public Date convertToDate(long unixTime) {
		return new Date(unixTime);
	}
	
}
