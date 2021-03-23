package tw.chris.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.chris.model.Account;
import tw.chris.model.AccountDAO;

@Controller
@EnableTransactionManagement
public class CheckLoginSystem {

	@RequestMapping(path="/checkLogin.controller",method = RequestMethod.GET)
	public String initLoginSystem() {
		return "LoginSystem";
	}
	
	@Autowired
	public AccountDAO acountdao;
	
	@RequestMapping(path="/login.controller",method=RequestMethod.POST)
	public String processAction (@RequestParam("userName")String user,@RequestParam("userPwd")String pwd,Model m) {
		Map<String,String> errors = new HashMap<String,String>();
		m.addAttribute("errors",errors);
		
		if(user==null||user.length()==0) {
			errors.put("name","username is required");
		}
		if (pwd==null||pwd.length()==0) {
			errors.put("pwd", "userpwd is required");
		}
		if (errors!=null&&!errors.isEmpty()) {
			return "LoginSystem";
		}
		
		boolean status = acountdao.checkLogin(new Account(user,pwd));
		
		m.addAttribute("userName", user);
		m.addAttribute("userPwd", pwd);
		
		if (status) {
			return "loginSuccess";
		}
		errors.put("msg","please input correct username or password");
		return "LoginSystem";
		
	}
	
	
	
}
