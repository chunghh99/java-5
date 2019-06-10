package poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.service.StaffService;

@Controller
@RequestMapping("")
public class ReportController {
	@Autowired
	StaffService staffService;
	
	@RequestMapping(value = "report.htm", method = RequestMethod.GET)
	public String report(ModelMap model) {
		model.put("arrays", staffService.getReport());
		return "report";
	}
}
