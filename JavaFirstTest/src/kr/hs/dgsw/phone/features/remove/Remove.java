package kr.hs.dgsw.phone.features.remove;

import kr.hs.dgsw.phone.base.BaseFeatures;
import kr.hs.dgsw.phone.model.Info;
import kr.hs.dgsw.phone.utils.Constants;
import kr.hs.dgsw.phone.utils.PrintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Remove extends BaseFeatures {

    public Remove(Scanner scanner, PrintUtil printUtil, Info info) {
        super(scanner, printUtil, info);
    }

    public void removeWithName() throws IOException {
        List<String> removeInfoList = new ArrayList<>();
        List<String> infoList = info.readFile();

        System.out.print("삭제할 정보의 이름을 입력해주세요 : ");
        String name = scanner.next();

        // 정보를 읽으며 삭제할 파일을 본다.
        for (String line : infoList) {
            String[] elements = line.split(Constants.DIVISION);
            if (Objects.equals(elements[0], name))
                removeInfoList.add(line);
        }

        long lineSize = removeInfoList.size();
        if (lineSize == 0) {
            // 같은 이름의 정보가 없는 경우
            System.out.println("해당하는 이름을 찾을 수 없습니다.");
        } else if (lineSize == 1) {
            // 같은 이름의 정보가 하나 있는 경우
            String[] elements = removeInfoList.get(0).split(Constants.DIVISION);
            reWriteFile(elements[1], infoList);
        } else {
            // 같은 이름의 정보가 2개 이상있는 경우
            for (String removeInfo : removeInfoList) {
                String[] elements = removeInfo.split(Constants.DIVISION);
                System.out.println("[이름 : " + elements[0] + " 전화번호 : " + elements[1] + "]");
            }
            System.out.println("무슨 정보를 삭제하시겠습니까?");
            System.out.print("전화번호를 입력해주세요 : ");
            String phone = scanner.next();
            reWriteFile(phone, infoList);
        }
    }

    private void reWriteFile(String phone, List<String> infoList) throws IOException {
        boolean isRemove = false;
        for (String s: infoList) {
            String[] elements = s.split(Constants.DIVISION);
            if (!Objects.equals(elements[1], phone))
                info.writeFile(elements[0], elements[1], false);
            else {
                System.out.println("[이름 : " + elements[0] + " 전화번호 : " + elements[1] + "] 을 삭제합니다.");
                isRemove = true;
            }
        }
        if (!isRemove) {
            System.out.println("해당하는 정보가 없습니다.");
            return;
        }
        System.out.println("삭제가 완료되었습니다!");
    }
}
