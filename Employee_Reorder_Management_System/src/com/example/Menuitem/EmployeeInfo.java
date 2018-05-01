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

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.example.Admin.db_connection;

public class EmployeeInfo extends JPanel{

	db_connection db = new db_connection();
	
	JPanel panelNorth =new JPanel();
	JPanel panelNorthEast =new JPanel();
	JPanel panelNorthEastNorth =new JPanel();
	JPanel panelNorthEastSouth =new JPanel();
	JPanel panelNorthEastSouthNorth =new JPanel();
	JPanel panelNorthEastSouthSouth =new JPanel();


	JPanel panelNorthWest =new JPanel();
	JPanel panelNorthWestNorth =new JPanel();
	JPanel panelNorthWestSouth =new JPanel();
	JPanel panelNorthWestSouthNorth =new JPanel();
	JPanel panelNorthWestSouthSouth =new JPanel();
	JPanel panelNorthWestSouthSouthWest =new JPanel();
	JPanel panelNorthWestSouthSouthWestNorth =new JPanel();
	JPanel panelNorthWestSouthSouthWestSouth =new JPanel();
	JPanel panelNorthWestSouthSouthEast =new JPanel();

	JPanel panelNorthSouth =new JPanel();
	JPanel panelSouth =new JPanel();

	JLabel lblEastNorth = new JLabel(new ImageIcon("images/east_emp.png"));
	JLabel lblWestNorth = new JLabel(new ImageIcon("images/west_emp.png"));

	JButton btnUpload=new JButton("Upload",new ImageIcon("images/Upload.png"));
	JLabel lblUpload=new JLabel();

	JLabel lblFullName = new JLabel("Full Name: ");
	JLabel lblEmployeeId = new JLabel("Employee Id: ");
	JLabel lblGender = new JLabel("Gender: ");
	JLabel lblMobile = new JLabel("Mobile No: ");
	JLabel lblEmail = new JLabel("Email Id: ");
	JLabel lblAddress = new JLabel("Address: ");
	JLabel lblPromotion = new JLabel("Promotion Limit(year): ");


	JLabel lblDateofJoin=new JLabel("Date of Join:");
	JLabel lblDesignation = new JLabel("Designation: ");
	JLabel lblSalary = new JLabel("Salary: ");
	JLabel lblOvertime = new JLabel("Overtime Per hour(TK): ");



	JTextField txtSearchPer = new JTextField(20);
	JTextField txtSearchAd = new JTextField(20);
	JButton btnSearchPer = new JButton("Search",new ImageIcon("images/search.png"));
	JButton btnSearchAd = new JButton("Search",new ImageIcon("images/search.png"));

	JTextField txtFullName = new JTextField(20);
	JTextField txtEmployeeId = new JTextField(20);
	JTextField txtMobile = new JTextField(20);
	JTextField txtEmail = new JTextField(20);
	JTextArea txtAddress = new JTextArea(2,2);

	//JDateChooser txtDate=new JDateChooser();
	JTextField txtDesignation = new JTextField(18);
	JTextField txtSalary = new JTextField(18);
	JTextField txtPromotion= new JTextField(20);
	JTextField txtOvertime = new JTextField(18);
	JTextField txtDate = new JTextField(18);



	JButton btnAdd=new JButton("Add",new ImageIcon("images/add.png"));
	JButton btnEdit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton btnRefresh=new JButton("Refresh",new ImageIcon("images/refresh.png"));
	JButton btnDelete=new JButton("Delete",new ImageIcon("images/delete.png"));



	String s[]={"","Male","Female","Others"};
	JComboBox cmbGender=new JComboBox(s);

	JScrollPane scrollAddress=new JScrollPane(txtAddress,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	GridBagConstraints c = new GridBagConstraints();


	String column[]={"Employee Id","Full Name","Mobile No","Email Id","Designation","Salary","Overtime Per Hour(Tk)","Date of Join"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JCheckBox ckPer = new JCheckBox();
	JCheckBox ckAd = new JCheckBox();

	JFileChooser Chooser=new JFileChooser();
	File file;
	BufferedImage buffer;

	String s2,t;
	int temp=0,temp1=0,temp2=0,btAd=0,btEd=0;
	int ck=0;
	public EmployeeInfo() {
		
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		setPreferredSize(new Dimension(1165,610));
		cmp();
		action();
		initialSetup();
		autoId();
		tabledata();
		dateSetup();

	}


	public void initialSetup()
	{

		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOvertime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateofJoin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPromotion.setFont(new Font("Tahoma", Font.PLAIN, 16));


		txtFullName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmployeeId.setForeground(Color.blue);
		txtMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtOvertime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPromotion.setFont(new Font("Tahoma", Font.PLAIN, 15));


		btnSearchPer.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnSearchAd.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnUpload.setFont(new Font("Times new roman", Font.BOLD, 13));
		btnAdd.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnEdit.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnRefresh.setFont(new Font("Times new roman", Font.BOLD, 14));
		btnDelete.setFont(new Font("Times new roman", Font.BOLD, 14));
		
		
		txtSearchPer.setBorder(BorderFactory.createRaisedBevelBorder());
		txtSearchPer.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		txtSearchAd.setBorder(BorderFactory.createRaisedBevelBorder());
		txtSearchAd.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		
		txtSearchAd.setHorizontalAlignment(JTextField.CENTER);
		txtSearchPer.setHorizontalAlignment(JTextField.CENTER);

		txtSearchAd.setText("Enter Employee Id....");
		txtSearchPer.setText("Enter Employee Id....");
		
		txtSearchAd.setForeground(Color.gray);
		txtSearchPer.setForeground(Color.gray);
	
		
		txtSearchAd.setEditable(false);
		txtSearchPer.setEditable(false);
		
	}
	
	private void cmp() {

		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		add(panelSouth,BorderLayout.SOUTH);

		northwork();
		southwork();

	}


	private void northwork() {

		FlowLayout flow = new FlowLayout();
		FlowLayout flow1 = new FlowLayout();
		FlowLayout flow2 = new FlowLayout();
		FlowLayout flow3 = new FlowLayout();
		FlowLayout flow4 = new FlowLayout();




		panelNorth.setPreferredSize(new Dimension(1,396));
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
		FlowLayout flow1 =new FlowLayout();
		FlowLayout flow2 =new FlowLayout();

		panelNorthWest.setPreferredSize(new Dimension(687,1));
		panelNorthWest.setLayout(new BorderLayout());
		panelNorthWest.add(panelNorthWestNorth,BorderLayout.NORTH);
		panelNorthWest.add(panelNorthWestSouth,BorderLayout.SOUTH);

		panelNorthWestNorth.setPreferredSize(new Dimension(1,42));
		panelNorthWestNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		panelNorthWestNorth.setLayout(flow);
		panelNorthWestNorth.add(lblWestNorth);

		panelNorthWestSouth.setPreferredSize(new Dimension(1,305));

		panelNorthWestSouth.setLayout(new BorderLayout());
		//panelNorthWestSouth.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
		panelNorthWestSouth.add(panelNorthWestSouthNorth,BorderLayout.NORTH);
		panelNorthWestSouth.add(panelNorthWestSouthSouth,BorderLayout.SOUTH);


		panelNorthWestSouthNorth.setPreferredSize(new Dimension(1,39));
		panelNorthWestSouthSouth.setPreferredSize(new Dimension(1,262));

		panelNorthWestSouthNorth.setLayout(new GridBagLayout());
		

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(1, 5, 1, 5);
		c.fill=GridBagConstraints.BOTH;
		panelNorthWestSouthNorth.add(ckPer,c);
		c.gridx=1;
		c.gridy=0;
		panelNorthWestSouthNorth.add(txtSearchPer,c);
		c.gridx=2;
		c.gridy=0;
		panelNorthWestSouthNorth.add(btnSearchPer,c);

		panelNorthWestSouthSouth.setLayout(new BorderLayout());
		panelNorthWestSouthSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelNorthWestSouthSouth.add(panelNorthWestSouthSouthWest,BorderLayout.WEST);
		panelNorthWestSouthSouth.add(panelNorthWestSouthSouthEast,BorderLayout.EAST);

		panelNorthWestSouthSouthWest.setPreferredSize(new Dimension(200,1));
		panelNorthWestSouthSouthEast.setPreferredSize(new Dimension(487,1));


		panelNorthWestSouthSouthWest.setLayout(new BorderLayout());
		panelNorthWestSouthSouthWest.add(panelNorthWestSouthSouthWestNorth,BorderLayout.NORTH);
		panelNorthWestSouthSouthWest.add(panelNorthWestSouthSouthWestSouth,BorderLayout.SOUTH);


		panelNorthWestSouthSouthWestNorth.setPreferredSize(new Dimension(1,196));
		panelNorthWestSouthSouthWestSouth.setPreferredSize(new Dimension(1,52));
		panelNorthWestSouthSouthWestNorth.setLayout(flow1);
		panelNorthWestSouthSouthWestSouth.setLayout(flow2);

		lblUpload.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		lblUpload.setPreferredSize(new Dimension(160,170));

		panelNorthWestSouthSouthWestNorth.add(lblUpload);
		panelNorthWestSouthSouthWestSouth.add(btnUpload);


		panelNorthWestSouthSouthEast.setLayout(new GridBagLayout());

		c.insets=new Insets(1, 3, 1, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelNorthWestSouthSouthEast.add(lblEmployeeId,c);

		c.gridx=1;
		c.gridy=0;
		panelNorthWestSouthSouthEast.add(txtEmployeeId,c);

		c.gridx=0;
		c.gridy=1;
		panelNorthWestSouthSouthEast.add(lblFullName,c);

		c.gridx=1;
		c.gridy=1;
		panelNorthWestSouthSouthEast.add(txtFullName,c);

		c.gridx=0;
		c.gridy=2;
		panelNorthWestSouthSouthEast.add(lblMobile,c);

		c.gridx=1;
		c.gridy=2;
		panelNorthWestSouthSouthEast.add(txtMobile,c);

		c.gridx=0;
		c.gridy=3;
		panelNorthWestSouthSouthEast.add(lblEmail,c);

		c.gridx=1;
		c.gridy=3;
		panelNorthWestSouthSouthEast.add(txtEmail,c);

		c.gridx=0;
		c.gridy=4;
		panelNorthWestSouthSouthEast.add(lblAddress,c);

		c.gridx=1;
		c.gridy=4;
		panelNorthWestSouthSouthEast.add(scrollAddress,c);

		c.gridx=0;
		c.gridy=5;
		panelNorthWestSouthSouthEast.add(lblGender,c);

		c.gridx=1;
		c.gridy=5;
		panelNorthWestSouthSouthEast.add(cmbGender,c);


		flow1.setVgap(24);
		flow2.setVgap(0);
		flow.setVgap(0);


	}



	private void northEastwork() {

		FlowLayout flow =new FlowLayout();

		panelNorthEast.setPreferredSize(new Dimension(470,1));
		panelNorthEast.setLayout(new BorderLayout());
		panelNorthEast.add(panelNorthEastNorth,BorderLayout.NORTH);
		panelNorthEast.add(panelNorthEastSouth,BorderLayout.SOUTH);

		panelNorthEastNorth.setPreferredSize(new Dimension(1,42));
		panelNorthEastNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		panelNorthEastNorth.setLayout(flow);
		panelNorthEastNorth.add(lblEastNorth);

		panelNorthEastSouth.setPreferredSize(new Dimension(1,305));
		panelNorthEastSouth.setLayout(new BorderLayout());

		panelNorthEastSouth.add(panelNorthEastSouthNorth,BorderLayout.NORTH);
		panelNorthEastSouth.add(panelNorthEastSouthSouth,BorderLayout.SOUTH);


		panelNorthEastSouthNorth.setPreferredSize(new Dimension(1,39));
		panelNorthEastSouthSouth.setPreferredSize(new Dimension(1,262));

		panelNorthEastSouthNorth.setLayout(new GridBagLayout());
	

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(1, 5, 1, 5);
		c.fill=GridBagConstraints.BOTH;
		panelNorthEastSouthNorth.add(ckAd,c);
		c.gridx=1;
		c.gridy=0;
		panelNorthEastSouthNorth.add(txtSearchAd,c);
		c.gridx=2;
		c.gridy=0;
		panelNorthEastSouthNorth.add(btnSearchAd,c);

		panelNorthEastSouthSouth.setBorder(BorderFactory.createLoweredBevelBorder());

		panelNorthEastSouthSouth.setLayout(new GridBagLayout());

		c.insets=new Insets(5, 1, 5, 1);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelNorthEastSouthSouth.add(lblDesignation,c);

		c.gridx=1;
		c.gridy=0;
		panelNorthEastSouthSouth.add(txtDesignation,c);

		c.gridx=0;
		c.gridy=1;
		panelNorthEastSouthSouth.add(lblSalary,c);

		c.gridx=1;
		c.gridy=1;
		panelNorthEastSouthSouth.add(txtSalary,c);

		c.gridx=0;
		c.gridy=2;
		panelNorthEastSouthSouth.add(lblPromotion,c);

		c.gridx=1;
		c.gridy=2;
		panelNorthEastSouthSouth.add(txtPromotion,c);
		
		c.gridx=0;
		c.gridy=3;
		panelNorthEastSouthSouth.add(lblOvertime,c);

		c.gridx=1;
		c.gridy=3;
		panelNorthEastSouthSouth.add(txtOvertime,c);

		c.gridx=0;
		c.gridy=4;
		panelNorthEastSouthSouth.add(lblDateofJoin,c);

		c.gridx=1;
		c.gridy=4;
		panelNorthEastSouthSouth.add(txtDate,c);
		//txtDate.setDateFormatString("yyy-MM-dd");

		flow.setVgap(0);
	}

	private void northSouthwork() {
		FlowLayout flow = new FlowLayout();

		panelNorthSouth.setPreferredSize(new Dimension(1,45));
		panelNorthSouth.setBorder(BorderFactory.createRaisedBevelBorder());

		panelNorthSouth.setLayout(flow);
		panelNorthSouth.add(btnAdd);
		panelNorthSouth.add(btnEdit);
		panelNorthSouth.add(btnRefresh);
		panelNorthSouth.add(btnDelete);

		flow.setHgap(20);
		flow.setVgap(2);
		//panelNorthSouth.setBackground(Color.yellow);
	}

	private void southwork() {
		FlowLayout flow = new FlowLayout();
		panelSouth.setPreferredSize(new Dimension(1,210));
		panelSouth.setLayout(flow);
		panelSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTable.setPreferredSize(new Dimension(1157,200));
		panelSouth.add(scrollTable);

		flow.setVgap(3);

		//table header center alignment...
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);

		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(210);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		//panelSouth.setBackground(Color.green);
	}
	
	
	
	
	
	
	private void dateSetup() {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		t=dateFormat.format(date);
		txtDate.setText(" "+t);
	}
	
	
	private void autoId() {

		try{
			String s="select ifnull(max(cast(substring(employeeid, locate('-',employeeid)+1,length(employeeid)- locate('-',employeeid))as UNSIGNED)),0)+1 as employeeid from tbl_employee";
			ResultSet rs=db.sta.executeQuery(s);
			while(rs.next()){
				txtEmployeeId.setText("emp-"+rs.getString("employeeid"));
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}

	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}

		String s="select employeeid,name,mobile,email,designation,salary,overtime,datejoin,image,cast(substring(employeeid,locate('-',employeeid)+1,LENGTH(employeeid)-locate('-',employeeid)) as unsigned) as ord from tbl_employee order by ord";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String Name=rs.getString("name");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String designation=rs.getString("designation");
				String salary=rs.getString("salary");
				String overtime=rs.getString("overtime");
				String txtDate=rs.getString("datejoin");
				String image=rs.getString("image");
				
				model.addRow(new Object[]{id,Name,mobile,email,designation,salary,overtime,txtDate,image});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}

	
	private void UploadAction()
	{

		FileNameExtensionFilter filter=new FileNameExtensionFilter("image","jpg","png","gif","jpeg");
		Chooser.addChoosableFileFilter(filter);
		Chooser.setDialogType(JFileChooser.OPEN_DIALOG);
		Chooser.setDialogTitle("Please upload your image..............");
		if(Chooser.showDialog(this, "Upload")!=JFileChooser.APPROVE_OPTION)
		{
			return;
		}
		file=Chooser.getSelectedFile();
		Image size=Toolkit.getDefaultToolkit().getImage(file.getPath());
		Image resize=size.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon icon=new ImageIcon(resize);
		lblUpload.setIcon(icon);
		temp=1;

	}
	
	protected boolean validation() {
		
		if(btAd==1)
		{
			if(!txtEmployeeId.getText().trim().isEmpty()){
				if(!txtFullName.getText().trim().isEmpty()){
					if(cmbGender.getSelectedIndex()!=0){
						if(!txtDesignation.getText().trim().isEmpty()){
							if(!txtSalary.getText().trim().isEmpty()){
								if(!txtOvertime.getText().trim().isEmpty()){
									if(!txtDate.getText().trim().isEmpty()){
										if(!txtMobile.getText().trim().isEmpty()){
											if(!txtAddress.getText().trim().isEmpty()){
												if(!txtEmail.getText().trim().isEmpty()){
													if(temp==1){
														if(!txtPromotion.getText().trim().isEmpty()){
															btAd=0;
															return true;
														}
														else{
															JOptionPane.showMessageDialog(null, "Please Enter Promotion Limit","Sorry!",JOptionPane.WARNING_MESSAGE);
														}		
													}
													else{
														JOptionPane.showMessageDialog(null, "Please Upload a Picture","Sorry!",JOptionPane.WARNING_MESSAGE);
													}				
												}
												else{
													JOptionPane.showMessageDialog(null, "Please Enter Email ID","Sorry!",JOptionPane.WARNING_MESSAGE);
												}
											}
											else{
												JOptionPane.showMessageDialog(null, "Please Enter address","Sorry!",JOptionPane.WARNING_MESSAGE);
											}
										}
										else{
											JOptionPane.showMessageDialog(null, "Please Enter Mobile No","Sorry!",JOptionPane.WARNING_MESSAGE);
										}
									}
									else{
										JOptionPane.showMessageDialog(null, "Please Enter Joinning Date","Sorry!",JOptionPane.WARNING_MESSAGE);
									}
								}
								else{
									JOptionPane.showMessageDialog(null, "Please Enter Overtime Taka","Sorry!",JOptionPane.WARNING_MESSAGE);
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Please Enter Salary","Sorry!",JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
						JOptionPane.showMessageDialog(null, "Please Enter Designation","Sorry!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please select Gender","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Full Name","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
			}

		}
		
		
		else if(btEd==1)
		{
			if(!txtEmployeeId.getText().trim().isEmpty()){
				if(!txtFullName.getText().trim().isEmpty()){
					if(cmbGender.getSelectedIndex()!=0){
						if(!txtMobile.getText().trim().isEmpty()){
							if(!txtAddress.getText().trim().isEmpty()){
								if(!txtEmail.getText().trim().isEmpty()){
									if(temp==1){
										return true;
									}
									else{
										JOptionPane.showMessageDialog(null, "Please, Upload a Picture","Sorry!",JOptionPane.WARNING_MESSAGE);
									}				
								}
								else{
									JOptionPane.showMessageDialog(null, "Please, Enter Email ID","Sorry!",JOptionPane.WARNING_MESSAGE);
								}
							}
							else{
								JOptionPane.showMessageDialog(null, "Please, Enter address","Sorry!",JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Please, Enter Mobile No","Sorry!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please, select Gender","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please, Enter Full Name","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please, Enter Employee ID","Sorry!",JOptionPane.WARNING_MESSAGE);
			}
	
		}
		
		
		else if(btEd==2)
		{
			if(!txtDesignation.getText().trim().isEmpty()){
				if(!txtSalary.getText().trim().isEmpty()){
					if(!txtOvertime.getText().trim().isEmpty()){
						if(!txtDate.getText().trim().isEmpty()){
							if(!txtPromotion.getText().trim().isEmpty()){
								return true;
							}
							else{
								JOptionPane.showMessageDialog(null, "Please Enter Promotion Limit","Sorry!",JOptionPane.WARNING_MESSAGE);
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Please Enter Joinning Date","Sorry!",JOptionPane.WARNING_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please Enter Overtime Taka","Sorry!",JOptionPane.WARNING_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Salary","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
			}
			else{
			JOptionPane.showMessageDialog(null, "Please Enter Designation","Sorry!",JOptionPane.WARNING_MESSAGE);
			}
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
		
		txtFullName.setText(null);
		txtMobile.setText(null);
		txtEmail.setText(null);
		txtAddress.setText(null);
		cmbGender.setSelectedItem("");
		txtDesignation.setText(null);
		txtSalary.setText(null);
		txtOvertime.setText(null);
		txtPromotion.setText(null);
		lblUpload.setIcon(new ImageIcon(""));
		temp=0;
		
		txtSearchAd.setText("Enter Employee Id....");
		txtSearchPer.setText("Enter Employee Id....");
		
		txtSearchAd.setForeground(Color.gray);
		txtSearchPer.setForeground(Color.gray);
		
		txtSearchAd.setEditable(false);
		txtSearchPer.setEditable(false);
		
		dateSetup();
		
	}
	
	protected void insertdata() {
		try{
			File file2=new File("D:\\Emp_System");
			if(!file2.isDirectory()){
				file2.mkdirs();
			}
			buffer=ImageIO.read(file);

			File fileToWrite=new File(file2.getPath()+"\\"+txtEmployeeId.getText().trim()+".jpg");

			if(fileToWrite.exists()){
				fileToWrite.delete();
			}
			ImageIO.write(buffer, "jpg", fileToWrite);
			String path=file2.getPath()+"\\"+txtEmployeeId.getText().trim()+".jpg";
			String s1=path.replace("\\", "#");
			
		
			db.sta.executeUpdate("insert into tbl_employee(employeeid,name,mobile,email,address,gender,designation,salary,promotion,overtime,datejoin,image) values('"+txtEmployeeId.getText().trim()+"','"+txtFullName.getText().trim()+"','"+txtMobile.getText().trim()+"','"+txtEmail.getText().trim()+"','"+txtAddress.getText().trim()+"','"+cmbGender.getSelectedItem().toString()+"','"+txtDesignation.getText().trim()+"','"+txtSalary.getText().trim()+"','"+txtPromotion.getText().trim()+"','"+txtOvertime.getText().trim()+"','"+txtDate.getText().trim()+"','"+s1+"')");
			autoId();
			txtClear();
			JOptionPane.showMessageDialog(null, "All Information Saved Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	protected void updatedata() {
		try{
			
			if(btEd==1)
			{
				
				File file2=new File("D:\\Emp_System");
				if(!file2.isDirectory()){
					file2.mkdirs();
				}
				buffer=ImageIO.read(file);

				File fileToWrite=new File(file2.getPath()+"\\"+txtEmployeeId.getText().trim()+".jpg");

				if(fileToWrite.exists()){
					fileToWrite.delete();
				}
				ImageIO.write(buffer, "jpg", fileToWrite);
				String path=file2.getPath()+"\\"+txtEmployeeId.getText().trim()+".jpg";
				String s1=path.replace("\\", "#");
				
				db.sta.executeUpdate("update tbl_employee set name='"+txtFullName.getText().trim()+"', mobile='"+txtMobile.getText().trim()+"', email='"+txtEmail.getText().trim()+"', address='"+txtAddress.getText().trim()+"', gender='"+cmbGender.getSelectedItem().toString()+"', image='"+s1+"' where employeeid='"+txtSearchPer.getText().trim()+"'");
				ckAd.setSelected(false);
				ckPer.setSelected(false);
			}
			else if(btEd==2)
			{
				db.sta.executeUpdate("update tbl_employee set designation='"+txtDesignation.getText().trim()+"', salary='"+txtSalary.getText().trim()+"', promotion='"+txtPromotion.getText().trim()+"', overtime='"+txtOvertime.getText().trim()+"', datejoin='"+txtDate.getText().trim()+"' where employeeid='"+txtSearchAd.getText().trim()+"'");
				ckAd.setSelected(false);
				ckPer.setSelected(false);
			}
			btEd=0;
			ck=0;
			autoId();
			txtClear();
			JOptionPane.showMessageDialog(null, "All Information Updated Successfully","Confirmation...",JOptionPane.INFORMATION_MESSAGE);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	
	
			
	private boolean deleteData() {
		try{
			String sql="delete from tbl_employee where employeeid='"+txtEmployeeId.getText().toString().trim()+"'";
			db.sta.executeUpdate(sql);
			return true;
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}


		return false;
	}
	
	
	private void checkExistPer(String id) {

		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs.next()){
				txtEmployeeId.setText(rs.getString("employeeid"));
				txtFullName.setText(rs.getString("name"));
				cmbGender.setSelectedItem(rs.getString("gender"));
				txtMobile.setText(rs.getString("mobile"));
				txtEmail.setText(rs.getString("email"));
				txtAddress.setText(rs.getString("address"));
				
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
	
	private void checkExistAd(String id) {

		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs.next()){
				txtDesignation.setText(rs.getString("designation"));
				txtSalary.setText(rs.getString("salary"));
				txtOvertime.setText(rs.getString("overtime"));
				txtDate.setText(rs.getString("datejoin"));
				txtPromotion.setText(rs.getString("promotion"));
					
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid ID!","Sorry..",JOptionPane.WARNING_MESSAGE);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void action() {

		ckPer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				ck=1;
				ckPer.setSelected(true);
				ckAd.setSelected(false);
				txtSearchPer.setEditable(true);
				txtSearchAd.setEditable(false);
				txtSearchAd.setForeground(Color.gray);
				txtSearchAd.setText("Enter Employee Id....");
				//txtClear();
				
				txtDesignation.setText(null);
				txtSalary.setText(null);
				txtPromotion.setText(null);
				txtOvertime.setText(null);
				
				dateSetup();
				
			}
		});
		
		ckAd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				ck=2;
				ckAd.setSelected(true);
				ckPer.setSelected(false);
				txtSearchAd.setEditable(true);
				txtSearchPer.setEditable(false);
				txtSearchPer.setForeground(Color.gray);
				txtSearchPer.setText("Enter Employee Id....");
				//txtClear();
				
				txtFullName.setText(null);
				txtMobile.setText(null);
				txtEmail.setText(null);
				txtAddress.setText(null);
				cmbGender.setSelectedIndex(0);
				lblUpload.setIcon(new ImageIcon(""));
				temp=0;
				
			}
		});

		txtSearchPer.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {
				
				if(ck==1)
				{
					//if(temp2==0)
						txtSearchPer.setText(null);
					txtSearchPer.setForeground(Color.red);
					
					//temp2++;
				}
		
			}
		});
		
		txtSearchAd.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {}

			@Override
			public void focusGained(FocusEvent arg0) {
				
				if(ck==2)
				{
					//(temp1==0)
						txtSearchAd.setText(null);
					txtSearchAd.setForeground(Color.red);
					
					//temp1++;
				}
			
			}
		});
		
		btnUpload.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				UploadAction();
			}
		});	
		
		
		btnSearchPer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if(!txtSearchPer.getText().trim().isEmpty()){
					checkExistPer(txtSearchPer.getText().trim());
				}
				else{
					JOptionPane.showMessageDialog(null, "Insert Employee Id","Search Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
		
		btnSearchAd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if(!txtSearchAd.getText().trim().isEmpty()){
					checkExistAd(txtSearchAd.getText().trim());
				}
				else{
					JOptionPane.showMessageDialog(null, "Insert Employee Id","Search Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});	
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				btAd=1;
				btEd=0;
				
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
				
				int c = 0;
				btAd = 0;
				
				if(txtSearchPer.getText().equalsIgnoreCase("enter employee id....") && !txtSearchAd.getText().equalsIgnoreCase("enter employee id...."))
				{
					btEd = 2;
					c++;
				}
				else if(txtSearchAd.getText().equalsIgnoreCase("enter employee id....") && !txtSearchPer.getText().equalsIgnoreCase("enter employee id...."))
				{
					btEd = 1;
					c++;
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Please Enter Employee ID","Error!",JOptionPane.ERROR_MESSAGE);
					c=0;
				}
				
				if(c!=0)
				{
					if(validation()){
						if(checkConfirmed("Edit")){
							updatedata();
							tabledata();
						}
					}
				}
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				
				//if(validation()){
					if(checkConfirmed("Delete")){
						if(deleteData()){
							autoId();
							txtClear();
							tabledata();
							ckAd.setSelected(false);
							ckPer.setSelected(false);
						}
					}
				//}
			}
		});
		
		btnRefresh.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				txtClear();
				ckAd.setSelected(false);
				ckPer.setSelected(false);
			}
		});	
	}

}
