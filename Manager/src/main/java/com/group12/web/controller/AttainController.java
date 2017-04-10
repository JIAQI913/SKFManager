package com.group12.web.controller;

import java.util.Date;
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
import com.group12.domain.entity.Invoice;
import com.group12.domain.entity.Payment;
import com.group12.domain.entity.PaymentId;
import com.group12.domain.entity.User;
import com.group12.domain.service.AttainService;
import com.group12.domain.service.InvoiceService;
import com.group12.domain.service.PaymentService;
import com.group12.domain.service.RankService;

@Controller
public class AttainController {
	@Autowired
	AttainService attainService;
	@Autowired
	RankService rankServer;
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	PaymentService paymentService;
	
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
	
	@ResponseBody
	@RequestMapping("/deleteAttainM")
	public String deleteAttainM(HttpServletRequest req, HttpServletResponse resp){
//		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		int InvNum=Integer.parseInt(req.getParameter("invNum"));
		attainService.delete(InvNum);
		return "MCheckAttain";
	}
	
	@ResponseBody
	@RequestMapping("/createAttain")
	public String createAttain(@RequestBody Attain attain,HttpServletRequest req, HttpServletResponse resp){
//		System.out.println(student.getStuEmail());
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("USER");
		if(user==null){
			return "Index";
		}
		if(user.getStuNum()!=null){
			return "Index";
		}
		int fee=Integer.parseInt(req.getParameter("fee"));
		String beltColour=req.getParameter("beltColour");
		int beltNum=rankServer.getNum(beltColour);
//		System.out.println(fee+beltColour);
//		System.out.println(rankServer.getNum(beltColour));
		Invoice invoice=new Invoice();
		invoice.setInvIsRank(true);
		int invNum=(Integer) invoiceService.insert(invoice);
//		System.out.println(invNum);
		PaymentId id=new PaymentId(attain.getStuNum(),invNum);
		Payment payment=new Payment(id, new Date(), fee);
		paymentService.insert(payment);
		attain.setInvNum(invNum);
		attain.setRankNum(beltNum);
		attainService.insert(attain);
		return "MCheckAttain";
	}
}
