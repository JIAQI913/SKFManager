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
import com.group12.domain.entity.Parent;
import com.group12.domain.entity.User;
import com.group12.domain.service.ParentService;

@Controller
public class MCheckParentInfo {
	@Autowired
	ParentService parentService;
	
	@RequestMapping("/getMCheckParentInfo")
	public ModelAndView getParentInfo(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckParentInfo");
			List<Parent> list=parentService.getAllParent();
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("ParentList", data);
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/changeParentM")
	public String changeParentM(@RequestBody Parent parent, HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		parentService.updateParent(parent);
		return "ParentInfo";
	}
	
	@ResponseBody
	@RequestMapping("/deleteParentM")
	public String changePassword(HttpServletRequest req, HttpServletResponse resp){
		int parentid=Integer.parseInt(req.getParameter("parentid"));
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		System.out.println(parentid);
		parentService.deleteParent(parentid);
		return "MCheckParentInfoParentInfo";
	}
}
