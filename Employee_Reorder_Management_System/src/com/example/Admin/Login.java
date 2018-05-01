package com.example.Admin;

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
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.Menuitem.AdminPanel;
import com.example.Menuitem.Email;
import com.example.Menuitem.UserPanel;
import com.example.WorkingPanel.PromotionPoint;

import com.example.WorkingPanel.WorkingPanel;


public class Login extends JFrame{
	
	db_connection db = new db_connection();

	JPanel mainPanel=new JPanel();
	JPanel panelWest=new JPanel();
	JPanel panelEast=new JPanel();
	JPanel panelNorth=new JPanel();
	JPanel panelSouth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();
		
	BorderLayout bdr=new BorderLayout();
	BorderLayout bdr2=new BorderLayout();
	FlowLayout flowWest=new FlowLayout();
	FlowLayout flowEast=new FlowLayout();
	FlowLayout flowNorth=new FlowLayout();
	FlowLayout flowSouth=new FlowLayout();
	FlowLayout flowCenterNorth=new FlowLayout();
	FlowLayout flowCenterCenter=new FlowLayout();
	
	GridBagLayout grid=new GridBagLayout();
	GridBagConstraints c=new GridBagConstraints();
	
	JCheckBox ckForgot = new JCheckBox();
	
	JLabel lblName=new JLabel("Username:");
	JLabel lblPass=new JLabel("Password:");
	JLabel lblForgot=new JLabel("Forgot Password ??");
	JLabel lblChoose=new JLabel("Choose Login Panel: ");
	JTextField txtUser= new JTextField(12);
	JPasswordField txtPass= new JPasswordField(12);
	
	JButton btnLogin=new JButton("Login");
	JButton btnReset=new JButton("Reset");

	JLabel lblImageWest=new JLabel(new ImageIcon("images/west.jpg"));
	JLabel lblImageEast=new JLabel(new ImageIcon("images/east.jpg"));
	JLabel lblImageNorth=new JLabel(new ImageIcon("images/north.jpg"));
	JLabel lblImageSouth=new JLabel(new ImageIcon("images/south.jpg"));
	JLabel lblImageCenterNorth=new JLabel(new ImageIcon("images/center_north.jpg"));

	String s[]={"","Admin","Operator","User"};
	JComboBox cmbChoose=new JComboBox(s);
	
	String username,password;
	int temp=0,all_check=0,count=0;
	
	public Login() {

		try{
			db.conect();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		init();
		cmp();
		action();
		
	}


	public void init()
	{
		setSize(555,370);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login Form");
	}
	
	public void cmp()
	{
		add(mainPanel);
		mainPanel.setLayout(bdr);
		mainPanel.add(panelEast,BorderLayout.EAST);
		mainPanel.add(panelWest,BorderLayout.WEST);
		mainPanel.add(panelNorth,BorderLayout.NORTH);
		mainPanel.add(panelSouth,BorderLayout.SOUTH);
		mainPanel.add(panelCenter,BorderLayout.CENTER);
		
		
		panelWest_work();
		panelEast_work();
		panelNorth_work();
		panelSouth_work();
		panelCenter_work();
		
		txtUser.setEditable(false);
		txtPass.setEditable(false);
		
		
	}
	public void panelNorth_work()
	{
		panelNorth.setPreferredSize(new Dimension(1,44));
		panelNorth.add(lblImageNorth);
		panelNorth.setLayout(flowNorth);
		flowNorth.setVgap(0);
	}
	
	
	public void panelWest_work()
	{
		panelWest.setPreferredSize(new Dimension(95,1));
		panelWest.add(lblImageWest);
		panelWest.setLayout(flowWest);
		flowWest.setVgap(0);
	}
	public void panelEast_work()
	{
		panelEast.setPreferredSize(new Dimension(95,1));
		panelEast.add(lblImageEast);
		panelEast.setLayout(flowEast);
		flowEast.setVgap(0);
	}
	
	public void panelSouth_work()
	{
		panelSouth.setPreferredSize(new Dimension(1,38));
		panelSouth.add(lblImageSouth);
		panelSouth.setLayout(flowSouth);
		flowSouth.setVgap(0);
	}
	
	
	public void panelCenter_work()
	{
		panelCenter.setLayout(bdr2);
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
		panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		
		panelCenterNorth.setPreferredSize(new Dimension(1,50));
		panelCenterNorth.add(lblImageCenterNorth);
		panelCenterNorth.setLayout(flowCenterNorth);
		flowCenterNorth.setVgap(0);
		
		lblName.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblPass.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblForgot.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblChoose.setFont(new Font("Tahoma",Font.PLAIN,17));
		cmbChoose.setFont(new Font("Tahoma",Font.PLAIN,17));
		
		cmbChoose.setPreferredSize(new Dimension(130,30));
		//panelCenterCenter.setBackground(Color.red);
		panelCenterCenter.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		
		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=0;
		panelCenterCenter.add(lblChoose,c);
		
		c.gridx=1;
		c.gridy=0;
		panelCenterCenter.add(cmbChoose,c);
		
	
		
		
		
		panelCenterSouth.setPreferredSize(new Dimension(1,165));
		//panelCenterSouth.setBackground(Color.green);
		panelCenterSouth.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		
		panelCenterSouth.setLayout(grid);
		
		c.fill=GridBagConstraints.BOTH;
		
		c.insets=new Insets(5, 5, 2, 5);
		c.gridx=0;
		c.gridy=0;
		panelCenterSouth.add(lblName,c);
		
		c.gridx=1;
		c.gridy=0;
		panelCenterSouth.add(txtUser,c);
		
		c.gridx=0;
		c.gridy=1;
		panelCenterSouth.add(lblPass,c);
		
		c.gridx=1;
		c.gridy=1;
		panelCenterSouth.add(txtPass,c);
		
		/*c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(3, 91, 5, -50);
		panelCenterSouth.add(ckForgot,c);
		
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(3, 26, 5, 5);
		panelCenterSouth.add(lblForgot,c);*/
		
		btnLogin.setFont(new Font("Tahoma",Font.BOLD,14));
		txtUser.setFont(new Font("Tahoma",Font.PLAIN,16));
		txtPass.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		btnLogin.setBackground(Color.pink);
		
		c.insets=new Insets(7, 5, 5, 5);
		
		c.gridx=1;
		c.gridy=2;
		panelCenterSouth.add(btnLogin,c);

	}
	
	public void action()
	{
		txtUser.setHorizontalAlignment(txtUser.CENTER);
		txtPass.setHorizontalAlignment(txtUser.CENTER);
		
		
		
		cmbChoose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(cmbChoose.getSelectedIndex()==1)
				{
					txtUser.setText("Admin");
					txtPass.setEditable(true);
					temp=1;
				}
				else if(cmbChoose.getSelectedIndex()==2)
				{
					txtUser.setText("Operator");
					txtPass.setEditable(true);
					temp=2;
				}
				else if(cmbChoose.getSelectedIndex()==3)
				{
					userLoginAction();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please Choose a Panel to Login","Panel Empty Error!!",JOptionPane.ERROR_MESSAGE);
					temp=0;
					txtUser.setEditable(false);
					txtUser.setText("");
					txtPass.setEditable(false);
				}
			}
		});
		
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtUser.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Username","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
				else if(txtPass.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Enter Password","Sorry!",JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					try{
						String sql="select username,password from tbl_login";
						ResultSet rs=db.sta.executeQuery(sql);
						while(rs.next())
						{
							username=rs.getString("username");
							password=rs.getString("password");
					
							if(txtUser.getText().trim().equalsIgnoreCase(username) && txtPass.getText().trim().equals(password))
							{
								
								all_check=1;
								break;
							}	
						}
						if(all_check==1)
						{	
							loginAction();
						}
						else
						{
							if(count==0)
								JOptionPane.showMessageDialog(null, "Sorry! You don't have Authority to Access this System.","Login Error",JOptionPane.ERROR_MESSAGE);
							count++;
							
							if(count==1)
								JOptionPane.showMessageDialog(null, "You Can Try 2 More Times", "Login Warning", JOptionPane.WARNING_MESSAGE);
							else if(count==2)
								JOptionPane.showMessageDialog(null, "You Can Try 1 More Time", "Login Warning", JOptionPane.WARNING_MESSAGE);
							if(count>=3)
							{
								Thread.sleep(10000);
								JOptionPane.showMessageDialog(null, "You Can try Again 3 More Times until You Successfully Login yourself !!");
								count=0;
							}

							txtPass.setText(null);
						}
					}
					catch(Exception e)
					{
						//JOptionPane.showMessageDialog(null, "Problem","Pvm",JOptionPane.ERROR_MESSAGE);
						System.out.print(e);
					}
				}
				
				
				//loginAction();
			}
		});
		
		
	}
	
	public void loginAction()
	{
		
		if(txtUser.getText().trim().equalsIgnoreCase("admin"))
		{
			mainPanel.setVisible(false);
			AdminPanel ap=new AdminPanel(this);
			add(ap);
			ap.setVisible(true);
		}
		
		else if(txtUser.getText().trim().equalsIgnoreCase("operator"))
		{
			mainPanel.setVisible(false);
			WorkingPanel wp=new WorkingPanel(this);
			add(wp);
			wp.setVisible(true);
			
		}
		
		
		/*mainPanel.setVisible(false);
		WorkingPanel wp=new WorkingPanel(this);
		add(wp);
		
		mainPanel.setVisible(false);
		AdminPanel ap=new AdminPanel(this);
		add(ap);*/
		
		//Email e = new Email(this);
		
	}
	
	public void userLoginAction()
	{
		mainPanel.setVisible(false);
		UserPanel up=new UserPanel(this);
		add(up);
		up.setVisible(true);
		
	}


}
