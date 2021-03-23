package tw.chris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.chris.model.Members;

@Controller
public class MembersController {

	@RequestMapping(path = "/members.controller", method = RequestMethod.GET)
	public String showMembersPage(Model model) {
		Members mymember = new Members();
		model.addAttribute("members",mymember);
		return "members";
	}
	
	
	@RequestMapping(path="/addMembers",method=RequestMethod.POST)
	public String submitMembers(@ModelAttribute("members")Members members,BindingResult result,ModelMap model) {
		if (result.hasErrors()) {
			return "membersError";
		}
		model.addAttribute("mName",members.getMemberName());
		model.addAttribute("mGender",members.getGender());
		model.addAttribute("mAge",members.getAge());
		return "membersResult";
	}

}
