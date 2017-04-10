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
import com.group12.domain.entity.PaymentId;
import com.group12.domain.entity.User;
import com.group12.domain.service.InvoiceService;
import com.group12.domain.service.PaymentService;

@Controller
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping("/getPayment")
	public ModelAndView getPayment(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Index");
		if(user==null){
			return modelAndView;
		}
		if(user.getStuNum()==null){
			List<Payment> list=paymentService.getAllPayment();
			modelAndView.setViewName("MCheckPayment");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("PayList", data);
		}
		else{
			List<Payment> list=paymentService.searchByStuNum(user.getStuNum());
			modelAndView.setViewName("Payment");
			String data=DataFormat.toFrontformat(list);
			modelAndView.addObject("PayList", data);
		}
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/Paid")
	public String Paid(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()==null){
			return "MCheckPayment";
		}
		else{
			int invNum=Integer.parseInt(req.getParameter("invNum"));
			//System.out.println(invNum);
			PaymentId id=new PaymentId();
			id.setInvNum(invNum);
			id.setStuNum(user.getStuNum());
			paymentService.paid(id);
			return "Payment";
		}
	}
	@ResponseBody
	@RequestMapping("/getInvTypeS")
	public String getInvType(HttpServletRequest req, HttpServletResponse resp){
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("USER");
		int InvNum=Integer.parseInt(req.getParameter("invNum"));
		System.out.println(InvNum);
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			session.setAttribute("INVNUM", InvNum);
			Invoice invoice= invoiceService.searchById(InvNum);
			if(invoice.isInvIsMem()){
				return "Membership";
			}
			if(invoice.isInvIsPro()){
				return "Product";
			}
			if(invoice.isInvIsRank()){
				return "AttainInv";
			}
		}
		else{
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
		return "Index";
	}
}
