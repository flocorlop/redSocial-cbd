package redSocial.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaController {

	@RequestMapping("/mensaje")
	public String mensaje(Model model) {
		model.addAttribute("message", "Hello World");
		return "mensaje";
	}

	@RequestMapping("/")
	public String hola() {
		
		return "welcome";
	}
	@RequestMapping("/about")
	public String about() {
		
		return "contactInfo";
	}
}
