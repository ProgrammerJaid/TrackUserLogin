package in.finlock.service;

import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.finlock.entity.LocationDetail;
import in.finlock.entity.UserTrackDetail;
import in.finlock.repo.TrackUserRepo;

@Service
public class TrackUser {

	@Autowired
	private TrackUserRepo detailRepo;

	private static final String url1 = "http://ip-api.com/json/";
	private static final String url2 = "?(fields=status,message,country,city)&fields=57369";

	@Autowired
	private RestTemplate restTemplate;

	public boolean loginDetailSave(HttpServletRequest req, Authentication auth) {

		UserTrackDetail details = new UserTrackDetail();

		details.setIpAddress(req.getRemoteAddr());
		details(req, details);

		ResponseEntity<LocationDetail> locationDetails = getIpDetails(details.getIpAddress());

		details.setLogIn(LocalDateTime.now());
		details.setSessionId(req.getSession().getId());
		req.setAttribute("checkS", details.getSessionId());
		details.setUsername(auth.getName());
		if (locationDetails.getStatusCode() == HttpStatus.OK)
			details.setLocation(locationDetails.getBody().getCity() + " " + locationDetails.getBody().getRegionName());

		detailRepo.save(details);

		return true;
	}

	private boolean details(HttpServletRequest request, UserTrackDetail details) {

		Enumeration<String> names = request.getHeaderNames();

		while (names.hasMoreElements()) {

			String name = names.nextElement();

			if (name.equals("sec-ch-ua-platform"))
				details.setOsName(request.getHeader(name));

			else if (name.equals("sec-ch-ua")) {
				String[] parts = request.getHeader(name).split("[;]+");
				String[] splits = parts[1].trim().split("[,]+");
				if (!splits[1].trim().startsWith(" Not"))
					details.setBrowserName(splits[1]);
				else {
					String[] split = parts[2].trim().split("[,]+");
					details.setBrowserName(split[1]);
				}
			}

		}

		return true;
	}

	public boolean logOutDetailsWork(String id) {
		
		UserTrackDetail details= detailRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Session Id not found."));
		details.setLogOut(LocalDateTime.now());
		details.setTime(details.getLogOut().getMinute()-details.getLogIn().getMinute());
		
		detailRepo.save(details);
		
		System.out.println(details.toString());
		
		return true;
	}

	private ResponseEntity<LocationDetail> getIpDetails(String ipAddr) {
		return restTemplate.getForEntity(url1+ipAddr+url2, LocationDetail.class);
	}

	
	public List<UserTrackDetail> getAll(Authentication auth,HttpServletRequest req){
		return detailRepo.findByUsername(auth.getName()).get();
	}
}
