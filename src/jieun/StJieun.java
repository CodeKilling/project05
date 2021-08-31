package jieun;

import java.io.*;
import java.util.*;

import project05.*;

public class StJieun implements FPath{
	private int num = 0;
	private String stNum = null, name = null;
	Scanner sc = new Scanner(System.in);
	File filePath;
	StDTO st;
	public void display() {
		boolean bool = true;
		while(bool) {
			System.out.println("1.학생등록 2.검색 3.나가기");
			num = sc.nextInt();
			switch(num) {
			case 1 : enroll(); break;
			case 2 : search(); break;
			case 3 : bool = false; break;
			default : System.out.println("1~3 중 입력"); break;
			}
		}
	}
	public boolean check(String s) {
		filePath = new File(Path4+"/"+stNum+".txt");
		return filePath.isFile();
	}
	public void enroll() {
		while(true) {
			System.out.print("학번 : "); stNum = sc.next();
			if(check(stNum)) {
				System.out.println("이미 등록된 학번입니다.");
			}else {
				break;
			}
		}
		System.out.print("이름 : "); name = sc.next();
		st = new StDTO();
		st.setStNum(stNum); st.setName(name);
		
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(st);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void search() {
		System.out.print("학번 입력 : "); stNum = sc.next();
		if(check(stNum)) {
			try {
				FileInputStream fis = new FileInputStream(filePath);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				StDTO stSerch = (StDTO)ois.readObject();
				System.out.println("학번 : " + stSerch.getStNum());
				System.out.println("이름 : " + stSerch.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("존재하지 않는 학번입니다.");
		}
	}
}
