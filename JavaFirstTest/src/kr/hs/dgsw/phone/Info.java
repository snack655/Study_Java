package kr.hs.dgsw.phone;

public class Info {
    private final String name;
    private final String phoneNumber;

    public Info (String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
