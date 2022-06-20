package kr.hs.dgsw.phone.model;

import kr.hs.dgsw.phone.utils.Constants;
import kr.hs.dgsw.phone.utils.InfoUtil;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Info {
    private Map<String, String> info;
    private final Scanner scanner;
    private PrintWriter pw;
    private final File file;
    private final InfoUtil infoUtil;
    private final PrintUtil printUtil;

    public Info(Scanner scanner, PrintUtil printUtil) throws IOException {
        this.scanner = scanner;
        this.printUtil = printUtil;
        infoUtil = new InfoUtil();
        file = new File(Constants.filePath);
    }

    /**
     * 전화번호부에 정보 등록
     * 등록 형식 : 이름::전화번호\n
     */
    public void addMyInfo(boolean isAppend) throws IOException {
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("전화번호 : ");
        String phoneNumber = scanner.next();

        System.out.println(name + " " + phoneNumber);
        writeFile(name, phoneNumber, isAppend);
        System.out.println("저장되었습니다.\n");
    }

    /**
     * 파일에 작성
     * @param name
     * @param phone
     * @param isAppend
     * @throws IOException
     */
    public void writeFile(String name, String phone, boolean isAppend) throws IOException {
        pw = new PrintWriter(new FileWriter(file, isAppend), true);
        pw.println(name + Constants.DIVISION + phone);
    }

    public void printInfo() throws IOException {
        BufferedReader br = initBufferedReader();
        String line;
        info = new HashMap<>();
        while((line = br.readLine()) != null) {
            String[] elements = infoUtil.splitInfo(line);
            info.put(elements[1], elements[0]);
        }
        printUtil.printSortedMapByValue(info);
        br.close();
    }

    private BufferedReader initBufferedReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }
}
