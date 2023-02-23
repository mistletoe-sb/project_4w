package model.dao;

import java.util.ArrayList;

// DAO 클래스에 사용되는 메소드들의 형식을 정해놓은 인터페이스
// (VO : DAO클래스에서 사용할 VO 객체 타입)
// 작성자 : 이수봉
public interface DAOInterface <VO>{
	public abstract void insertData(VO vo);		// insert 실행 메소드
	public abstract void updateData(VO vo);		// update 실행 메소드
	public abstract void deleteData(int num);	// delete 실행 메소드
	
	public abstract VO selectByNum(int num);		// 시퀀스 번호 기준으로 하나의 데이터를 select하는 메소드
	public abstract ArrayList<VO> selectAllData();	// 테이블의 모든 데이터를 select하는 메소드
}
