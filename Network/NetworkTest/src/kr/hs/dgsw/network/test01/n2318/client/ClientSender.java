package kr.hs.dgsw.network.test01.n2318.client;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Scanner;

class ClientSender extends Thread {
    Socket socket;
    DataOutputStream out;
    FileInputStream fileIn;
    String name;
    String id;
    String pw;
    Scanner scanner;
    FileInputStream fis;
    File file;

    ClientSender(Socket socket, String name) {
        this.socket = socket;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            this.name = name;
        } catch (Exception e) {}
    }

    @Override
    public void run() {
        scanner = new Scanner(System.in);
        try {
            if (out != null) {
                out.writeUTF(name);
            }

            sendAuth();

            System.out.println("FTP 서버에 연결되었습니다!");
            System.out.println("메시지 혹은 명령어를 입력해주세요.");
            System.out.println("/help로 명령어 목록을 볼 수 있습니다.");

            while (out != null) {
                String command = scanner.nextLine();
                sortOutCommand(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // run()

    private void sendAuth() throws IOException{
        while (true) {
            if (MultiChatClient.IS_LOGIN)
                break;
            System.out.print("ID : ");
            id = scanner.nextLine();
            System.out.print("PW : ");
            pw = scanner.nextLine();

            out.writeUTF("[AUTH]" +
                    MultiChatClient.STANDARD +
                    id +
                    MultiChatClient.STANDARD +
                    pw
            );

            // receiver와의 동시성 문제 해결
            MultiChatClient.IS_LOADING = true;
            while(MultiChatClient.IS_LOADING){}
        }
    }

    /**
     * 입력된 문자열을 받아 명령어에 따라 서버에 올바른 명령어로 변환시켜 전송한다.
     * 아무 명령어도 아닐 경우 메시지 취급하여 서버에서 전송한다.
     * @param command
     * @throws IOException
     */
    private void sortOutCommand(String command) throws IOException {
        String[] commandDiv = command.split(" ");

        switch (commandDiv[0].toLowerCase(Locale.ROOT)) {
            case "/filelist": {
                out.writeUTF("[LIST]"+MultiChatClient.STANDARD);
                break;
            }
            case "/upload": {
                if (commandDiv.length >= 3) {
                    makeFileWithName(commandDiv[1], commandDiv[2]);
                } else if (commandDiv.length == 2){
                    makeFile(commandDiv[1]);
                } else {
                    System.out.println("[/upload 파일경로 (파일명)] 형식으로 입력해주세요");
                }
                break;
            }
            case "/download": {
                if (commandDiv.length < 2) {
                    System.out.println("[/download 파일명] 형식으로 입력해주세요");
                } else {
                    downloadFile(commandDiv[1]);
                }
                break;
            }
            case "/help": {
                printCommandList();
                break;
            }
            case "/exit": {
                exit();
                break;
            }
            default: {
                out.writeUTF("["+name+"] " + command);
            }
        } // switch
    } // sortOutCommand

    /**
     * 파일 다운로드 요청
     * @param fileName
     * @throws IOException
     */
    private void downloadFile(String fileName) throws IOException {
        out.writeUTF("[DOWNLOAD]" +
                MultiChatClient.STANDARD +
                fileName
        );
        while (true) {
            if (MultiChatClient.IS_SUCCESS_FILE_DOWNLOAD != null)
                break;
            System.out.print("");
        }
        if (MultiChatClient.IS_SUCCESS_FILE_DOWNLOAD) {
            System.out.println(
                    MultiChatClient.CLIENT_FOLDER_PATH +
                    " 경로에 파일 다운로드가 완료되었습니다." +
                    fileName
            );
        } else {
            System.out.println("파일 다운로드에 실패했습니다.");
        }
        MultiChatClient.IS_SUCCESS_FILE_DOWNLOAD = null;
    }

    /**
     * 파일 경로만을 받았을 경우 가공 후 sendFileInfo() 함수 호출
     * @param path
     * @throws IOException
     */
    private void makeFile(String path) throws IOException {
        fis = initFile(path);
        if (fis == null)
            return;
        file = new File(path);
        sendFileInfo(file.getName());
    }

    /**
     * 지정한 이름으로 보낼 파일 가공하기
     * @param path
     * @param name
     * @throws IOException
     */
    private void makeFileWithName(String path, String name) throws IOException {
        fis = initFile(path);
        if (fis == null)
            return;
        file = new File(path);

        // 확장자가 없다면
        String ext;
        if (!name.contains(".")) {
            String fileName = file.getName();
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
            name = name + "." + ext;
        }
        sendFileInfo(name);
    }

    /**
     * 최종적인 파일 전송
     * @throws IOException
     */
    private void sendFileInfo(String fileName) throws IOException {
        out.writeUTF("[UPLOAD]" +
                MultiChatClient.STANDARD +
                Files.size(file.toPath()) +
                MultiChatClient.STANDARD +
                fileName
        );


        while(MultiChatClient.IS_DUPLICATE_WAIT) { }

        if (MultiChatClient.IS_DUPLICATE) {
            System.out.println("같은 이름의 파일이 있습니다.");
            System.out.println("덮어쓰기 하실건가요? (Y: 덮어쓰기 / N: 취소)");

            String answer = scanner.nextLine();

            if (answer.toLowerCase(Locale.ROOT).equals("y")) {
                readFile(fis, true);
            } else {
                readFile(fis, false);
            }
        } else {
            readFile(fis, true);
        }

        MultiChatClient.IS_DUPLICATE_WAIT = true;
        MultiChatClient.IS_DUPLICATE = null;
    }

    /**
     * 프로그램을 종료햐는 함수
     */
    private void exit() {
        System.out.println("접속을 종료합니다.");
        System.exit(0);
    }


    /**
     * 명령어 목록을 출력해주는 함수.
     */
    private void printCommandList() {
        System.out.println("********** | 명령어 목록 | **********");
        System.out.println("/help : 명령어 목록을 보여줍니다.");
        System.out.println("/filelist : 파일의 목록을 보여줍니다.");
        System.out.println("/upload 파일경로 : 서버에 지정한 경로의 파일을 업로드 합니다.");
        System.out.println("/upload 파일경로 파일명 : 서버에 지정한 경로의 파일을 지정한 파일명으로 업로드 합니다.");
        System.out.println("/download 파일명 : 서버의 파일 목록에 있는 파일을 다운받습니다.");
        System.out.println("/exit : 접속을 종료합니다.");
        System.out.println("***********************************");
    }

    /**
     * 받은 파일 경로를 통해서 FileInputStream 반환
     * @param filePath
     * @return
     */
    private FileInputStream initFile(String filePath) {
        File file = new File(filePath);
        try {
            fileIn = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            return null;
        }
        return fileIn;
    }

    private void readFile(FileInputStream fis, Boolean result) throws IOException {
        if (result) {
            out.writeUTF("[SEND_FILE]");
            byte[] bytes = new byte[1024];
            int readBit = 0;
            while((readBit = fis.read(bytes)) != -1) {
                // bytes에 저장된 데이터 전송
                out.write(bytes, 0, readBit);
            }
        } else {
            out.writeUTF("[CANCEL_SEND_FILE]");
        }
        fis.close();
    }
    
} // ClientSender
