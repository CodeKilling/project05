package psy;

import java.io.*;
import java.util.*;
import project05.*;

public class DTOpsy implements FPath, Serializable {

	private File filePath = new File(Path5);

	private FileOutputStream fos = null;
	private BufferedOutputStream bos = null;
	private ObjectOutputStream oos = null;

	private FileInputStream fis = null;
	private BufferedInputStream bis = null;
	private ObjectInputStream ois = null;

	private Scanner sc = null;
	private HashMap<String, JewelryDTO> map = null;
	private boolean flag = true;
	private int input = 0;

	private String name = null;
	private String price = null;
	private int count = 0;

	public DTOpsy() {
		sc = new Scanner(System.in);
		map = new HashMap<String, JewelryDTO>();
	}

	public void display() {

		while (flag) {
			System.out.println("1.보석 등록");
			System.out.println("2.보석 구매");
			System.out.println("3.보석 재고 관리");
			System.out.println("4.나가기");

			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 1:
				System.out.println("보석 이름 입력 : ");
				name = sc.nextLine();

				if (filePath.isFile()) {// 파일이 이미 존재할 경우.
					readJewelryDTO();

					int cnt = 0;
					Iterator<HashMap.Entry<String, JewelryDTO>> entries = map.entrySet().iterator();
					while (entries.hasNext()) {
						HashMap.Entry<String, JewelryDTO> entry = entries.next();
						if (name.equals(entry.getValue().getName())) {
							break;
						}
						cnt++;
					}
					if (cnt != map.size()) {
						System.out.println("이미 있는 보석 입니다.");
					} else {
						addJewelry();
					}
				} else {// 파일이 없을 경우.
					addJewelry();
				}
				break;

			case 2:
				if (filePath.isFile()) {
					this.readJewelryDTO();
					if (this.map.size() > 0) {
						this.buyJewelry();
					} else {
						System.out.println("등록된 보석이 없습니다.");
					}
				} else {
					System.out.println("등록된 보석이 없습니다.");
				}
				break;

			case 3:
				if (filePath.isFile()) {
					this.readJewelryDTO();
					if (this.map.size() > 0) {
						this.inventoryControl();
					} else {
						System.out.println("등록된 보석이 없습니다.");
					}
				} else {
					System.out.println("등록된 보석이 없습니다.");
				}
				break;

			case 4:
				System.out.println("Program Exit.");
				flag = false;
				break;
			default:
				System.out.println("only 1~4.");
				break;
			}
		}

	}

	private void inventoryControl() {
		while(true) {
			this.showList();
			System.out.println("1.재고 변경");
			System.out.println("2.나가기");
			input = sc.nextInt(); sc.nextLine();
			
			switch(input) {
			case 1:
				System.out.println("변경할 보석 이름 입력 : ");
				name = sc.nextLine();
				
				int cnt = 0;
				Iterator<HashMap.Entry<String, JewelryDTO>> entries = map.entrySet().iterator();
				while(entries.hasNext()) {
					HashMap.Entry<String, JewelryDTO> entry = entries.next();
					if(name.equals(entry.getValue().getName())) {
						System.out.println("변경할 수량 입력 : ");
						count = sc.nextInt();
						entry.getValue().setCount(count);
						break;
					}
					cnt++;
				}
				
				if(cnt == map.size()) {
					System.out.println("존재 하지 않는 보석 입니다.");
				}
				
				this.writeMap();
				
				break;
				
			case 2: System.out.println("Exit."); return;
			default: System.out.println("only 1~2."); break;
			}
		}

	}

	private void buyJewelry() {
		while (true) {
			this.showList();

			System.out.println("1.구매");
			System.out.println("2.나가기");
			input = sc.nextInt();
			sc.nextLine();

			switch (input) {
			case 1:
				System.out.println("구매할 보석 이름 입력 : ");
				name = sc.nextLine();

				int cnt = 0;
				Iterator<HashMap.Entry<String, JewelryDTO>> entries = map.entrySet().iterator();
				while (entries.hasNext()) {
					HashMap.Entry<String, JewelryDTO> entry = entries.next();
					if (name.equals(entry.getValue().getName())) {
						System.out.println("구매할 수량 입력 : ");
						count = sc.nextInt();
						if (count > entry.getValue().getCount()) {
							System.out.println("재고 보다 많은 수량은 구매 할 수 없습니다.");
						} else {
//							int tmp = entry.getValue().getCount() - count;
//							if (tmp == 0) {
//								map.remove(entry.getKey());
//								return;
//							} else {
//								entry.getValue().setCount(entry.getValue().getCount() - count);
//							}
							entry.getValue().setCount(entry.getValue().getCount() - count);
						}
						break;
					}
					cnt++;
				}

				if (cnt == map.size()) {
					System.out.println("존재 하지 않는 보석 입니다.");
				}

				this.writeMap();

				break;

			case 2:
				System.out.println("Exit.");
				return;
			default:
				System.out.println("only 1~2.");
				break;
			}
		}
	}

	private void addJewelry() {
		System.out.println("보석 가격 입력 : ");
		price = sc.nextLine();
		System.out.println("보석 수량 입력 : ");
		count = sc.nextInt();

		JewelryDTO jdto = new JewelryDTO();
		jdto.setName(name);
		jdto.setPrice(price);
		jdto.setCount(count);

		map.put(name, jdto);

		this.writeMap();
	}

	private void readJewelryDTO() {
		try {
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);

			map = (HashMap<String, JewelryDTO>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showList() {
		Iterator<HashMap.Entry<String, JewelryDTO>> entries = this.map.entrySet().iterator();
		while (entries.hasNext()) {
			HashMap.Entry<String, JewelryDTO> entry = entries.next();
			System.out.println("보석 이름 : " + entry.getValue().getName() + ", 보석 가격 : " + entry.getValue().getPrice()
					+ ", 보석 수량 : " + entry.getValue().getCount());
		}
	}

	private void writeMap() {
		try {
			fos = new FileOutputStream(filePath);
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);

			oos.writeObject(map);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
