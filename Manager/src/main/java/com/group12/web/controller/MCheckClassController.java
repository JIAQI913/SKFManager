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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			List<Class> list=classService.getAllClass();
			modelAndView.setViewName("MCheckClass");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("ClassList", data);
		}
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/changeClassM")
	public String changeStudentM(@RequestBody Class c, HttpServletRequest req, HttpServletResponse resp){
//		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		classService.update(c);
		return "MCheckClass";
	}
	@ResponseBody
	@RequestMapping("/deleteClassM")
	public String changePassword(HttpServletRequest req, HttpServletResponse resp){
		int classId=Integer.parseInt(req.getParameter("classId"));
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		System.out.println(classId);
		classService.delete(classId);
		return "MCheckClass";
	}
}
