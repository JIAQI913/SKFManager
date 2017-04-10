package com.group12.domain.action;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataFormat{

	static public String toFrontformat(List list) {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		String json=gson.toJson(list);
		System.out.println(json);
		String data="{\"total\":"+list.size()+",\"rows\":";
		data+=json;
		data+="}";
		return data;
	}

}
