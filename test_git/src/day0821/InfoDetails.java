package day0821;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InfoDetails  extends JFrame{
	private JTextField jtfEmpno;
	private JTextField jtfName;
	private JTextField jtfDate;
	private JTextField jtfJob;
	private JTextField jtfSal;
	
	private JLabel jlEmpno;
	private JLabel jlName;
	private JLabel jlDate;
	private JLabel jlJob;
	private JLabel jlSal;

	public InfoDetails() {
		super("InfoDetails");
		jtfEmpno = new JTextField();
		jtfName = new JTextField();
		jtfDate = new JTextField();
		jtfJob = new JTextField();
		jtfSal = new JTextField();
		
		jlEmpno = new JLabel("사원번호");
		jlName = new JLabel("이름");
		jlDate = new JLabel("입사날짜");
		jlJob = new JLabel("업무");
		jlSal = new JLabel("연봉");
		
		add("Center",jtfEmpno);
		add("Center",jtfName);
		add("Center",jtfDate);
		add("Center",jtfJob);
		add("Center",jtfSal);
		
		add("Center",jlEmpno);
		add("Center",jlName);
		add("Center",jlDate);
		add("Center",jlJob);
		add("Center",jlSal);
		
		setLayout(null);
		
		jtfEmpno.setBounds(150, 50, 100,50);
		jtfName.setBounds(150, 110, 100,50);
		jtfDate.setBounds(150, 170, 100,50);
		jtfJob.setBounds(150, 230, 100,50);
		jtfSal.setBounds(150, 290, 100,50);
		
		jlEmpno.setBounds(50, 50, 100,50);
		jlName.setBounds(50, 110, 100,50);
		jlDate.setBounds(50, 170, 100,50);
		jlJob.setBounds(50, 230, 100,50);
		jlSal.setBounds(50, 290, 100,50);

		setVisible(true);
		setBounds(500,500,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public InfoDetails(JTextField jtfEmpno, JTextField jtfName, JTextField jtfDate, JTextField jtfJob,
			JTextField jtfSal) {
		super();
		this.jtfEmpno = jtfEmpno;
		this.jtfName = jtfName;
		this.jtfDate = jtfDate;
		this.jtfJob = jtfJob;
		this.jtfSal = jtfSal;
	}
	@Override
	public String toString() {
		return "InfoDetails [jtfEmpno=" + jtfEmpno + ", jtfName=" + jtfName + ", jtfDate=" + jtfDate + ", jtfJob="
				+ jtfJob + ", jtfSal=" + jtfSal + "]";
	}
	
	public JTextField getJtfEmpno() {
		return jtfEmpno;
	}
	public void setJtfEmpno(JTextField jtfEmpno) {
		this.jtfEmpno = jtfEmpno;
	}
	public JTextField getJtfName() {
		return jtfName;
	}
	public void setJtfName(JTextField jtfName) {
		this.jtfName = jtfName;
	}
	public JTextField getJtfDate() {
		return jtfDate;
	}
	public void setJtfDate(JTextField jtfDate) {
		this.jtfDate = jtfDate;
	}
	public JTextField getJtfJob() {
		return jtfJob;
	}
	public void setJtfJob(JTextField jtfJob) {
		this.jtfJob = jtfJob;
	}
	public JTextField getJtfSal() {
		return jtfSal;
	}
	public void setJtfSal(JTextField jtfSal) {
		this.jtfSal = jtfSal;
	}

}
