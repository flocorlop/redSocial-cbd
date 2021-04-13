package redSocial;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
	CommandLineRunner demo(PostService postS) {
		return args -> {
			Person pe1 = new Person("rosario", "lopez", "ros");
			Person pe2 = new Person("manolo", "correa", "man");
			Set<Person> set1 = new HashSet<Person>();
			set1.add(pe1);
			set1.add(pe2);
			Post po1 = new Post(2, set1, pe1);
			Post po2 = new Post(2, set1, pe2);
			List<Post> lista = new ArrayList<Post>();
			lista.add(po1);
			lista.add(po2);
			for (Post pon : lista) {
				postS.save(pon);
			}

		};
	}
}
