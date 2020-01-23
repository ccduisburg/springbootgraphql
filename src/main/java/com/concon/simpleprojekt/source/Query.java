package com.concon.simpleprojekt.source;

import com.concon.simpleprojekt.model.Person;
import com.concon.simpleprojekt.repository.PersonRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class Query implements GraphQLQueryResolver {
  @Autowired
  private  PersonRepository personRepository;


//  public Query(PersonRepository personRepository) {
//    this.personRepository = personRepository;
//
//  }



  //public List<Person> findAllPerson() {
//        return personRepository.findAll();
//    }

public GraphQLPaginationResult findPersonlistBy(Optional<String> vorname, Optional<String> nachname, Optional<String>skill, Optional<Date> geburtsdatum, GraphQLPaginationInput pagination){
  if(vorname.isPresent()){
    return  new GraphQLPaginationResult(personRepository.findByVorname(vorname.orElse(null),
            GraphQLPaginationPageableFactory.toPageable(pagination)));
  }
//  else if(nachname.isPresent()){
//    return personRepository.findByNachname(nachname.orElse(null),GraphQLPaginationPageableFactory.toPageable(pagination));
//  }
//  else if(skill.isPresent()){
//    return personRepository.findBySkill(skill.orElse(null),GraphQLPaginationPageableFactory.toPageable(pagination));
//  }
//  else if(geburtsdatum.isPresent()){
//    return personRepository.findByGeburtsdatum(geburtsdatum.orElse(null), GraphQLPaginationPageableFactory.toPageable(pagination));
//  }

  else
return  new GraphQLPaginationResult(personRepository.findAll(GraphQLPaginationPageableFactory.toPageable(pagination)));
//  return new GraphQLPaginationResult(
//          personRepository.findAllByOptional(
//                  vorname.orElse(null),
//                  nachname.orElse(null),
//                  skill.orElse(null),
//                  geburtsdatum.orElse(null),
//                  GraphQLPaginationPageableFactory.toPageable(pagination)
//          )
//  );

}

}
