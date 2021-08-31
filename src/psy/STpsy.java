package psy;

import java.io.*;
import java.util.*;

import project05.FPath;
import project05.StDTO;

public class STpsy implements FPath{
	
	File filePath = new File(Path5);
	
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream oos = null;
	
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;

	Scanner sc = null;
	HashMap<String, StDTO> map = null;
	boolean flag = true;
	
	public STpsy() {
		sc = new Scanner(System.in);
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void display() {
		
		while(flag) {
			System.out.println("1.학생 등록");
			System.out.println("2.학생 찾기");
			System.out.println("3.전체 보기");
			System.out.println("4.나가기");
			
		}
		
	}
}
