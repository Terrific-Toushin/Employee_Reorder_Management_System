package com.example.Admin;


import java.io.File;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class db_connection{
	String a=null,username=null, password="", b=null,c=null,port=null,d=null,server=null,e=null,db_file=null;
	public Connection con=null;
	public Statement sta=null;
	public void conect()
	{
		try{
			int temp=1;
			File file=new File("src/db_connection.txt");
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine()){
				String s=scan.nextLine();
				StringTokenizer token=new StringTokenizer(s);
				
				if(temp==1){
					a=token.nextToken();
					username=token.nextToken();
					temp=2;
				}
				else if(temp==2){
					c=token.nextToken();
					port=token.nextToken();
					temp=3;
				}
				else if(temp==3){
					d=token.nextToken();
					server=token.nextToken();
					temp=4;
				}
				else if(temp==4){
					e=token.nextToken();
					db_file=token.nextToken();
					break;
				}
				
			}
			
			String url="jdbc:mysql://"+server+":"+port+"/"+db_file;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,username,password);
			sta=con.createStatement();
			System.out.println ("Database_connection_established");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
	}
}
