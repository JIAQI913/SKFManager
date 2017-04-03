package com.group12.domain.entity;
// Generated Apr 2, 2017 1:34:23 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Attain generated by hbm2java
 */
@Entity
@Table(name = "attain", catalog = "SKF")
public class Attain implements java.io.Serializable {

	private AttainId id;
	private Date rankTestTime;
	private Boolean rankIsPassed;

	public Attain() {
	}

	public Attain(AttainId id) {
		this.id = id;
	}

	public Attain(AttainId id, Date rankTestTime, Boolean rankIsPassed) {
		this.id = id;
		this.rankTestTime = rankTestTime;
		this.rankIsPassed = rankIsPassed;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "rankNum", column = @Column(name = "Rank_Num", nullable = false)),
			@AttributeOverride(name = "stuNum", column = @Column(name = "Stu_Num", nullable = false)),
			@AttributeOverride(name = "invNum", column = @Column(name = "Inv_Num", nullable = false)) })
	public AttainId getId() {
		return this.id;
	}

	public void setId(AttainId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Rank_Test_Time", length = 19)
	public Date getRankTestTime() {
		return this.rankTestTime;
	}

	public void setRankTestTime(Date rankTestTime) {
		this.rankTestTime = rankTestTime;
	}

	@Column(name = "Rank_Is_Passed")
	public Boolean getRankIsPassed() {
		return this.rankIsPassed;
	}

	public void setRankIsPassed(Boolean rankIsPassed) {
		this.rankIsPassed = rankIsPassed;
	}

}