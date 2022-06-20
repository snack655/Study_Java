package kr.hs.dgsw.phone.features.search;

import kr.hs.dgsw.phone.base.BaseFeatures;
import kr.hs.dgsw.phone.model.Info;
import kr.hs.dgsw.phone.utils.Constants;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.io.IOException;
import java.util.*;

public class Search extends BaseFeatures {

    public Search(Scanner scanner, PrintUtil printUtil, Info info) {
        super(scanner, printUtil, info);
    }

    public void searchWithName() throws IOException {
        System.out.print("검색하실 이름을 입력해주세요 : ");
        String name = scanner.next().toLowerCase(Locale.ROOT);
        findInformation(name, Type.NAME.getValue());
    }

    public void searchWithPhone() throws IOException {
        System.out.print("검색하실 전화번호를 입력해주세요 : ");
        String phone = scanner.next();
        findInformation(phone, Type.PHONE.getValue());
    }

    /**
     * 정보를 입력받아 파일에서 같은 정보를 포함하고 있는 라인 찾기
     */
    private void findInformation(String hint, int type) throws IOException {
        List<String> infoList = info.readFile();

        Map<String, String> infoMap = new HashMap<>();
        boolean isContain = false;

       for(String line : infoList) {
            String[] elements = line.split(Constants.DIVISION);
            if (elements[type].toLowerCase(Locale.ROOT).contains(hint)) {
                infoMap.put(elements[1], elements[0]);
                isContain = true;
            }
        }
        if (!isContain) {
            System.out.println("검색하신 정보가 존재하지 않습니다..\n");
            return;
        }
        printUtil.printSortedMapByValue(infoMap);
        System.out.println();
    }
}
