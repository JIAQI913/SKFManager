package com.group12.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Attendance;
import com.group12.domain.entity.User;
import com.group12.domain.service.AttendanceService;

@Controller
public class MCheckAttendanceController {
	@Autowired
	AttendanceService attendanceService;
	
	@RequestMapping("/getMCheckAttendance")
	public ModelAndView getMCheckAttendance(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckAttendance");
			List<Attendance> list=attendanceService.getAllAttendance();
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("AttendanceList", data);
		}
		return modelAndView;
	}
}
