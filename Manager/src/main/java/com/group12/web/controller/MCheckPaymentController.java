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
import com.group12.domain.entity.Payment;
import com.group12.domain.entity.User;
import com.group12.domain.service.PaymentService;

@Controller
public class MCheckPaymentController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/getMCheckPayment")
	public ModelAndView getMCheckPaymentController(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			modelAndView.setViewName("MCheckPayment");
			List<Payment> list=paymentService.getAllPayment();
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("PayList", data);
			return modelAndView;
		}
		return modelAndView;
	}
}
