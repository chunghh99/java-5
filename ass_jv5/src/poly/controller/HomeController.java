package poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {
	@RequestMapping("index.htm")
	public String departs(ModelMap model,HttpSession session) {
		session.setAttribute("btlogin", "Login");
		session.setAttribute("btloginout", "Login");
		session.setAttribute("btrepass","Repass");
		session.setAttribute("loginout","login.htm");
		session.setAttribute("repass","repass.htm");
		return "index";
	}
}
