package kr.hs.dgsw.java.dept23.d0519;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Divider {

    private final Scanner scanner;
    private File file;
    private FileWriter fw;
    private PrintWriter pw;

    public Divider() {
        scanner = new Scanner(System.in);
    }

    public int calculate(int value1, int value2) {
        return value1 / value2;
    }

    public void execute() {
        try {
            System.out.println("두 정수를 입력하세요.");

            int value1 = scanner.nextInt();
            int value2 = scanner.nextInt();

            int result = calculate(value1, value2);
            System.out.printf("%d / %d = %d\n", value1, value2, result);

            // 계산식과 결과를 파일로 저장한다.
            saveResult("/Users/choiminjae/공부/fileStudy/divide.txt", value1, value2, result);

            scanner.close();

            System.out.println("프로그램을 종료합니다.");
        } catch (InputMismatchException e) {
            System.out.println("문자가 아닌 숫자를 입력하세요!");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 쓰기에 실패하였습니다.");
        } finally {
            if (pw != null) {
                pw.close();
            }
            scanner.close();
        }

        /*catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("문자가 아닌 숫자를 입력하세요!");
            } else if(e instanceof ArithmeticException) {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }*/
    }

    public void saveResult(String uri, int value1, int value2, int result) throws IOException {
        file = new File(uri);
        if (!file.exists()) {
            file.createNewFile();
        }

        fw = new FileWriter(file, true);
        pw = new PrintWriter(fw);

        pw.println("%d / %d = %d".formatted(value1, value2, result));
    }

    public static void main(String[] args) {
        Divider divider = new Divider();
        divider.execute();
    }
}
