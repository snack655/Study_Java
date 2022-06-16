package kr.hs.dgsw.phone;

import java.io.IOException;

interface BasePhoneBook {

    void addMyInfo() throws IOException;

    void searchWithName();

    void searchWithPhone();

    void removeWithName();

    void execute() throws IOException;

}
