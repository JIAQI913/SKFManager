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
import com.group12.domain.entity.Attain;
import com.group12.domain.entity.Class;
import com.group12.domain.entity.User;
import com.group12.domain.service.AttainService;

@Controller
public class AttainController {
	@Autowired
	AttainService attainService;
	
	@RequestMapping("/getAttain")
	public ModelAndView getAttain(HttpServletRequest req, HttpServletResponse resp){
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
		else{
			List<Attain> list=attainService.searchByStuNum(user.getStuNum());
			modelAndView.setViewName("Attain");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("AttainList", data);
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/changeAttainM")
	public String changeStudentM(@RequestBody Attain attain, HttpServletRequest req, HttpServletResponse resp){
//		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		attainService.update(attain);
		return "MCheckAttain";
	}
	
	@RequestMapping("/getAttainInv")
	public ModelAndView getMUpdateMembership(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		ModelAndView modelAndView = new ModelAndView();
		User user=(User) session.getAttribute("USER");
		int invNum=(Integer) session.getAttribute("INVNUM");
//		System.out.println(invNum);
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null&&invNum>0){
			modelAndView.setViewName("MUpdateAttain");
			Attain attain=attainService.searchByInv(invNum);
			modelAndView.addObject("ATTAIN", attain);
			return modelAndView;
		}
		else{
			modelAndView.setViewName("AttainInv");
			Attain attain=attainService.searchByInv(invNum);
			modelAndView.addObject("ATTAIN", attain);
			return modelAndView;
		}
	}
}
