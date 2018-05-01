package com.example.Menuitem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.FlatteningPathIterator;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

public class UserPanel extends JPanel{

	db_connection db = new db_connection();
	
	JFrame frame;
	
	JPanel panelWest = new JPanel();
	JPanel panelWestNorth = new JPanel();
	JPanel panelWestCenter = new JPanel();
	JPanel panelWestCenterNorth = new JPanel();
	JPanel panelWestCenterCenter = new JPanel();
	JPanel panelWestSouth = new JPanel();
	JPanel panelWestSouthNorth = new JPanel();
	JPanel panelWestSouthCenter = new JPanel();
	
	JPanel panelEast = new JPanel();
	JPanel panelEastNorth = new JPanel();
	JPanel panelEastNorthNorth = new JPanel();
	JPanel panelEastNorthCenter = new JPanel();
	JPanel panelEastCenter = new JPanel();
	JPanel panelEastSouth = new JPanel();
	
	JLabel lblIdLeft = new JLabel("Employee Id:");
	JLabel lblIdRight = new JLabel("Employee Id:");
	JLabel lblName = new JLabel("Name:");
	JLabel lblDesignation = new JLabel("Designation:");
	JLabel lblSalary = new JLabel("Salary:");
	JLabel lblPromotion = new JLabel("Promotion Mark:");
	JLabel lblMonth = new JLabel("Month:");
	JLabel lblPerformance = new JLabel("Performance:");
	
	JLabel lblUpload=new JLabel();
	
	JTextField txtIdLeft = new JTextField(18);
	JTextField txtIdRight = new JTextField(18);
	JTextField txtName = new JTextField(18);
	JTextField txtDesignation = new JTextField(18);
	JTextField txtSalary = new JTextField(18);
	JTextField txtPromotion = new JTextField(18);
	JTextField txtPerformance = new JTextField(18);
	
	JButton btnSearchLeft = new JButton("Search",new ImageIcon("images/search.png"));
	JButton btnSearchRight = new JButton("Search",new ImageIcon("images/search.png"));
	JButton btnPrint = new JButton("Print",new ImageIcon("images/print.png"));
	JButton btnHome = new JButton("Home",new ImageIcon("images/home2.png"));
	
	
	
	String s1[]= {"","January","February","March","April","May","June","July","August","September","Octobor","November","December"}; 
	String s2[]= {"Select Month","January","February","March","April","May","June","July","August","September","Octobor","November","December"}; 
	String s3[]= {"Select Year","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017"};

	JComboBox cmbMonth = new JComboBox(s2);
	JComboBox cmbYear = new JComboBox(s3);
	JComboBox cmbMonthLeft = new JComboBox(s1);
	
	GridBagConstraints c = new GridBagConstraints();


	String column[]={"Employee Id","Date","Sign In","sign Out"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JFileChooser Chooser=new JFileChooser();
	File file;
	BufferedImage buffer;

	String s22,t;
	int monthnew;
	
	public UserPanel(JFrame frame1) {
		
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
		this.frame.setTitle("User Panel");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmp();
		action();
		initialSetup();
		tabledata();
		
	}
	
	private void cmp() {

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
		add(panelWest,BorderLayout.WEST);
		add(panelEast,BorderLayout.EAST);
		
		panelWest.setBorder(BorderFactory.createLoweredBevelBorder());
		panelEast.setBorder(BorderFactory.createLoweredBevelBorder());
		
		
		west_work();
		east_work();

	}
	
	private void initialSetup() {
		
		lblIdLeft.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdRight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPromotion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerformance.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtIdLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIdRight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPromotion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPerformance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbMonthLeft.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSearchLeft.setFont(new Font("Times new roman", Font.BOLD, 15));
		btnSearchRight.setFont(new Font("Times new roman", Font.BOLD, 15));
		btnPrint.setFont(new Font("Times new roman", Font.BOLD, 15));
		btnHome.setFont(new Font("Times new roman", Font.BOLD, 15));
		
		txtName.setEditable(false);
		txtSalary.setEditable(false);
		txtDesignation.setEditable(false);
		txtPromotion.setEditable(false);
		txtPerformance.setEditable(false);
		
		
		cmbMonth.setPreferredSize(new Dimension(130,30));
		cmbYear.setPreferredSize(new Dimension(130,30));
		btnPrint.setPreferredSize(new Dimension(572,45));
		
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		lblUpload.setPreferredSize(new Dimension(150,170));

		txtIdLeft.setHorizontalAlignment(JTextField.CENTER);
		txtIdLeft.setForeground(Color.red);
		
		txtIdRight.setHorizontalAlignment(JTextField.CENTER);
		txtIdRight.setForeground(Color.red);
		
	}	

	private void west_work() {
		
		FlowLayout flow = new FlowLayout();
		FlowLayout flow2 = new FlowLayout();
		
		panelWest.setPreferredSize(new Dimension(600,1));
		//panelWest.setBackground(Color.red);
		
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		
		panelWestNorth.setPreferredSize(new Dimension(1,80));
		//panelWestNorth.setBackground(Color.orange);
		
		
		panelWestNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelWestNorth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelWestNorth.add(lblIdLeft,c);
		c.gridx=1;
		c.gridy=0;
		panelWestNorth.add(txtIdLeft,c);
		c.gridx=2;
		c.gridy=0;
		panelWestNorth.add(btnSearchLeft,c);
		
		
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterNorth,BorderLayout.NORTH);
		panelWestCenter.add(panelWestCenterCenter,BorderLayout.CENTER);
		
		//panelWestCenterNorth.setBackground(Color.red);
		//panelWestCenterCenter.setBackground(Color.green);

		
		panelWestCenterNorth.setPreferredSize(new Dimension(1,220));
		panelWestCenterNorth.setLayout(flow);
		panelWestCenterNorth.add(lblUpload);
		
		flow.setVgap(30);
		
		panelWestCenterCenter.setLayout(new GridBagLayout());

		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelWestCenterCenter.add(lblName,c);
		c.gridx=1;
		c.gridy=0;
		panelWestCenterCenter.add(txtName,c);
		
		c.gridx=0;
		c.gridy=1;
		panelWestCenterCenter.add(lblDesignation,c);
		c.gridx=1;
		c.gridy=1;
		panelWestCenterCenter.add(txtDesignation,c);
		
		c.gridx=0;
		c.gridy=2;
		panelWestCenterCenter.add(lblSalary,c);
		c.gridx=1;
		c.gridy=2;
		panelWestCenterCenter.add(txtSalary,c);
		
		/*c.gridx=0;
		c.gridy=3;
		panelWestCenterCenter.add(lblPromotion,c);
		c.gridx=1;
		c.gridy=3;
		panelWestCenterCenter.add(txtPromotion,c);*/
		
		
		
		
		
		panelWestSouth.setPreferredSize(new Dimension(1,190));
		panelWestSouth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panelWestSouth.setLayout(new BorderLayout());
		panelWestSouth.add(panelWestSouthNorth,BorderLayout.NORTH);
		panelWestSouth.add(panelWestSouthCenter,BorderLayout.CENTER);
		
		panelWestSouthNorth.setPreferredSize(new Dimension(1,130));
		
		panelWestSouthNorth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelWestSouthNorth.add(lblMonth,c);
		c.gridx=1;
		c.gridy=0;
		panelWestSouthNorth.add(cmbMonthLeft,c);
		
		c.gridx=0;
		c.gridy=1;
		panelWestSouthNorth.add(lblPerformance,c);
		c.gridx=1;
		c.gridy=1;
		panelWestSouthNorth.add(txtPerformance,c);
		
		
		panelWestSouthCenter.setLayout(flow2);
		panelWestSouthCenter.add(btnHome);
		
		
	}

	private void east_work() {
	
		FlowLayout flow = new FlowLayout();
		FlowLayout flow1 = new FlowLayout();
		
		panelEast.setPreferredSize(new Dimension(576,1));
		//panelEast.setBackground(Color.green);
		
		panelEast.setLayout(new BorderLayout());
		panelEast.add(panelEastNorth,BorderLayout.NORTH);
		panelEast.add(panelEastCenter,BorderLayout.CENTER);
		panelEast.add(panelEastSouth,BorderLayout.SOUTH);
		
		panelEastNorth.setPreferredSize(new Dimension(1,120));
		//panelEastNorth.setBackground(Color.pink);
		panelEastNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelEastNorth.setLayout(new BorderLayout());
		panelEastNorth.add(panelEastNorthNorth,BorderLayout.NORTH);
		panelEastNorth.add(panelEastNorthCenter,BorderLayout.CENTER);
		
		panelEastNorthNorth.setPreferredSize(new Dimension(1,60));
		panelEastNorthNorth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelEastNorthNorth.add(lblIdRight,c);
		c.gridx=1;
		c.gridy=0;
		panelEastNorthNorth.add(txtIdRight,c);	
		
		panelEastNorthCenter.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelEastNorthCenter.add(cmbMonth,c);
		c.gridx=1;
		c.gridy=0;
		panelEastNorthCenter.add(cmbYear,c);
		c.gridx=2;
		c.gridy=0;
		panelEastNorthCenter.add(btnSearchRight,c);
		
		
		
		
		panelEastCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelEastCenter.setLayout(flow);
		//panelEastCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTable.setPreferredSize(new Dimension(567,508));
		panelEastCenter.add(scrollTable);

		flow.setVgap(0);
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);
		
	
		
		panelEastSouth.setPreferredSize(new Dimension(1,45));
		panelEastSouth.setLayout(flow1);
		panelEastSouth.add(btnPrint);
		
		flow1.setVgap(0);
		//panelEastSouth.setBackground(Color.blue);
		
	}
	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}
		//String s="select *,cast(substring(2,10) as unsigned) as ord from tbl_signin order by ord";
		//String s="select *,cast(substring(bookid,locate('-',bookid)+1,LENGTH(bookid)-locate('-',bookid)) as unsigned) as ord from tbl_addbook order by ord";
		
		String s="select employeeid,date,entrytime,exittime from tbl_signout order by autoid";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String date=rs.getString("date");
				String time=rs.getString("entrytime");
				String time2=rs.getString("exittime");
				
				
				model.addRow(new Object[]{id,date,time,time2});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}
	
	public void action()
	{
		btnSearchLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(!txtIdLeft.getText().trim().isEmpty())
				{
					String id = txtIdLeft.getText().trim();
					
					String s="select name,designation,salary,image from tbl_employee where employeeid='"+id+"'";
					try{
						ResultSet rs= db.sta.executeQuery(s);
						
						if(rs.next()){
							String name=rs.getString("name");
							String designation=rs.getString("designation");
							String salary=rs.getString("salary");
							
							txtName.setText(name);
							txtDesignation.setText(designation);
							txtSalary.setText(salary);
							
							Image image=Toolkit.getDefaultToolkit().getImage(rs.getString("image").replace("#", "\\"));
							file=new File(rs.getString("image").replace("#", "\\"));
							Image resize=image.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(),image.SCALE_DEFAULT);
							lblUpload.setIcon(new ImageIcon(resize));
							//temp=1;
						}
						
						
						
					}
					catch(Exception exp){
						JOptionPane.showMessageDialog(null, exp);
					}
					
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		
		cmbMonthLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(!txtIdLeft.getText().trim().isEmpty())
				{
					if(cmbMonthLeft.getSelectedIndex()!=0)
					{
						String id = txtIdLeft.getText().trim();
						String month = cmbMonthLeft.getSelectedItem().toString();
						
						String s="select performance from tbl_compute where month='"+month+"' and employeeid='"+id+"'";
						try{
							ResultSet rs= db.sta.executeQuery(s);
							
							if(rs.next()){
								String performance=rs.getString("performance");
								txtPerformance.setText(performance);
							}
				
						}
						catch(Exception exp){
							JOptionPane.showMessageDialog(null, exp);
						}
						
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Please Choose month","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		
		
		btnSearchRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtIdRight.getText().trim().isEmpty()){
					if(cmbMonth.getSelectedIndex()!=0){	
						if(cmbYear.getSelectedIndex()!=0){
							
							String id = txtIdRight.getText().trim();
							String month = cmbMonth.getSelectedItem().toString();
							String year = cmbYear.getSelectedItem().toString();
							if(month.equalsIgnoreCase("january"))
							{
								monthnew = 1;
							}
							else if(month.equalsIgnoreCase("February"))
							{
								monthnew = 2;
							}
							else if(month.equalsIgnoreCase("March"))
							{
								monthnew = 3;
							}
							else if(month.equalsIgnoreCase("April"))
							{
								monthnew = 4;
							}
							else if(month.equalsIgnoreCase("May"))
							{
								monthnew = 5;
							}
							else if(month.equalsIgnoreCase("June"))
							{
								monthnew = 6;
							}
							else if(month.equalsIgnoreCase("July"))
							{
								monthnew = 7;
							}
							else if(month.equalsIgnoreCase("August"))
							{
								monthnew = 8;
							}
							else if(month.equalsIgnoreCase("September"))
							{
								monthnew = 9;
							}
							else if(month.equalsIgnoreCase("Octobor"))
							{
								monthnew = 10;
							}
							else if(month.equalsIgnoreCase("November"))
							{
								monthnew = 11;
							}
							else if(month.equalsIgnoreCase("December"))
							{
								monthnew = 12;
							}
							
							for(int a=model.getRowCount()-1;a>=0;a--)
							{
								model.removeRow(a);
							}
							
							String s="select employeeid,date,entrytime,exittime from tbl_signout where month='"+monthnew+"' and year='"+year+"' and employeeid='"+id+"'";
							try{
								ResultSet rs= db.sta.executeQuery(s);
								
								while(rs.next()){
									
									String id1=rs.getString("employeeid");
									String date=rs.getString("date");
									String time=rs.getString("entrytime");
									String time2=rs.getString("exittime");
									
									model.addRow(new Object[]{id1,date,time,time2});
								}
								
								
								//String s="select *,cast(substring(2,10) as unsigned) as ord from tbl_signin order by ord";
								//String s="select *,cast(substring(bookid,locate('-',bookid)+1,LENGTH(bookid)-locate('-',bookid)) as unsigned) as ord from tbl_addbook order by ord";
							

					
							}
							catch(Exception exp){
								JOptionPane.showMessageDialog(null, exp);
							}
							
						}
						else{
							JOptionPane.showMessageDialog(null, "Please Choose Year","Sorry!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please Choose Month","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MessageFormat Header=new MessageFormat("Employee Signing");
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
		
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				Login hm=new Login();
			}
		});
		
	}

}
