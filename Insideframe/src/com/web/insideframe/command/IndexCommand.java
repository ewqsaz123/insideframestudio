package com.web.insideframe.command;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.insideframe.dto.MovieDTO;
import com.web.insideframe.service.IndexService;

public class IndexCommand implements Command {

	   @Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
	      // TODO Auto-generated method stub
	      IndexService is=new IndexService();
	      ArrayList<MovieDTO> mlist=is.getPoster();
	      Iterator it=mlist.iterator();
	      while(it.hasNext()){
	         it.next().toString();
	      }
	      request.setAttribute("movieList",is.getPoster());
	   }

	}