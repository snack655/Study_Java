package javaclass;

public class Animal {
    public int weight;
    int height;
    protected String name;
    private int age;

    public void sayHello() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Animal minjae = new Animal();
        minjae.age = 0;
        minjae.name = "qt";

        Animal taehwan = new Animal();
        minjae.sayHello();
    }
}
