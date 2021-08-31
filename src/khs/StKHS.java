package khs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import project05.FPath;
import project05.StDTO;

public class StKHS implements FPath{
	public void display() throws Exception {
		Scanner input = new Scanner(System.in);
		int sel;
		while(true) {
			System.out.println("===== 학생 등록 프로그램 =====");
			System.out.println("1.등록  2.보기  3.종료");
			sel = input.nextInt();
			switch(sel){
			case 1:
				enroll();
				break;
			case 2:
				view();
				break;
			case 3:
				System.out.println("프로그램 종료합니다.");
				return;
			default : System.out.println("1~3 사이의 숫자만 입력하세요.");
				break;
				
			}
		}
	}
	
	public void enroll() throws Exception {
		Scanner input = new Scanner(System.in);
		StDTO dto = new StDTO();
		
		System.out.println("학번 입력 : ");
		String StNum = input.next();
		File filepath = new File(Path3 + "/" + StNum + ".txt");
		if(!filepath.isFile()) {
			System.out.println("이름 입력 : ");
			String name = input.next();
		
			dto.setStNum(StNum); dto.setName(name);
			FileOutputStream fos = new FileOutputStream(filepath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(dto);
			oos.close();
		}else {
			System.out.println("동일한 학번이 있습니다. 다시 입력 하세요.");
		}

	}
	
	public void view() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("찾을 학번 입력 : ");
		String StNum = input.next();
		File filepath = new File(Path3 + "/" + StNum + ".txt");
		if(filepath.isFile()) {
			FileInputStream fis = new FileInputStream(filepath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			StDTO dto2 = (StDTO)ois.readObject();
			System.out.println("===== 검색 결과 =====");
			System.out.println("학번 : " + dto2.getStNum());
			System.out.println("이름 : " + dto2.getName());
		} else {
			System.out.println("존재하지 않는 학번입니다.");
		}
		
	}

}
