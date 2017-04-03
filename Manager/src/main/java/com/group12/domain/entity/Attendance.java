package com.group12.domain.entity;
// Generated Apr 2, 2017 1:34:23 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Attendance generated by hbm2java
 */
@Entity
@Table(name = "attendance", catalog = "SKF")
public class Attendance implements java.io.Serializable {

	private AttendanceId id;

	public Attendance() {
	}

	public Attendance(AttendanceId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "classId", column = @Column(name = "Class_ID", nullable = false)),
			@AttributeOverride(name = "stuNum", column = @Column(name = "Stu_Num", nullable = false)),
			@AttributeOverride(name = "attendDate", column = @Column(name = "Attend_Date", nullable = false, length = 10)) })
	public AttendanceId getId() {
		return this.id;
	}

	public void setId(AttendanceId id) {
		this.id = id;
	}

}