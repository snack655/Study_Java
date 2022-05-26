package kr.hs.dgsw.java.dept23.d0526;

public class Student implements Job, Expert {

    @Override
    public void work() {
        System.out.println("학생이 공부를 합니다.");
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public void enjoy() {
        System.out.println("학생이 플라톤의 국가론을 재미삼아 읽습니다.");
    }

    public static void main(String[] args) {
        Student student = new Student();
        Job job = (Job) student;
        Expert expert = (Expert) student;

        // job.enjoy();
        expert.enjoy();
    }
}
