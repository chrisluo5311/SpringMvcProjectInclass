package tw.chris.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloController extends AbstractController {
	
	@RequestMapping(path="/helloHomePage.controller",method=RequestMethod.GET)
	public String init() throws Exception {
		int i =1 ;
		if (i==1) {
			throw new Exception();
		}
		return "form";
	}
	

	@Override
	@RequestMapping(path="/hello.controller2",method=RequestMethod.POST)//annotation可與xml同時存在，但是path的路徑要不同，jsp設定時指定路徑
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String userName = request.getParameter("userName");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if (userName == null || userName.length() == 0) {
			errors.put("name", "name is required");
		}
		if (errors != null && !errors.isEmpty()) {
			return new ModelAndView("form");
		}

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);

		return new ModelAndView("success");
	}

}
