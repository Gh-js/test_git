package day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.co.sist.dao.DbConn;

public class InjectionTestDAO {
	private static InjectionTestDAO itDAO;
	
	private InjectionTestDAO() {
	}
	//singleton code
	public static InjectionTestDAO getInstance() {
		if (itDAO  ==null) {
			itDAO = new InjectionTestDAO();
		}//end if
		return itDAO;
	}//getInstance
	
	public LoginResultVO usePreparedStatementLogin(LoginVO lVO) throws SQLException {
		LoginResultVO lrVO=null;
		
		Connection con =null;
		PreparedStatement pstmt=null;
		
		ResultSet rs=null;
		
		DbConn db = DbConn.getInstance();
		try {
			//3
			con=db.getConnection("localhost","scott","tiger");
			StringBuilder selectLogin=new StringBuilder();
			selectLogin
			.append(" select name, input_date ")
			.append(" from test_login ")
			.append(" where ID = ? and pass=?");
			pstmt=con.prepareStatement(selectLogin.toString());
			//4
			pstmt.setString(1, lVO.getId());
			pstmt.setString(2, lVO.getPassword());
			//5
			rs = pstmt.executeQuery();
			while(rs.next()) {
				lrVO = new LoginResultVO(rs.getString("name"), rs.getDate("input_date"));
			}
		}finally {
			//5
			db.dbClose(rs, pstmt, con);
		}
		return lrVO;
	}//useStatementLogin
	
	public static void main(String args[]) {
		try {
			System.out.println(
			InjectionTestDAO.getInstance().usePreparedStatementLogin(new LoginVO("hong","1234"))
			);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}//class
