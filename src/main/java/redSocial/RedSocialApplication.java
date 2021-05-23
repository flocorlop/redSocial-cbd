package redSocial;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import redSocial.model.Hobby;
import redSocial.model.Person;
import redSocial.repository.HobbyRepository;
import redSocial.repository.PersonRepository;

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

}
