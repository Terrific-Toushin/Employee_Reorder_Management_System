package com.example.WorkingPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.example.Admin.Login;
import com.example.Admin.db_connection;

public class PromotionPoint extends JPanel{

	db_connection db = new db_connection();
	
	JFrame frame;
	
	JPanel panelMain =new JPanel();
	
	JPanel panelWest =new JPanel();
	JPanel panelWestNorth =new JPanel();
	JPanel panelWestCenter =new JPanel();
	JPanel panelWestSouth =new JPanel();
	JPanel panelWestSouthNorth =new JPanel();
	JPanel panelWestSouthSouth =new JPanel();
	JPanel panelWestSouthCenter =new JPanel();
	
	
	JPanel panelEast =new JPanel();
	JPanel panelEastNorth =new JPanel();
	JPanel panelEastCenter =new JPanel();
	JPanel panelEastSouth =new JPanel();
	
	
	JLabel lblEmployeeId = new JLabel("Employee Id: ");
	JLabel lblName = new JLabel("Name: ");
	JLabel lblPerformance = new JLabel("Performance: ");
	JLabel lblPresense = new JLabel("Present Percentage: ");
	JLabel lblOldDesignation = new JLabel("Designation: ");
	JLabel lblDesignation = new JLabel("Choose Designation: ");
	JLabel lblPromoteLimit = new JLabel("Promotion Limit Left(year): ");
	JLabel lblPromoteMark = new JLabel("Promotion Mark: ");
	JLabel lblNewSalary = new JLabel("New Salary: ");
	JLabel lblNewDesingnation = new JLabel("New Designation: ");
	
	
	String s[]={"","1","2","3","4","5","6","7","8","9","10"};
	String s1[]={""};
	
	JTextField txtEmployeeId = new JTextField(20);
	JTextField txtName= new JTextField(20);
	JTextField txtPerformance= new JTextField(20);
	JTextField txtPresense = new JTextField(20);
	JTextField txtOldDesignation = new JTextField(20);
	JTextField txtPromoteLimit = new JTextField(20);
	JTextField txtNewSalary = new JTextField(20);
	JTextField txtNewDesignation = new JTextField(20);
	
	JComboBox cmbPromoteMark =  new JComboBox(s);
	JComboBox cmbDesignation =  new JComboBox(s1);
	
	JLabel lblNorthImage =  new JLabel(new ImageIcon("images/promotenorth.png"));
	
	JButton btnAdd = new JButton("Save",new ImageIcon("images/add.png"));
	JButton btnEdit = new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton btnRefresh = new JButton("Refresh",new ImageIcon("images/refresh.png"));
	JButton btnLogout = new JButton("Logout",new ImageIcon("images/logout2.png"));
	JButton btnPrint = new JButton("Print",new ImageIcon("images/print.png"));

	
	String column[]={"Employee Id","Full Name","Designation","Salary"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTableEast=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String column1[]={"Employee Id","Full Name","Designation","Salary","Date of Join"};
	Object row1[][]={};
	DefaultTableModel model1=new DefaultTableModel(row1,column1);
	JTable table1=new JTable(model1);
	JScrollPane scrollTableWest=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	GridBagConstraints c = new GridBagConstraints();
	
	String designation,t;
	
	int se,e,vg,g,a,b;
	
	public PromotionPoint(JFrame frame1) {
		
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		this.frame=frame1;
		this.frame.setSize(1200,730);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle("Admin Panel");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmp();
		action();
		initialSetup();
		cmbdesignationLoad();
		tabledata();
	}
	


	private void initialSetup() {
		
		lblEmployeeId.setFont(new Font("tahoma", Font.PLAIN,16));
		lblDesignation.setFont(new Font("tahoma", Font.PLAIN,16));
		lblName.setFont(new Font("tahoma", Font.PLAIN,16));
		lblPerformance.setFont(new Font("tahoma", Font.PLAIN,16));
		lblOldDesignation.setFont(new Font("tahoma", Font.PLAIN,16));
		lblPresense.setFont(new Font("tahoma", Font.PLAIN,16));
		lblPromoteLimit.setFont(new Font("tahoma", Font.PLAIN,16));
		lblPromoteMark.setFont(new Font("tahoma", Font.PLAIN,16));
		lblNewDesingnation.setFont(new Font("tahoma", Font.PLAIN,16));
		lblNewSalary.setFont(new Font("tahoma", Font.PLAIN,16));
		
		txtName.setFont(new Font("tahoma", Font.PLAIN,15));
		txtEmployeeId.setFont(new Font("tahoma", Font.PLAIN,15));
		txtOldDesignation.setFont(new Font("tahoma", Font.PLAIN,15));
		txtPerformance.setFont(new Font("tahoma", Font.PLAIN,15));
		txtNewDesignation.setFont(new Font("tahoma", Font.PLAIN,15));
		txtNewSalary.setFont(new Font("tahoma", Font.PLAIN,15));
		txtPresense.setFont(new Font("tahoma", Font.PLAIN,15));
		txtPromoteLimit.setFont(new Font("tahoma", Font.PLAIN,15));
		cmbDesignation.setFont(new Font("tahoma", Font.PLAIN,15));
		cmbPromoteMark.setFont(new Font("tahoma", Font.PLAIN,15));
		
		btnAdd.setFont(new Font("times new roman", Font.BOLD,15));
		btnEdit.setFont(new Font("times new roman", Font.BOLD,15));
		btnRefresh.setFont(new Font("times new roman", Font.BOLD,15));
		btnPrint.setFont(new Font("times new roman", Font.BOLD,15));
		btnLogout.setFont(new Font("times new roman", Font.BOLD,15));
		
		
		cmbDesignation.setPreferredSize(new Dimension(300,30));
		btnPrint.setPreferredSize(new Dimension(515,45));
		//lblPromotion.setFont(new Font("times new roman", Font.PLAIN,18));
		
		/*txtEmployeeId.setBorder(BorderFactory.createLineBorder(Color.gray));
		txtName.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtOldDesignation.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtOldSalary.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtPresense.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		txtNewSalary.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		txtNewDesignation.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		txtPromoteLimit.setBorder(BorderFactory.createLineBorder(Color.gray));
		cmbDesignation.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		cmbPromoteMark.setBorder(BorderFactory.createLineBorder(Color.lightGray));
	
		txtEmployeeId.setPreferredSize(new Dimension(1,30));
		txtName.setPreferredSize(new Dimension(1,30));
		txtOldDesignation.setPreferredSize(new Dimension(1,30));
		txtOldSalary.setPreferredSize(new Dimension(1,30));
		txtPresense.setPreferredSize(new Dimension(1,30));
		txtPromoteLimit.setPreferredSize(new Dimension(1,30));
		txtNewDesignation.setPreferredSize(new Dimension(1,30));
		txtNewSalary.setPreferredSize(new Dimension(1,30));
		cmbPromoteMark.setPreferredSize(new Dimension(1,30));
		
		*/
		txtEmployeeId.setEditable(false);
		txtName.setEditable(false);
		txtOldDesignation.setEditable(false);
		txtPerformance.setEditable(false);
		txtPresense.setEditable(false);
		txtPromoteLimit.setEditable(false);
		
		
	}
	
	private void cmp() {

		setLayout(new BorderLayout());
		add(panelMain,BorderLayout.CENTER);
		setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
		
		panelMain.setLayout(new BorderLayout());
		panelMain.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelMain.add(panelWest,BorderLayout.WEST);
		panelMain.add(panelEast,BorderLayout.EAST);
		
		west_work();
		east_work();

	}

	private void west_work() {
		
		panelWest.setPreferredSize(new Dimension(650,1));
		//panelWest.setBackground(Color.red);
		panelWest.setBorder(BorderFactory.createLineBorder(Color.darkGray,2));
		
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		
		
		west_north_work();
		west_center_work();
		west_south_work();
		
	}

	private void west_north_work() {
		
		panelWestNorth.setPreferredSize(new Dimension(1,50));
	//	panelWestNorth.setBackground(Color.green);
		panelWestNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panelWestNorth.setLayout(new GridBagLayout());
		
		c.insets=new Insets(2, 3, 4, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelWestNorth.add(lblDesignation,c);
		
		c.gridx=1;
		c.gridy=0;
		panelWestNorth.add(cmbDesignation,c);
		
	}

	private void west_center_work() {
		
		FlowLayout flow = new FlowLayout();
		//panelWestCenter.setPreferredSize(new Dimension(520,1));
		panelWestCenter.setLayout(flow);
		//panelWestCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTableWest.setPreferredSize(new Dimension(640,200));
		panelWestCenter.add(scrollTableWest);

		flow.setVgap(3);
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);
	
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		/*table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(210);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);*/

	}

	private void west_south_work() {
		
		FlowLayout flow  = new FlowLayout();
		
		panelWestSouth.setPreferredSize(new Dimension(1,418));
		//panelWestSouth.setBackground(Color.red);
		//panelWestSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panelWestSouth.setLayout(new BorderLayout());
		panelWestSouth.add(panelWestSouthNorth,BorderLayout.NORTH);
		panelWestSouth.add(panelWestSouthCenter,BorderLayout.CENTER);
		panelWestSouth.add(panelWestSouthSouth,BorderLayout.SOUTH);
		
		panelWestSouthNorth.setPreferredSize(new Dimension(1,240));
		//panelWestSouthNorth.setBackground(Color.red);
		
		panelWestSouthNorth.setLayout(new GridBagLayout());
		
		c.insets=new Insets(2, 3, 3, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelWestSouthNorth.add(lblEmployeeId,c);
		
		c.gridx=1;
		c.gridy=0;
		panelWestSouthNorth.add(txtEmployeeId,c);
		
		c.gridx=0;
		c.gridy=1;
		panelWestSouthNorth.add(lblName,c);
		
		c.gridx=1;
		c.gridy=1;
		panelWestSouthNorth.add(txtName,c);
		
		c.gridx=0;
		c.gridy=2;
		panelWestSouthNorth.add(lblOldDesignation,c);
		
		c.gridx=1;
		c.gridy=2;
		panelWestSouthNorth.add(txtOldDesignation,c);
		
		
		c.gridx=0;
		c.gridy=3;
		panelWestSouthNorth.add(lblPresense,c);
		
		c.gridx=1;
		c.gridy=3;
		panelWestSouthNorth.add(txtPresense,c);
		
		
		c.gridx=0;
		c.gridy=4;
		panelWestSouthNorth.add(lblPerformance,c);
		
		c.gridx=1;
		c.gridy=4;
		panelWestSouthNorth.add(txtPerformance,c);
		
		
		c.gridx=0;
		c.gridy=5;
		panelWestSouthNorth.add(lblPromoteLimit,c);
		
		c.gridx=1;
		c.gridy=5;
		panelWestSouthNorth.add(txtPromoteLimit,c);
		
		
		
		
		
		
	//	panelWestSouthCenter.setBackground(Color.blue);
		panelWestSouthCenter.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelWestSouthCenter.setLayout(new GridBagLayout());
		
		c.insets=new Insets(2, 3, 3, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(2, 0, 3, 16);
		panelWestSouthCenter.add(lblPromoteMark,c);
		
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(2, 15, 3, 0);
		panelWestSouthCenter.add(cmbPromoteMark,c);
		
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(2, 0, 3, 16);
		panelWestSouthCenter.add(lblNewDesingnation,c);
		
		c.gridx=1;
		c.gridy=1;
		c.insets=new Insets(2, 15, 3, 0);
		panelWestSouthCenter.add(txtNewDesignation,c);
		
		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(2, 0, 3, 16);
		panelWestSouthCenter.add(lblNewSalary,c);
		
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(2, 15, 3, 0);
		panelWestSouthCenter.add(txtNewSalary,c);
		
		
		
		
		
		
		
		
		
		panelWestSouthSouth.setPreferredSize(new Dimension(1,46));
		//panelWestSouthSouth.setBackground(Color.green);
		
		panelWestSouthSouth.setLayout(flow);
		panelWestSouthSouth.add(btnAdd);
		panelWestSouthSouth.add(btnEdit);
		panelWestSouthSouth.add(btnRefresh);
		panelWestSouthSouth.add(btnLogout);
		
		flow.setHgap(20);
		flow.setVgap(6);
		
	}

	private void east_work() {
		panelEast.setPreferredSize(new Dimension(520,1));
		
		panelEast.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelEast.setLayout(new BorderLayout());
		panelEast.add(panelEastNorth,BorderLayout.NORTH);
		panelEast.add(panelEastCenter,BorderLayout.CENTER);
		panelEast.add(panelEastSouth,BorderLayout.SOUTH);
		
		
		east_north_work();
		east_center_work();
		east_south_work();
		
		
		//panelEast.setBackground(Color.green);
	}

	private void east_north_work() {
		
		FlowLayout flow = new FlowLayout();
		panelEastNorth.setPreferredSize(new Dimension(1,48));
		//panelEastNorth.setLayout(flow);
		panelEastNorth.add(lblNorthImage);
		
		
		//panelEastNorth.setBackground(Color.blue);
	}

	private void east_center_work() {
		
		FlowLayout flow = new FlowLayout();
		panelEastCenter.setPreferredSize(new Dimension(520,1));
		panelEastCenter.setLayout(flow);
		panelEastCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTableEast.setPreferredSize(new Dimension(510,570));
		panelEastCenter.add(scrollTableEast);

		flow.setVgap(2);
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);
	}

	private void east_south_work() {
		
		FlowLayout flow = new FlowLayout();
		
		panelEastSouth.setPreferredSize(new Dimension(1,46));
		
		panelEastSouth.setLayout(flow);
		panelEastSouth.add(btnPrint);
		flow.setVgap(0);
		//panelEastSouth.setBackground(Color.orange);
	}

	
	
	
	
	
	
	
	public void cmbdesignationLoad() {
		
		try
		{
			cmbDesignation.removeAllItems();
			cmbDesignation.addItem("");
			
			String sql="select distinct designation from tbl_employee";
			ResultSet rs=db.sta.executeQuery(sql);
			while(rs.next())
			{
				cmbDesignation.addItem(rs.getString("designation"));
			}
		}
		catch(Exception e)
		{
			cmbDesignation.removeAllItems();
			cmbDesignation.addItem("");
			
			String sql="select distinct designation from tbl_employee";
			ResultSet rs;
				try {
					rs = db.sta.executeQuery(sql);
					while(rs.next())
					{
						cmbDesignation.addItem(rs.getString("designation"));
					}
				} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					
				}
			
			//JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	
	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}

		String s="select employeeid,name,designation,salary,cast(substring(employeeid,locate('-',employeeid)+1,LENGTH(employeeid)-locate('-',employeeid)) as unsigned) as ord from tbl_employee order by ord";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String Name=rs.getString("name");
				String designation=rs.getString("designation");
				String salary=rs.getString("salary");
				
				model.addRow(new Object[]{id,Name,designation,salary});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}
	
	
	public void tableDataWest()
	{

		for(int a=model1.getRowCount()-1;a>=0;a--)
		{
			model1.removeRow(a);
		}

		String s="select employeeid,name,designation,salary,datejoin,cast(substring(employeeid,locate('-',employeeid)+1,LENGTH(employeeid)-locate('-',employeeid)) as unsigned) as ord from tbl_employee where designation='"+designation+"' order by ord";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String Name=rs.getString("name");
				String designation=rs.getString("designation");
				String salary=rs.getString("salary");
				String datejoin=rs.getString("datejoin");
				
				model1.addRow(new Object[]{id,Name,designation,salary,datejoin});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		
	}
	
	
	private void checkExist(String id) {

		try{
			
			int count=0,pers,total=0,res;
			
			se=0;
			e=0;
			vg=0;
			g=0;
			a=0;
			b=0;
			
			
			ResultSet rs=db.sta.executeQuery("select * from tbl_present where employeeid='"+id+"'");
			while(rs.next()){
				
				pers = Integer.parseInt(rs.getString("present"));
				total = total+pers;
				count++;
			}
			if(count!=0)
			{
				res = (int) Math.ceil(total/count);
			}
			else
			{
				res=0;
			}
			
			

			ResultSet rs1=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs1.next()){
				
				//System.out.println(rs.getString("bookid") + "\n"+rs.getString("subject") + "\n"+ rs.getString("department") + "\n"+ "\n"+ rs.getString("semester") + "\n"+ "\n"+ rs.getString("bookname") + "\n"+ "\n"+ rs.getString("author") + "\n"+ "\n"+ rs.getString("edition") + "\n"+ "\n"+ rs.getString("course") + "\n"+ "\n"+ rs.getString("admin") + "\n"+ "\n"+ rs.getString("file") + "\n"+ "\n"+ rs.getString("date"));
				
				String employeeid = rs1.getString("employeeid");
				String designation = rs1.getString("designation");
				String name = rs1.getString("name");
				String datejoin = rs1.getString("datejoin");
				
				
				StringTokenizer str = new StringTokenizer(datejoin,"/");
				
				String d=str.nextToken();
				String m=str.nextToken();
				String y=str.nextToken();
				
				int datejoin1 = Integer.parseInt(y);
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();

				t=dateFormat.format(date);
				StringTokenizer str1 = new StringTokenizer(t,"/");
				
				String d1=str1.nextToken();
				String m1=str1.nextToken();
				String y1=str1.nextToken();
				
				int yPresent = Integer.parseInt(y1);
				
				int yearCount = 4 - (yPresent - datejoin1);
				
				
				txtEmployeeId.setText(employeeid);
				txtName.setText(name);
				txtOldDesignation.setText(designation);
				txtPresense.setText(res+""+"%");
				txtPromoteLimit.setText(yearCount+"");
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid Employee ID!","Sorry..",JOptionPane.WARNING_MESSAGE);
			}
			
			
			
			ResultSet rs2=db.sta.executeQuery("select * from tbl_compute where employeeid='"+id+"'");
			while(rs2.next()){
				
				//System.out.println(rs.getString("bookid") + "\n"+rs.getString("subject") + "\n"+ rs.getString("department") + "\n"+ "\n"+ rs.getString("semester") + "\n"+ "\n"+ rs.getString("bookname") + "\n"+ "\n"+ rs.getString("author") + "\n"+ "\n"+ rs.getString("edition") + "\n"+ "\n"+ rs.getString("course") + "\n"+ "\n"+ rs.getString("admin") + "\n"+ "\n"+ rs.getString("file") + "\n"+ "\n"+ rs.getString("date"));
				
				String performance = rs2.getString("performance");
				
				if(performance.equalsIgnoreCase("Super Excellent"))
				{
					se++;
				}
				else if(performance.equalsIgnoreCase("Excellent"))
				{
					e++;
				}
				else if(performance.equalsIgnoreCase("Very Good"))
				{
					vg++;
				}
				else if(performance.equalsIgnoreCase("Good"))
				{
					g++;
				}
				else if(performance.equalsIgnoreCase("Average"))
				{
					a++;
				}
				else if(performance.equalsIgnoreCase("Bad"))
				{
					b++;
				}

			}
			
			if(se>=vg && se>=e && se>=g  && se>=a  && se>=b)
			{
				txtPerformance.setText("Super Excellent");
			}
			
			else if(e>=vg && e>=se && e>=g  && e>=a  && e>=b)
			{
				txtPerformance.setText("Excellent");
			}
			
			else if(vg>=se && vg>=e && vg>=g  && vg>=a  && vg>=b)
			{
				txtPerformance.setText("Very Good");
			}
			
			else if(g>=se && g>=e && g>=vg  && g>=a  && g>=b)
			{
				txtPerformance.setText("Good");
			}
			
			else if(a>=vg && a>=e && a>=g  && a>=se  && a>=b)
			{
				txtPerformance.setText("Average");
			}
			
			else if(b>=vg && b>=e && b>=g  && b>=a  && b>=se)
			{
				txtPerformance.setText("Bad");
			}
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}


	
	
	
	
	public boolean validation()
	{
		
		if(!txtNewDesignation.getText().trim().isEmpty()){
			if(!txtNewSalary.getText().trim().isEmpty()){
				if(cmbPromoteMark.getSelectedIndex()!=0){
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null, "Please, Select Promotion Mark","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please, Enter New Salary","Sorry!",JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Please, Enter new Designaiton","Sorry!",JOptionPane.WARNING_MESSAGE);
		}
		
		return false;
	}
	
	private boolean checkConfirmed(String s) {

		int a=JOptionPane.showConfirmDialog(null, "Sure To "+s,"Confirmation...",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	private void txtClear() {
		
		txtName.setText(null);
		txtEmployeeId.setText(null);
		txtNewSalary.setText(null);
		txtNewDesignation.setText(null);
		cmbPromoteMark.setSelectedItem("");
		txtOldDesignation.setText(null);
		txtPerformance.setText(null);
		txtPresense.setText(null);
		txtPromoteLimit.setText(null);
		
		
	}
	
	
	
	protected void insertdata() {
		try{
			
			db.sta.executeUpdate("update tbl_compute set designation='"+txtNewDesignation.getText().trim()+"',salary='"+txtNewSalary.getText().trim()+"' where employeeid='"+txtEmployeeId.getText().trim()+"'");
		
			db.sta.executeUpdate("update tbl_employee set designation='"+txtNewDesignation.getText().trim()+"',salary='"+txtNewSalary.getText().trim()+"' where employeeid='"+txtEmployeeId.getText().trim()+"'");
			
			cmbdesignationLoad();
			
			txtClear();
			tableDataWest();
			
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	public void action()
	{
		
		table1.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseClicked(MouseEvent arg0) {

				checkExist(table1.getValueAt(table1.getSelectedRow(), 0).toString());
			}
		});
		
		

		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {


				frame.setVisible(false);
				Login hm=new Login();
					
			}
		}); 
		
		
		cmbDesignation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(cmbDesignation.getSelectedIndex()!=0 && cmbDesignation.getSelectedItem()!=null)
				{
					
					designation = cmbDesignation.getSelectedItem().toString();
					
					//JOptionPane.showMessageDialog(null, designation);
					
					tableDataWest();
					
					
					
				}
				
				else
				{

					//JOptionPane.showMessageDialog(null, "Please Choose a Designation","Error!!",JOptionPane.ERROR_MESSAGE);
				}
					
				
				
				
			}
		});
		
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(validation())
				{
					if(checkConfirmed("Save"))
					{
						insertdata();
						tabledata();
						
					}
				}
			}
		});
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(validation())
				{
					if(checkConfirmed("Save"))
					{
						insertdata();
						tabledata();
						
					}
				}
			}
		});
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				txtClear();
			}
		});
	
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MessageFormat Header=new MessageFormat("All Employee Information");
				MessageFormat Footer=new MessageFormat("Page 0");

				try {

					table.print(JTable.PrintMode.FIT_WIDTH,Header,Footer);
				} 

				catch (PrinterException e) {

					e.printStackTrace();
					//System.out.print("Error Printing",e.getMessage());
					JOptionPane.showMessageDialog(null, "Error Printing");
				}
			}
		});
	}

}
