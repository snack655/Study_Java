package kr.hs.dgsw.phone.execute;

import kr.hs.dgsw.phone.base.BaseExecute;
import java.io.*;
import java.util.*;

public class Execute extends BaseExecute {

    Execute() throws IOException {
        super();
    }

    public void execute() throws IOException {
        printUtil.showCommand();
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
                    info.addMyInfo(true);
                    break;
                }
                case 2: {
                    search.searchWithName();
                    break;
                }
                case 3: {
                    search.searchWithPhone();
                    break;
                }
                case 4: {
                    remove.removeWithName();
                    break;
                }
                case 5: {
                    printUtil.showCommand();
                    break;
                }
                case 6: {
                    info.printInfo();
                    break;
                }
                default: {
                    System.out.println("해당하는 명령어가 없습니다. 다시 시도해주세요.");
                    printUtil.showCommand();
                    break;
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            Execute execute = new Execute();
            execute.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

