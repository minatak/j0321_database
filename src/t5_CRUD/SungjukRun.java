package t5_CRUD;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SungjukService service = new SungjukService();
		
		int choice = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("\n\t** 성 적 표 **");
			System.out.println("--메뉴를 선택하세요--");
			System.out.println("1.입력 2.전체조회 3.개별조회 4.수정 5.삭제 0.종료");
			System.out.print(" ==> ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					service.setSungjukInput();
					break;
				case 2:
					service.getSungjukList();
					break;
				case 3:
					service.getSungjukSearch();
					break;
				case 4:
					service.setSungjukUpdate(); // 조회할 성명에 잘못된 이름을 입력해도 계속 진행되고 오류 남. 고치기!
					break;
				case 5:
					service.setSungjukDelete();
					break;
				case 0:
					run = false;
				default:
					System.out.println("1/2/3/4/5/0 중에 입력하세요");
					break;
			}
		}
		System.out.println("프로그램을 종료합니다.");  
		
		sc.close();
	}
}
