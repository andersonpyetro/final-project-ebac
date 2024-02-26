package br.com.pyetro.user.repositories;

import br.com.pyetro.user.entities.User;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @Aggregation("{ $sample: { size: 1 } }")
    Optional<User> findRandomUser();

}
