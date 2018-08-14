package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TBookDAO;
import com.dao.TOrgDAO;
import com.dao.TPinglunDAO;
import com.dao.TUserDAO;
import com.dao.TZhangjieDAO;
import com.model.TBook;
import com.model.TUser;
import com.model.TZhangjie;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bookAction extends ActionSupport
{
	private Integer id;
	private Integer orgId;
	private String mingcheng;
	private String zuozhe;
	
	private String chubanshe;
	private String jieshao;
	private String tupian;
	private String fujian;
	
	private String fabushi;
	private int dianji;
	private String del;
    
    
    private TBookDAO bookDAO;
    private TOrgDAO orgDAO;
    private TZhangjieDAO zhangjieDAO;
    private TPinglunDAO pinglunDAO;
    private TUserDAO userDAO;
    
	public String bookAdd()
	{
		TBook book=new TBook();
		
		//book.setBookId(bookId);
		book.setOrgId(orgId);
		book.setMingcheng(mingcheng);
		book.setZuozhe(zuozhe);
		
		book.setChubanshe(chubanshe);
		book.setJieshao(jieshao);
		book.setTupian((tupian.equals("")?"/img/zanwu.jpg":tupian));
		book.setFujian(fujian);
		
		book.setFabushi(fabushi);
		book.setDianji(0);
		book.setDel("no");
		
		bookDAO.save(book);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "操作成功");
		return "msg";
	}
	
	
	public String bookMana()
	{
		String sql="from TBook where del='no' order by orgId";
		List bookList=bookDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<bookList.size();i++)
		{
			TBook book=(TBook)bookList.get(i);
			book.setOrg(orgDAO.findById(book.getOrgId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bookList", bookList);
		return ActionSupport.SUCCESS;
	}
	
	public String bookDel()
	{
		TBook book=bookDAO.findById(id);
		book.setDel("yes");
		bookDAO.attachDirty(book);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bookList", "操作成功");
		return "msg";
	}
	
	
	public String bookByOrg()
	{
		String sql="from TBook where del='no' and orgId="+orgId;
		List bookList=bookDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<bookList.size();i++)
		{
			TBook book=(TBook)bookList.get(i);
			book.setOrg(orgDAO.findById(book.getOrgId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bookList", bookList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String bookDetailQian()
	{
		
		
		TBook book=bookDAO.findById(id);
		Map request=(Map)ServletActionContext.getContext().get("request");
		Map session=ActionContext.getContext().getSession();
		request.put("book", book);
		
		String sql = "from TZhangjie where bookId="+book.getId();
		List zhangjieList=zhangjieDAO.getHibernateTemplate().find(sql);
		request.put("zhangjieList", zhangjieList);
		
		
		String sql2="from TPinglun where bookId="+book.getId();
		List pinglunList=pinglunDAO.getHibernateTemplate().find(sql2);
		request.put("pinglunList", pinglunList);
		
		String sql3="update TBook set dianji=dianji+1 where id="+id;
		bookDAO.getHibernateTemplate().bulkUpdate(sql3);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String bookRes()
	{
		StringBuffer  sql=new StringBuffer("from TBook where del='no'");
		
		sql.append(" and mingcheng like '%"+mingcheng.trim()+"%'");
		sql.append(" and zuozhe like '%"+zuozhe.trim()+"%'");
		sql.append(" and chubanshe like '%"+chubanshe+"%'");
		
		
		List bookList=bookDAO.getHibernateTemplate().find(sql.toString());
		for(int i=0;i<bookList.size();i++)
		{
			TBook book=(TBook)bookList.get(i);
			book.setOrg(orgDAO.findById(book.getOrgId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bookList", bookList);
		return ActionSupport.SUCCESS;
	}

	
	public String bookDianjilv()
	{
		String sql="from TBook where del='no' order by dianji desc";
		List bookList=bookDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<bookList.size();i++)
		{
			TBook book=(TBook)bookList.get(i);
		}
		
		if(bookList.size()>8)
		{
			bookList=bookList.subList(0, 8);
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("bookList", bookList);
		return ActionSupport.SUCCESS;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getOrgId() {
		return orgId;
	}


	public TUserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}


	public String getMingcheng() {
		return mingcheng;
	}


	public String getTupian() {
		return tupian;
	}


	public void setTupian(String tupian) {
		this.tupian = tupian;
	}


	public int getDianji() {
		return dianji;
	}


	public void setDianji(int dianji) {
		this.dianji = dianji;
	}


	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}


	public TPinglunDAO getPinglunDAO() {
		return pinglunDAO;
	}


	public void setPinglunDAO(TPinglunDAO pinglunDAO) {
		this.pinglunDAO = pinglunDAO;
	}


	public String getZuozhe() {
		return zuozhe;
	}


	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}


	public String getChubanshe() {
		return chubanshe;
	}


	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}


	public TZhangjieDAO getZhangjieDAO() {
		return zhangjieDAO;
	}


	public void setZhangjieDAO(TZhangjieDAO zhangjieDAO) {
		this.zhangjieDAO = zhangjieDAO;
	}


	public String getJieshao() {
		return jieshao;
	}


	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}


	public String getFujian() {
		return fujian;
	}


	public void setFujian(String fujian) {
		this.fujian = fujian;
	}


	public String getFabushi() {
		return fabushi;
	}

	public void setFabushi(String fabushi) {
		this.fabushi = fabushi;
	}


	public String getDel() {
		return del;
	}


	public void setDel(String del) {
		this.del = del;
	}


	public TBookDAO getBookDAO() {
		return bookDAO;
	}


	public void setBookDAO(TBookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}


	public TOrgDAO getOrgDAO() {
		return orgDAO;
	}


	public void setOrgDAO(TOrgDAO orgDAO) {
		this.orgDAO = orgDAO;
	}
	
}
