package in.finlock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.finlock.entity.UserTrackDetail;
import in.finlock.repo.TrackUserRepo;

@RestController
public class TestController {

	@Autowired
	private TrackUserRepo trackRepo;
	
	@GetMapping("/getAll")
	public List<UserTrackDetail> getAll(Authentication auth,HttpServletRequest req){
		System.out.println(req.getSession().getId());
		return trackRepo.findByUsername(auth.getName()).get();
		
	}
	
	
}
