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
import com.group12.domain.entity.Invoice;
import com.group12.domain.entity.Payment;
import com.group12.domain.entity.User;
import com.group12.domain.service.InvoiceService;
import com.group12.domain.service.PaymentService;

@Controller
public class MCheckPaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	InvoiceService invoiceService;
	
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
		}
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/searchInvByInv")
	public String searchInvByInvController(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		int invNum=Integer.parseInt(req.getParameter("invNum"));
//		System.out.println(invNum);
		if(user==null){
			return "Failed";
		}
		if(user.getStuNum()==null){
			List<Payment> list=paymentService.searchByInvNum(invNum);
			String data=DataFormat.toFrontformat(list);
			return data;
		}
		return "Failed";
	}
	
	@ResponseBody
	@RequestMapping("/searchInvByStu")
	public String searchInvByStuController(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		int stuNum=Integer.parseInt(req.getParameter("stuNum"));
//		System.out.println(invNum);
		if(user==null){
			return "Failed";
		}
		if(user.getStuNum()==null){
			List<Payment> list=paymentService.searchByStuNum(stuNum);
			String data=DataFormat.toFrontformat(list);
			return data;
		}
		return "Failed";
	}
	
	@ResponseBody
	@RequestMapping("/getInvType")
	public String getInvType(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		int InvNum=Integer.parseInt(req.getParameter("invNum"));
		System.out.println(InvNum);
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()==null){
			session.setAttribute("INVNUM", InvNum);
			Invoice invoice= invoiceService.searchById(InvNum);
			if(invoice.isInvIsMem()){
				return "MUpdateMembership";
			}
			if(invoice.isInvIsPro()){
				return "MUpdateProduct";
			}
			if(invoice.isInvIsRank()){
				return "MUpdateAttain";
			}
		}
		else{
			session.setAttribute("INVNUM", InvNum);
			Invoice invoice= invoiceService.searchById(InvNum);
			if(invoice.isInvIsMem()){
				return "Membership";
			}
			if(invoice.isInvIsPro()){
				return "Product";
			}
			if(invoice.isInvIsRank()){
				return "Attain";
			}
		}
		return "Index";
	}
}
