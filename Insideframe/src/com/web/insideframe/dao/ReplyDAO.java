package com.web.insideframe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.ReplyDTO;

public class ReplyDAO {
	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public void insert(ReplyDTO rdto){
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("insert into board_comment(comment_board, commentid, commentdate, commentcontent) values(?,?,now(),?)");
			
			pstmt.setInt(1,rdto.getComment_board());
			pstmt.setString(2,rdto.getCommentId());
			pstmt.setString(3,rdto.getCommentContent());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ReplyDAO insert fail");
		}
	}
	public ArrayList<ReplyDTO> selectAll(int comment_board,int startRow,int endRow){
		ReplyDTO rdto=null;
		ArrayList<ReplyDTO> rList=new ArrayList<ReplyDTO>();
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("SELECT @RNUM := @RNUM + 1 AS NO, a.* FROM( SELECT * FROM board_comment WHERE comment_board=? ORDER BY commentno DESC  ) a,  ( SELECT @RNUM := 0 ) b");
			
			pstmt.setInt(1,comment_board);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				if(rs.getInt("NO")>=startRow && rs.getInt("NO")<=endRow){
					rdto=new ReplyDTO(rs.getInt("commentno"),rs.getInt("comment_board")
							,rs.getString("commentid"),rs.getString("commentdate")
							,rs.getString("commentcontent"));
					rList.add(rdto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ReplyDAO selectAll fail !");
		}
		return rList;
	}
	
	public int commentTotalCount(int idx){
		int totalCount=0;
		
		try {
			Connection conn=connection.getConnetion();
			pstmt=conn.prepareStatement("select count(*) from board_comment where comment_board=?");
			
			pstmt.setInt(1,idx);
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
}
