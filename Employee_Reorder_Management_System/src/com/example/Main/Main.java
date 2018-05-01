package com.example.Main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.example.Admin.Login;
import com.example.Menuitem.Email;
import com.example.Menuitem.Progress_bar;
import com.example.WorkingPanel.WorkingPanel;

public class Main {

	public Main() {
		try{

			for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels())
			{
				if("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}

		}
		catch(Exception e){
			e.printStackTrace();

		}
		Progress_bar l=new Progress_bar();
		
	}

	
	public static void main(String[] args) {
		
		Main lg=new Main();
	}

}
