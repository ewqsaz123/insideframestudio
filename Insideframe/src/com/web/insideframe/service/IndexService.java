package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.MovieDAO;
import com.web.insideframe.dto.MovieDTO;

public class IndexService {
	   DaoFactory df=new DaoFactory();
	   MovieDAO mdao=df.movieDao();
	   
	   public ArrayList<MovieDTO> getPoster(){
	      ArrayList<MovieDTO> mList=mdao.getPoster();
	      return mList;
	   }
	}