package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import domain.Curso;

@Repository
public interface ICursoRepository extends MongoRepository<Curso, String>{
}
