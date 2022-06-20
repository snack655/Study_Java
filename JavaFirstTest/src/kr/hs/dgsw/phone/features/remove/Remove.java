package kr.hs.dgsw.phone.features.remove;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Remove {
    private final Scanner scanner;

    public Remove(Scanner scanner) {
        this.scanner = scanner;
    }

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
}
