package com.web.insideframe.service;

import java.util.ArrayList;

import com.web.insideframe.common.DaoFactory;
import com.web.insideframe.dao.BoardDAO;
import com.web.insideframe.dao.ReplyDAO;
import com.web.insideframe.dto.BoardDTO;
import com.web.insideframe.dto.ReplyDTO;
import com.web.insideframe.paging.Paging;

public class PagingService {
	DaoFactory df=new DaoFactory();
	BoardDAO bdao=df.boardDao();
	Paging pg=new Paging();
	
	public Paging paging(){
		
		pg.setTotalCount(bdao.totalCount());
		pg.makePaging();
		
		return pg;
	}
	public ArrayList<BoardDTO> getBoardList(int curPage){
		ArrayList<BoardDTO> blist=new ArrayList<BoardDTO>();
		int startRow = (curPage - 1) * pg.getPageSize() + 1;
		int endRow = startRow + (pg.getPageSize()-1);
		blist=bdao.boardList(startRow, endRow);
		return blist;
	}
	
	
}
