package redSocial;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import redSocial.model.Hobby;
import redSocial.model.Person;
import redSocial.repository.HobbyRepository;
import redSocial.repository.PersonRepository;
import redSocial.repository.PostRepository;
import redSocial.model.Post;
import redSocial.service.PostService;

@EnableConfigurationProperties
@EnableTransactionManagement
@EnableNeo4jRepositories
@SpringBootApplication
public class RedSocialApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedSocialApplication.class, args);
	}

	@Bean
	CommandLineRunner crearBBDD(HobbyRepository hobR, PersonRepository perR, PostService postS, PostRepository postR) {
		return args -> {
			hobR.deleteAll();
			perR.deleteAll();
			postR.deleteAll();

			Set<Person> sinSeguidores = new HashSet<>();

			Hobby ho1 = new Hobby("Futbol");
			Hobby ho2 = new Hobby("Baloncesto");
			Hobby ho3 = new Hobby("Badminton");

			Person admin = new Person("Admin", "ad", "admin", null, sinSeguidores);
			Person pe1 = new Person("Juanjo", "Leon", "jualeoval", null, sinSeguidores);

			Set<Hobby> setHobbies1 = new HashSet<>();
			setHobbies1.add(ho1);
			setHobbies1.add(ho2);
			
			Set<Person> seguidores1 = new HashSet<>();
			seguidores1.add(pe1);

			Person pe2 = new Person("Flor", "Correa", "flocorlop", setHobbies1, sinSeguidores);

			Set<Person> seguidores2 = new HashSet<>();
			seguidores2.add(pe1);
			seguidores2.add(pe2);

			Person pe3 = new Person("Sara", "Romero", "sarromcar", null, seguidores1);
			Person pe4 = new Person("Fran", "Lopez", "fralopdez", null, seguidores2);

			hobR.save(ho3);
			perR.save(admin);
			perR.save(pe1);
			perR.save(pe2);
			perR.save(pe3);
			perR.save(pe4);

			Set<Person> likers1 = new HashSet<Person>();
			likers1.add(pe1);
			
			Set<Person> likersVacio = new HashSet<Person>();

			Post po1 = new Post(likers1.size(), "post 1", likers1, pe1);
			Post po2 = new Post(likersVacio.size(), "post 2", likersVacio, pe2);
			Post po3 = new Post(likersVacio.size(), "post 3", likersVacio, pe3);
			Post po4 = new Post(likersVacio.size(), "post 4", likersVacio, pe4);
			Post po5 = new Post(likers1.size(), "post 5", likers1, pe2);
			Post po6 = new Post(likers1.size(), "post 6", likers1, admin);
			Post po7 = new Post(likers1.size(), "post 7", likersVacio, admin);
			
			postS.savePost(po1);
			postS.savePost(po2);
			postS.savePost(po3);
			postS.savePost(po4);
			postS.savePost(po5);
			postS.savePost(po6);
			postS.savePost(po7);
		};
	}

	
}
