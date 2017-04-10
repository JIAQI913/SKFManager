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
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckStudentInfo");
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
	
	@ResponseBody
	@RequestMapping("/changeStudentM")
	public String changeStudentM(@RequestBody Student student, HttpServletRequest req, HttpServletResponse resp){
//		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		studentService.updateStudent(student);
		return "MCheckStudentInfo";
	}
}
