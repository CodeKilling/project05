package nmrnkd;

import java.util.ArrayList;
import java.util.Scanner;

import project05.JewelryDTO;
import project05.StDTO;

/*
 	-문제점 1
 	신규 등록시 이미 등록되ㄴ어 있던 정보들이 신규 등록 내용으로 바뀜
 	-문제점 2
 	수정시 리스트에 새로운 공간이 할당됨.
 	-문제점 3
	수정시 등록된 모든 정보가 수정됨 	
*/


public class Je_nmrnkd {

	Scanner input = new Scanner(System.in);
	ArrayList<JewelryDTO> list = new ArrayList<JewelryDTO>();
		
	JewelryDTO jdto = new JewelryDTO();
	int cnt;
	
	public void display() 
	{
		boolean bool = true;

		while(bool) {				
			System.out.println("------------주얼리 관리 프로그램------------");
			System.out.println("1.등록  2.모든 목록 보기  3.수정  4.삭제  5.종료");
					
			int num=0;
			num = input.nextInt();
			
			switch(num) {
				case 1:
					enroll(); break;
				case 2:
					view(); break;
				case 3:
					modify(); break;
				case 4:
					delete(); break;
				case 5:
					exit(); break;
			}

		}
	}
	
	public void enroll() {
		String jName=null; int jAmount=0; String jPrice=null;
		boolean check = true;
		
		System.out.println("등록할 보석의 이름을 입력하세요 : ");
		jName = input.next();

		
		for(int i=0;i<list.size();i++)
		{
			if((list.get(i).getName()).equals(jName))
			{
				System.out.println("이미 등록된 항목입니다.");
				check = false;
				break;
			}
		}
		
		if(check)
		{	
			System.out.println("등록할 수량을 입력하세요 : ");
			jAmount = input.nextInt();
			System.out.println("등록할 가격을 입력하세요 : ");
			jPrice = input.next();
			
			jdto.setName(jName);
			jdto.setCount(jAmount);
			jdto.setPrice(jPrice);
			
			list.add(cnt, jdto);
			cnt++;
		}
		
	}
	public void view() {
		if(list.size()>0)
		{
			for(int i=0;i<list.size();i++) {
				
				System.out.println("보석 이름 : " + list.get(i).getName());
				System.out.println("보석 수량 : " + list.get(i).getCount());
				System.out.println("보석 가격 : " + list.get(i).getPrice());
			}
		}else {
			System.out.println("등록된 항목이 없습니다.");
		}
	}
	public void modify() {
		String jName=null; int jAmount=0; String jPrice=null;
		boolean check = true;
		System.out.println("수정할 보석의 이름을 입력하세요 : ");
		jName =input.next();
		check=false;
		int index=0;
		for(int i=0 ; i<list.size() ; i++)
		{
			if(jName.equals(list.get(i).getName()))
			{
				index=i; check=true; break;
			}
		}
		if(check)
		{
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1. 수량   2. 가격");
			
			int sel = 0;
			sel = input.nextInt();
			
			switch(sel)
			{
			case 1:
				System.out.println("수정할 수량을 입력하세요 : ");
				jAmount = input.nextInt();
				jdto.setCount(jAmount);
				list.add(index, jdto);
				break;
			case 2:
				System.out.println("수정할 가격을 입력하세요 : ");
				jPrice = input.next();
				jdto.setPrice(jPrice);
				list.add(index, jdto);
				break;
			}
		}else {
			System.out.println("해당 보석은 등록된 정보가 없습니다.");
		}
	
	}
	public void delete() {
		String jName=null; int jAmount=0; String jPrice=null;
		boolean check = true;
		System.out.println("삭제할 보석의 이름을 입력하세요 : ");
		jName =input.next();
		check=false;
		int index=0;
		for(int i=0 ; i<list.size() ; i++)
		{
			if(jName.equals(list.get(i).getName()))
			{
				index=i; check=true; break;
			}
		}
		if(check)
		{
			list.remove(index);
			if(list.get(index)==null)
			{
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 되지 않음");
			}
		}else {
			System.out.println("해당 보석은 등록되어 있지 않습니다.");
		}
	}
	public boolean exit() {
		return false;
	}

}

