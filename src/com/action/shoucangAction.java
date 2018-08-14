package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TBookDAO;
import com.dao.TShoucangDAO;
import com.model.TShoucang;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class shoucangAction extends ActionSupport
{
	private Integer id;
	private Integer bookId;
	private String shijian;
	private Integer userId;
	
	
	private TShoucangDAO shoucangDAO;
	private TBookDAO bookDAO;
	
	private String message;
	private String path;
	
	public String shoucangAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TShoucang where bookId=? and userId=?";
		Object[] c={bookId,user.getUserId()};
		List list=shoucangDAO.getHibernateTemplate().find(sql,c);
		if(list.size()>0)
		{
			this.setMessage("您已经加入书架。请不要重复加入");
			this.setPath("index.action");
			return "succeed";
		}
		
		TShoucang shoucang=new TShoucang();
		
		//shoucang.setId(id);
		shoucang.setBookId(bookId);
		shoucang.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		shoucang.setUserId(user.getUserId());
		
		shoucangDAO.save(shoucang);
		
		this.setMessage("已加入书架，请点击我的书架查看");
		this.setPath("index.action");
		return "succeed";
		
	}
	
	public String shoucangMine()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		String sql="from TShoucang where userId="+user.getUserId();
		List shoucangList=shoucangDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<shoucangList.size();i++)
		{
			TShoucang shoucang=(TShoucang)shoucangList.get(i);
			shoucang.setBook(bookDAO.findById(shoucang.getBookId()));
		}
		
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("shoucangList", shoucangList);
		return ActionSupport.SUCCESS;
	}
	
	public String shoucangDel()
	{
		TShoucang shoucang=shoucangDAO.findById(id);
		shoucangDAO.delete(shoucang);
		
		this.setMessage("删除完毕");
		this.setPath("shoucangMine.action");
		return "succeed";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getShijian() {
		return shijian;
	}

	public void setShijian(String shijian) {
		this.shijian = shijian;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public TShoucangDAO getShoucangDAO() {
		return shoucangDAO;
	}

	public void setShoucangDAO(TShoucangDAO shoucangDAO) {
		this.shoucangDAO = shoucangDAO;
	}

	public TBookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(TBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
