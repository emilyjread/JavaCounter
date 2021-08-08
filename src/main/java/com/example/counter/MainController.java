package com.example.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		return "index.jsp";		
	}
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		
		if (session.getAttribute("count")==null) {
			session.setAttribute("count", 1);
		}
		
		else {
			Integer newcount= (Integer) session.getAttribute("count");
			session.setAttribute("count", newcount+1);
		}
		Integer currentcount = (Integer) session.getAttribute("count");
		model.addAttribute("count", currentcount);
		
		return "counter.jsp";
	}
	
	@RequestMapping("/counter/double")
	public String showCountTwo(HttpSession session, Model model) {
		if (session.getAttribute("count")==null) {
			session.setAttribute("count", 2);
		}
		
		else {
			Integer newcount= (Integer) session.getAttribute("count");
			session.setAttribute("count", newcount+2);
		}
		
		Integer currentcount = (Integer) session.getAttribute("count");
		model.addAttribute("count", currentcount);
		
		return "counttwo.jsp";
	}
	
	@RequestMapping("/reset")
	
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:";
		
	}

}
