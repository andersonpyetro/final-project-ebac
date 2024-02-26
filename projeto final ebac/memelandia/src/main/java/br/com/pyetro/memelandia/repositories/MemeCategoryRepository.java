package br.com.pyetro.memelandia.repositories;

import br.com.pyetro.memelandia.entities.MemeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemeCategoryRepository extends MongoRepository<MemeCategory, Long> {
}
