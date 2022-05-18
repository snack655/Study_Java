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

		return changeUnit(file.length());
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


	/**
	 * 파일 크기를 받아 K, M, G 단위를 붙이는 함수
	 * 숫자는 3자리까지 나타냅니다.
	 * @param fileSize
	 * @return
	 */
	private String changeUnit(long fileSize) {
		int unit = 0;
		String result = "";
		while(true) {
			if (fileSize / 1000 < 1) {
				if (unit == 0)
					result = String.format("%d", fileSize);
				else if (unit == 1)
					result = String.format("%dK", fileSize);
				else if (unit == 2)
					result = String.format("%dM", fileSize);
				else if (unit == 3)
					result = String.format("%dG", fileSize);
				else
					result = String.format("%d", fileSize);

				return result;
			}

			fileSize = fileSize / 1024;
			unit++;
		}
	}
}
