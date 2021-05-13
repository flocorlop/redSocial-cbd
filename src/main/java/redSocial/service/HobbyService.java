package redSocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redSocial.model.Hobby;
import redSocial.repository.HobbyRepository;

@Service
public class HobbyService {
	private HobbyRepository hobbyRepository;

	@Autowired
	public HobbyService(final HobbyRepository hobbyRepository) {
		this.hobbyRepository = hobbyRepository;
	}
	
	
	public Hobby saveHobby(Hobby hobby) {
		return hobbyRepository.save(hobby);
	}
	public List<Hobby> getHobbies() {
		return (List<Hobby>) hobbyRepository.findAll();
	}
	
	public void deleteHobbybyId(long id) {
		hobbyRepository.deleteById(id);
		
	}
	@Transactional
	public Iterable<Hobby> findAllHobbies() {
		return this.hobbyRepository.findAll();
	}


	


	public Hobby getHobbyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
