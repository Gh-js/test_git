package day0821;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kr.co.sist.dao.DbConn;

public class EmpInfoEvt extends WindowAdapter implements ListSelectionListener {
	private EmpInfoDesign eid;

	public EmpInfoEvt() {
		super();
		
	}
	public EmpInfoEvt(EmpInfoDesign eid) {
		super();
		this.eid = eid;
	}

	public List<String> getEnameList() throws SQLException{
		List<String> nameList = new ArrayList<String>();
		
		DbConn db = DbConn.getInstance();
		Connection con = null;
		ResultSet rs= null;
		PreparedStatement pstmt=null;
		
		try {
			con=db.getConnection("localhost","scott","tiger");
			StringBuilder Query = new StringBuilder();
			Query
			.append("select empno from emp" );
			pstmt=con.prepareStatement(Query.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
			 nameList.add(rs.getString("empno"));
			}
			return nameList;
		} finally {
			db.dbClose(rs, pstmt, con);
		}
	}//getEnameList


	public InfoVO getEmpInfo(int empno) throws SQLException {
		
		DbConn db = DbConn.getInstance();
		Connection con = null;
		ResultSet rs= null;
		PreparedStatement pstmt=null;
		
		try {
			con=db.getConnection("localhost","scott","tiger");
			StringBuilder Query = new StringBuilder();
			Query
			.append(" select empno,ename,hiredate,sal,job ")
			.append(" from emp " )
			.append(" where empno = ? ");
			pstmt=con.prepareStatement(Query.toString());
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			InfoVO iVO=null;
			while(rs.next()) {
			iVO = 	new InfoVO(rs.getInt("empno"),rs.getString("ename"),rs.getDate("hiredate"),rs.getString("job"),rs.getInt("sal"));
			}
			return iVO;
		} finally {
			db.dbClose(rs, pstmt, con);
		}//end finally
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting()) {
			int selectedIndex = eid.getJlName().getSelectedIndex();
			if(selectedIndex != -1) {
				int empno = Integer.parseInt(eid.getDlm().getElementAt(selectedIndex));
				try {
					InfoVO iVO = getEmpInfo(empno);
					InfoDetails iD = new InfoDetails();
					iD.getJtfEmpno().setText(String.valueOf(iVO.getEmpno()));
					iD.getJtfName().setText(iVO.getEname());
					iD.getJtfDate().setText(iVO.getHiredate().toString());
					iD.getJtfJob().setText(iVO.getJob());
					iD.getJtfSal().setText(String.valueOf(iVO.getSal()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//end catch
			}//end if
		}//end if
		
	}//valueChanged
	
//	public static void main(String args[]) {
//		EmpInfoEvt eie = new EmpInfoEvt();
//		try {
//			System.out.println(eie.getEmpInfo(7521));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	
}//class
