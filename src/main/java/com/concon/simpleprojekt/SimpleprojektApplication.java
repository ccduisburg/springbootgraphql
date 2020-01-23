package com.concon.simpleprojekt;

import com.concon.simpleprojekt.exceptions.GraphQLErrorAdapter;
import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.concon.simpleprojekt.source.Mutation;
import com.concon.simpleprojekt.source.PersonResolver;
import com.concon.simpleprojekt.source.Query;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SimpleprojektApplication {

	public static void main(String[] args) {
	//	Config config = ConfigFactory.load();
		SpringApplication.run(SimpleprojektApplication.class, args);
	}
//	@Bean
//	public PersonResolver authorResolver(PersonRepository authorRepository) {
//		return new PersonResolver(authorRepository);
//	}

//	@Bean
//	public Query query(PersonRepository personRepository) {
//		return new Query();
//	}

	@Bean
	public Mutation mutation(PersonRepository personRepository) {
		return new Mutation(personRepository);
	}
	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

//	@Bean
//	public CommandLineRunner demo(PersonRepository personRepository) {
//		return (args) -> {
//			Person person = new Person();
//			person.setVorname("cc");
//			person.setNachname("jkkdk");
//			person.setSkill("hic bisey");
//			personRepository.save(person);
//
//
//		};
//	}
}
