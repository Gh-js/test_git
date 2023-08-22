package day0821;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class EmpInfoDesign extends JFrame{
	private JList< String> jlName;
	private DefaultListModel<String> dlm;
	
	public EmpInfoDesign() {
		super("empno");
		dlm=new DefaultListModel<String>();
		
		EmpInfoEvt eie = new EmpInfoEvt(this);
		try {
			List<String> temp = eie.getEnameList();
			for(String name : temp) {
				dlm.addElement(name);
			}
			jlName=new JList<String>(dlm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jlName.addListSelectionListener(eie);
		add(jlName);
		
		setBounds(500,500,500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmpInfoDesign();
	}//main

	
	public JList<String> getJlName() {
		return jlName;
	}

	public void setJlName(JList<String> jlName) {
		this.jlName = jlName;
	}

	public DefaultListModel<String> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}

	
	
	
	
}//class
