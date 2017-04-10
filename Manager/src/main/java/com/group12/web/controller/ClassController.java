package com.group12.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Class;
import com.group12.domain.entity.Student;
import com.group12.domain.entity.User;
import com.group12.domain.service.ClassService;

@Controller
public class ClassController {
	@Autowired
	ClassService classService;
	
	@RequestMapping("/getClass")
	public ModelAndView getMCheckClass(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		List<Class> list=classService.getAllClass();
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckClass");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("ClassList", data);
		}
		else{
			modelAndView.setViewName("Class");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("ClassList", data);
		}
		return modelAndView;
	}
}
