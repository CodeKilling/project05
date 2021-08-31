package jieun;

import java.util.ArrayList;
import java.util.Scanner;

import project05.JewelryDTO;

public class JwJieun {
	JewelryDTO jw;
	Scanner sc = new Scanner(System.in);
	ArrayList<JewelryDTO> list = new ArrayList<JewelryDTO>();
	private int num=0, count=0;
	private String name = null, price = null;

	public void display() {
		boolean bool = true;
		while(bool) {
			System.out.println("1.보석등록 2.보석내역 3.보석검색 4.보석삭제 5.나가기");
			num = sc.nextInt();
			switch(num) {
			case 1 : enroll(); break;
			case 2 : view(); break;
			case 3 : search(); break;
			case 4 : del(); break;
			case 5 : bool = false; break;
			default : System.out.println("1~5 입력");break;
			}
		}
		
	}
	public void enroll() {
		boolean check = true;
		while(check) {
			System.out.print("보석 이름 입력 : "); name = sc.next();
			if(list.size() != 0) {
				for(int j=0; j<list.size(); j++) {
					if(name.equals(list.get(j).getName())) {
						System.out.println("이미 등록된 보석이 있습니다.");
						break;
					}
					if(j == list.size()-1) {
						check = false;
						break;
					}
				}
			}else {
				check = false;
			}
		}
		System.out.print("보석 가격 입력 : "); price = sc.next();
		System.out.print("보석 개수 입력 : "); count = sc.nextInt();
		jw = new JewelryDTO();
		jw.setName(name); jw.setPrice(price); jw.setCount(count);
		list.add(jw);
	}
	public void view() {
		System.out.println("보석 LIST");
		for(int i=0; i<list.size(); i++) {
			System.out.println("---------"+ (i+1) + "---------");
			System.out.println("보석 이름 : " + list.get(i).getName());
			System.out.println("보석 가격 : " + list.get(i).getPrice());
			System.out.println("보석 개수 : " + list.get(i).getCount());
		}
	}
	public void search() {
		System.out.print("찾을 보석 이름 입력 : "); name = sc.next();
		for(int j=0; j<list.size(); j++) {
			if(name.equals(list.get(j).getName())) {
				System.out.println("보석 이름 : " + list.get(j).getName());
				System.out.println("보석 가격 : " + list.get(j).getPrice());
				System.out.println("보석 개수 : " + list.get(j).getCount());
				break;
			}
			if(j == list.size()-1) {
				System.out.println(name + "은(는) 리스트에 없습니다.");
			}
		}
		
	}
	public void del() {
		System.out.print("삭제할 보석 이름 입력 : "); name = sc.next();
		for(int j=0; j<list.size(); j++) {
			if(name.equals(list.get(j).getName())) {
				list.remove(j);
				System.out.println("삭제되었습니다.");
				break;
			}
			if(j == list.size()-1) {
				System.out.println(name + "은(는) 리스트에 없습니다.");
			}
		}
	}
}
