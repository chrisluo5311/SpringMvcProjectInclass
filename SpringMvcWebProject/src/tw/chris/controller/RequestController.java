package tw.chris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
	
	@RequestMapping(path="/request.controller",method =RequestMethod.GET )
	public String processrequest(@RequestParam("user")String name,@RequestParam("address")String address,Model m) {
		System.out.println("user:"+name+" address:"+ address);
		m.addAttribute("user",name);
		m.addAttribute("address",address);
		return "/requestResult.jsp";
	}
	
}
