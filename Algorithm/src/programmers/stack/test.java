package programmers.stack;

interface Category {
    Integer getCategoryNumber();
}

class Android implements Category {

    @Override
    public Integer getCategoryNumber() {
        return 1;
    }
}

class Kotlin implements Category {

    @Override
    public Integer getCategoryNumber() {
        return 2;
    }
}

class ManageCategory {
    Integer getCategoryNumber(Category category) {
        return category.getCategoryNumber();
    }
}

public class test {
    public static void main(String[] args) {
        ManageCategory mc = new ManageCategory();

        Android android = new Android();
        System.out.println(mc.getCategoryNumber(android));
    }
}