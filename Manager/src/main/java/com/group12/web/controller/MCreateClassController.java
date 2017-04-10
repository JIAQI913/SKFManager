package com.group12.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Class;
import com.group12.domain.entity.Parent;
import com.group12.domain.entity.User;
import com.group12.domain.service.ClassService;

@Controller
public class MCreateClassController {
	@Autowired
	ClassService classService;
	
	@RequestMapping("/getMCreateClass")
	public ModelAndView getMCreateClass(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCreateClass");
			//modelAndView.addObject("ClassList", data);
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/createClassM")
	public String changeParentM(@RequestBody Class c, HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		classService.insertData(c);
		return "MCheckClass";
	}
}
