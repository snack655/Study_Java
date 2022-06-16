package kr.hs.dgsw.phone;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBook implements BasePhoneBook {
    private final Scanner scanner;
    private final File file;
    private final PrintWriter pw;

    PhoneBook() throws IOException {
        scanner = new Scanner(System.in);
        file = new File("/Users/choiminjae/Study/Sample/PhoneBook");
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
        pw.println(name + "::" + phoneNumber);
        System.out.println("저장되었습니다.");
    }

    @Override
    public void searchWithName() {

    }

    @Override
    public void searchWithPhone() {

    }

    @Override
    public void removeWithName() {

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
                    System.out.println("이름으로 전화번호 검색하기");
                    break;
                }
                case 3: {
                    System.out.println("전화번호의 일부로 전화번호 검색하기");
                    break;
                }
                case 4: {
                    System.out.println("이름으로 전화번호 삭제하기");
                    break;
                }
                case 5: {
                    showCommand();
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

/**
 * 이름과 전화번호 등록하기 (등록된 데이터는 파일에 저장 - 데이터베이스 사용 금지)
 * 이름으로 전화번호 검색하기 - 이름의 일부분으로 검색 가능해야 하며, 결과가 여러 개일 경우에 모두 보여 줍니다.
 * 전화번호의 일부로 전화번호 검색하기 - 결고가 여러 개일 경우에 모두 보여 줍니다.
 * 이름으로 전화번호 삭제하기 - 이름이 중복되었을 경우, 전화번호를 모두 제시한 뒤 특정한 전화번호를 삭제하게 합니다.
 * 전화번호 수정 기능을 구현하지 않아도 됩니다.
 * 결과가 여러 개일 경우에 이름 순으로 정렬되어 출력되어야 합니다.
 */
