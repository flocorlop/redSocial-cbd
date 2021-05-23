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

			

			Hobby ho1 = new Hobby("Futbol");
			Hobby ho2 = new Hobby("Baloncesto");
			Hobby ho3 = new Hobby("Badminton");
			Hobby ho4 = new Hobby("Idiomas");
			Hobby ho5 = new Hobby("Diseño");
			Hobby ho6 = new Hobby("Videojuegos");
			
			
			Set<Person> sinSeguidos = new HashSet<>();
			Set<Hobby> sinHobbies = new HashSet<>();
			Set<Hobby> SetHobbies1 = new HashSet<>();SetHobbies1.add(ho4);SetHobbies1.add(ho6);
			Set<Hobby> SetHobbies2 = new HashSet<>();SetHobbies2.add(ho1);SetHobbies2.add(ho2);SetHobbies2.add(ho3);
			Set<Hobby> SetHobbies3 = new HashSet<>();SetHobbies3.add(ho4);SetHobbies3.add(ho5);
			Set<Hobby> SetHobbies4 = new HashSet<>();SetHobbies4.add(ho6);SetHobbies4.add(ho4);SetHobbies4.add(ho5);

			
			Person admin = new Person("Admin", "ad", "admin", sinHobbies, sinSeguidos);
			Person pe1 = new Person("Juanjo", "Leon", "jualeoval", SetHobbies4, sinSeguidos);
			Person pe2 = new Person("Flor", "Correa", "flocorlop", SetHobbies1, sinSeguidos);
			
			Set<Person> SetSeguidos1 = new HashSet<>();SetSeguidos1.add(pe1);SetSeguidos1.add(pe2);
			Set<Person> SetSeguidos2 = new HashSet<>();SetSeguidos2.add(pe1);
			Set<Person> SetSeguidos3 = new HashSet<>();SetSeguidos3.add(pe2);

			

			Person pe3 = new Person("Sara", "Romero", "sarromcar", SetHobbies2, SetSeguidos1);
			Person pe4 = new Person("Fran", "Lopez", "fralopdez", sinHobbies, SetSeguidos3);
			Person pe5 = new Person("Antonio", "Valero", "antvalmul", SetHobbies3, SetSeguidos2);

			Set<Person> SetSeguidos4 = new HashSet<>();SetSeguidos4.add(pe1);SetSeguidos4.add(pe5);SetSeguidos4.add(pe2);
			Set<Person> SetSeguidos5 = new HashSet<>();SetSeguidos5.add(pe5);SetSeguidos5.add(pe5);SetSeguidos5.add(pe3);


			Person pe6 = new Person("Maria", "Hernandez", "marherfer", SetHobbies1, SetSeguidos4);
			Person pe7 = new Person("Calos", "Sanchez", "carsanbel", SetHobbies2, SetSeguidos5);
			Person pe8 = new Person("Lola", "Muñoz", "lolmuñder", SetHobbies4, sinSeguidos);
			
			
			

			hobR.save(ho3);
			perR.save(admin);
			perR.save(pe1);
			perR.save(pe2);
			perR.save(pe3);
			perR.save(pe4);
			perR.save(pe5);
			perR.save(pe6);
			perR.save(pe7);
			perR.save(pe8);

			
			Set<Person> SetLikersVacio = new HashSet<Person>();
			Set<Person> SetLikers1 = new HashSet<Person>();SetLikers1.add(pe2);SetLikers1.add(pe4);SetLikers1.add(pe8);
			Set<Person> SetLikers2 = new HashSet<Person>();SetLikers2.add(pe1);SetLikers2.add(pe5);SetLikers2.add(pe6);
			Set<Person> SetLikers3 = new HashSet<Person>();SetLikers3.add(pe3);SetLikers3.add(pe7);
			Set<Person> SetLikers4 = new HashSet<Person>();SetLikers4.add(pe4);SetLikers4.add(pe5);SetLikers4.add(pe1);

			

			Post po1 = new Post(SetLikers1.size(), "Pues hoy no hace mucho frio", SetLikers1, pe1);
			Post po2 = new Post(SetLikers2.size(), "Hoy he ido a la montaña", SetLikers2, pe2);
			Post po3 = new Post(SetLikers3.size(), "Que calor", SetLikers3, pe3);
			Post po4 = new Post(SetLikers4.size(), "Hace frio en la montaña", SetLikers4, pe4);
			Post po5 = new Post(SetLikers2.size(), "Estoy agobiado con los examenes", SetLikers1, pe5);
			Post po6 = new Post(SetLikers2.size(), "He acabado los examenes", SetLikers2, pe6);
			Post po7 = new Post(SetLikers2.size(), "He acabado los examenes", SetLikers2, pe6);
			Post po8 = new Post(SetLikersVacio.size(), "Tengo frio", SetLikersVacio, pe7);
			
			postS.savePost(po1);
			postS.savePost(po2);
			postS.savePost(po3);
			postS.savePost(po4);
			postS.savePost(po5);
			postS.savePost(po6);
			postS.savePost(po7);
			postS.savePost(po8);

		};
	}

	
}
