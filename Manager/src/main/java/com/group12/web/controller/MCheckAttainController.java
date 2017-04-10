package com.group12.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.group12.domain.action.DataFormat;
import com.group12.domain.entity.Attain;
import com.group12.domain.entity.User;
import com.group12.domain.service.AttainService;

@Controller
public class MCheckAttainController {
	@Autowired
	AttainService attainService;
	
	@RequestMapping("getMCheckAttain")
	public ModelAndView getMCheckAttain(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			List<Attain> list=attainService.getAllAttain();
			modelAndView.setViewName("MCheckAttain");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("AttainList", data);
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("searchAttainByStu")
	public String searchInvByStuController(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		int stuNum=Integer.parseInt(req.getParameter("stuNum"));
		System.out.println(stuNum);
		if(user==null){
			return "Failed";
		}
		if(user.getStuNum()==null){
			List<Attain> list=attainService.searchByStuNum(stuNum);
			String data=DataFormat.toFrontformat(list);
			return data;
		}
		return "Failed";
	}
}
