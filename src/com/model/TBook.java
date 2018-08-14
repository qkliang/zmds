package com.model;

/**
 * TBook entity. @author MyEclipse Persistence Tools
 */

public class TBook implements java.io.Serializable {

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
	
	private TOrg org;

	// Constructors

	/** default constructor */
	public TBook() {
	}

	/** full constructor */
	public TBook(Integer orgId, String mingcheng, String zuozhe,
			String chubanshe, String jieshao, String fujian, String fabushi,
			String del) {
		this.orgId = orgId;
		this.mingcheng = mingcheng;
		this.zuozhe = zuozhe;
		this.chubanshe = chubanshe;
		this.jieshao = jieshao;
		this.fujian = fujian;
		this.fabushi = fabushi;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getZuozhe() {
		return this.zuozhe;
	}

	public int getDianji() {
		return dianji;
	}

	public String getTupian() {
		return tupian;
	}

	public void setTupian(String tupian) {
		this.tupian = tupian;
	}

	public void setDianji(int dianji) {
		this.dianji = dianji;
	}

	public TOrg getOrg() {
		return org;
	}

	public void setOrg(TOrg org) {
		this.org = org;
	}

	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}

	public String getChubanshe() {
		return this.chubanshe;
	}

	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}

	public String getJieshao() {
		return this.jieshao;
	}

	public void setJieshao(String jieshao) {
		this.jieshao = jieshao;
	}

	public String getFujian() {
		return this.fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public String getFabushi() {
		return this.fabushi;
	}

	public void setFabushi(String fabushi) {
		this.fabushi = fabushi;
	}

	public String getDel() {
		return this.del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}