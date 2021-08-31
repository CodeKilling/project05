package psy;

import java.io.*;
import java.util.HashMap;

import project05.FPath;

public class STpsy implements FPath{
	
	FileOutputStream fos = null;
	BufferedOutputStream bos = null;
	ObjectOutputStream oos = null;
	
	FileInputStream fis = null;
	BufferedInputStream bis = null;
	ObjectInputStream ois = null;
	
	
	public void display() {
		System.out.println("1.학생 등록");
		System.out.println("2.학생 찾기");
		System.out.println("3.전체 보기");
		System.out.println("4.나가기");
	}
}
