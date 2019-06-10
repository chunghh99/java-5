package poly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Departs;
import poly.entity.Records;
import poly.entity.Staffs;
import poly.service.DepartService;
import poly.service.RecordSevices;
import poly.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	StaffService staffService;
	@Autowired
	DepartService departService;
	@Autowired
	RecordSevices recordSevices ;

	@RequestMapping(value = "staff.htm", method = RequestMethod.GET)
	public String staff(ModelMap model) {
		model.put("listnhanvien", staffService.getall());
		return "staff";
	}

	@RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String insert(ModelMap model, HttpSession session) {
		model.put("staff", new Staffs());
		session.setAttribute("action", "insert.htm");
		return "save";
	}

	@RequestMapping(value ="insert.htm",params = "btnInsert", method = RequestMethod.POST)
	public String insertStaff(ModelMap model, @ModelAttribute(value = "staff") Staffs staff,BindingResult result) {
	staffService.insert(staff);
	model.put("listnhanvien",staffService.getall());		
		return "staff";
	}

	@RequestMapping(value = "{id}.htm", method = RequestMethod.GET)
	public String update(ModelMap model,HttpSession session ,@PathVariable(value = "id") String id) {
		model.put("staff", staffService.findByID(id));
		session.setAttribute("action", "update.htm");
		return "save";

	}
	@RequestMapping(value ="update.htm",params = "btnInsert", method = RequestMethod.POST)
	public String updateStaff(ModelMap model, @ModelAttribute(value = "staff") Staffs staff,BindingResult result) {
	staffService.update(staff);
	model.put("listnhanvien",staffService.getall());		
		return "staff";
	}

	@RequestMapping(value = "remove/{id}.htm", method = RequestMethod.GET)
	public String removeStaff(ModelMap model, @PathVariable(value = "id") String id) {
		Staffs s = staffService.findByID(id);
			staffService.delete(s);
			model.put("listnhanvien", staffService.getall());

		return "staff";
	}

	@ModelAttribute("depart")
	public List<Departs> getDepart() {
		List<Departs> list = departService.getall();
		return list;
	}

}
