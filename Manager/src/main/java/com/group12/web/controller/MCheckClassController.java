package com.group12.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.entity.User;
import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Class;
import com.group12.domain.service.ClassService;


@Controller
public class MCheckClassController {
	
	@Autowired
	ClassService classService;
	
	@RequestMapping("/getMCheckClass")
	public ModelAndView getMCheckClass(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		List<Class> list=classService.getAllClass();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MCheckClass");
		if(user.getStuNum()==null){
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("ClassList", data);
		}
		return modelAndView;
	}
}
