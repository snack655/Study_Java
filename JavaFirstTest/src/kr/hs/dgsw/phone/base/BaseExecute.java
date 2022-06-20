package kr.hs.dgsw.phone.base;

import kr.hs.dgsw.phone.features.remove.Remove;
import kr.hs.dgsw.phone.features.search.Search;
import kr.hs.dgsw.phone.model.Info;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.io.IOException;
import java.util.Scanner;

public abstract class BaseExecute {
    protected PrintUtil printUtil;
    protected final Scanner scanner;
    protected Info info;
    protected Search search;
    protected Remove remove;

    public BaseExecute() {
        printUtil = new PrintUtil();
        scanner = new Scanner(System.in);
        info = new Info(scanner, printUtil);
        search = new Search(scanner, printUtil, info);
        remove = new Remove(scanner, printUtil, info);
    }

    abstract public void execute() throws IOException;
}
