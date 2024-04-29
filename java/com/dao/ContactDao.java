package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.contact;

public class ContactDao {
	private Connection conn;

	public ContactDao(Connection conn) {
		super();
		this.conn = conn;

	}

	public boolean saveContact(contact c) {
		boolean f = false;
		try {
			String sql = "insert into contact(name,email,phno,about,userid) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhno());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

public List<contact> getAllContact(int uId)
{
  List<contact> list=new ArrayList<contact>();
    contact c=null;
 try {
	String sql="select*from contact where userid=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, uId);
	
	ResultSet rs=ps.executeQuery();
	
	while(rs.next()) 
	{
	c=new contact();
	c.setId(rs.getInt(1));
    c.setName(rs.getString(2));
    c.setEmail(rs.getString(3));
    c.setPhno(rs.getString(4));
    c.setAbout(rs.getString(5));
    list.add(c);
	}
	
	}catch (Exception e) 
      {
		e.printStackTrace();
          }
 return list;
}

public contact getcontactByID(int cid)
{
	contact c=new contact();
	try { 
		PreparedStatement ps=conn.prepareStatement("select* from contact where id=?");
		ps.setInt(1, cid);
		
	ResultSet rs=ps.executeQuery();
		
		while(rs.next()) 
		{
		  c.setId(rs.getInt(1));	
		  c.setName(rs.getString(2));
		  c.setEmail(rs.getString(3));
		  c.setPhno(rs.getString(4));
		  c.setAbout(rs.getString(5));
		  
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return c;
}

public boolean updatecontact(contact c)
{
	boolean f = false;
	try {
		String sql = "update contact set name=?,email=?,phno=?,about=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getName());
		ps.setString(2, c.getEmail());
		ps.setString(3, c.getPhno());
		ps.setString(4, c.getAbout());
		ps.setInt(5, c.getId());

		int i = ps.executeUpdate();
		if (i == 1) {
			f = true;
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	return f;	
}

public boolean deleteContactByID(int id)
{
	boolean f=false;
	
	try {
		
		String sql="delete from contact where id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 int i=ps.executeUpdate();
		
		 if(i>0) 
		 {
			 f=true;
		 }
		
	}catch(Exception e) 
	{
		e.printStackTrace();
	}
	
	return f;
}


}
