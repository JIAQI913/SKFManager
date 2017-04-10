package com.group12.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group12.domain.entity.Student;
import com.group12.domain.entity.User;
import com.group12.domain.service.StudentService;
import com.group12.domain.service.UserService;

@Controller
public class IndexController {
//	@Autowired
//	StudentService studentService;
//	
//	@RequestMapping("/testInDb")
//	public String testInDb(Model model){
//		Student student=new Student();
//		student.setStuFname("Qihui");
//		student.setStuLname("Fan");
//		student.setStuEmail("fqh333@gmail.com");
//		student.setStuAddress("2995");
//		student.setStuDob(new Date());
//		student.setStuMobileNum("2269757323");
//		Serializable result=studentService.insertData(student);
//		model.addAttribute("result", result);
//		return "/test";
//	}
//	
	@Autowired
	UserService userService;
	
	@ResponseBody
	@RequestMapping("/getIndex")
	public String login(@RequestBody User user, HttpServletRequest req, HttpServletResponse resp){
//		System.out.println("get");
//		String userName=user.getUserName();
//		String userPassword=user.getUserPassword();
//		System.out.println(user.getUserName()+"\n"+ user.getUserPassword());
		User userS=userService.getUser(user);
		int res=userService.judgeUser(user, userS);
//		System.out.println(res);
		if(res==0){
			HttpSession session = req.getSession();
			session = req.getSession();
			session.setAttribute("USER", userS);
			return "MCheckStudentInfo";
		}
		else{
			if(res>0){
				HttpSession session = req.getSession();
				session.setAttribute("USER", userS);
				return "StudentInfo";
			}
		}
		return "Failed";
	}
}
