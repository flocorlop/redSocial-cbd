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

	// probando post y relaciones
	@Bean
	CommandLineRunner crearBBDD(PostService postS, PostRepository postR, PersonRepository perR) {
		return args -> {
			postR.deleteAll();
			perR.deleteAll();
			Person pe1 = new Person("flor", "correa", "fcl");
			Person pe2 = new Person("isa", "duran", "idv");
			Person pe3 = new Person("eva", "romero", "evj");
			Set<Person> set1 = new HashSet<Person>();
			set1.add(pe1);
			set1.add(pe2);
			Set<Person> set2 = new HashSet<Person>();
			set2.add(pe2);
			Post po1 = new Post(2, "post 1", set1, pe1);
			Post po2 = new Post(4, "post 2", set2, pe2);

			postS.savePost(po1);
			postS.savePost(po2);

			perR.save(pe1);
			perR.save(pe2);
			perR.save(pe3);
		};
	}
}
