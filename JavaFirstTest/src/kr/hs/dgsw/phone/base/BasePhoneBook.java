package kr.hs.dgsw.phone.base;

import java.io.IOException;

public interface BasePhoneBook {

    void addMyInfo() throws IOException;

    void searchWithName() throws IOException;

    void searchWithPhone() throws IOException;

    void removeWithName() throws IOException;

    void printInfo() throws IOException;

}
