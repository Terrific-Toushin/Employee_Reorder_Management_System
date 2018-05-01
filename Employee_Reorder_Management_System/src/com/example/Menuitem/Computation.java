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


public class Computation extends JPanel{

	db_connection db =  new db_connection();
	
	JPanel panelNorth =new JPanel();
	JPanel panelNorthWest =new JPanel();
	JPanel panelNorthWestNorth =new JPanel();
	JPanel panelNorthWestSouth =new JPanel();



	JPanel panelNorthEast =new JPanel();
	JPanel panelNorthEastNorth =new JPanel();
	JPanel panelNorthEastSouth =new JPanel();
	
	
	JPanel panelNorthSouth =new JPanel();
	
	JPanel panelSouth =new JPanel();

	JLabel lblWestNorth = new JLabel(new ImageIcon("images/calc1.png"));


	JLabel lblMonth = new JLabel("Month: ");
	JLabel lblTotalDays = new JLabel("Total Office Days: ");
	JLabel lblHoliday = new JLabel("Holiday (Including Friday): ");
	JLabel lblEmployeeId = new JLabel("Employee Id: ");
	JLabel lblName = new JLabel("Name: ");
	JLabel lblSalary = new JLabel("Salary: ");
	JLabel lblDesignation = new JLabel("Designation: ");
	JLabel lblWorkingDay = new JLabel("Working Day: ");
	JLabel lblPerformance= new JLabel("Performance: ");
	JLabel lblOvertime= new JLabel("Overtime: ");

	String s1[]= {"","January","February","March","April","May","June","July","August","September","Octobor","November","December"}; 
	JComboBox cmbMonth = new JComboBox(s1);
	
	
	JTextField txtEmployeeId = new JTextField(20);
	JTextField txtTotalDays = new JTextField(20);
	JTextField txtHoliday = new JTextField(20);
	JTextField txtName = new JTextField(20);
	JTextField txtSalary = new JTextField(20);
	JTextField txtDesignation = new JTextField(20);
	JTextField txtWorkingDay = new JTextField(20);
	JTextField txtPerformance = new JTextField(20);
	JTextField txtOvertime = new JTextField(20);

	JButton btnAdd=new JButton("Add",new ImageIcon("images/add.png"));
	JButton btnEdit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton btnRefresh=new JButton("Refresh",new ImageIcon("images/refresh.png"));
	JButton btnDelete=new JButton("Delete",new ImageIcon("images/delete.png"));

	GridBagConstraints c = new GridBagConstraints();


	String column[]={"Employee Id","Full Name","Designation","Salary","Month","Total Day","Working Day","Performance"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton btnSearch = new JButton("Search",new ImageIcon("images/search.png"));
	
	String t,holyday,workDay,day,month,year,employeeId,overtime,hour,min,employeeId2,workday2,totalday2;
	int dayCount,temp=0,totalDay,holyday1,workDay1,year1,empId=0,month1,day1,overtime1,total,hour1,min1,totalHour,totalMin,resultMin,resultHour,hourCount,overtimeperday,workday21,totalday21;
	
	public Computation() {
		
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		setPreferredSize(new Dimension(1165,610));
		//setBackground(Color.blue);
		cmp();
		action();
		initialSetup();
		tabledata();
	}

	private void cmp() {

		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		add(panelSouth,BorderLayout.SOUTH);

		northwork();
		southwork();
	}

	private void initialSetup() {

		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWorkingDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHoliday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerformance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOvertime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));


		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//txtEmployeeId.setForeground(Color.red);
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtWorkingDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTotalDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoliday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPerformance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOvertime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		

		btnAdd.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnEdit.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnRefresh.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnDelete.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnSearch.setFont(new Font("Times new roman", Font.BOLD, 14));
		
		
		txtEmployeeId.setHorizontalAlignment(JTextField.CENTER);
		txtEmployeeId.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		txtWorkingDay.setText("Click Here....");
		txtPerformance.setText("Click Here....");
		txtOvertime.setText("Click Here....");
		txtTotalDays.setText("Click Here....");
		txtEmployeeId.setText("Enter Employee Id....");
		
		txtEmployeeId.setForeground(Color.gray);
		txtWorkingDay.setForeground(Color.gray);
		txtPerformance.setForeground(Color.gray);
		txtOvertime.setForeground(Color.gray);
		txtTotalDays.setForeground(Color.gray);

		txtName.setEditable(false);
		txtSalary.setEditable(false);
		txtWorkingDay.setEditable(false);
		txtPerformance.setEditable(false);
		txtOvertime.setEditable(false);
		txtTotalDays.setEditable(false);
		
		
	}


	private void northwork() {

		panelNorth.setPreferredSize(new Dimension(1,375));
		//panelNorth.setBackground(Color.red);
		panelNorth.setLayout(new BorderLayout());

		panelNorth.add(panelNorthEast,BorderLayout.EAST);
		panelNorth.add(panelNorthWest,BorderLayout.WEST);
		panelNorth.add(panelNorthSouth,BorderLayout.SOUTH);

		northWestwork();
		northEastwork();
		northSouthwork();
	}


	private void northWestwork() {

		FlowLayout flow =new FlowLayout();

		panelNorthWest.setPreferredSize(new Dimension(660,1));
		
		/*panelNorthWest.setLayout(new BorderLayout());
		panelNorthWest.add(panelNorthWestNorth,BorderLayout.NORTH);
		panelNorthWest.add(panelNorthWestSouth,BorderLayout.SOUTH);
		
		panelNorthWestNorth.setPreferredSize(new Dimension(1,120));
		//panelNorthWestNorth.setBackground(Color.yellow);
		panelNorthWestNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		panelNorthWestNorth.setLayout(flow);
		panelNorthWestNorth.add(lblWestNorth);

		panelNorthWestSouth.setPreferredSize(new Dimension(1,204));
		//panelNorthWestSouth.setBackground(Color.green);
*/		
		
		panelNorthWest.setLayout(new GridBagLayout());
		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelNorthWest.add(lblMonth,c);
		
		c.gridx=1;
		c.gridy=0;
		panelNorthWest.add(cmbMonth,c);

		c.gridx=0;
		c.gridy=1;
		panelNorthWest.add(lblHoliday,c);
		
		c.gridx=1;
		c.gridy=1;
		panelNorthWest.add(txtHoliday,c);
		
		c.gridx=0;
		c.gridy=2;
		panelNorthWest.add(lblTotalDays,c);
		
		c.gridx=1;
		c.gridy=2;
		panelNorthWest.add(txtTotalDays,c);
		
		
		
		flow.setVgap(7);

	}



	private void northEastwork() {

		FlowLayout flow =new FlowLayout();

		panelNorthEast.setPreferredSize(new Dimension(510,1));
		//panelNorthEast.setBackground(Color.orange);
		panelNorthEast.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		panelNorthEast.setLayout(new BorderLayout());
		panelNorthEast.add(panelNorthEastNorth,BorderLayout.NORTH);
		panelNorthEast.add(panelNorthEastSouth,BorderLayout.SOUTH);
		
		panelNorthEastNorth.setPreferredSize(new Dimension(1,70));
		//panelNorthWestNorth.setBackground(Color.yellow);
		panelNorthEastNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		panelNorthEastNorth.setLayout(new GridBagLayout());
		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(2, 5, 3, 3);
		c.fill=GridBagConstraints.BOTH;
		panelNorthEastNorth.add(txtEmployeeId,c);
		
	/*	c.gridx=1;
		c.gridy=0;
		panelNorthEastNorth.add(txtEmployeeId,c);*/

		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(2, 10, 3, 6);
		panelNorthEastNorth.add(btnSearch,c);
		
		
		
		
		
		
		

		panelNorthEastSouth.setPreferredSize(new Dimension(1,254));
		//panelNorthWestSouth.setBackground(Color.green);
		
		
		panelNorthEastSouth.setLayout(new GridBagLayout());
		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(2, 5, 2, 6);
		c.fill=GridBagConstraints.BOTH;
		panelNorthEastSouth.add(lblName,c);
		
		c.gridx=1;
		c.gridy=0;
		panelNorthEastSouth.add(txtName,c);

		c.gridx=0;
		c.gridy=1;
		panelNorthEastSouth.add(lblDesignation,c);
		
		c.gridx=1;
		c.gridy=1;
		panelNorthEastSouth.add(txtDesignation,c);
		
		c.gridx=0;
		c.gridy=2;
		panelNorthEastSouth.add(lblSalary,c);
		
		c.gridx=1;
		c.gridy=2;
		panelNorthEastSouth.add(txtSalary,c);
		
		c.gridx=0;
		c.gridy=3;
		panelNorthEastSouth.add(lblWorkingDay,c);
		
		c.gridx=1;
		c.gridy=3;
		panelNorthEastSouth.add(txtWorkingDay,c);
		
		c.gridx=0;
		c.gridy=4;
		panelNorthEastSouth.add(lblOvertime,c);
		
		c.gridx=1;
		c.gridy=4;
		panelNorthEastSouth.add(txtOvertime,c);
		
		c.gridx=0;
		c.gridy=5;
		panelNorthEastSouth.add(lblPerformance,c);
		
		c.gridx=1;
		c.gridy=5;
		panelNorthEastSouth.add(txtPerformance,c);
		
		flow.setVgap(7);
		flow.setVgap(0);
	
	}

	private void northSouthwork() {
		
		FlowLayout flow = new FlowLayout();

		panelNorthSouth.setPreferredSize(new Dimension(1,50));
		panelNorthSouth.setBorder(BorderFactory.createRaisedBevelBorder());

		panelNorthSouth.setLayout(flow);
		panelNorthSouth.add(btnAdd);
		//panelNorthSouth.add(btnEdit);
		panelNorthSouth.add(btnRefresh);
		//panelNorthSouth.add(btnDelete);

		flow.setHgap(20);
	}

	private void southwork() {
		
		FlowLayout flow = new FlowLayout();
		panelSouth.setPreferredSize(new Dimension(1,240));
		panelSouth.setLayout(flow);
		panelSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTable.setPreferredSize(new Dimension(1162,228));
		panelSouth.add(scrollTable);

		//panelSouth.setBackground(Color.red);
		
		flow.setVgap(4);

		//table header center alignment...
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);

		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(280);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(60);
		table.getColumnModel().getColumn(7).setPreferredWidth(80);
		//panelSouth.setBackground(Color.green);
	}
	
	
	
	
	public void dateCount()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		t=dateFormat.format(date);

		StringTokenizer str = new StringTokenizer(t,"/");
		
		day = str.nextToken();
		month = str.nextToken();
		year = str.nextToken();
		
		year1 = Integer.parseInt(year);
		month1 = Integer.parseInt(month);
		day1 = Integer.parseInt(day);
	}
	
	private void checkExistPer(String id) {
	
		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs.next()){		
				txtName.setText(rs.getString("name"));
				txtDesignation.setText(rs.getString("designation"));
				txtSalary.setText(rs.getString("salary"));
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Employee Id","Error!!",JOptionPane.ERROR_MESSAGE);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}

	}

	
	public boolean validation()
	{
		
		if(!txtEmployeeId.getText().trim().isEmpty() && !txtEmployeeId.getText().equalsIgnoreCase("Enter Employee Id....")){
			if(!txtName.getText().trim().isEmpty()){
				if(cmbMonth.getSelectedIndex()!=0){
					if(!txtTotalDays.getText().trim().isEmpty() && !txtTotalDays.getText().equalsIgnoreCase("Click Here....")){
						if(!txtHoliday.getText().trim().isEmpty()){
							if(!txtDesignation.getText().trim().isEmpty()){
								if(!txtSalary.getText().trim().isEmpty()){
									if(!txtWorkingDay.getText().trim().isEmpty() && !txtWorkingDay.getText().equalsIgnoreCase("Click Here....")){
										if(!txtOvertime.getText().trim().isEmpty() && !txtOvertime.getText().equalsIgnoreCase("Click Here....")){
											if(!txtPerformance.getText().trim().isEmpty() && !txtPerformance.getText().equalsIgnoreCase("Click Here....")){
												return true;
											}
											else{
												JOptionPane.showMessageDialog(null, "Please, Enter Performance","Sorry!",JOptionPane.WARNING_MESSAGE);
											}	
										}
										else{
											JOptionPane.showMessageDialog(null, "Please, Enter Overtime","Sorry!",JOptionPane.WARNING_MESSAGE);
										}	
									}
									else{
										JOptionPane.showMessageDialog(null, "Please, Enter Working Day","Sorry!",JOptionPane.WARNING_MESSAGE);
									}	
								}
								else{
									JOptionPane.showMessageDialog(null, "Please, Enter Salary","Sorry!",JOptionPane.WARNING_MESSAGE);
								}		
							}
							else{
								JOptionPane.showMessageDialog(null, "Please, Enter Designation","Sorry!",JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Please, Enter Holiday","Sorry!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please, Enter Total Days","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please, Select Month","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please, Enter Full Name","Sorry!",JOptionPane.WARNING_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Please, Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
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
		txtDesignation.setText(null);
		txtSalary.setText(null);
		txtHoliday.setText(null);
		cmbMonth.setSelectedItem("");
		txtOvertime.setText("Click Here....");
		txtWorkingDay.setText("Click Here....");
		txtTotalDays.setText("Click Here....");
		txtPerformance.setText("Click Here....");
		
		txtEmployeeId.setText("Enter Employee Id....");
	
		txtEmployeeId.setForeground(Color.gray);
		txtOvertime.setForeground(Color.gray);
		txtTotalDays.setForeground(Color.gray);
		txtWorkingDay.setForeground(Color.gray);
		txtPerformance.setForeground(Color.gray);
	}
	
	
	
	protected void insertdata() {
		try{
			
			int c=0;
			String Prmonth = null;
			
			
			employeeId2 = txtEmployeeId.getText().trim();
			
			ResultSet rs=db.sta.executeQuery("select * from tbl_compute where employeeid='"+employeeId2+"' and presentdate='"+t+"'");
			if(rs.next()){
				c=1;
				Prmonth = rs.getString("month");
				
			}
			
			
			if(c==1)
			{
				JOptionPane.showMessageDialog(null, "This Employee of " + Prmonth + " Month is Already Calculated","Calculation Error",JOptionPane.ERROR_MESSAGE);
				c=0;
			}
			
			else
			{
				db.sta.executeUpdate("insert into tbl_compute(employeeid,name,designation,salary,month,year,totalday,workingday,performance,presentdate) values('"+txtEmployeeId.getText().trim()+"','"+txtName.getText().trim()+"','"+txtDesignation.getText().trim()+"','"+txtSalary.getText().trim()+"','"+cmbMonth.getSelectedItem().toString()+"','"+year+"','"+txtTotalDays.getText().trim()+"','"+txtWorkingDay.getText().trim()+"','"+txtPerformance.getText().trim()+"','"+t+"')");
				insertdata2();
				txtClear();
				JOptionPane.showMessageDialog(null, "All Information Saved Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	protected void insertdata2() {
		
		try{
			
			int t9,t8,t7,t6,t5,t4,t3,t2,t1;
			String pres;
			
			workday2 = txtWorkingDay.getText();
			totalday2 = txtTotalDays.getText();
			
			workday21 = Integer.parseInt(workday2);
			totalday21 = Integer.parseInt(totalday2);
			
			t1 = (int) Math.ceil(totalday21 * .1);
			t2 = (int) Math.ceil(totalday21 * .2);
			t3 = (int) Math.ceil(totalday21 * .3);
			t4 = (int) Math.ceil(totalday21 * .4);
			t5 = (int) Math.ceil(totalday21 * .5);
			t6 = (int) Math.ceil(totalday21 * .6);
			t7 = (int) Math.ceil(totalday21 * .7);
			t8 = (int) Math.ceil(totalday21 * .8);
			t9 = (int) Math.ceil(totalday21 * .9);
			
			if(workday21<=t1 && workday21>0)
			{
				pres = "10";
			}
			else if(workday21<=t2 && workday21>t1)
			{
				pres = "20";
			} 
			
			else if(workday21<=t3 && workday21>t2)
			{
				pres = "30";
			}
			else if(workday21<=t4 && workday21>t3)
			{
				pres = "40";
			}
			
			else if(workday21<=t5 && workday21>t4)
			{
				pres = "50";
			}
			else if(workday21<=t6 && workday21>t5)
			{
				pres = "60";
			}
			else if(workday21<=t7 && workday21>t6)
			{
				pres = "70";
			}
			else if(workday21<=t8 && workday21>t7)
			{
				pres = "80";
			}
			else if(workday21<=t9 && workday21>t8)
			{
				pres = "90";
			}	
			else if(workday21==totalday21)
			{
				pres = "100";
			}
			else
			{
				pres = "00";
			}
			
			
			
			db.sta.executeUpdate("insert into tbl_present(employeeid,month,presentdate,present) values('"+txtEmployeeId.getText().trim()+"','"+cmbMonth.getSelectedItem().toString()+"','"+t+"','"+pres+"')");
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}

		String s="select employeeid,name,designation,salary,month,totalday,workingday,performance,cast(substring(employeeid,locate('-',employeeid)+1,LENGTH(employeeid)-locate('-',employeeid)) as unsigned) as ord from tbl_compute order by ord";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String Name=rs.getString("name");
				String designation=rs.getString("designation");
				String salary=rs.getString("salary");
				String month=rs.getString("month");
				String totalday=rs.getString("totalday");
				String workingday=rs.getString("workingday");
				String performance=rs.getString("performance");
				
				model.addRow(new Object[]{id,Name,designation,salary,month,totalday,workingday,performance});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}
	
	
	
	
	
/*	
	protected void updatedata() {
		try{
		
			db.sta.executeUpdate("update tbl_compute set designation='"+txtDesignation.getText().trim()+"', salary='"+txtSalary.getText().trim()+"', performance='"+txtPerformance.getText().trim()+"', name='"+txtName.getText().trim()+"', month='"+cmbMonth.getSelectedItem()+"', totalday='"+txtTotalDays.getText().trim()+"', workingday='"+txtWorkingDay.getText().trim()+"', presentdate='"+t+"' where employeeid='"+txtEmployeeId.getText().trim()+"'");
	
			txtClear();
			JOptionPane.showMessageDialog(null, "All Information Updated Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	*/
	
	
	
	
	
	private void action() {

		cmbMonth.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtHoliday.setText(null);
				txtTotalDays.setText("Click Here....");
				txtTotalDays.setForeground(Color.gray);
			
			}
		});
		
		txtTotalDays.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {}
			@Override
			public void focusGained(FocusEvent arg0) {

				
				
				if(!txtHoliday.getText().trim().isEmpty())
				{
					if(cmbMonth.getSelectedIndex()!=0)
					{
						if(cmbMonth.getSelectedIndex()==1 || cmbMonth.getSelectedIndex()==3 || cmbMonth.getSelectedIndex()==5 || cmbMonth.getSelectedIndex()==7 || cmbMonth.getSelectedIndex()==8 || cmbMonth.getSelectedIndex()==10 || cmbMonth.getSelectedIndex()==12)
						{
							totalDay = 31;
						}
						else if(cmbMonth.getSelectedIndex()==4 || cmbMonth.getSelectedIndex()==6 || cmbMonth.getSelectedIndex()==9 || cmbMonth.getSelectedIndex()==11)
						{
							totalDay = 30;
						}
						else if(cmbMonth.getSelectedIndex()==2)
						{
							dateCount();
							
							if (year1 % 400 == 0 || (year1 % 4 == 0 && year1 % 100 != 0))
							{
								totalDay = 29;
							}
							else
							{
								totalDay = 28;
							}
							
						}
					
							
						
						holyday = txtHoliday.getText().trim();
						holyday1 = Integer.parseInt(holyday);
						
						workDay1 = totalDay - holyday1;
						workDay = workDay1+"";
						
						txtTotalDays.setText(null);
						txtTotalDays.setForeground(Color.black);
						txtTotalDays.setText(workDay);
					}	
					else
					{
						txtHoliday.setText(null);
						txtTotalDays.setText("Click Here....");
						txtTotalDays.setForeground(Color.gray);
						txtTotalDays.setEditable(false);
					}
				}
			}
		});
		
		txtWorkingDay.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				
				if(!txtTotalDays.getText().trim().isEmpty())
				{
					if(!txtHoliday.getText().trim().isEmpty())
					{
						if(cmbMonth.getSelectedIndex()!=0)
						{
							if(empId==1)
							{
								employeeId = txtEmployeeId.getText().trim();
								dateCount();
								
								dayCount=0;
					
								if(month1==1)
								{
									year1 = year1-1;
								}
								if(day1>=1 && day1<=15)
								{
									month1 = month1-1;
								}
							
								//System.out.println(day1+"    "+month1+"    "+year1);
								
								try{
									ResultSet rs=db.sta.executeQuery("select * from tbl_signout where employeeid='"+employeeId+"' and month='"+month1+"' and year='"+year1+"'");
									while(rs.next()){
											++dayCount;
										//System.out.println(dayCount);
									}
								}
								catch(Exception e){
									JOptionPane.showMessageDialog(null, e);
								}
							
								txtWorkingDay.setText(null);
								txtWorkingDay.setForeground(Color.black);
								txtWorkingDay.setText(dayCount+"");
								
								//dayCount = 20;
							}
						
						}
					}
					
				}
				
				
			}
		});
		
		
		txtOvertime.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if(!txtTotalDays.getText().trim().isEmpty())
				{
					if(!txtHoliday.getText().trim().isEmpty())
					{
						if(cmbMonth.getSelectedIndex()!=0)
						{
							if(empId==1)
							{
								overtimeperday=0;
								
								employeeId = txtEmployeeId.getText().trim();
								dateCount();
								
								totalHour=0;
								totalMin=0;
								
								if(month1==1)
								{
									year1 = year1-1;
								}
								if(day1>=1 && day1<=15)
								{
									month1 = month1-1;
								}
							
								//System.out.println(day1+"    "+month1+"    "+year1);
								
								try{
									ResultSet rs=db.sta.executeQuery("select * from tbl_signout where employeeid='"+employeeId+"' and month='"+month1+"' and year='"+year1+"'");
									while(rs.next()){
										
										overtime = rs.getString("overtime");
										
										StringTokenizer str = new StringTokenizer(overtime,":");
										hour = str.nextToken();
										min = str.nextToken();
										
										hour1 = Integer.parseInt(hour);
										min1 = Integer.parseInt(min);

										totalHour = totalHour+hour1;
										totalMin = totalMin+min1;
										
										if((hour1!=0 && min1==0) || (hour1==0 && min1!=0) || (hour1!=0 && min1!=0)){
											
											++overtimeperday;
										}
										
									}
								}
								catch(Exception e){
									JOptionPane.showMessageDialog(null, e);
								}
								
								//System.out.println(dayCount);
								
								
								hourCount = totalMin/60;
								resultMin = totalMin%60;
								
								resultHour = hourCount + totalHour;
								
								
								txtOvertime.setText(null);
								txtOvertime.setForeground(Color.black);
								txtOvertime.setText(resultHour+":"+resultMin);
								
								//overtimeperday=3;
							}
						
						}
					}
					
				}
			}
		});
		
		txtPerformance.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				if(!txtTotalDays.getText().trim().isEmpty())
				{
					if(!txtHoliday.getText().trim().isEmpty())
					{
						if(cmbMonth.getSelectedIndex()!=0)
						{
							txtPerformance.setText(null);
							txtPerformance.setForeground(Color.black);
							
							int overPercentExc,overPercentAvg;
							
							overPercentExc = (int) Math.ceil(dayCount * .7);
							overPercentAvg = (int) Math.ceil(dayCount * .3);
							
							
							//System.out.println(workDay1 +"      "+26+"      "+resultHour+"     "+resultMin+"     "+overPercentExc+"     "+overPercentAvg);
							
							if(workDay1==dayCount && overtimeperday>=overPercentExc && resultHour>2)
							{
								txtPerformance.setText("Super Excellent");
							}
							
							else if((workDay1==dayCount && overtimeperday>=overPercentAvg && resultHour>4) || (workDay1>=dayCount && overtimeperday>=overPercentAvg && resultHour<=4 && resultHour>=1))
							{
								txtPerformance.setText("Excellent");
							}
							
							else if((workDay1==dayCount && overtimeperday<=8) || (workDay1==dayCount && overtimeperday==0))
							{
								txtPerformance.setText("Very Good");
							}
							else if(workDay1>15 && overtimeperday>=2)
							{
								txtPerformance.setText("Good");
							}
							
							else if(dayCount>=10 && overtimeperday>=3)
							{
								txtPerformance.setText("Average");
							}
							else
							{
								txtPerformance.setText("Bad");
							}
							
							
							
							
						}
					}
					
				}
				
			}
		});
		
		txtEmployeeId.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {

				/*if(!txtTotalDays.getText().trim().isEmpty())
				{
					if(!txtHoliday.getText().trim().isEmpty())
					{
						if(cmbMonth.getSelectedIndex()!=0)
						{*/
							txtEmployeeId.setEditable(true);
							txtEmployeeId.setText(null);
							txtEmployeeId.setForeground(Color.red);
							/*}
					}
					
				}*/
				
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
		
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				
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
		
		/*btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(validation()){
						if(checkConfirmed("Edit")){
							updatedata();
							tabledata();
						}
					}
				}
				
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
				if(checkConfirmed("Delete")){
						if(deleteData()){
							txtClear();
							tabledata();
							
						}
					}
			}
		});*/
		
		btnRefresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				txtClear();
				
			}
		});	
		
	}

}
