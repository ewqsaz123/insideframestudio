package com.web.insideframe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.web.insideframe.common.DBConnection;
import com.web.insideframe.dto.MovieDTO;

public class MovieDAO {
	DBConnection connection;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(DBConnection connection){
		this.connection=connection;
	}
	
	public ArrayList<MovieDTO> selectAll(){
		MovieDTO mdto=null;
		ArrayList<MovieDTO> mList=new ArrayList<MovieDTO>();
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from movie");
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				mdto=new MovieDTO();
				mdto.setMovieNo(rs.getInt("movieno"));
				mdto.setmTitle(rs.getString("mtitle"));
				mdto.setMovieImage(rs.getString("movieimage"));
				mdto.setDirector(rs.getString("director"));
				mdto.setYoutubeLink(rs.getString("youtubelink"));
				mdto.setCategory(rs.getString("category"));
				mdto.setMdate(rs.getString("mdate"));
				mdto.setLike(rs.getInt("likeno"));
				mdto.setCount(rs.getInt("mcount"));
				
				mList.add(mdto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectAll fail");
		}
		return mList;
	}
	public ArrayList<MovieDTO> selectTitle(String mtitle){
		MovieDTO mdto=null;
		ArrayList<MovieDTO> mList=new ArrayList<MovieDTO>();
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from movie where mtitle like ?");
			
			pstmt.setString(1,mtitle);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				mdto=new MovieDTO();
				mdto.setMovieNo(rs.getInt("movieno"));
				mdto.setmTitle(rs.getString("mtitle"));
				mdto.setMovieImage(rs.getString("movieimage"));
				mdto.setDirector(rs.getString("director"));
				mdto.setYoutubeLink(rs.getString("youtubelink"));
				mdto.setCategory(rs.getString("category"));
				mdto.setMdate(rs.getString("mdate"));
				mdto.setLike(rs.getInt("likeno"));
				mdto.setCount(rs.getInt("mcount"));
				
				mList.add(mdto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectTitle fail");
		}
		return mList;
	}
	public ArrayList<MovieDTO> selectCategory(String category){
		MovieDTO mdto=null;
		ArrayList<MovieDTO> mList=new ArrayList<MovieDTO>();
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from movie where category=?");
			
			pstmt.setString(1,category);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				mdto=new MovieDTO();
				mdto.setMovieNo(rs.getInt("movieno"));
				mdto.setmTitle(rs.getString("mtitle"));
				mdto.setMovieImage(rs.getString("movieimage"));
				mdto.setDirector(rs.getString("director"));
				mdto.setYoutubeLink(rs.getString("youtubelink"));
				mdto.setCategory(rs.getString("category"));
				mdto.setMdate(rs.getString("mdate"));
				mdto.setLike(rs.getInt("likeno"));
				mdto.setCount(rs.getInt("mcount"));
				
				mList.add(mdto);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectCategory fail");
		}
		return mList;
	}
	public MovieDTO selectMoiveNo(int movieNo){
		MovieDTO mdto=null;
		try {
			Connection conn=connection.getConnetion();
			
			pstmt=conn.prepareStatement("select * from movie where movieno=?");
			
			pstmt.setInt(1,movieNo);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				mdto=new MovieDTO();
				mdto.setMovieNo(rs.getInt("movieno"));
				mdto.setmTitle(rs.getString("mtitle"));
				mdto.setMovieImage(rs.getString("movieimage"));
				mdto.setDirector(rs.getString("director"));
				mdto.setYoutubeLink(rs.getString("youtubelink"));
				mdto.setCategory(rs.getString("category"));
				mdto.setMdate(rs.getString("mdate"));
				mdto.setLike(rs.getInt("likeno"));
				mdto.setCount(rs.getInt("mcount"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("MovieDAO selectMovieNo fail");
		}
		return mdto;
	}
	public void insertCount(int movieNo){
	      try{
	         Connection conn=connection.getConnetion();
	         pstmt=conn.prepareStatement("update movie set mcount=mcount+1 where movieno=?");
	         
	         pstmt.setInt(1,movieNo);
	         pstmt.executeUpdate();
	         
	         pstmt.close();
	         conn.close();
	      }catch (SQLException e) {
	         // TODO: handle exception
	         e.printStackTrace();
	         System.out.println("MovieDAO insertCount fail !");
	      }
	   }
	   public ArrayList<MovieDTO> getPoster(){
	      
	      ArrayList<MovieDTO> mList=new ArrayList<MovieDTO>();
	      try{
	         Connection conn=connection.getConnetion();
	         pstmt=conn.prepareStatement("select movieno,mtitle,movieimage from movie order by mcount desc");
	         
	         rs=pstmt.executeQuery();
	         
	         for(int i=0;i<3;i++){
	            MovieDTO mdto=new MovieDTO();
	            rs.next();
	            mdto.setMovieNo(rs.getInt("movieno"));
	            mdto.setmTitle(rs.getString("mtitle"));
	            mdto.setMovieImage(rs.getString("movieimage"));
	            mList.add(mdto);
	         }
	      }catch (SQLException e) {
	         // TODO: handle exception
	         e.printStackTrace();
	         System.out.println("MovieDAO getPoster fail !");
	      }
	      return mList;
	   }
}
