package redSocial.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import redSocial.model.Hobby;
import redSocial.model.Person;
import redSocial.repository.HobbyRepository;
import redSocial.service.HobbyService;

@Controller
@RequestMapping("/hobbies")
public class HobbyController {

	
	private HobbyService hobbyService;
	
	@Autowired
    public HobbyController(final HobbyService hobbyService) {
    	this.hobbyService = hobbyService;
    }
	
	@PostMapping("/new")
	private Hobby saveHobby(@RequestBody Hobby hobby) {
		return hobbyService.saveHobby(hobby);
	}
	
	@RequestMapping("/all")
    public String findAllHobbies(Model model) {
    	Iterable<Hobby> hobbies = this.hobbyService.findAllHobbies();
    	model.addAttribute("hobbies", hobbies);
    	return "hobbiesList";
    }
	
    @RequestMapping("/{id}")
    public String showCause(@PathVariable("id") final int id, ModelMap model) {
    	Hobby h = this.hobbyService.getHobbyById(id);
    	model.addAttribute("hobby", h);
    	return "details.jsp";
    }
	
	
	@PostMapping("/{id}/delete")
	public void deleteHobby(@PathVariable("id") int id) {
		hobbyService.deleteHobbybyId((long)id);;
	}
	
	
	
}
