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

import redSocial.model.Person;
import redSocial.model.Post;
import redSocial.repository.PersonRepository;
import redSocial.repository.PostRepository;
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
	CommandLineRunner crearBBDD(HobbyRepository hobR, PersonRepository perR) {
		return args -> {
			hobR.deleteAll();
			perR.deleteAll();
			
			Set<Person> emptyP = new HashSet<>();

			Hobby ho1 = new Hobby("Futbol");
			Hobby ho2 = new Hobby("Baloncesto");
			Hobby ho3 = new Hobby("Badminton");
			
			Person pe1 = new Person("Juanjo", "Leon", "jualeoval", null, emptyP);

			Set<Hobby> SH1 = new HashSet<>();SH1.add(ho1);SH1.add(ho2);
			Set<Person> SP1 = new HashSet<>();SP1.add(pe1);
			
			Person pe2 = new Person("Flor", "Correa", "flocorlop",SH1,emptyP);
			
			Set<Person> SP2 = new HashSet<>();SP2.add(pe2);

			Person pe3 = new Person("Sara", "Romero", "sarromcar",null,emptyP);
			Person pe4 = new Person("Fran", "Lopez", "fralopdez",null,emptyP);

		
			hobR.save(ho3);
			perR.save(pe1);
			perR.save(pe2);
			perR.save(pe3);
			perR.save(pe4);
		};
	}

	// probando post y relaciones
	@Bean
	CommandLineRunner crearBBDD2(PostService postS, PostRepository postR, PersonRepository perR) {
		return args -> {
			postR.deleteAll();
			perR.deleteAll();

			Person pe1 = new Person("flor", "correa", "fcl");
			Person pe2 = new Person("isa", "duran", "idv");
			Person pe3 = new Person("eva", "romero", "erj");
			Person pe4 = new Person("lau", "roman", "lrh");

			Set<Person> set1 = new HashSet<Person>();
			set1.add(pe1);
			set1.add(pe2);
			set1.add(pe3);
			set1.add(pe4);

			Set<Person> set2 = new HashSet<Person>();
			set2.add(pe2);
			set2.add(pe4);
			
			Set<Person> setV = new HashSet<Person>();
			
			Post po1 = new Post(set1.size(), "post 1", set1, pe1);
			Post po2 = new Post(setV.size(), "post 2", setV, pe2);
			Post po3 = new Post(setV.size(), "post 3", setV, pe3);
			Post po4 = new Post(setV.size(), "post 4", setV, pe4);
			Post po5 = new Post(set1.size(), "post 5", set1, pe2);
			postS.savePost(po1);
			postS.savePost(po2);
			postS.savePost(po3);
			postS.savePost(po4);
			postS.savePost(po5);

			perR.save(pe1);
			perR.save(pe2);
			perR.save(pe3);
			perR.save(pe4);
		};
	}
}
