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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.example.Admin.Login;
import com.example.Admin.db_connection;

public class Email extends JPanel{

	db_connection db = new db_connection();
	
	JFrame frame;
	
	JPanel panelWest = new JPanel();
	JPanel panelWestNorth = new JPanel();
	JPanel panelWestCenter = new JPanel();
	JPanel panelWestSouth = new JPanel();
	
	JPanel panelEast = new JPanel();
	JPanel panelEastNorth = new JPanel();
	JPanel panelEastCenter = new JPanel();
	JPanel panelEastSouth = new JPanel();
	
	
	JLabel lblEmail = new JLabel("Email:");
	JLabel lblSubject = new JLabel("Subject:");
	JLabel lblMessage = new JLabel("Message:");
	JLabel lblEastTop = new JLabel(new ImageIcon("images/eastTop.png"));
	
	JTextField txtEmail = new JTextField(24);
	JTextField txtSubject = new JTextField(24);
	JTextArea txtMessage = new JTextArea(10,10);
	
	JButton btnPrint = new JButton("Print",new ImageIcon("images/print.png"));
	JButton btnlogout = new JButton("Logout",new ImageIcon("images/logout2.png"));
	JButton btnSend = new JButton("Send",new ImageIcon("images/signin.png"));
	
	JCheckBox ckAll=new JCheckBox("All Employees");
	JCheckBox ckSpecific=new JCheckBox("Specific Employee");
	
	
	GridBagConstraints c = new GridBagConstraints();


	String column[]={"Employee Id","Name","Email"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scrollTable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	String s2,email,emailtxt,password,msz,sub,senderid;
	int flag1=0,flag=0,f,tempId=1;
	
	
	public Email(JFrame frame1){
		
		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		this.frame=frame1;
		this.frame.setSize(1000,600);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle("Admin Email Panel");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmp();
		action();
		initialSetup();
		tabledata();
	}


	private void cmp() {
		
		//setBackground(Color.red);
		setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
		setLayout(new BorderLayout());
		add(panelWest,BorderLayout.WEST);
		add(panelEast,BorderLayout.EAST);
		
		west_work();
		east_work();	
		
	}
	
	private void initialSetup() {
		
		lblEmail.setFont(new Font("tahoma", Font.PLAIN, 16));
		lblSubject.setFont(new Font("tahoma", Font.PLAIN, 16));
		lblMessage.setFont(new Font("tahoma", Font.PLAIN, 16));
		txtEmail.setFont(new Font("tahoma", Font.PLAIN, 16));
		txtSubject.setFont(new Font("tahoma", Font.PLAIN, 16));
		txtMessage.setFont(new Font("tahoma", Font.PLAIN, 16));
		
		ckAll.setFont(new Font("tahoma", Font.PLAIN, 16));
		ckSpecific.setFont(new Font("tahoma", Font.PLAIN, 16));
		
		
		btnPrint.setFont(new Font("Times new roman", Font.BOLD, 15));
		btnlogout.setFont(new Font("Times new roman", Font.BOLD, 15));
		btnSend.setFont(new Font("Times new roman", Font.BOLD, 15));
		
		btnPrint.setPreferredSize(new Dimension(475,45));
		
		txtEmail.setEditable(false);
		txtSubject.setEditable(false);
		txtMessage.setEditable(false);
	}


	private void west_work() {
		
		panelWest.setPreferredSize(new Dimension(497,1));
		//panelWest.setBackground(Color.green);
		panelWest.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelWest.setLayout(new BorderLayout());
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		
		
		panelWestNorth.setPreferredSize(new Dimension(1,90));
		//panelWestNorth.setBackground(Color.green);
		panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestNorth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 12, 5, 12);
		c.fill=GridBagConstraints.BOTH;
		panelWestNorth.add(ckAll,c);
		c.gridx=1;
		c.gridy=0;
		panelWestNorth.add(ckSpecific,c);	
		
		
		
		
		
		
		panelWestCenter.setLayout(new GridBagLayout());
		//panelWestCenter.setBackground(Color.red);
		
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 5, 5, 5);
		c.fill=GridBagConstraints.BOTH;
		panelWestCenter.add(lblEmail,c);
		c.gridx=1;
		c.gridy=0;
		panelWestCenter.add(txtEmail,c);	
		
		c.gridx=0;
		c.gridy=1;
		panelWestCenter.add(lblSubject,c);	
		c.gridx=1;
		c.gridy=1;
		panelWestCenter.add(txtSubject,c);	
		
		c.gridx=0;
		c.gridy=2;
		panelWestCenter.add(lblMessage,c);	
		c.gridx=1;
		c.gridy=2;
		panelWestCenter.add(txtMessage,c);
		
		
		
		panelWestSouth.setPreferredSize(new Dimension(1,90));
		panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		panelWestSouth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(5, 8, 5, 8);
		c.fill=GridBagConstraints.BOTH;
		panelWestSouth.add(btnSend,c);
		c.gridx=1;
		c.gridy=0;
		panelWestSouth.add(btnlogout,c);	
	}


	private void east_work() {
		
		FlowLayout flow = new FlowLayout();
		FlowLayout flow2 = new FlowLayout();
		FlowLayout flow3 = new FlowLayout();
		
		
		panelEast.setPreferredSize(new Dimension(478,1));
		//panelEast.setBackground(Color.yellow);
		panelEast.setBorder(BorderFactory.createLoweredBevelBorder());
		
		panelEast.setLayout(new BorderLayout());
		panelEast.add(panelEastNorth,BorderLayout.NORTH);
		panelEast.add(panelEastCenter,BorderLayout.CENTER);
		panelEast.add(panelEastSouth,BorderLayout.SOUTH);
		
		panelEastNorth.setPreferredSize(new Dimension(1,70));
		panelEastNorth.setLayout(flow);
		panelEastNorth.add(lblEastTop);
		flow.setVgap(0);
		
		
		
		
		
		panelEastNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelEastCenter.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panelEastCenter.setLayout(flow3);
		//panelEastCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollTable.setPreferredSize(new Dimension(470,430));
		panelEastCenter.add(scrollTable);

		flow3.setVgap(-2);
		TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
		JLabel label = (JLabel)renderer;
		label.setHorizontalAlignment(JLabel.CENTER);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		
		
		
		panelEastSouth.setPreferredSize(new Dimension(1,45));
		panelEastSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelEastSouth.setLayout(flow2);
		panelEastSouth.add(btnPrint);
		flow2.setVgap(-2);
		
	}
	
	
	
	private void tabledata() {

		for(int a=model.getRowCount()-1;a>=0;a--)
		{
			model.removeRow(a);
		}
		//String s="select *,cast(substring(2,10) as unsigned) as ord from tbl_signin order by ord";
		//String s="select *,cast(substring(bookid,locate('-',bookid)+1,LENGTH(bookid)-locate('-',bookid)) as unsigned) as ord from tbl_addbook order by ord";
		
		String s="select employeeid,name,email from tbl_employee order by autoid";
		try{
			ResultSet rs= db.sta.executeQuery(s);
			while(rs.next()){
				String id=rs.getString("employeeid");
				String name=rs.getString("name");
				String email=rs.getString("email");
				
				
				model.addRow(new Object[]{id,name,email});
			}
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}

	}
	
	
	private void checkExist(String id) {

		try{
			ResultSet rs=db.sta.executeQuery("select * from tbl_employee where employeeid='"+id+"'");
			if(rs.next()){
				
				txtEmail.setText(rs.getString("email"));
				
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
		
		
		table.addMouseListener(new MouseListener() 
		{
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}

			public void mouseClicked(MouseEvent arg0) {
				
				if(tempId==0)
				{
					checkExist(table.getValueAt(table.getSelectedRow(), 0).toString());
				}
				
			}
		});
		
		
		
		btnPrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MessageFormat Header=new MessageFormat("Employee information");
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
		
		btnlogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				Login hm=new Login();
			}
		});
		
		
		
		ckSpecific.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ckAll.setSelected(false);
				tempId=0;
				flag1=1;
				txtEmail.setText(null);
				txtEmail.setEditable(true);
				txtSubject.setEditable(true);
				txtMessage.setEditable(true);
				
				txtEmail.setForeground(Color.black);
			}
		});

		ckAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ckSpecific.setSelected(false);
				tempId=1;
				flag1=1;
				txtEmail.setText(null);
				txtEmail.setEditable(false);
				txtSubject.setEditable(true);
				txtMessage.setEditable(true);
				
				txtEmail.setText("All Email is Selected");
				txtEmail.setForeground(Color.red);
			}
		});

		
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if(flag1==1)
				{

					int s=JOptionPane.showConfirmDialog(null, "Is Your Network Connection Ok..?","Network Confirmation....",JOptionPane.YES_NO_OPTION);
					if(s==JOptionPane.YES_OPTION)
					{

						try
						{
							msz = txtMessage.getText();
							sub = txtSubject.getText();

							if(tempId==0)
							{
								senderid = txtEmail.getText();

								Properties props = new Properties();
								props.put("mail.smtp.host", "smtp.gmail.com");
								props.put("mail.smtp.socketFactory.port", "465");
								props.put("mail.smtp.socketFactory.class",
										"javax.net.ssl.SSLSocketFactory");
								props.put("mail.smtp.auth", "true");
								props.put("mail.smtp.port", "465");

								Session session = Session.getDefaultInstance(props,
										new javax.mail.Authenticator() {
									protected PasswordAuthentication getPasswordAuthentication() {
										return new PasswordAuthentication("arofinenishchup01@gmail.com", "01676191740");

									}
								});

								try {
									Message message = new MimeMessage(session);
									message.setFrom(new InternetAddress("arofinenishchup01@gmail.com"));
									message.setRecipients(Message.RecipientType.TO,
											InternetAddress.parse(senderid));


									message.setSubject(sub);
									message.setText(msz);
									Transport.send(message);
									JOptionPane.showMessageDialog(null, "The message is sent");
									
									txtEmail.setText(null);
									txtSubject.setText(null);
									txtMessage.setText(null);
									
									txtEmail.setEditable(false);
									txtSubject.setEditable(false);
									txtMessage.setEditable(false);
									
									ckAll.setSelected(false);
									ckSpecific.setSelected(false);
								} 

								catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);

								}

								//JOptionPane.showMessageDialog(null, "ok");
							}


							else
							{
								ResultSet rs=db.sta.executeQuery("select email from tbl_employee");
								while(rs.next())
								{
									String Rec_email=rs.getString("email");


									Properties props = new Properties();
									props.put("mail.smtp.host", "smtp.gmail.com");
									props.put("mail.smtp.socketFactory.port", "465");
									props.put("mail.smtp.socketFactory.class",
											"javax.net.ssl.SSLSocketFactory");
									props.put("mail.smtp.auth", "true");
									props.put("mail.smtp.port", "465");

									Session session = Session.getDefaultInstance(props,
											new javax.mail.Authenticator() {
										protected PasswordAuthentication getPasswordAuthentication() {
											return new PasswordAuthentication("arofinenishchup01@gmail.com", "01676191740");

										}
									});

									try {
										Message message = new MimeMessage(session);
										message.setFrom(new InternetAddress("arofinenishchup01@gmail.com"));
										message.setRecipients(Message.RecipientType.TO,
												InternetAddress.parse(Rec_email));


										message.setSubject(sub);
										message.setText(msz);
										Transport.send(message);
										flag=1;

									} 

									catch (Exception e) {
										JOptionPane.showMessageDialog(null, e);

									}

								}
							}

							if(flag==1 && tempId==1)
							{
								JOptionPane.showMessageDialog(null, "The message is sent");
								
								txtEmail.setText(null);
								txtSubject.setText(null);
								txtMessage.setText(null);
								
								txtEmail.setEditable(false);
								txtSubject.setEditable(false);
								txtMessage.setEditable(false);
								
								ckAll.setSelected(false);
								ckSpecific.setSelected(false);
								
							}

						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, e);
						}

					}

					else
					{
						JOptionPane.showMessageDialog(null, "Your Operation Is Failed....Try Again....","Sending Error!!",JOptionPane.ERROR_MESSAGE);
					}
				}

				else
				{
					JOptionPane.showMessageDialog(null, "Click any one CheckBox","CheckBox Choose Error",JOptionPane.ERROR_MESSAGE);
				}

			}
		});


	}

}
