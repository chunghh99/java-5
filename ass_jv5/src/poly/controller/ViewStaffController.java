package poly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Staffs;
import poly.service.StaffService;

@Controller
@RequestMapping("viewstaff")
public class ViewStaffController {
	@Autowired
	StaffService staffService;
	
	
	@RequestMapping(value="/{id}.htm", method=RequestMethod.GET)
	public String viewStaff(ModelMap model, @PathVariable(value = "id") String id, HttpSession session) {
		session.setAttribute("viewstaff", staffService.findByID(id));
		model.put("staff", staffService.findByID(id));
		return"viewstaff";
	}
}
