package kr.hs.dgsw.phone.features.search;

import kr.hs.dgsw.phone.utils.Constants;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Search {
    private final Scanner scanner;
    private final PrintUtil printUtil;

    public Search(Scanner scanner, PrintUtil printUtil) {
        this.scanner = scanner;
        this.printUtil = printUtil;
    }

    public void searchWithName() throws IOException {
        System.out.print("검색하실 이름을 입력해주세요 : ");
        String name = scanner.next().toLowerCase(Locale.ROOT);
        findInformation(name, 0);
    }

    public void searchWithPhone() throws IOException {
        System.out.print("검색하실 전화번호를 입력해주세요 : ");
        String phone = scanner.next();
        findInformation(phone, 1);
    }

    /**
     * 정보를 입력받아 파일에서 같은 정보를 포함하고 있는 라인 찾기
     */
    private void findInformation(String hint, int type) throws IOException {
        br = initBufferedReader();

        // 전화번호 - 이름
        info = new HashMap<>();

        boolean isContain = false;
        String line;

        while ((line = br.readLine()) != null) {
            String[] elements = line.split(Constants.DIVISION);
            if (elements[type].toLowerCase(Locale.ROOT).contains(hint)) {
                info.put(elements[1], elements[0]);
                isContain = true;
            }
        }
        if (!isContain) {
            System.out.println("검색하신 정보가 존재하지 않습니다..\n");
            return;
        }
        printUtil.printSortedMapByValue(info);
        System.out.println();
        br.close();
    }


}
