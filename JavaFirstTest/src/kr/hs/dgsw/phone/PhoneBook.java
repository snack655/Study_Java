package kr.hs.dgsw.phone;

interface PhoneBook {

    void addMyInfo(String name, String phoneNumber);

    void searchWithName();

    void searchWithPhone();

    void removeWithName();

    void execute();

}
