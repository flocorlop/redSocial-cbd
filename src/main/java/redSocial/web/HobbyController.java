package redSocial.web;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
import redSocial.service.PersonService;

@Controller
@RequestMapping("/hobbies")
public class HobbyController {

	
	private HobbyService hobbyService;
	private PersonService personService;
	
	@Autowired
    public HobbyController(final HobbyService hobbyService, final PersonService personService) {
    	this.hobbyService = hobbyService;
    	this.personService = personService;
    }
	
	@GetMapping(value = "/new")
	public String initCreationForm(Map<String, Object> model) {
		Hobby h = new Hobby();
		model.put("hobby", h);
		return "hobbies/createHobby";
	}

	@PostMapping(value = "/new")
	public String processCreationForm(Hobby h, BindingResult result) {
		if (result.hasErrors()) {
			return "hobbies/createHobby";
		}
		else {
			Person p = personService.findByUsername("jualeoval");
			Set<Hobby> hobbies = hobbyService.findHobbiesbyUsername("jualeoval");
			hobbies.add(h);
			p.setHobbies(hobbies);
			System.out.println("Nuevo hobbie creado. Nombre: "+h.getName());
			this.hobbyService.saveHobby(h);
			this.personService.savePerson(p);
			return "redirect:/hobbies/all";
		}
	}
	
	@RequestMapping("/all")
    public String findAllHobbies(Model model) {
    	Iterable<Hobby> hobbies = this.hobbyService.findAllHobbies();
    	model.addAttribute("hobbies", hobbies);
    	return "hobbies/hobbiesList";
    }
	
    @GetMapping("/{name}")
    public String showCause(@PathVariable("name") String name, ModelMap model) {
    	Hobby h = this.hobbyService.getHobbyByName(name);
    	Set<Person> interested = personService.findPersonByHobbyName(name);
    	model.addAttribute("hobby", h);
    	model.addAttribute("interested",interested);
    	return "hobbies/hobbyDetails";
    }
	
	
	@GetMapping("/{id}/delete")
	public String deleteHobby(@PathVariable("id") int id) {
		hobbyService.deleteHobbybyId((long)id);
		return "redirect:/hobbies/all";
	}
	
	@GetMapping(value="/jualeoval/join/{name}")
	public String joinHobby(@PathVariable("name") String name) {
		Person me = personService.findByUsername("jualeoval");
		Set<Hobby> mHobby = hobbyService.findHobbiesbyUsername("jualeoval");
		System.out.println(mHobby);
		Hobby h = hobbyService.getHobbyByName(name);
		System.out.println(h.getName());
		
		mHobby.add(h);
		me.setHobbies(mHobby);
		personService.savePerson(me);
		
		
		
		return "redirect:/hobbies/all";
	}
	
	
	@GetMapping(value = "/{id}/edit")
	public String initEditForm(Map<String, Object> model,@PathVariable("id") int id) {
		Hobby h = hobbyService.getHobbyById(id);
		System.out.println(h.getName());
		model.put("h", h);
		return "hobbies/editHobby";
	}
	
	
	@PostMapping(value = "/{id}/edit")
	public String processEditForm(Hobby h, BindingResult result) {
		this.hobbyService.saveHobby(h);
		return "redirect:/hobbies/all";
		
	}

	
	
}
