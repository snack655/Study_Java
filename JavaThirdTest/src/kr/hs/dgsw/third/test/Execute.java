package kr.hs.dgsw.third.test;

public class Execute {
    Client client;
    Computer computer;
    Execute() {
        client = new Client();
        computer = new Computer();
    }

    void execute() {
        while (true) {
            System.out.println("가위 바위 보 가운데 하나를 입력하세요.\n(quit) 입력 시 프로그램 종료");

            String answer = client.throwOut();
            if ("quit".equals(answer))
                break;

            System.out.println(computer.judgeResult(answer));
            computer.printResult();
        }

        computer.printResult();
        System.out.println("프로그램을 종료합니다.");
    }

    public static void main(String[] args) {
        Execute exe = new Execute();
        exe.execute();
    }
}
