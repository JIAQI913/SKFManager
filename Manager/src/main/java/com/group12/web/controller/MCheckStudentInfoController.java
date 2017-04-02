package com.group12.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Student;
import com.group12.domain.entity.User;
import com.group12.domain.service.StudentService;

@Controller
public class MCheckStudentInfoController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/getMCheckStudentInfo")
	public ModelAndView getMCheckStudentInfo(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("MCheckStudentInfo");
		if(user.getStuNum()==null){
			List<Student> list=studentService.getAllStudent();
//			int size=list.size();
//			System.out.println("List size="+size);
//			for(int i=0; i<size; i++){
//				System.out.println(list.get(i).getStuFname());
//			}
			 String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("StudnetList", data);
			return modelAndView;
		}
		return modelAndView;
	}
}
