package kr.hs.dgsw.phone.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintUtil {
     public void showCommand() {
        System.out.println("(1) - 내 정보 등록하기\n" +
                "(2) - 이름으로 전화번호 검색하기\n" +
                "(3) - 전화번호의 일부로 전화번호 검색하기\n" +
                "(4) - 이름으로 전화번호 삭제하기\n" +
                "(5) - 명령어 종류보기\n" +
                "(6) - 전화번호부 정보 출력하기\n" +
                "(-1) - 프로그램 종료");
    }

    public void printSortedMapByValue(Map<String, String> info) {
        List<Map.Entry<String, String>> entryList = new LinkedList<>(info.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        for(Map.Entry<String, String> entry: entryList)
            System.out.println("이름 : " + entry.getValue() + "     전화번호 : "+entry.getKey());
    }
}
