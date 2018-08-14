package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBookDAO;
import com.dao.TXinwenDAO;
import com.model.TBook;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
    private TXinwenDAO xinwenDAO;
    private TBookDAO bookDAO;
    
	public TBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(TBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public TXinwenDAO getXinwenDAO() {
		return xinwenDAO;
	}

	public void setXinwenDAO(TXinwenDAO xinwenDAO) {
		this.xinwenDAO = xinwenDAO;
	}

	public String index()
	{
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		
		
		String sql = "from TXinwen order by id desc";
		List xinwenList=xinwenDAO.getHibernateTemplate().find(sql);
		if(xinwenList.size()>3)
		{
			xinwenList=xinwenList.subList(0, 3);
		}
		request.put("xinwenList", xinwenList);
		
		
		String sql1="from TBook where del='no' order by id desc";
		List bookList=bookDAO.getHibernateTemplate().find(sql1);
		if(bookList.size()>8)
		{
			bookList=bookList.subList(0, 8);
		}
		request.put("bookList", bookList);
		
		
		return ActionSupport.SUCCESS;
	}

}
