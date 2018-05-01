package com.example.Menuitem;

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
import java.sql.Time;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.example.WorkingPanel.PromotionPoint;
import com.example.WorkingPanel.WorkingPanel;

public class AdminPanel extends JPanel{
	
	JFrame frame;
	
	JPanel panelNorth =new JPanel();
	JPanel panelCenter =new JPanel();
	JPanel panelSouth =new JPanel();
	
	
	JLabel lblView = new JLabel("View Data");
	JLabel lblPromotion = new JLabel("Promotion Point");
	JLabel lblEmail = new JLabel("Email Area");
	
	JButton btnView = new JButton(new ImageIcon("images/view3.png"));
	JButton btnPromotion = new JButton(new ImageIcon("images/promotion2.png"));
	JButton btnEmail = new JButton(new ImageIcon("images/email.png"));
	
	GridBagConstraints c = new GridBagConstraints();
	
	public AdminPanel(JFrame frame1) {
		
		this.frame=frame1;
		this.frame.setSize(555,480);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle("Admin Panel");
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cmp();
		action();
		initialSetup();
		
	}
	
	
	private void initialSetup() {
		lblView.setFont(new Font("times new roman", Font.PLAIN,18));
		lblPromotion.setFont(new Font("times new roman", Font.PLAIN,18));
		lblEmail.setFont(new Font("times new roman", Font.PLAIN,18));
		
	}
	
	private void cmp() {

		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(new TitledBorder("")));
		add(panelNorth,BorderLayout.NORTH);
		add(panelCenter,BorderLayout.CENTER);
		//add(panelSouth,BorderLayout.SOUTH);

		north_work();
		center_work();
		south_Work();

	}

	private void north_work() {
		
		panelNorth.setPreferredSize(new Dimension(1,220));
		//panelNorth.setBackground(Color.red);
		
		panelNorth.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelNorth.setLayout(new GridBagLayout());

		c.insets=new Insets(5, 3, 4, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelNorth.add(btnView,c);
		
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(5, 30, 4, 2);
		panelNorth.add(btnPromotion,c);
		
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(0, 46, 4, 3);
		panelNorth.add(lblView,c);
		
		c.gridx=1;
		c.gridy=1;
		c.insets=new Insets(0, 49, 4, 3);
		panelNorth.add(lblPromotion,c);
	}

	private void center_work() {
		
		/*FlowLayout flow = new FlowLayout();
		panelCenter.setLayout(flow);
		panelCenter.add(btnView);
		panelCenter.add(btnPromotion);

		flow.setHgap(20);*/
		
		panelCenter.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		panelCenter.setLayout(new GridBagLayout());

		c.insets=new Insets(5, 3, 4, 2);
		c.fill=GridBagConstraints.BOTH;

		c.gridx=0;
		c.gridy=0;
		panelCenter.add(btnEmail,c);
		
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(0, 42, 4, 3);
		panelCenter.add(lblEmail,c);
		
	}

	private void south_Work() {
		//panelSouth.setPreferredSize(new Dimension(1,10));
	}
	
	public void action()
	{
		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panelNorth.setVisible(false);
				panelCenter.setVisible(false);
				setBorder(null);
				WorkingPanel wp=new WorkingPanel(frame);
				add(wp);
				//wp.setVisible(true);
			}
		});
		
		btnPromotion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panelNorth.setVisible(false);
				panelCenter.setVisible(false);
				setBorder(null);
				PromotionPoint wp=new PromotionPoint(frame);
				add(wp);
				//wp.setVisible(true);
			}
		});
		
		btnEmail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				panelNorth.setVisible(false);
				panelCenter.setVisible(false);
				setBorder(null);
				Email wp=new Email(frame);
				add(wp);
				//wp.setVisible(true);
			}
		});
	}
			

}
