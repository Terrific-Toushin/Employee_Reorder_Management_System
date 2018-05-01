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
import java.nio.channels.AcceptPendingException;
import java.util.concurrent.BrokenBarrierException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.example.Admin.Login;
import com.example.Menuitem.Computation;
import com.example.Menuitem.EmployeeInfo;
import com.example.Menuitem.SignIn;
import com.example.Menuitem.SignOut;


public class WorkingPanel extends JPanel{

	EmployeeInfo emp =new EmployeeInfo();
	SignIn si =new SignIn();
	SignOut so =new SignOut();
	Computation com =new Computation();
	
	
	JFrame frame;

	JPanel panelNorth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterCenterNorth=new JPanel();
	JPanel panelCenterCenterSouth=new JPanel();
	

	JButton btnHome = new JButton("Home",new ImageIcon("images/home.png"));
	JButton btnEmpInfo = new JButton("Employee Information",new ImageIcon("images/employee.png"));
	JButton btnSignIn = new JButton("Sign In",new ImageIcon("images/signin3.png"));
	JButton btnSignOut = new JButton("Sign Out",new ImageIcon("images/signout3.png"));
	JButton btnComp = new JButton("Computation",new ImageIcon("images/compute.png"));
	JButton btnLogout = new JButton("Logout",new ImageIcon("images/logout.png"));

	JLabel lblCenter = new JLabel(new ImageIcon("images/main.jpg"));

	public WorkingPanel(JFrame frame1) {

		this.frame=frame1;
		this.frame.setSize(1200,730);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle("Main Panel");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmp();
		action();
		allPanelFalse();
		
		btnHome.setBackground(Color.gray);

	}

	

	private void cmp() {

		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);

		north_work();
		center_work();
	

	}
	
	private void allPanelFalse() {
		
		emp.setVisible(false);
		si.setVisible(false);
		so.setVisible(false);
		com.setVisible(false);
		
	}

	private void north_work() {

		FlowLayout flow=new FlowLayout();
		panelNorth.setPreferredSize(new Dimension(1,61));
		//panelNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		panelNorth.setLayout(new BorderLayout());
		//panelNorth.setBackground(Color.red);

		panelNorth.setLayout(flow);

		btnHome.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));
		btnEmpInfo.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));
		btnSignIn.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));
		btnSignOut.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));
		btnComp.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));
		btnLogout.setFont(new Font("Times new roman",Font.BOLD+Font.ITALIC,20));

		/*btnHome.setSize(130, 60);
		btnEmpInfo.setSize(130, 60);
		btnUp1.setSize(130, 60);
		btnUp2.setSize(130, 60);
		btnUp3.setSize(130, 60);
		*/
	/*	btnHome.setPreferredSize(new Dimension(130,60));
		btnEmpInfo.setPreferredSize(new Dimension(270,60));
		btnUp1.setPreferredSize(new Dimension(130,60));
		btnUp2.setPreferredSize(new Dimension(130,60));
		btnUp3.setPreferredSize(new Dimension(130,60));
		*/
		panelNorth.add(btnHome);
		panelNorth.add(btnEmpInfo);
		panelNorth.add(btnSignIn);
		panelNorth.add(btnSignOut);
		panelNorth.add(btnComp);
		panelNorth.add(btnLogout);

		flow.setVgap(0);
		
	//	btnHome.setBorder(BorderFactory.createMatteBorder(0, 0, 15, 0, Color.white));

	}

	private void center_work() {
		FlowLayout flow=new FlowLayout();

		panelCenter.setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));

		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);

		
		panelCenterCenter.setBorder(BorderFactory.createLoweredBevelBorder());
		panelCenterCenter.setLayout(new BorderLayout());
		
		panelCenterCenter.add(lblCenter);
		flow.setVgap(0);
	}



	private void action() {
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				btnHome.setBackground(Color.gray);
				
				btnEmpInfo.setBackground(Color.lightGray);
				btnSignIn.setBackground(Color.lightGray);	
				btnSignOut.setBackground(Color.lightGray);	
				btnComp.setBackground(Color.lightGray);	
				btnLogout.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(true);
		
			}
		});
		
		btnEmpInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnEmpInfo.setBackground(Color.gray);
				
				btnSignIn.setBackground(Color.lightGray);
				btnHome.setBackground(Color.lightGray);	
				btnSignOut.setBackground(Color.lightGray);	
				btnComp.setBackground(Color.lightGray);	
				btnLogout.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(false);
				panelCenterCenter.add(emp);
				emp.setVisible(true);
				
			}

		});
		
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnSignIn.setBackground(Color.gray);
				
				btnEmpInfo.setBackground(Color.lightGray);
				btnHome.setBackground(Color.lightGray);	
				btnSignOut.setBackground(Color.lightGray);	
				btnComp.setBackground(Color.lightGray);	
				btnLogout.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(false);
				panelCenterCenter.add(si);
				si.setVisible(true);
				
			}

		});
		
		btnSignOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnSignOut.setBackground(Color.gray);
				
				btnEmpInfo.setBackground(Color.lightGray);
				btnHome.setBackground(Color.lightGray);	
				btnSignIn.setBackground(Color.lightGray);	
				btnComp.setBackground(Color.lightGray);	
				btnLogout.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(false);
				panelCenterCenter.add(so);
				so.setVisible(true);
				
			}

		});
		
		btnComp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				btnComp.setBackground(Color.gray);
				
				btnEmpInfo.setBackground(Color.lightGray);
				btnHome.setBackground(Color.lightGray);	
				btnSignOut.setBackground(Color.lightGray);	
				btnSignIn.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(false);
				panelCenterCenter.add(com);
				com.setVisible(true);
				
			}

		});
		
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				/*btnLogout.setBackground(Color.gray);
				
				btnEmpInfo.setBackground(Color.lightGray);
				btnHome.setBackground(Color.lightGray);	
				btnSignOut.setBackground(Color.lightGray);	
				btnSignIn.setBackground(Color.lightGray);	
				btnComp.setBackground(Color.lightGray);	
				
				allPanelFalse();
				lblCenter.setVisible(false);*/
				frame.setVisible(false);
				Login hm=new Login();
				/*panelCenterCenter.add(com);
				com.setVisible(true);*/
				
			}

		});
	}
	
}
