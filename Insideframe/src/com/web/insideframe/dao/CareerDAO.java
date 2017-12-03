package com.web.insideframe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.CareerDTO;
import com.web.insideframe.dto.MemberDTO;

public class CareerDAO {
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
	}
	
	public ArrayList<CareerDTO> selectCareer(String email){
		ArrayList<CareerDTO> cList = new ArrayList<>();
		try {
			conn = connection.getConnetion();
			sql = "select * from career where email = '"+email+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CareerDTO cdto =new CareerDTO();
				cdto.setCareerNo(rs.getInt("careerno"));
				cdto.setEmail(rs.getString("email"));
				cdto.setType(rs.getString("type"));
				cdto.setTitle(rs.getString("title"));
				cdto.setRoll(rs.getString("roll"));
				cdto.setCdate(rs.getString("cdate"));
				
				cList.add(cdto);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cList;
	}
	
	
	//감독별 작품 전체 검색
	public ArrayList<CareerDTO> selectAllCareer(){
		ArrayList<CareerDTO> cList = new ArrayList<>();
		try {
			conn = connection.getConnetion();
			sql = "select * from career where email IN (select email from member where mtype='감독')";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CareerDTO cdto =new CareerDTO();
				cdto.setCareerNo(rs.getInt("careerno"));
				cdto.setEmail(rs.getString("email"));
				cdto.setType(rs.getString("type"));
				cdto.setTitle(rs.getString("title"));
				cdto.setRoll(rs.getString("roll"));
				cdto.setCdate(rs.getString("cdate"));
				
				cList.add(cdto);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cList;
	}
	//감독 이름별 검색
		public ArrayList<CareerDTO> selectConditionDirectorAsName(String name){
			ArrayList<CareerDTO> cList = new ArrayList<>();
			try {
				conn = connection.getConnetion();
				sql = "select * from career where email in (select email from member where name like '%"+name+"%' and mtype='감독')";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()){
					CareerDTO cdto = new CareerDTO();
					cdto.setCareerNo(rs.getInt("careerno"));
					cdto.setEmail(rs.getString("email"));
					cdto.setType(rs.getString("type"));
					cdto.setTitle(rs.getString("title"));
					cdto.setRoll(rs.getString("roll"));
					cdto.setCdate(rs.getString("cdate"));
					
					cList.add(cdto);
				}
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return cList;
		}
	//감독 작품별 검색
			public ArrayList<CareerDTO> selectConditionDirectorAsTitle(String title){
				ArrayList<CareerDTO> cList = new ArrayList<>();
				try {
					conn = connection.getConnetion();
					sql = "select * from career where title like '%"+title+ "%' and roll='감독'";
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					
					while(rs.next()){
						CareerDTO cdto = new CareerDTO();
						cdto.setCareerNo(rs.getInt("careerno"));
						cdto.setEmail(rs.getString("email"));
						cdto.setType(rs.getString("type"));
						cdto.setTitle(rs.getString("title"));
						cdto.setRoll(rs.getString("roll"));
						cdto.setCdate(rs.getString("cdate"));
						
						cList.add(cdto);
					}
					rs.close();
					ps.close();
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return cList;
			}
			
		
		
	public void delete(String email){
		
	}
	
	public void deleteAll(){
		
	
	}
	
	
}

