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


public class SignOut extends JPanel{

	db_connection db =  new db_connection();
	
	JPanel panelNorth = new JPanel();
	JPanel panelSouth = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelCenterNorth = new JPanel();
	JPanel panelCenterSouth = new JPanel();
	JPanel panelCenterCenter = new JPanel();
	JPanel panelCenterCenterNorth = new JPanel();
	JPanel panelCenterCenterSouth = new JPanel();
	JPanel panelCenterCenterCenter = new JPanel();

	JPanel panelCenterCenterCenterNorth = new JPanel();
	JPanel panelCenterCenterCenterWest = new JPanel();
	JPanel panelCenterCenterCenterEast = new JPanel();
	JPanel panelCenterCenterCenterSouth = new JPanel();
	
	
	JPanel panelCenterCenterWest = new JPanel();
	JPanel panelCenterCenterEast = new JPanel();
	
	JPanel panelCenterWest = new JPanel();
	JPanel panelCenterEast = new JPanel();
	
	JPanel panelWest = new JPanel();
	JPanel panelEast = new JPanel();
	
 	
	JLabel lblEmployeeId = new JLabel("Employee Id: ");
	JLabel lblDate = new JLabel("Date: ");
	JLabel lblExitTime = new JLabel("Exit Time: ");
	JLabel lblOvertime = new JLabel("Overtime: ");
	JLabel lblOvertimeTk = new JLabel("Overtime (TK): ");
	JLabel lblUpload = new JLabel("");
	JLabel lblWorkingTime = new JLabel("Working Time: ");
	
	
	JTextField txtEmployeeId = new JTextField(20);
	JTextField txtDate = new JTextField(20);
	JTextField txtExitTime = new JTextField(20);
	JTextField txtOvertime = new JTextField(20);
	JTextField txtOvertimeTk = new JTextField(20);
	JTextField txtWorkingTime = new JTextField(20);
	
	JButton btnSignOut = new JButton("Sign Out",new ImageIcon("images/signout.png"));
	JButton btnSearch = new JButton("Search",new ImageIcon("images/search.png"));
	
	GridBagConstraints c= new GridBagConstraints(); 
	
	String t;
	JFileChooser Chooser=new JFileChooser();
	File file;
	BufferedImage buffer;
	
	String s2,t1,t2,d,t3,t4,t5,t6,time,id,entryTime,year;
	int temp=0,temp1=0,timeTemp=0,idCount,empId=0,idEnrtyCount=0;
	
	String entTime,entTime1, extTime,extTime1, entTimeAmPm, extTimeAmPm, entTimeHour, entTimeMin, extTimeHour, extTimeMin, workTimeHour, workTimeMin,overTimeMin,overTimeHour,day,month;
	int entTimeHour1,entTimeMin1,extTimeHour1,extTimeMin1,workTimeHour1,workTimeMin1,overTimeHour1,overTimeMin1,month1;
	
	public SignOut() {
		
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		setPreferredSize(new Dimension(1165,610));
		//setBackground(Color.green);
		cmp();
		action();
		initialSetup();

	}

	
	private void initialSetup() {
	
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setFont(new Font("Times new roman", Font.BOLD, 17));
		btnSignOut.setFont(new Font("Times new roman", Font.BOLD, 17));
		//txtEmployeeId.setForeground(Color.red);

		
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblExitTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOvertime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOvertimeTk.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWorkingTime.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtExitTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOvertime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtOvertimeTk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtWorkingTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		lblUpload.setPreferredSize(new Dimension(180,180));
		
		txtEmployeeId.setHorizontalAlignment(JTextField.CENTER);
		
		txtDate.setText(" ");
		
		txtExitTime.setText(" "+"Click Here....");
		txtWorkingTime.setText(" "+"Click Here....");
		txtOvertime.setText(" "+"Click Here....");
		txtOvertimeTk.setText(" "+"Click Here....");
		
		txtExitTime.setForeground(Color.gray);
		txtWorkingTime.setForeground(Color.gray);
		txtOvertime.setForeground(Color.gray);
		txtOvertimeTk.setForeground(Color.gray);
		
		txtEmployeeId.setText("Enter Employee Id....");
		txtEmployeeId.setForeground(Color.gray);
		
		txtEmployeeId.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		txtEmployeeId.setHorizontalAlignment(JTextField.CENTER);
		
		txtExitTime.setEditable(false);
		txtWorkingTime.setEditable(false);
		txtOvertime.setEditable(false);
	
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		t=dateFormat.format(date);

		StringTokenizer str = new StringTokenizer(t);
	
		d=str.nextToken();
		t2=str.nextToken();

		txtDate.setText(d);
		
	}

	private void cmp() {

		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		add(panelSouth,BorderLayout.SOUTH);
		add(panelCenter,BorderLayout.CENTER);
		add(panelWest,BorderLayout.WEST);
		add(panelEast,BorderLayout.EAST);
		
		panelNorth.setPreferredSize(new Dimension(1,40));
		panelSouth.setPreferredSize(new Dimension(1,40));
		panelWest.setPreferredSize(new Dimension(50,1));
		panelEast.setPreferredSize(new Dimension(50,1));
		
		panelNorth.setBackground(Color.darkGray);
		panelSouth.setBackground(Color.darkGray);
		panelWest.setBackground(Color.darkGray);
		panelEast.setBackground(Color.darkGray);
		
		centerwork();
		
	}


	private void centerwork() {
		
		
		
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
		panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenter.add(panelCenterWest,BorderLayout.WEST);
		panelCenter.add(panelCenterEast,BorderLayout.EAST);
		
		panelCenterNorth.setPreferredSize(new Dimension(1,40));
		panelCenterSouth.setPreferredSize(new Dimension(1,40));
		panelCenterWest.setPreferredSize(new Dimension(50,1));
		panelCenterEast.setPreferredSize(new Dimension(50,1));
		
		panelCenterNorth.setBackground(Color.gray);
		panelCenterSouth.setBackground(Color.gray);
		panelCenterWest.setBackground(Color.gray);
		panelCenterEast.setBackground(Color.gray);
		
		
		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.add(panelCenterCenterNorth,BorderLayout.NORTH);
		panelCenterCenter.add(panelCenterCenterSouth,BorderLayout.SOUTH);
		panelCenterCenter.add(panelCenterCenterCenter,BorderLayout.CENTER);
		panelCenterCenter.add(panelCenterCenterWest,BorderLayout.WEST);
		panelCenterCenter.add(panelCenterCenterEast,BorderLayout.EAST);
		
		panelCenterCenterNorth.setPreferredSize(new Dimension(1,40));
		panelCenterCenterSouth.setPreferredSize(new Dimension(1,40));
		panelCenterCenterWest.setPreferredSize(new Dimension(50,1));
		panelCenterCenterEast.setPreferredSize(new Dimension(50,1));
		
		panelCenterCenterNorth.setBackground(Color.lightGray);
		panelCenterCenterSouth.setBackground(Color.lightGray);
		panelCenterCenterWest.setBackground(Color.lightGray);
		panelCenterCenterEast.setBackground(Color.lightGray);
		
		
		panelCenterCenterCenter.setLayout(new BorderLayout());
		panelCenterCenterCenter.add(panelCenterCenterCenterNorth,BorderLayout.NORTH);
		panelCenterCenterCenter.add(panelCenterCenterCenterSouth,BorderLayout.SOUTH);
		panelCenterCenterCenter.add(panelCenterCenterCenterWest,BorderLayout.WEST);
		panelCenterCenterCenter.add(panelCenterCenterCenterEast,BorderLayout.EAST);
		
		
		panelCenterCenterCenterNorth.setPreferredSize(new Dimension(1,70));
		panelCenterCenterCenterSouth.setPreferredSize(new Dimension(1,60));
		panelCenterCenterCenterWest.setPreferredSize(new Dimension(537,1));
		panelCenterCenterCenterEast.setPreferredSize(new Dimension(330,1));
		
		/*panelCenterCenterCenterNorth.setBackground(Color.red);
		panelCenterCenterCenterSouth.setBackground(Color.blue);
		panelCenterCenterCenterWest.setBackground(Color.green);
		panelCenterCenterCenterEast.setBackground(Color.yellow);*/
		
		panelCenterCenterCenterNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		//panelCenterCenterCenterSouth.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelCenterCenterCenterEast.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelCenterCenterCenterWest.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		
		panelCenterCenterCenterNorth.setLayout(new GridBagLayout());

		c.insets=new Insets(5, 3, 4, 3);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelCenterCenterCenterNorth.add(txtEmployeeId,c);
		
/*		c.gridx=1;
		c.gridy=0;
		panelCenterCenterCenterNorth.add(txtEmployeeId,c);*/
		
		c.insets=new Insets(5, 12, 4, 3);
		c.gridx=1;
		c.gridy=0;
		panelCenterCenterCenterNorth.add(btnSearch,c);
		
		
		
		panelCenterCenterCenterWest.setLayout(new GridBagLayout());

		c.insets=new Insets(3, 3, 3, 3);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelCenterCenterCenterWest.add(lblDate,c);
		
		c.gridx=1;
		c.gridy=0;
		panelCenterCenterCenterWest.add(txtDate,c);
		
		c.gridx=0;
		c.gridy=1;
		panelCenterCenterCenterWest.add(lblExitTime,c);
		
		c.gridx=1;
		c.gridy=1;
		panelCenterCenterCenterWest.add(txtExitTime,c);
		
		c.gridx=0;
		c.gridy=2;
		panelCenterCenterCenterWest.add(lblWorkingTime,c);
		
		c.gridx=1;
		c.gridy=2;
		panelCenterCenterCenterWest.add(txtWorkingTime,c);
		
		c.gridx=0;
		c.gridy=3;
		panelCenterCenterCenterWest.add(lblOvertime,c);
		
		c.gridx=1;
		c.gridy=3;
		panelCenterCenterCenterWest.add(txtOvertime,c);
		
		/*c.gridx=0;
		c.gridy=4;
		panelCenterCenterCenterWest.add(lblOvertimeTk,c);
		
		c.gridx=1;
		c.gridy=4;
		panelCenterCenterCenterWest.add(txtOvertimeTk,c);*/
		
		
		FlowLayout flow = new FlowLayout();
		panelCenterCenterCenterEast.setLayout(flow);
		panelCenterCenterCenterEast.add(lblUpload);
		flow.setVgap(32);
		
		
		FlowLayout flow1 = new FlowLayout();
		panelCenterCenterCenterSouth.setLayout(flow1);
		panelCenterCenterCenterSouth.add(btnSignOut);
		flow1.setVgap(11);
	}
	
	public void timecount()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		t=dateFormat.format(date);

		StringTokenizer str = new StringTokenizer(t);
	
		d=str.nextToken();
		t2=str.nextToken();
		
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
			//System.out.println(i);
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


	private void workingTimeCount() {
		
		try{
			
			ResultSet rs=db.sta.executeQuery("select * from tbl_signin where date='"+txtDate.getText().trim()+"' and employeeid='"+txtEmployeeId.getText().trim()+"'");
			if(rs.next()){
				
				entTime = rs.getString("time");
			
				extTime = txtExitTime.getText().trim();
			
				System.out.println(entTime);
				System.out.println(extTime);
				
				StringTokenizer str = new StringTokenizer(entTime);
				
				entTime1 = str.nextToken();
				entTimeAmPm = str.nextToken();
				
				StringTokenizer str1 = new StringTokenizer(entTime1,":");
				
				entTimeHour=str1.nextToken();
				entTimeMin=str1.nextToken();
				
				entTimeHour1 = Integer.parseInt(entTimeHour);
				entTimeMin1 = Integer.parseInt(entTimeMin);
				
				
				//System.out.println(entTimeHour+"   "+entTimeMin+"    "+entTimeAmPm);
				
				
				StringTokenizer str2 = new StringTokenizer(extTime);
				
				extTime1 = str2.nextToken();
				extTimeAmPm = str2.nextToken();
				
				StringTokenizer str3 = new StringTokenizer(extTime1,":");
				
				extTimeHour=str3.nextToken();
				extTimeMin=str3.nextToken();
				

				
				
				extTimeHour1 = Integer.parseInt(extTimeHour);
				extTimeMin1 = Integer.parseInt(extTimeMin);
				
				//System.out.println(extTimeHour+"   "+extTimeMin+"    "+extTimeAmPm);
				
				
				
				if(extTimeAmPm.equalsIgnoreCase("pm") && extTimeHour1!=12)
				{
					extTimeHour1 = extTimeHour1+12;
				}
				
				if(extTimeAmPm.equalsIgnoreCase("pm") && extTimeHour1==12)
				{
					extTimeHour1 = 12;
				}
				if(entTimeAmPm.equalsIgnoreCase("pm") && entTimeHour1==12)
				{
					entTimeHour1 = 12;
				}
				
				if(entTimeAmPm.equalsIgnoreCase("pm") && entTimeHour1!=12 )
				{
					entTimeHour1 = entTimeHour1+12;
				}
				
				if(extTimeMin1 < entTimeMin1)
				{
					extTimeHour1 = extTimeHour1-1;
					workTimeMin1 = 60 - (entTimeMin1-extTimeMin1);
				}
				else if(extTimeMin1 > entTimeMin1)
				{
					workTimeMin1 = extTimeMin1-entTimeMin1;
				}
				else if(extTimeMin1 == entTimeMin1)
				{
					workTimeMin = "00";
				}
				
				workTimeMin = workTimeMin1+"";
				
				if(workTimeMin.length()==1)
				{
					workTimeMin = "0"+workTimeMin;
				}
				
				
				if(extTimeHour1 == entTimeHour1)
				{
					workTimeHour = "00";
				}
				else
				{
					workTimeHour1 = extTimeHour1-entTimeHour1;
					workTimeHour = workTimeHour1+"";
				}
				
				if(workTimeHour.length()==1)
				{
					workTimeHour = "0"+workTimeHour;
				}
				
			//	System.out.println();
				System.out.println(workTimeHour1);
				
			}	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void checkExistPer(String id) {

		idEnrtyCount=0;
		
		try{
			ResultSet rs1=db.sta.executeQuery("select * from tbl_signin where date='"+txtDate.getText().trim()+"' and employeeid='"+id+"'");
			if(rs1.next()){
				idEnrtyCount=1;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		if(idEnrtyCount==1)
		{
			try{
				ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
				if(rs.next()){
					
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
		else
		{
			JOptionPane.showMessageDialog(null, id+" Is Absent Today!","Sorry..",JOptionPane.WARNING_MESSAGE);
		}
		
	}

	
	
	public boolean validation()
	{
		if(!txtDate.getText().trim().isEmpty()){
			if(!txtExitTime.getText().trim().isEmpty() && !txtExitTime.getText().equalsIgnoreCase("click here....")){
				if(!txtWorkingTime.getText().trim().isEmpty() && !txtEmployeeId.getText().equalsIgnoreCase("click here....")){
					if(!txtOvertime.getText().trim().isEmpty() && !txtEmployeeId.getText().equalsIgnoreCase("click here....")){
						if(!txtEmployeeId.getText().trim().isEmpty() && !txtEmployeeId.getText().equalsIgnoreCase("click here....")){
							return true;
						}
						else{
							JOptionPane.showMessageDialog(null, "Please Enter Employee Id","Insert Warning",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please Enter OverTime","Insert Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Working Time","Insert Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Enter Exit Time","Insert Warning",JOptionPane.WARNING_MESSAGE);
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
			ResultSet rs=db.sta.executeQuery("select * from tbl_signout where date='"+txtDate.getText().trim()+"'");
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
				JOptionPane.showMessageDialog(null, "Employee Id  "+id+"  is Already Signed Out","SignOut Error!!",JOptionPane.ERROR_MESSAGE);
				txtClear();
			}
			else
			{
				if(idEnrtyCount==1)
				{
					ResultSet rs=db.sta.executeQuery("select * from tbl_signin where date='"+txtDate.getText().trim()+"' and employeeid='"+txtEmployeeId.getText().trim()+"'");
					while(rs.next()){				
						entryTime = rs.getString("time");
					}
		
					
					StringTokenizer str = new StringTokenizer(d,"/");
					day = str.nextToken();
					month = str.nextToken();
					year = str.nextToken();
					
					month1 = Integer.parseInt(month); 
					
					
					
					db.sta.executeUpdate("insert into tbl_signout(employeeid,date,entrytime,exittime,worktime,overtime,month,year) values('"+txtEmployeeId.getText().trim()+"','"+txtDate.getText().trim()+"','"+entryTime+"','"+txtExitTime.getText().trim()+"','"+txtWorkingTime.getText().trim()+"','"+txtOvertime.getText().trim()+"','"+month1+"','"+year+"')");
					JOptionPane.showMessageDialog(null, "Employee Signed Out Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
					
					
				}
				
			}

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void txtClear()
	{	
		txtExitTime.setText("Click Here....");
		txtWorkingTime.setText("Click Here....");
		txtOvertime.setText("Click Here....");
		txtEmployeeId.setText("Enter Employee Id....");
		
		txtExitTime.setForeground(Color.gray);
		txtWorkingTime.setForeground(Color.gray);
		txtOvertime.setForeground(Color.gray);
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

				txtEmployeeId.setText(null);
				txtEmployeeId.setForeground(Color.red);
				
			}
		});
	
		txtExitTime.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(empId==1)
				{
					txtExitTime.setEditable(true);
					
					txtExitTime.setText(null);
					txtExitTime.setForeground(Color.black);
					timecount();
					
					if(timeTemp==1)
					{
						txtExitTime.setText(t6+":"+t4+" PM");
					}
					else if(timeTemp==2)
					{
						txtExitTime.setText(t3+":"+t4+" AM");
					}
				}
			
			}
		});
		
		txtWorkingTime.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(empId==1)
				{
					txtWorkingTime.setEditable(true);
					
					txtWorkingTime.setText(null);
					txtWorkingTime.setForeground(Color.black);
					workingTimeCount();
					txtWorkingTime.setText(workTimeHour+":"+workTimeMin);
	
				}
			
			}
		});
		
		txtOvertime.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(empId==1)
				{
					txtOvertime.setEditable(true);
					
					txtOvertime.setText(null);
					txtOvertime.setForeground(Color.black);
					
					/*if(workTimeMin.length() == 1)
					{
						workTimeMin = "0"+workTimeMin;
					}*/
					
					if(workTimeHour1 == 7)
					{
						overTimeHour= "00";
						overTimeMin=workTimeMin;
					}

					else if(workTimeHour1 > 7)
					{
						overTimeHour1 = workTimeHour1-7;
						overTimeHour = overTimeHour1+"";
						
						if(overTimeHour.length()==1)
						{
							overTimeHour = "0"+overTimeHour;
						}
						
						overTimeMin=workTimeMin;
					}
					else if(workTimeHour1 < 7)
					{
						overTimeMin="00";
						overTimeHour="00";
						
					}
					
					txtOvertime.setText(overTimeHour+":"+overTimeMin);
					
				}
				
				
			}
		});
		
	/*	txtOvertimeTk.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(empId==1)
				{
					txtOvertimeTk.setEditable(true);
					
					txtOvertimeTk.setText(null);
					txtOvertimeTk.setForeground(Color.black);
				}
				
				
			}
		});*/
		
		
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
		
		btnSignOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

			
				if(validation())
				{
					if(checkConfirmed("Sign Out"))
					{
						insertdata();
						txtClear();
						
						temp1=0;
						empId=0;
						txtExitTime.setEditable(false);
						txtWorkingTime.setEditable(false);
						txtOvertime.setEditable(false);
						
					}
				}
				
			}
		});
	}

}
