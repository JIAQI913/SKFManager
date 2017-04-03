package com.group12.domain.entity;
// Generated Apr 2, 2017 1:34:23 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Requirement generated by hbm2java
 */
@Entity
@Table(name = "requirement", catalog = "SKF")
public class Requirement implements java.io.Serializable {

	private int reqNum;
	private String reqDescript;
	private int rankNum;

	public Requirement() {
	}

	public Requirement(int reqNum, String reqDescript, int rankNum) {
		this.reqNum = reqNum;
		this.reqDescript = reqDescript;
		this.rankNum = rankNum;
	}

	@Id

	@Column(name = "Req_Num", unique = true, nullable = false)
	public int getReqNum() {
		return this.reqNum;
	}

	public void setReqNum(int reqNum) {
		this.reqNum = reqNum;
	}

	@Column(name = "Req_Descript", nullable = false, length = 45)
	public String getReqDescript() {
		return this.reqDescript;
	}

	public void setReqDescript(String reqDescript) {
		this.reqDescript = reqDescript;
	}

	@Column(name = "Rank_Num", nullable = false)
	public int getRankNum() {
		return this.rankNum;
	}

	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}

}