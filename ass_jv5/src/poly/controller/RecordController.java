package poly.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Records;
import poly.entity.Staffs;
import poly.service.RecordSevices;

@Controller
@RequestMapping()
public class RecordController {
	@Autowired
	RecordSevices recordSevices;

	@RequestMapping(value="record",method=RequestMethod.GET)
	public String record(ModelMap model) {
		model.put("listThanhtich", recordSevices.getall(1));
		model.put("listKiluat", recordSevices.getall(0));
		return "record";
	}

	@RequestMapping(value = "removerecord/{id}.htm", method = RequestMethod.GET)
	public String removeRecord(ModelMap model, @PathVariable(value ="id") String id) {
		Records r = recordSevices.findByID(id);
		if (r != null) {
			recordSevices.delete(r);
			model.put("listThanhtich", recordSevices.getall(1));
			model.put("listKiluat", recordSevices.getall(0));
		}
		
		return "record";
	}
	@RequestMapping(value="/viewstaff.htm",params="btnInsertThanhtich",method=RequestMethod.POST)
	public String newThanhtich(ModelMap model, @ModelAttribute(value="staff")Staffs id, HttpSession session,BindingResult result ) {
		Records r = new Records();
		Date dnow= new Date();
		r.setStaff(id);
		r.setDate(dnow);
		r.setType(1);
		model.put("record", r);
		session.setAttribute("message", "TitleNewRecord1");
		return"newrecord";
	}
	@RequestMapping(value="/viewstaff.htm",params="btnInsertKiluat",method=RequestMethod.POST)
	public String newKiluat(ModelMap model, @ModelAttribute(value="staff")Staffs id, HttpSession session,BindingResult result ) {
		Records r = new Records();
		Date dnow= new Date();
		r.setStaff(id);
		r.setDate(dnow);
		r.setType(0);
		model.put("record", r);
		session.setAttribute("message", "TitleNewRecord1");
		return"newrecord";
	}
	@RequestMapping(value="insertrecord.htm",params="btnInsertRecord",method=RequestMethod.POST)
	public String insertRecord(ModelMap model, @ModelAttribute(value="record")Records record,BindingResult result) {
		recordSevices.insert(record);
		model.put("listThanhtich", recordSevices.getall(1));
		model.put("listKiluat", recordSevices.getall(0));
		return "record";
	}

}
