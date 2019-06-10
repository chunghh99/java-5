package poly.controller;


import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import poly.entity.*;

@Transactional
@Controller
@RequestMapping()
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	
	@RequestMapping(value="login.htm", method= RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("user", new Users() );
		
		return "login";
	}
	
	@RequestMapping(value="login.htm", method= RequestMethod.POST)
	public String login( @ModelAttribute(value="user") Users user, ModelMap model, HttpSession session) {
		String username=user.getUsername();
		String password=user.getPassword();
		Session ss = factory.openSession();
		
		try {
			Users u = (Users) ss.get(Users.class, username);
			if(!u.getPassword().equals(password)){
				model.addAttribute("message", "Loginfailed");
				return "login";
			}
			else{
				session.removeAttribute("btlogin");
				session.removeAttribute("btloginout");
				session.removeAttribute("login-out");
				session.setAttribute("username", user.getUsername());
				session.setAttribute("btloginout", "Logout");
				session.setAttribute("loginout","logout.htm");
				return "index";
			}
		} 
		catch (Exception e) {
			return "login";
		}
		
	
	}
	
	@RequestMapping(value="logout.htm",method=RequestMethod.GET)
	public String loguot(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("logout");
		return "redirect:index.htm";
	}
	
}
