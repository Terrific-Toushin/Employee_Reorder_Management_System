package com.example.Menuitem;
import javax.swing.*;

import com.example.Admin.Login;
import com.example.Main.Main;

import java.awt.*;

public class Progress_bar extends JWindow{
	JPanel panel_main=new JPanel();
	JPanel panel_center=new JPanel();
	JLabel lbl_icon=new JLabel(new ImageIcon("images/progress.jpg"));
	JProgressBar bar=new JProgressBar(0,3000);
	int c;
	public Progress_bar()
	{
		init();
		cmp();
	}
	public void cmp()
	{
		add(panel_main);
		panel_main.setLayout(new BorderLayout());
		panel_main.setBorder(BorderFactory.createLineBorder(Color.black));
		panel_main.add(lbl_icon,BorderLayout.CENTER);
		panel_main.add(bar,BorderLayout.SOUTH);
		try 
		{
			for(c=0;c<4000;c++)
			{
				int value=bar.getValue();
				if(value<3000)
				{
					bar.setValue(++value);
				}
				Thread.sleep(1);
			}
			dispose();
			Login l=new Login();
		}
		catch (Exception e) 
		{ 
			// TODO: handle exception
		}
	}
	public void init()
	{
		setSize(450,240);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
