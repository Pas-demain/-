package com.hubPlayer.denglu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Jdbc {
	
	@SuppressWarnings("rawtypes")
	Vector rowData,columnNames;
	
	Connection con = null;  
	Statement statement = null;  
	ResultSet res = null;  
	String driver = "com.mysql.jdbc.Driver";  
	String url  = "jdbc:mysql://localhost:3306/demo";  
	String name = "root";  
	String passwd = "980405"; 
	
	public Jdbc(){  
	    try{  
	    Class.forName(driver).newInstance();  
	    con = DriverManager.getConnection(url,name,passwd);  
	    statement = con.createStatement();  
	      
	    }catch(ClassNotFoundException e){  
	        System.out.println("�Բ����Ҳ������Driver");  
	        e.printStackTrace();  
	    }catch(SQLException e){  
	        e.printStackTrace();  
	    }catch(Exception e){  
	        e.printStackTrace();  
	        }  
	}  
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init(String sql)
	{
		if(sql.equals(""))
		{
			sql="select * from musicInfo";
		}
		columnNames=new Vector();
	    //����û����Ϣ
		columnNames.add("������");
		columnNames.add("������ַ");
		columnNames.add("����");
		columnNames.add("�����б�");
		columnNames.add("��ʵ�ַ");
		
		rowData=new Vector();		
		//�����ݿ���ȡ����������
		try {
			//��ʼ������
			//1����������
			Class.forName(driver);
			//2���õ�����
			con=DriverManager.getConnection(url,name,passwd);
			//3�����������
			statement=con.prepareStatement(sql);
			//4��ִ�У��������ɾ�ģ�ʹ��executeUpdate����������ǲ�ѯ��ʹ��executeQuery������
			res=statement.executeQuery(sql);
			
			//ѭ��ȡ��ÿ�н�����
			while(res.next())
			{
				Vector hang=new Vector();
				
				hang.add(res.getString(1));
				hang.add(res.getString(2));
				hang.add(res.getString(3));
				hang.add(res.getString(4));
				hang.add(res.getString(5));
						
				rowData.add(hang);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ر���Դ
			try {
				if(res!=null) res.close();
				if(statement!=null) statement.close();
				if(con!=null) con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			
		}
	}
	
	public boolean compare(String username, String password) {
		// TODO Auto-generated method stub
		boolean m = false;  
	    String sql = "select password from user where username=\""+username+"\"";  
	    try{  
	        res = statement.executeQuery(sql);  
	        if(res.next()){  
	            String pa = res.getString(1);  
	            System.out.println(pa+" " +password);  
	            if(pa.equals(password)){  
	                m = true;  
	            }else {  
	                JOptionPane.showMessageDialog(null, "�������");  
	            }  
	        }else {  
	            JOptionPane.showMessageDialog(null, "�û��������ڣ�");  
	        }  
	        res.close();  
	        con.close();  
	        statement.close();  
	          
	    }catch(SQLException e){  
	        e.printStackTrace();  
	    }  
	    return m;  
	}  
	public void insert(String username, String password, String password2,String phonenum) {
		// TODO Auto-generated method stub
		String sql = "insert into user(username,password,password2,phonenum) values(\""+username+"\",\""+password+"\",\""+password2+"\",\""+phonenum+"\")";  
		try{  
	        int a = statement.executeUpdate(sql);  
	        con.close();  
	        statement.close();  
	        if(a==1){  
	            //JOptionPane.showMessageDialog(null,"ע��ɹ���");  
	        	new Denglu();
	        }  
	    }catch(SQLException e){  
	        JOptionPane.showMessageDialog(null, "�Բ�����û����Ѿ����ˣ�");  
	        e.printStackTrace();  
	    }  
	}
	
	@SuppressWarnings("unused")
	public boolean insert(String musicName,String songAddress,String singerName,String songAlbum,String songLrc) {
		
		String sql = "insert into musicInfo(musicName,songAddress,singerName,songAlbum,songLrc) values(\""+musicName+"\",\""+songAddress+"\",\""+singerName+"\",\""+songAlbum+"\",\""+songLrc+"\")"; 
		PreparedStatement pst=null;
		boolean b=true;
		
		try{  
			pst=con.prepareStatement("select musicName from musicInfo");
			res=pst.executeQuery();
			while(res.next()){
				if(musicName.equals(res.getString(1)))				
				{
					JOptionPane.showMessageDialog(null, "�����������ظ�����������ӣ���");
					b=false; 
					return b;
				}
				   
			}
	        int c = statement.executeUpdate(sql);  
	        con.close();  
	        statement.close();  

	    }catch(SQLException e){  
	        e.printStackTrace();  
	    }
		return b;   
}

	@SuppressWarnings("rawtypes")
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
