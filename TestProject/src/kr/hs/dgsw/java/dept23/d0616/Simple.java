package kr.hs.dgsw.java.dept23.d0616;

public class Simple<T, Q> {

    private T value;

    private Q data;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Simple<Integer, String> simple = new Simple<>();
        simple.setValue(1311);

        Simple<String, Integer> simple2 = new Simple<>();
        simple2.setValue("Hello");

        Simple raw = new Simple();
        int value = (Integer)raw.getValue();
    }
}
