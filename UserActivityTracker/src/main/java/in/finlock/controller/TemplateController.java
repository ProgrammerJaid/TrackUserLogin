package in.finlock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.finlock.entity.User;
import in.finlock.service.UserService;

@Controller
@RequestMapping("/registration")
public class TemplateController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getLoginForm(Model model) {
		model.addAttribute("user", new User() );
		return "register";
	}
	
	@PostMapping
	public String registerUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		
		return "redirect:/login?success";
	}
	
	
}
