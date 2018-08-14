package com.model;

/**
 * TZhangjie entity. @author MyEclipse Persistence Tools
 */

public class TZhangjie implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mingcheng;
	private String neirong;
	private Integer bookId;

	// Constructors

	/** default constructor */
	public TZhangjie() {
	}

	/** full constructor */
	public TZhangjie(String mingcheng, String neirong, Integer bookId) {
		this.mingcheng = mingcheng;
		this.neirong = neirong;
		this.bookId = bookId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public String getNeirong() {
		return this.neirong;
	}

	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}