package br.com.pyetro.memes.services;

import br.com.pyetro.memes.entities.Meme;
import org.slf4j.Logger;
import br.com.pyetro.memes.repositories.MemeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class MemeService {

    private MemeRepository memeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(MemeService.class);

    @Autowired
    public MemeService(MemeRepository memeRepository){

    }
    public Meme createMeme(Meme meme) {
        LOGGER.info("New meme created: " + meme.getName() + " (ID: " + meme.getId() + ")");
        return memeRepository.save(meme);
    }
    public Iterable<Meme> findAll() {
        LOGGER.info("Memes " + memeRepository.count());
        return memeRepository.findAll();
    }
    public Optional<Meme> findMemeById(Meme meme){
        LOGGER.info("finding meme by Id " + meme.getId());
        return memeRepository.findById(meme.getId());
    }

    public Optional<Meme> findRandomMeme() {
        LOGGER.info("Finding random meme");
        return memeRepository.findRandomMeme();
    }

    public Meme updateMeme(Meme meme){
        try {
            Optional<Meme> existingMeme = memeRepository.findById(meme.getId());
            if(existingMeme.isPresent()){
                Meme memeUpdate = existingMeme.get();
                memeUpdate.setName(meme.getName());
                memeUpdate.setDescription(meme.getDescription());
                memeUpdate.setUrl(meme.getUrl());
                memeRepository.save(memeUpdate);
                LOGGER.info("meme updated successfully:  " + meme.getId());
            } else {
                throw new RuntimeException("Meme not found by Id: " + meme.getId());
            }
        } catch (Exception e) {
            LOGGER.error("Failed to update meme with ID  " + e.getMessage(), e);
            throw new RuntimeException("Error updating meme:  " + e.getMessage());
        }

        return meme;
    }

    public void deleteMemeById(Meme meme){
        try {
            memeRepository.deleteById(meme.getId());
            LOGGER.info("Meme deleted successfully: " + meme.getId());
        } catch (Exception e) {
            LOGGER.error("Failed to delete meme with ID " + meme.getId() + ": " + e.getMessage(), e);
            throw new RuntimeException("Error deleting meme: " + e.getMessage());
        }
    }
}


