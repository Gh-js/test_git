package day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.dao.DbConn;

public class Work0820 {

	public Work0820() throws SQLException{
		String inputData=JOptionPane.showInputDialog("제조사를 입력해주세요");
	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		DbConn db=DbConn.getInstance();
		
		try {
			con=db.getConnection("localhost", "scott", "tiger");
			StringBuilder selectEmp=new StringBuilder();
			selectEmp
			.append("select cc.country, cma.maker, cm.model, cm.car_year, cm.price, cm.car_option	")
			.append(" from car_country cc,car_model cm,car_maker cma 	" )
			.append("where (cc.maker=cma.maker(+) and cm.model(+)=cma.model)")
			.append("and cma.maker=	?	");
			
			pstmt=con.prepareStatement(selectEmp.toString());
			pstmt.setString(1,inputData);
			rs=pstmt.executeQuery();
			
			StringBuilder searchEmp=new StringBuilder();
			searchEmp.append(inputData + "로 검색한 결과\n");
			searchEmp.append("번호\t제조극\t제조사\t모델명\t연식\t가격\t옵션\n");
			
			int cnt=0;
			while( rs.next() ) {
				cnt++;
				searchEmp.append(cnt).append("\t").append(rs.getString("country")).append("\t").append(rs.getString("maker"))
						.append("\t").append(rs.getString("model")).append("\t").append(rs.getString("car_year"))
						.append("\t").append(rs.getInt("price")).append("\t").append(rs.getString("car_option")).append("\n");
				
			}//end while
			
			if( cnt == 0 ) {
				searchEmp.append("자동차 정보가 존재하지 않습니다.");
			}//end if
			
			JTextArea jta=new JTextArea(searchEmp.toString(),30,100); //10줄에 50자정도 
			JScrollPane jsp=new JScrollPane( jta );
			
			JOptionPane.showMessageDialog(null, jsp);
			
		} finally {
		//6. 연결 끊기
			db.dbClose(rs, pstmt, con);
		}//end finally
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Work0820();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
