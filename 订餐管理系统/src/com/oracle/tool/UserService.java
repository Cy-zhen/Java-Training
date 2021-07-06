package com.oracle.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.oracle.entity.User;

public class UserService {
	
	public boolean insertUser(User u) {
		try {
	        BufferedReader in = new BufferedReader(new FileReader("src/file/user.txt"));
	        String str;
	        boolean you=false;
	        while ((str = in.readLine()) != null) {
	           String[] sz = str.split(" ");
	           //比较参数对象的用户名和文件中的用户名是否一致
        	   if (sz.length>1&&sz[1].equals(u.getName())) {
   					you= true;
   	           }
	        }
	        in.close();
	        //存用户信息
	        if (you==false) {
	           BufferedWriter out = new BufferedWriter(new FileWriter("src/file/user.txt",true));
		       out.newLine();
	           out.write(u.getId()+" "+u.getName()+" "+u.getPassWord()+" "+u.getEmail());
		       out.close();
		       return true;//添加成功
			} else {
				//当you为true时证明文件冲you重复的用户名
				return false;//添加失败
			}
	    } catch (IOException ioe) {
	    }
		return true;
	}
	/**
	 * 根据用户名和密码验证登录
	 * @param name
	 * @param pass
	 * @return
	 */
	public User loginAuthentication(String name,String pass) {
		User u=null;
		try {
	        BufferedReader in = new BufferedReader(new FileReader("src/file/user.txt"));
	        String str;
	        while ((str = in.readLine()) != null) {
	           String[] sz = str.split(" ");
	           //比较参数对象的用户名和文件中的用户名是否一致
        	   if (sz.length>1&&sz[1].equals(name)&&sz[2].equals(pass)) {
   					u=new User(sz[0], sz[1], sz[2], sz[3]);
   	           }
	        }
	        in.close();
	    } catch (IOException ioe) {
	    }
		return u;
	}
	
	public void updatePasswordByName(String name,String pass) {
		try {
	        BufferedReader in = new BufferedReader(new FileReader("src/file/user.txt"));
	        String str;
	        ArrayList<User> list = new  ArrayList<User>();
	        //将文件中的每条数据都放入到user对象中,再用list容器盛装
	        while ((str = in.readLine()) != null) {
	            String[] sz = str.split(" ");
	            if (sz.length>1) {
	            	 User u = new User(sz[0], sz[1], sz[2], sz[3]);
	 	            list.add(u);
				}
	           
	        }
	        in.close();
	        //遍历容器,找到匹配的用户对象,将其密码修改为参数值
	        for (User user : list) {
				if (user.getName().equals(name)) {
					user.setPassWord(pass);
				}
			}
	        
	        BufferedWriter out = new BufferedWriter(new FileWriter("src/file/user.txt"));
	        for (User u : list) {
		        out.write(u.getId()+" "+u.getName()+" "+u.getPassWord()+" "+u.getEmail());
		        out.newLine();
	        }
	        
	        out.close();
		   
	    } catch (IOException e) {
	    }
	}
	
	
	public static void main(String[] args) {
		String id=UUID.randomUUID().toString();
		System.out.println(id);
		User u = new User(id, "李四", "admin", "123@!qq.com");
		UserService us = new UserService();
		boolean success = us.insertUser(u);
		System.out.println(success);
	}

}
