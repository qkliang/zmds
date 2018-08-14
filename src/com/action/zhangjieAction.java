package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TTupianDAO;
import com.dao.TZhangjieDAO;
import com.dao.TZhangjieDAO;
import com.model.TZhangjie;
import com.opensymphony.xwork2.ActionSupport;

public class zhangjieAction extends ActionSupport
{
	private Integer id;
	private String mingcheng;
	private String neirong;
	private Integer bookId;
	
	private TZhangjieDAO zhangjieDAO;
	
	
	public String zhangjieAdd()
	{
		TZhangjie zhangjie=new TZhangjie();
		
		//zhangjie.setId(id);
		zhangjie.setMingcheng(mingcheng);
		zhangjie.setNeirong(neirong);
		zhangjie.setBookId(bookId);
		
		zhangjieDAO.save(zhangjie);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		
		return "msg";
	}
	
	public String zhangjieMana()
	{
		String sql = "from TZhangjie where bookId="+bookId;
		List zhangjieList=zhangjieDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		return ActionSupport.SUCCESS;
	}	
	
	
	
	public String zhangjieDel()
	{
		TZhangjie zhangjie=zhangjieDAO.findById(id);
		zhangjieDAO.delete(zhangjie);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String zhangjieAll()
	{
		String sql = "from TZhangjie where bookId="+bookId;
		List zhangjieList=zhangjieDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjieList", zhangjieList);
		return ActionSupport.SUCCESS;
	}
	
	public String zhangjieDetailQian()
	{
		TZhangjie zhangjie=zhangjieDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zhangjie", zhangjie);
		return ActionSupport.SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getNeirong() {
		return neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public TZhangjieDAO getZhangjieDAO() {
		return zhangjieDAO;
	}

	public void setZhangjieDAO(TZhangjieDAO zhangjieDAO) {
		this.zhangjieDAO = zhangjieDAO;
	}
	
}
