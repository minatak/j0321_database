package t5_CRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukService_수정전 {
	Scanner sc = new Scanner(System.in);
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null; // 처음에는 생성하지 않고 선언만 해놓음 (사용 되었는지 확인하기 위해. null일경우 사용x니깐!)
	
	int res;
	String ans = "N";
	
	// 성적 입력
	public void setSungjukInput() {
		vo = new  SungjukVO();
		
		while(true) {
			System.out.println("\n** 성적 입력처리 **");
			String name = "";
			int kor=0, eng=0, mat=0;
			while(true) {
				System.out.print("성명 : "); name = sc.next();
				// 동명이인 처리
				vo = dao.getSungjukSearch(name);
				if(vo == null) break; // 같은 이름이 없을 경우-> null. 새로 가입 가능.
				else System.out.println("이미 가입된 이름입니다. 다시 입력하세요.");
			}
			System.out.print("국어점수 입력 : "); kor = sc.nextInt();
			System.out.print("영어점수 입력 : "); eng = sc.nextInt();
			System.out.print("수학점수 입력 : "); mat = sc.nextInt();
			
			vo = new SungjukVO();
			vo.setName(name);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMat(mat);
			
			int res = dao.setSungjukInput(vo); // 처리되면 1, 처리 안되면 0이 res에 넘어옴 
			
			if(res != 0) System.out.println("성적자료가 등록되었습니다."); 
			else System.out.println("성적자료 등록이 실패했습니다.");
			
			System.out.print("계속하시겠습니까? (Y/N) => ");
			ans = sc.next();
			if(!ans.toUpperCase().equals("Y")) break;
		}
		
	//	sc.close();
	}
	
	// 회원 전체 검색
	public void getSungjukList() {
		ArrayList<SungjukVO> vos =  dao.getSungjukList();
		
		System.out.println("\n\t*** 성 적 리 스 트 ***");
		System.out.println("===================================================================");
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-------------------------------------------------------------------");
		for(int i=0; i<vos.size(); i++) { 
			vo = vos.get(i);
			calculator(vo);
			System.out.print(" " + (i+1) + "\t" + vo.getName() + "\t" + vo.getKor() + "\t" + vo.getEng() + "\t" + vo.getMat() + "\t");
			System.out.print(vo.getTot() + "\t");
			System.out.print(String.format("%.1f", vo.getAvg())  + "\t");
			System.out.print(vo.getGrade() + "\n");
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\t총 인원수 : " + vos.size() + "명");
		
		System.out.println("===================================================================");
	}

		// 계산(총점, 평균, 학점) 처리
	private void calculator(SungjukVO vo) {
		vo.setTot(vo.getKor()+vo.getEng()+vo.getMat()); 
		vo.setAvg(vo.getTot() / 3.0);
		if(vo.getAvg() >= 90) vo.setGrade('A');
		else if(vo.getAvg() >= 80) vo.setGrade('B');
		else if(vo.getAvg() >= 70) vo.setGrade('C');
		else if(vo.getAvg() >= 60) vo.setGrade('D'); 
		else vo.setGrade('F');
		
	}
	
	// 개별자료 검색
	public void getSungjukSearch() {
		while(true) {
			System.out.print("\n조회할 성명을 입력하세요 > ");
			String name = sc.next();
			
			vo = dao.getSungjukSearch(name);
			
			if(vo != null) {
				calculator(vo);
				System.out.println("\n고유번호 : " + vo.getIdx());
				System.out.println("성명 : " + vo.getName());
				System.out.println("국어 : " + vo.getKor());
				System.out.println("영어 : " + vo.getEng());
				System.out.println("수학 : " + vo.getMat());
				System.out.println("총점 : " + vo.getTot());
				System.out.println("평균 : " + String.format("%.1f", vo.getAvg())  + "\t");
				System.out.println("학점 : " + vo.getGrade());
			}
			else System.out.println("검색하신 "+name+"님의 성적은 존재하지 않습니다.");
			System.out.print("계속하시겠습니까? (Y/N) => ");
			ans = sc.next();
			if(!ans.toUpperCase().equals("Y")) break;
		}
	}

	// 회원 정보 수정하기
	public void setSungjukUpdate() {
		
	}
	
}
