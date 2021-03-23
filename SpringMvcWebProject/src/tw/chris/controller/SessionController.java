package tw.chris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(names = { "demo" })
@RequestMapping(path = "/region")
public class SessionController {

	//http://localhost:8080/SpringMvcWebProject/region/role.controller
	
	@RequestMapping(path = "/role.controller", method = RequestMethod.GET)
	public String processGet(Model m) {
		m.addAttribute("demo", "angel");
		return "redirect:/region/second.controller";
	}
//    
//    @RequestMapping(path = "/role2.controller", method = RequestMethod.GET)
//	public String processGet2(Model m) {
//		m.addAttribute("demo2","steve");
//		return "/sessionResult.jsp";
//	}

	@RequestMapping(path = "/second.controller", method = RequestMethod.GET)
	public String processGet2(@ModelAttribute("demo")String m, SessionStatus status) {
		System.out.println("hi" + m);
		status.setComplete();
		return "sessionResult";
	}

}
