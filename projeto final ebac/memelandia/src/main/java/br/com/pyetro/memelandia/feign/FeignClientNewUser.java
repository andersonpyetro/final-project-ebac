package br.com.pyetro.memelandia.feign;

import br.com.pyetro.memelandia.dto.NewUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "new-user", url = "https://localhost:8082")
public interface FeignClientNewUser {

    @RequestMapping("/users")
    public NewUserDTO createNewUser(@RequestBody NewUserDTO newUserDTO);
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public Iterable<NewUserDTO> findAll();
}
