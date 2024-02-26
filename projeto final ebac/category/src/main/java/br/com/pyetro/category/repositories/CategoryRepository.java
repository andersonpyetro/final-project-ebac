package br.com.pyetro.category.repositories;

import br.com.pyetro.category.entities.MemeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<MemeCategory, String> {

}
