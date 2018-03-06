package br.sabadini.resource;

import br.sabadini.entity.Produto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/primeiro-resource")
public class PrimeiroResource {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/oi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Produto oi() {
        return new Produto("RedBull");
    }
}
