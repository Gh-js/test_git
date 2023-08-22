package day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.sist.dao.DbConn;

/**
 * 
 * Transaction 처리
 * @author user
 *
 */
public class TestTransaction {
	private Connection con;
	
	public int insertTest() throws SQLException {
		int cnt=0;
		
		DbConn db = DbConn.getInstance();
		con=db.getConnection("localhost","scott","tiger");
		con.setAutoCommit(false);//autocommit 해제
		
		PreparedStatement pstmt =null;
		String name="홍찬영1";
		String addr="서울시1";
		String sql="insert into transaction1(name,addr) values(?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		int cnt1=pstmt.executeUpdate();
		//연결을 끊지 않으면 heap에 계속 남아서 메모리를 점유함. 그래서 지워줘야함.
		pstmt.close();
		
		sql="insert into transaction2(name,addr) values(?,?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, addr);
		int cnt2=pstmt.executeUpdate();
		pstmt.close();
		
		cnt=cnt1+cnt2;
		
		if(cnt1 ==1 && cnt2 == 1) {
			con.commit();
		}
		return cnt;
	}
	public void useInsertTest() {
		try {
			int cnt = insertTest();
			if(cnt==2) {
				System.out.println("추가성공");
				con.commit();
			}
		} catch (SQLException e) { //rollback에 대한 예외처리도 해야되서 try~catch를 한번더.
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestTransaction tt= new TestTransaction();
		tt.useInsertTest();
	}//main

}//class
