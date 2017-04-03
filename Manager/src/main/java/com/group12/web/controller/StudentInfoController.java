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
import com.group12.domain.entity.Student;
import com.group12.domain.entity.User;
import com.group12.domain.service.ParentService;
import com.group12.domain.service.StudentService;

@Controller
public class StudentInfoController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/getStudentInfo")
	public ModelAndView getStudentInfo(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("USER");
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckStudentInfo");
			List<Student> list=studentService.getAllStudent();
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("StudnetList", data);
			return modelAndView;
		}
		Student student=studentService.getStudent(user.getStuNum());
		modelAndView.setViewName("StudentInfo");
		if(student!=null){
			modelAndView.addObject("STUDENT", student);
			//System.out.println(student.getStuFname());
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/changeStudent")
	public String changeStudent(@RequestBody Student student, HttpServletRequest req, HttpServletResponse resp){
		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		student.setStuNum(user.getStuNum());
		studentService.updateStudent(student);
		return "StudentInfo";
	}
}
