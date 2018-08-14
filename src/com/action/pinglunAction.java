package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TPinglunDAO;
import com.model.TPinglun;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class pinglunAction extends ActionSupport
{
	private Integer id;
	private String neirong;
	private String shijian;
	private Integer bookId;
	
	private Integer userId;
	
	private TPinglunDAO pinglunDAO;
	
	
	public String pinglunAdd()
	{
		Map session=ActionContext.getContext().getSession();
		TUser user=(TUser)session.get("user");
		
		TPinglun pinglun=new TPinglun();
		
		//pinglun.setId(id);
		pinglun.setNeirong(neirong);
		pinglun.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		pinglun.setBookId(bookId);
		
		pinglun.setUserId(user.getUserId());
		
		pinglunDAO.save(pinglun);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "发布评论完毕");
		return "msg";
	}
	
	public String pinglunAll()
	{
		String sql="from TPinglun where bookId="+bookId;
		List pinglunList=pinglunDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}
	
	public String pinglunMana()
	{
		String sql="from TPinglun where bookId="+bookId;
		List pinglunList=pinglunDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pinglunList", pinglunList);
		return ActionSupport.SUCCESS;
	}
	
	public String pinglunDel()
	{
		
		TPinglun pinglun=pinglunDAO.findById(id);
		pinglunDAO.delete(pinglun);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}


	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNeirong()
	{
		return neirong;
	}

	public void setNeirong(String neirong)
	{
		this.neirong = neirong;
	}

	public TPinglunDAO getPinglunDAO()
	{
		return pinglunDAO;
	}

	public void setPinglunDAO(TPinglunDAO pinglunDAO)
	{
		this.pinglunDAO = pinglunDAO;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	
}
