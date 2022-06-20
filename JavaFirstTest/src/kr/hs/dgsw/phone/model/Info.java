package kr.hs.dgsw.phone.model;

import kr.hs.dgsw.phone.utils.Constants;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.io.*;
import java.util.*;

public class Info {
    private final Scanner scanner;
    private final File file;
    private final PrintUtil printUtil;

    public Info(Scanner scanner, PrintUtil printUtil) {
        this.scanner = scanner;
        this.printUtil = printUtil;
        file = new File(Constants.filePath);
    }

    /**
     * 전화번호부에 정보 등록
     * 등록 형식 : 이름::전화번호\n
     */
    public void addMyInfo() throws IOException {
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("전화번호 : ");
        String phoneNumber = scanner.next();

        System.out.println(name + " " + phoneNumber);
        writeFile(name, phoneNumber);
        System.out.println("저장되었습니다.\n");
    }


    public void initFile() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(file, false), true);
        pw.print("");
        pw.close();
    }

    /**
     * 파일에 작성
     * @param name 이름
     * @param phone 전화번호
     */
    public void writeFile(String name, String phone) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(file, true), true);
        pw.println(name + Constants.DIVISION + phone);
        pw.close();
    }

    public List<String> readFile() throws IOException {
        List<String> infoList = new ArrayList<>();
        BufferedReader br = initBufferedReader();
        String line;
        while ((line = br.readLine()) != null) {
            infoList.add(line);
        }
        return infoList;
    }

    public void printInfo() throws IOException {
        BufferedReader br = initBufferedReader();
        String line;
        Map<String, String> info = new HashMap<>();
        while((line = br.readLine()) != null) {
            String[] elements = line.split(Constants.DIVISION);
            info.put(elements[1], elements[0]);
        }
        printUtil.printSortedMapByValue(info);
        br.close();
    }

    private BufferedReader initBufferedReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }
}
