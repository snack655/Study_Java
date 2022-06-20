package kr.hs.dgsw.phone.base;

import kr.hs.dgsw.phone.model.Info;
import kr.hs.dgsw.phone.utils.PrintUtil;

import java.util.Scanner;

public abstract class BaseFeatures {
    protected Scanner scanner;
    protected PrintUtil printUtil;
    protected Info info;

    public BaseFeatures(Scanner scanner, PrintUtil printUtil, Info info) {
        this.scanner = scanner;
        this.printUtil = printUtil;
        this.info = info;
    }
}
