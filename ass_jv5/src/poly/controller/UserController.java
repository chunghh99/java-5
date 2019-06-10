package poly.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Users;
import poly.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "user")
	public String user(ModelMap model) {
		model.put("users", new Users());
		model.put("user", userService.getall());
		return "user";

	}

	@RequestMapping(value = "users.htm", params = "bntInsert", method = RequestMethod.POST)
	public String insertUser(ModelMap model, @ModelAttribute(value = "users") Users u, BindingResult result) {
		userService.insert(u);
		model.put("user", userService.getall());
		System.out.println(111);
		return "user";
	}

	@RequestMapping(value = "edit/{id}.htm", method = RequestMethod.GET)
	public String edit(ModelMap model, HttpSession session, @PathVariable(value = "id") String id) {
		model.put("users", userService.findByID(id));
		model.put("user", userService.getall());
		return "user";
	}

	@RequestMapping(value = "users.htm", params = "bntUpdate", method = RequestMethod.POST)
	public String updateUser(ModelMap model, @ModelAttribute(value = "users") Users u, BindingResult result) {
		userService.update(u);
		model.put("user", userService.getall());
		return "user";
	}

	@RequestMapping(value = "deleteUser/{id}.htm", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, Users users) {
		System.out.println(123);
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.delete(users);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.flush();
			session.close();
		}
		model.put("user", userService.getall());
		return "user";
	}
}
