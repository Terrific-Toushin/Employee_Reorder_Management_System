package com.example.Menuitem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.example.Admin.db_connection;


public class SignIn extends JPanel{

	db_connection db =  new db_connection();
	
	JPanel panelWest = new JPanel();
	JPanel panelWestNorth = new JPanel();
	JPanel panelWestNorthNorth = new JPanel();
	JPanel panelWestNorthSouth = new JPanel();
	JPanel panelWestNorthCenter = new JPanel();
	JPanel panelWestNorthCenterNorth = new JPanel();
	JPanel panelWestNorthCenterSouth = new JPanel();

	JPanel panelWestNorthCenterSouthWest = new JPanel();
	JPanel panelWestNorthCenterSouthEast = new JPanel();
	
	
	JPanel panelWestNorthWest = new JPanel();
	JPanel panelWestNorthEast = new JPanel();
	
	
	
	JPanel panelWestSouth = new JPanel();
	JPanel panelWestSouthNorth = new JPanel();
	JPanel panelWestSouthSouth = new JPanel();
	JPanel panelWestSouthCenter = new JPanel();
	JPanel panelWestSouthCenterNorth = new JPanel();
	JPanel panelWestSouthCenterSouth = new JPanel();
	
	
	JPanel panelWestSouthWest = new JPanel();
	JPanel panelWestSouthEast = new JPanel();
	
	JPanel panelEast = new JPanel();
	
	
	
	JLabel lblEmployeeId = new JLabel("Employee Id:");
	JLabel lblName = new JLabel("Name: ");
	JLabel lblDesignation = new JLabel("Designation: ");
	JLabel lblMobile = new JLabel("Mobile No: ");
	JLabel lblEmail = new JLabel("Email Id: ");
	JLabel lblUpload = new JLabel("");
	JLabel lblDate = new JLabel("Date: ");
	JLabel lblEntryTime = new JLabel("Entry Time: ");
	
	
	JTextField txtEmployeeId = new JTextField(20);
	JTextField txtName = new JTextField(20);
	JTextField txtDesignation = new JTextField(20);
	JTextField txtMobile = new JTextField(20);
	JTextField txtEmail = new JTextField(20);
	JTextField txtDate = new JTextField(20);
	JTextField txtEntryTime = new JTextField(20);
	
	
	JButton btnSignIn = new JButton("Sign In",new ImageIcon("images/signin.png"));
	JButton btnSearch = new JButton("Search",new ImageIcon("images/search.png"));
	
	GridBagConstraints c= new GridBagConstraints();
	
	String column[]={"Employee Id","Date","Entry Time"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	String t;
	JFileChooser Chooser=new JFileChooser();
	File file;
	BufferedImage buffer;

	String s2,t1,t2,d,t3,t4,t5,t6,id,day,month,dateall,year;
	int temp=0,temp1=0,timeTemp=0,idCount,empId=0,month1,year1;
	
	public SignIn() {
	
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		setPreferredSize(new Dimension(1165,610));
		//setBackground(Color.red);
		cmp();
		action();
		initialSetup();
		tabledata();
		timecount();
	}

	private void cmp() {

		setLayout(new BorderLayout());
		add(panelWest,BorderLayout.WEST);
		add(panelEast,BorderLayout.EAST);

		eastWork();
		WestWork();
		
	}

	public void initialSetup()
	{
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSearch.setFont(new Font("Times new roman", Font.BOLD, 17));
		txtEmployeeId.setForeground(Color.red);

		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		lblUpload.setPreferredSize(new Dimension(180,180));
		
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEntryTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEntryTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSignIn.setFont(new Font("Times new roman", Font.BOLD, 18));
		
		txtEmployeeId.setHorizontalAlignment(JTextField.CENTER);
		
		txtEntryTime.setText(" "+"Click Here....");
		txtEntryTime.setForeground(Color.gray);
		
		txtEmployeeId.setText("Enter Employee Id....");
		txtEmployeeId.setForeground(Color.gray);
		
		txtEntryTime.setEditable(false);
		
		
		//txtDate.setText(" "+t);
		
		txtName.setEditable(false);
		txtMobile.setEditable(false);
		txtEmail.setEditable(false);
		txtDesignation.setEditable(false);
		
		
	}
	
	private void WestWork() {

		panelWest.setPreferredSize(new Dimension(650,1));
		//panelWest.setBackground(Color.green);

		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		
		panelWestNorth.setPreferredSize(new Dimension(1,360));
		//panelWestNorth.setBackground(Color.green);
		
		panelWestNorth.setLayout(new BorderLayout());
		panelWestNorth.add(panelWestNorthNorth,BorderLayout.NORTH);
		panelWestNorth.add(panelWestNorthSouth,BorderLayout.SOUTH);
		panelWestNorth.add(panelWestNorthCenter,BorderLayout.CENTER);
		panelWestNorth.add(panelWestNorthWest,BorderLayout.WEST);
		panelWestNorth.add(panelWestNorthEast,BorderLayout.EAST);
		
		
		
		panelWestSouth.setPreferredSize(new Dimension(1,258));
		//panelWestSouth.setBackground(Color.blue);
		
		
		panelWestSouth.setLayout(new BorderLayout());
		panelWestSouth.add(panelWestSouthNorth,BorderLayout.NORTH);
		panelWestSouth.add(panelWestSouthSouth,BorderLayout.SOUTH);
		panelWestSouth.add(panelWestSouthCenter,BorderLayout.CENTER);
		panelWestSouth.add(panelWestSouthWest,BorderLayout.WEST);
		panelWestSouth.add(panelWestSouthEast,BorderLayout.EAST);
	
		
		westNorthCenter();
		westSouthCenter();
	}
	
	
	private void westNorthCenter() {

		panelWestNorthCenter.setLayout(new BorderLayout());
		panelWestNorthCenter.add(panelWestNorthCenterNorth,BorderLayout.NORTH);
		panelWestNorthCenter.add(panelWestNorthCenterSouth,BorderLayout.SOUTH);
		
		panelWestNorthCenterNorth.setPreferredSize(new Dimension(1,60));
		panelWestNorthCenterSouth.setPreferredSize(new Dimension(1,275));
		
		
		
		
		//panelWestNorthCenterNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panelWestNorthCenterNorth.setLayout(new GridBagLayout());

		c.insets=new Insets(1, 3, 1, 4);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelWestNorthCenterNorth.add(txtEmployeeId,c);
		
	/*	c.gridx=1;
		c.gridy=0;
		panelWestNorthCenterNorth.add(txtEmployeeId,c);
		*/
		c.insets=new Insets(1, 10, 1, 4);
		c.gridx=1;
		c.gridy=0;
		panelWestNorthCenterNorth.add(btnSearch,c);
		
		
		//panelWestNorthCenterSouth.setBorder(BorderFactory.createLineBorder(Color.gray,2));
		
		panelWestNorthCenterSouth.setLayout(new BorderLayout());
		
		
		panelWestNorthCenterSouth.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		panelWestNorthCenterSouth.add(panelWestNorthCenterSouthWest,BorderLayout.WEST);
		panelWestNorthCenterSouth.add(panelWestNorthCenterSouthEast,BorderLayout.EAST);
		
		panelWestNorthCenterSouthWest.setPreferredSize(new Dimension(427,1));
		panelWestNorthCenterSouthEast.setPreferredSize(new Dimension(206,1));
		//panelWestNorthCenterSouthWest.setBackground(Color.blue);
		//panelWestNorthCenterSouthEast.setBackground(Color.yellow);
		
		
		panelWestNorthCenterSouthWest.setLayout(new GridBagLayout());

		c.insets=new Insets(5, 3, 4, 3);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelWestNorthCenterSouthWest.add(lblName,c);
		
		c.gridx=1;
		c.gridy=0;
		panelWestNorthCenterSouthWest.add(txtName,c);
		
		c.gridx=0;
		c.gridy=1;
		panelWestNorthCenterSouthWest.add(lblDesignation,c);
		
		c.gridx=1;
		c.gridy=1;
		panelWestNorthCenterSouthWest.add(txtDesignation,c);
		
		c.gridx=0;
		c.gridy=2;
		panelWestNorthCenterSouthWest.add(lblMobile,c);
		
		c.gridx=1;
		c.gridy=2;
		panelWestNorthCenterSouthWest.add(txtMobile,c);
		
		c.gridx=0;
		c.gridy=3;
		panelWestNorthCenterSouthWest.add(lblEmail,c);
		
		c.gridx=1;
		c.gridy=3;
		panelWestNorthCenterSouthWest.add(txtEmail,c);
		
		
		FlowLayout flow = new FlowLayout();
		panelWestNorthCenterSouthEast.setLayout(flow);
		panelWestNorthCenterSouthEast.add(lblUpload);
		flow.setVgap(45);
	}

	
	private void westSouthCenter() {
		
		panelWestSouthCenter.setLayout(new BorderLayout());
		panelWestSouthCenter.add(panelWestSouthCenterNorth,BorderLayout.NORTH);
		panelWestSouthCenter.add(panelWestSouthCenterSouth,BorderLayout.SOUTH);
		
		panelWestSouthCenterNorth.setPreferredSize(new Dimension(1,160));
		panelWestSouthCenterSouth.setPreferredSize(new Dimension(1,78));
		//panelWestSouthCenterNorth.setBackground(Color.orange);
		//panelWestSouthCenterSouth.setBackground(Color.yellow);
		
		panelWestSouthCenter.setBorder(BorderFactory.createLineBorder(Color.gray,2,true));
		
		panelWestSouthCenterNorth.setLayout(new GridBagLayout());

		c.insets=new Insets(15, 3, 4, 3);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelWestSouthCenterNorth.add(lblDate,c);
		
		c.gridx=1;
		c.gridy=0;
		panelWestSouthCenterNorth.add(txtDate,c);
		
		c.insets=new Insets(5, 3, 4, 3);
		c.gridx=0;
		c.gridy=1;
		panelWestSouthCenterNorth.add(lblEntryTime,c);
		
		c.gridx=1;
		c.gridy=1;
		panelWestSouthCenterNorth.add(txtEntryTime,c);
		
		
		FlowLayout flow = new FlowLayout();
		panelWestSouthCenterSouth.setLayout(flow);
		panelWestSouthCenterSouth.add(btnSignIn);
		flow.setVgap(10);
		
		
	}
	
	
	private void eastWork() {

		//panelEast.setBackground(Color.red);
		
		FlowLayout flow = new FlowLayout();
		panelEast.setPreferredSize(new Dimension(520,1));
		panelEast.setLayout(flow);
		panelEast.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTable.setPreferredSize(new Dimension(510,610));
		panelEast.add(scrollTable);

		flow.setVgap(0);
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);
		
	}
	
	public void timecount()
	{
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		t=dateFormat.format(date);
		
		StringTokenizer str = new StringTokenizer(t);
	
		d=str.nextToken();
		t2=str.nextToken();

		txtDate.setText(d);
		
		int i,j,k,l;

		StringTokenizer str1=new StringTokenizer(t2,":");
		t3=str1.nextToken();
		t4=str1.nextToken();
		t5=str1.nextToken();
		
		i=Integer.parseInt(t3);
		//System.out.println(i);
		if(i>12)
		{
			j=i-12;
			System.out.println(i);
			t6=j+"";
			
			timeTemp=1;
			
		}
		else if(i==12)
		{
			t6=i+"";
			timeTemp=1;
		}
		else
		{	
			timeTemp=2;
		}

	}
	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}
		//String s="select *,cast(substring(2,10) as unsigned) as ord from tbl_signin order by ord";
		//String s="select *,cast(substring(bookid,locate('-',bookid)+1,LENGTH(bookid)-locate('-',bookid)) as unsigned) as ord from tbl_addbook order by ord";
		
		String s="select employeeid,date,time from tbl_signin order by autoid";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String date=rs.getString("date");
				String time=rs.getString("time");
				
				model.addRow(new Object[]{id,date,time});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}

	private void checkExistPer(String id) {

		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs.next()){
				txtName.setText(rs.getString("name"));
				txtMobile.setText(rs.getString("mobile"));
				txtEmail.setText(rs.getString("email"));
				txtDesignation.setText(rs.getString("designation"));
				
				Image image=Toolkit.getDefaultToolkit().getImage(rs.getString("image").replace("#", "\\"));
				file=new File(rs.getString("image").replace("#", "\\"));
				Image resize=image.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(),image.SCALE_DEFAULT);
				lblUpload.setIcon(new ImageIcon(resize));
				temp=1;
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid ID!","Sorry..",JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public boolean validation()
	{
		if(!txtDate.getText().trim().isEmpty()){
			if(!txtEntryTime.getText().trim().isEmpty() && !txtEntryTime.getText().equalsIgnoreCase("click here...."))
			{
				if(!txtEmployeeId.getText().trim().isEmpty() && !txtEmployeeId.getText().equalsIgnoreCase("enter employee id....")){
					
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Employee Id","Insert Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Enter Time","Insert Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Please Enter Date","Insert Warning",JOptionPane.WARNING_MESSAGE);
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

	protected void insertdata() {
	
		idCount=0; 
		
		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_signin where date='"+txtDate.getText().trim()+"'");
			while(rs.next()){
				
				id = rs.getString("employeeid");
				if(txtEmployeeId.getText().trim().equalsIgnoreCase(id))
				{
					idCount =1 ;
					break;
				}
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		try{	
			if(idCount == 1)
			{
				JOptionPane.showMessageDialog(null, "Employee Id  "+id+"  is Already Signed In","SignIn Error!!",JOptionPane.ERROR_MESSAGE);
				txtClear();
			}
			else
			{
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();

				dateall=dateFormat.format(date);
				StringTokenizer str = new StringTokenizer(dateall,"/");
				day = str.nextToken();
				month = str.nextToken();
				year = str.nextToken();
				
				month1 = Integer.parseInt(month); 
				
				db.sta.executeUpdate("insert into tbl_signin(employeeid,date,time,month,year) values('"+txtEmployeeId.getText().trim()+"','"+txtDate.getText().trim()+"','"+txtEntryTime.getText().trim()+"','"+month+"','"+year+"')");
				JOptionPane.showMessageDialog(null, "Employee Signed In Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
			}

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void txtClear()
	{
		txtEmployeeId.setText(null);
		txtName.setText(null);
		txtDesignation.setText(null);
		txtMobile.setText(null);
		txtEmail.setText(null);
		
		txtEntryTime.setText("Click Here....");
		txtEmployeeId.setText("Enter Employee Id....");
		
		txtEntryTime.setForeground(Color.gray);
		txtEmployeeId.setForeground(Color.gray);
		
		lblUpload.setIcon(new ImageIcon(""));
		temp=0;
		timeTemp=0;
	}
	
	private void action() {
		
		txtEmployeeId.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(temp1==0)
				{
					txtEmployeeId.setText(null);
					txtEmployeeId.setForeground(Color.red);
				}
				temp1++;
				
			}
		});
		

		txtEntryTime.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(empId == 1)
				{
					txtEntryTime.setEditable(true);
					
					txtEntryTime.setText(null);
					txtEntryTime.setForeground(Color.black);
					timecount();
					
					if(timeTemp==1)
					{
						txtEntryTime.setText(t6+":"+t4+" PM");
					}
					else if(timeTemp==2)
					{
						txtEntryTime.setText(t3+":"+t4+" AM");
					}
				}
				//else
				//{
					//JOptionPane.showMessageDialog(null, "Please At First Complete Search Process","SingIn Error!",JOptionPane.ERROR_MESSAGE);
				//}
	
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtEmployeeId.getText().trim().isEmpty()){
					checkExistPer(txtEmployeeId.getText().trim());
					empId=1;
				}
				else{
					JOptionPane.showMessageDialog(null, "Insert Employee Id","Search Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnSignIn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(validation())
				{
					if(checkConfirmed("Sign In"))
					{
						insertdata();
						tabledata();
						txtClear();
						
						temp1=0;
						empId=0;
						txtEntryTime.setEditable(false);
					}
				}
			}
		});
	}

}
