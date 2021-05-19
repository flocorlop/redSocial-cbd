package redSocial.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaController {

	@RequestMapping("/")
	public String hola() {
		
		return "welcome";
	}
	@RequestMapping("/about")
	public String about() {
		
		return "contactInfo";
	}
}