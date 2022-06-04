package kr.hs.dgsw.phone;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, Info> infoMap = new HashMap<>();

    public PhoneBook(String name, String phoneNumber) {
        Info info = new Info(name, phoneNumber);
        infoMap.put(name, info);
    }

    public static void main(String[] args) {
        
    }
}
