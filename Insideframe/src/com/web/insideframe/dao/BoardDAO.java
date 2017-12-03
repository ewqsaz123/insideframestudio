package com.web.insideframe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.BoardDTO;
import com.web.insideframe.dto.*;

public class BoardDAO {

	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public int totalCount(){
		int totalCount=0;
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select count(*) from board");
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("BoardDAO totalCount fail !");
		}
		return totalCount;
	}
	public ArrayList<BoardDTO> boardList(int startRow,int endRow){
		BoardDTO bdto=null;
		ArrayList<BoardDTO> blist=new ArrayList<BoardDTO>();
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("SELECT @RNUM := @RNUM + 1 AS NO, a.* FROM( SELECT * FROM board  ORDER BY idx DESC  ) a,  ( SELECT @RNUM := 0 ) b");
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("NO")>=startRow && rs.getInt("NO")<= endRow){
					bdto=new BoardDTO(rs.getInt("idx"),rs.getString("writer"),
							rs.getString("btitle"),rs.getString("bdate"),
							rs.getString("btype"),rs.getString("content"),rs.getInt("bcount"));
					blist.add(bdto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}
	public BoardDTO select(int idx){
		BoardDTO bdto=null;
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select * from board where idx=?");
			
			pstmt.setInt(1,idx);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
					bdto=new BoardDTO(rs.getInt("idx"),rs.getString("writer"),
							rs.getString("btitle"),rs.getString("bdate"),
							rs.getString("btype"),rs.getString("content"),rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bdto;
	}
	public void insertCount(int idx){
	      try{
	         Connection conn=connection.getConnetion();
	         pstmt=conn.prepareStatement("update board set bcount=bcount+1 where idx=?");
	         
	         pstmt.setInt(1,idx);
	         pstmt.executeUpdate();
	         
	         pstmt.close();
	         conn.close();
	      }catch (SQLException e) {
	         // TODO: handle exception
	         e.printStackTrace();
	         System.out.println("BoardDAO insertCount fail !");
	      }
	   }
}
