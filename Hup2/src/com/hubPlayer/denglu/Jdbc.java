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
	        System.out.println("对不起，找不到这个Driver");  
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
	    //设置没列信息
		columnNames.add("歌曲名");
		columnNames.add("歌曲地址");
		columnNames.add("歌手");
		columnNames.add("所在列表");
		columnNames.add("歌词地址");
		
		rowData=new Vector();		
		//从数据库中取出各行数据
		try {
			//初始化对象
			//1、加载数据
			Class.forName(driver);
			//2、得到连接
			con=DriverManager.getConnection(url,name,passwd);
			//3、创建火箭车
			statement=con.prepareStatement(sql);
			//4、执行（如果是增删改，使用executeUpdate（），如果是查询，使用executeQuery（））
			res=statement.executeQuery(sql);
			
			//循环取出每行结数据
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
			//关闭资源
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
	                JOptionPane.showMessageDialog(null, "密码错误！");  
	            }  
	        }else {  
	            JOptionPane.showMessageDialog(null, "用户名不存在！");  
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
	            //JOptionPane.showMessageDialog(null,"注册成功！");  
	        	new Denglu();
	        }  
	    }catch(SQLException e){  
	        JOptionPane.showMessageDialog(null, "对不起该用户名已经有了！");  
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
					JOptionPane.showMessageDialog(null, "歌曲名不能重复，请重新添加！！");
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
