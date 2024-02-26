package br.com.pyetro.memes.repositories;

import br.com.pyetro.memes.entities.Meme;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemeRepository extends MongoRepository<Meme, String> {

    @Aggregation("{ $sample: { size: 1 } }")
    Optional<Meme> findRandomMeme();

}

