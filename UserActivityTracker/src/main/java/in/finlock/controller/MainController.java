package in.finlock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.finlock.entity.User;
import in.finlock.entity.UserTrackDetail;
import in.finlock.service.TrackUser;

@Controller
public class MainController {
	
	@Autowired
	private TrackUser trackService;

	@GetMapping("/login")
	public String loginForm(Model model) {
		
		model.addAttribute("user",new User());
		return "login_form";
	}
	
	@GetMapping("/home")
	public String homePage(Model model,Authentication auth,HttpServletRequest req) {
		List<UserTrackDetail> list = trackService.getAll(auth,req);
		model.addAttribute("data", list);
		return "home_page";
	}
	
	
}
