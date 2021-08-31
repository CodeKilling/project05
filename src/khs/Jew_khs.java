package khs;

import java.util.ArrayList;
import java.util.Scanner;

import project05.JewelryDTO;

public class Jew_khs extends JewelryDTO{
	private ArrayList<JewelryDTO> list = new ArrayList<JewelryDTO>();
	private Scanner input = new Scanner(System.in);
	private int index;

	
	public void display() {
		int sel;
		while(true) {
			System.out.println("======= 쥬얼리 관리 프로그램 =======");
			System.out.println("1.등록  2.모든 목록 보기  3.수정  4.삭제  5.종료");
			sel = input.nextInt();
			switch(sel) {
				case 1:
					enroll();
					break;
				case 2:
					showList();
					break;
				case 3:
					edit();
					break;
				case 4:
					delete();
					break;
				case 5:
					System.out.println("프로그램 종료");
					return;
				default : System.out.println("1~5 사이 숫자를 입력하세요."); break;
			}
		}	
	}
	
	public int NameSearch(String name) {
		int i;
		for( i=0; i<list.size() ;i++) {
			JewelryDTO d = list.get(i);
			if(name.equals( d.getName()) ) {
				return i;
			}
		}
		return -1;
	}
	
	public void enroll() {
		JewelryDTO dto = new JewelryDTO();
		boolean bool = true;
		
		if(list.size() != 0) {
			while(bool) {
				System.out.println("보석 이름 :");
				dto.setName( input.next());
				index = NameSearch(dto.getName());
				if(index != -1) {
					System.out.println("동일한 보석명이 존재합니다.");
				}
				if(index == -1) {
					bool = false;
				}
			}
		}else { // size() = 0 , 즉 저장값이 없으면
			System.out.println("보석 이름 : ");
			dto.setName(input.next());
		}
		System.out.println("개수 입력 : ");
		dto.setCount(input.nextInt());
		System.out.println("가격 입력 : ");
		dto.setPrice(input.next());
		
		list.add(dto);
		System.out.println("저장 되었습니다!!!");
	}
	
	public void showList() {
		System.out.println("==== 모든 목록 보기 ====");
		for(int i = 0; i<list.size(); i++) {
			System.out.println("보석명 : " + list.get(i).getName());
			System.out.println("개수 : " + list.get(i).getCount());
			System.out.println("가격 : " + list.get(i).getPrice());
			System.out.println("---------------------------");
		}
	}
		
	public void edit() {
		System.out.println("수정될 보석명 입력 : ");
		String name = input.next();
		index = NameSearch(name);
		
		if(index != -1) {
			JewelryDTO d = list.get(index);
			
			System.out.println("수정할 보석명 입력");
			d.setName(input.next());
			System.out.println("수정할 개수 입력");
			d.setCount(input.nextInt());
			System.out.println("수정할 가격 입력");
			d.setPrice(input.next());
		}
		
		if(index == -1) {
			System.out.println("수정할 보석명이 존재하지 않습니다.");
		}
	}
	
	public void delete() {
		System.out.println("삭제할 보석명 입력");
		String name = input.next();
		index = NameSearch(name);
		if(index != -1) {
			list.remove(index);
			System.out.println("삭제되었습니다 !!!");
		}
		if(index == -1) {
			System.out.println("삭제할 보석명이 존재하지 않습니다.");
		}
	}
	
}
