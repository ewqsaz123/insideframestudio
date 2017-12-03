package com.web.insideframe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.MemberDTO;

public class MemberDAO {
	private DBConnection connection;
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	private String sql ="";
	
	public void setConnection(DBConnection connection){
		this.connection = connection;
	}
	
	public void insert(MemberDTO mdto){
		try {
			conn = connection.getConnetion();
			sql = "insert into member(email,pw,name,mtype,mimage,birth,phone,sex) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,mdto.getEmail());
			ps.setString(2,mdto.getPw());
			ps.setString(3,mdto.getName());
			ps.setString(4,mdto.getmType());
			ps.setString(5,mdto.getMimage());
			ps.setString(6,mdto.getBirth());
			ps.setString(7,mdto.getPhone());
			ps.setString(8, mdto.getSex());

			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			System.out.println("join 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public MemberDTO select(String email){
		MemberDTO mdto = null;
		try {
			conn = connection.getConnetion();
			sql = "select * from member where email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			rs = ps.executeQuery();
			
			if(rs.next()){
				mdto = new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setmType(rs.getString("mtype"));
				mdto.setMimage(rs.getString("mimage"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setHeight(rs.getInt("height"));
				mdto.setWeight(rs.getInt("weight"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setSex(rs.getString("sex"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mdto;
	}
	//배우 전체 검색
	public ArrayList<MemberDTO> selectAllActor(){
		ArrayList<MemberDTO> mList = new ArrayList<>();
		try {
			conn = connection.getConnetion();
			sql = "select * from member where mtype = '배우'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				MemberDTO mdto = new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setmType(rs.getString("mtype"));
				mdto.setMimage(rs.getString("mimage"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setHeight(rs.getInt("height"));
				mdto.setWeight(rs.getInt("weight"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setSex(rs.getString("sex"));
				
				mList.add(mdto);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mList;
	}
	
	//감독 전체 검색
	public ArrayList<MemberDTO> selectAllDirector(){
		ArrayList<MemberDTO> mList = new ArrayList<>();
		try {
			conn = connection.getConnetion();
			sql = "select * from member where mtype = '감독'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				MemberDTO mdto = new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setmType(rs.getString("mtype"));
				mdto.setMimage(rs.getString("mimage"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setHeight(rs.getInt("height"));
				mdto.setWeight(rs.getInt("weight"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setSex(rs.getString("sex"));
				
				mList.add(mdto);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mList;
	}
	
	//감독 이름별 검색
	public ArrayList<MemberDTO> selectConditionDirectorAsName(String name){
		ArrayList<MemberDTO> mList = new ArrayList<>();
		try {
			conn = connection.getConnetion();
			sql = "select * from member where name like '%"+name+"%' and mtype='감독'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				MemberDTO mdto = new MemberDTO();
				mdto.setEmail(rs.getString("email"));
				mdto.setPw(rs.getString("pw"));
				mdto.setName(rs.getString("name"));
				mdto.setmType(rs.getString("mtype"));
				mdto.setMimage(rs.getString("mimage"));
				mdto.setBirth(rs.getString("birth"));
				mdto.setHeight(rs.getInt("height"));
				mdto.setWeight(rs.getInt("weight"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setSex(rs.getString("sex"));
				
				mList.add(mdto);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mList;
	}
	
	//감독 작품별 검색
		public ArrayList<MemberDTO> selectConditionDirectorAsTitle(String title){
			ArrayList<MemberDTO> mList = new ArrayList<>();
			try {
				System.out.println("title="+title);
				conn = connection.getConnetion();
				sql = "select * from member where email in (select distinct email from career where title like '%" + title + "%' and roll='감독')";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					MemberDTO mdto = new MemberDTO();
					mdto.setEmail(rs.getString("email"));
					mdto.setPw(rs.getString("pw"));
					mdto.setName(rs.getString("name"));
					mdto.setmType(rs.getString("mtype"));
					mdto.setMimage(rs.getString("mimage"));
					mdto.setBirth(rs.getString("birth"));
					mdto.setHeight(rs.getInt("height"));
					mdto.setWeight(rs.getInt("weight"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setSex(rs.getString("sex"));
					
					mList.add(mdto);
				}
				
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return mList;
		}
	
	public void delete(String email){
		MemberDTO mdto = null;
		
		try {
			conn = connection.getConnetion();
			sql = "delete from member where email = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ps.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void deleteAll(){
		try {
			conn = connection.getConnetion();
			sql = "delete from member";
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	public void update(String email,String pw,String phone,String mimage){
		try {
			conn=connection.getConnetion();
			sql = "update member set pw=?,phone=?,mimage=? where email=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,pw);
			ps.setString(2,phone);
			ps.setString(3,mimage);
			ps.setString(4,email);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MemberDAO update fail");
		}
	}
}

