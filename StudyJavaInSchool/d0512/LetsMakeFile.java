package kr.hs.dgsw.java.dept23.d0512;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import kr.hs.dgsw.java.dept23.d0414.SetScanner;

public class LetsMakeFile {
	
	String baseUri;
	File file;
	
	public LetsMakeFile(String fileName) {
		baseUri = "/Users/choiminjae/공부/fileStudy/LetsMakeFile/" + fileName;
		file = new File(baseUri);
	}
	

	private void creatFile() {
		try {
			Boolean result = file.createNewFile();
			if (result) {
				System.out.println("파일 생성에 성공했습니다.");
				System.out.println(file.getAbsolutePath());
			} else {
				System.out.println("같은 이름의 파일이 있어 파일 생성에 실패하였습니다. 파일을 삭제합니다.");
				file.delete();
			}
		} catch (IOException e) {
			System.out.println("파일 생성에 실패했습니다.");
		}
		
	}
	
	public static void main(String[] args) {
		SetScanner setScanner = new SetScanner();
		setScanner.assignScanner();
		
		Scanner scan = setScanner.getScanner();
		
		System.out.print("파일 이름을 입력해주세요 : ");
		String fileName = scan.nextLine();
		LetsMakeFile makeFile = new LetsMakeFile(fileName);
		makeFile.creatFile();
	}

}
