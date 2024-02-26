package br.com.pyetro.memelandia.services;

import br.com.pyetro.memelandia.dto.NewUserDTO;
import br.com.pyetro.memelandia.feign.FeignClientNewUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NewUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewUserService.class);

    private final FeignClientNewUser feignClientNewUser;

    public NewUserService(FeignClientNewUser feignClientNewUser){
        this.feignClientNewUser = feignClientNewUser;
    }

    public NewUserDTO createNewUser(NewUserDTO userDTO){
        LOGGER.info("Creating a new User");
        return feignClientNewUser.createNewUser(userDTO);
    }

    public Iterable<NewUserDTO> findAll(){
        LOGGER.info("Find all users");
        return feignClientNewUser.findAll();
    }
}
