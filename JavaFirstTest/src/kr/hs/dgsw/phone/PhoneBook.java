package kr.hs.dgsw.phone;

import java.io.*;
import java.util.*;

public class PhoneBook implements BasePhoneBook {
    private final Scanner scanner;
    private final File file;
    private final PrintWriter pw;
    private Map<String, String> info;
    public static final String DIVISION = "::";
    private final String filePath = "/Users/choiminjae/Study/Sample/PhoneBook";
    private BufferedReader br;

    PhoneBook() throws IOException {
        scanner = new Scanner(System.in);
        file = new File(filePath);
        pw = new PrintWriter(new FileWriter(file, true), true);
    }

    /**
     * 전화번호부에 정보 등록
     * 등록 형식 : 이름::전화번호\n
     */
    @Override
    public void addMyInfo() {
        System.out.print("이름 : ");
        String name = scanner.next();
        System.out.print("전화번호 : ");
        String phoneNumber = scanner.next();

        System.out.println(name + " " + phoneNumber);
        pw.println(name + DIVISION + phoneNumber);
        System.out.println("저장되었습니다.\n");
    }

    @Override
    public void searchWithName() throws IOException {
        System.out.print("검색하실 이름을 입력해주세요 : ");
        String name = scanner.next().toLowerCase(Locale.ROOT);
        findInformation(name, 0);
    }

    @Override
    public void searchWithPhone() throws IOException {
        System.out.print("검색하실 전화번호를 입력해주세요 : ");
        String phone = scanner.next();
        findInformation(phone, 1);
    }

    /**
     * 정보를 입력받아 파일에서 같은 정보를 호함하고 있는 라인 찾기
     */
    private void findInformation(String hint, int type) throws IOException {
        br = initBufferedReader();

        // 전화번호 - 이름
        info = new HashMap<>();

        boolean isContain = false;
        String line;

        while ((line = br.readLine()) != null) {
            String[] elements = line.split(DIVISION);
            if (elements[type].toLowerCase(Locale.ROOT).contains(hint)) {
                info.put(elements[1], elements[0]);
                isContain = true;
            }
        }
        if (!isContain) {
            System.out.println("검색하신 정보가 존재하지 않습니다..\n");
            return;
        }
        printSortedMapByValue(info);
        System.out.println();
        br.close();
    }

    private void printSortedMapByValue(Map info) {
        List<Map.Entry<String, String>> entryList = new LinkedList<>(info.entrySet());
        entryList.sort(Map.Entry.comparingByValue()); 
        for(Map.Entry<String, String> entry: entryList)
            System.out.println("이름 : " + entry.getValue() + "     전화번호 : "+entry.getKey());
    }

    @Override
    public void removeWithName() throws IOException {
        br = initBufferedReader();
        List<String> removeInfoList = new ArrayList<>();
        List<String> infoList = new ArrayList<>();

        System.out.print("삭제할 정보의 이름을 입력해주세요 : ");
        String name = scanner.next();
        String line;
        // 파일을 읽으며 정보를 리스트 형태로 저장한다.
        while ((line = br.readLine()) != null) {
            String[] elements = splitInfo(line);
            if (Objects.equals(elements[0], name))
                removeInfoList.add(line);
            infoList.add(line);
        }

        long lineSize = removeInfoList.size();
        if (lineSize == 0) {
            // 같은 이름의 정보가 없는 경우
            System.out.println("해당하는 이름을 찾을 수 없습니다.");
        } else if (lineSize == 1) {
            // 같은 이름의 정보가 하나 있는 경우
            String[] elements = splitInfo(removeInfoList.get(0));
            reWriteFile(elements[1], infoList);
        } else {
            // 같은 이름의 정보가 2개 이상있는 경우
            for (int i = 0; i < lineSize; i++) {
                String[] elements = splitInfo(removeInfoList.get(i));
                System.out.println("[이름 : " + elements[0] + " 전화번호 : " + elements[1] + "]");
            }
            System.out.println("무슨 정보를 삭제하시겠습니까?");
            System.out.print("전화번호를 입력해주세요 : ");
            String phone = scanner.next();
            reWriteFile(phone, infoList);
        }
        br.close();
    }

    private void reWriteFile(String phone, List<String> infoList) throws IOException {
        PrintWriter newPw = new PrintWriter(new FileWriter(file), true);
        boolean isRemove = false;
        for (String info: infoList) {
            String[] elements = splitInfo(info);
            if (!Objects.equals(elements[1], phone))
                newPw.println(info);
            else {
                System.out.println("[이름 : " + elements[0] + " 전화번호 : " + elements[1] + "] 을 삭제합니다.");
                isRemove = true;
            }
        }
        if (!isRemove)
            System.out.println("해당하는 정보가 없습니다.");
    }

    private BufferedReader initBufferedReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }


    @Override
    public void printInfo() throws IOException {
        br = initBufferedReader();
        String line;
        info = new HashMap<>();
        while((line = br.readLine()) != null) {
            String[] elements = splitInfo(line);
            info.put(elements[1], elements[0]);
        }
        printSortedMapByValue(info);
        br.close();
    }

    private String[] splitInfo(String info) {
        return info.split(DIVISION);
    }

    @Override
    public void execute() throws IOException {
        showCommand();
        while (true) {
            System.out.print("명령어를 입력해주세요 : ");
            int command;
            try {
                command = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("명령어 형식이 잘못되었습니다.");
                break;
            }
            if (command == -1) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (command) {
                case 1: {
                    addMyInfo();
                    break;
                }
                case 2: {
                    searchWithName();
                    break;
                }
                case 3: {
                    searchWithPhone();
                    break;
                }
                case 4: {
                    removeWithName();
                    break;
                }
                case 5: {
                    showCommand();
                    break;
                }
                case 6: {
                    printInfo();
                    break;
                }
                default: {
                    System.out.println("해당하는 명령어가 없습니다. 다시 시도해주세요.");
                    showCommand();
                    break;
                }
            }
        }
        pw.close();
        scanner.close();
    }

    private void showCommand() {
        System.out.println("(1) - 내 정보 등록하기\n" +
                "(2) - 이름으로 전화번호 검색하기\n" +
                "(3) - 전화번호의 일부로 전화번호 검색하기\n" +
                "(4) - 이름으로 전화번호 삭제하기\n" +
                "(5) - 명령어 종류보기\n" +
                "(6) - 전화번호부 정보 출력하기\n" +
                "(-1) - 프로그램 종료");
    }

    public static void main(String[] args) {
        try {
            PhoneBook phoneBook = new PhoneBook();
            phoneBook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
