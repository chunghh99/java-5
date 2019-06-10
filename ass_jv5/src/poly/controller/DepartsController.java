package poly.controller;




import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.entity.Departs;
import poly.service.DepartService;

@Controller
@RequestMapping()
public class DepartsController {
	@Autowired
	DepartService departService;
	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "departs.htm", method = RequestMethod.GET)
	public String departs(ModelMap model) {
		model.put("departs", new Departs());
		model.put("depart", departService.getall());
		return "departs";
	}
	@RequestMapping(value ="departs.htm",params = "bntInsert", method = RequestMethod.POST)
	public String insertDeparts(ModelMap model, @ModelAttribute(value = "departs") Departs dp) {
		System.out.println(123);
		departService.insert(dp);
		model.put("depart",departService.getall());
		return"departs";
	}
	
	@RequestMapping(value = "editDepart/{id}.htm", method = RequestMethod.GET)
	public String editDeparts(ModelMap model,HttpSession session ,@PathVariable(value = "id") String id) {
		model.put("departs", departService.findByID(id));
		model.put("depart",departService.getall());
		return"departs";
	}
	@RequestMapping(value ="departs.htm",params = "bntUpdate", method = RequestMethod.POST)
	public String updateDeparts(ModelMap model, @ModelAttribute(value = "departs") Departs dp) {
		departService.update(dp);
		model.put("depart",departService.getall());
		return"departs";
	}
	@RequestMapping(value = "delete/{id}.htm", method = RequestMethod.GET)
	public String deleteDeparts(ModelMap model,Departs departs) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
			session.delete(departs);
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
		model.put("depart",departService.getall());
		return"departs";
	}

}
