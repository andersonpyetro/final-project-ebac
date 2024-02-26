package br.com.pyetro.memelandia.repositories;

import br.com.pyetro.memelandia.entities.MemeCategory;
import br.com.pyetro.memelandia.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
