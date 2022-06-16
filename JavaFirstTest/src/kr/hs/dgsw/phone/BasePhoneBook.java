package kr.hs.dgsw.phone;

import java.io.IOException;

interface BasePhoneBook {

    void addMyInfo() throws IOException;

    void searchWithName() throws IOException;

    void searchWithPhone() throws IOException;

    void removeWithName();

    void execute() throws IOException;

}
