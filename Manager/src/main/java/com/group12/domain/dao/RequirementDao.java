package com.group12.domain.dao;

import java.io.Serializable;

import com.group12.domain.entity.Requirement;

public interface RequirementDao {
	Serializable save(Requirement requirement);
}
