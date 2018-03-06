package br.sabadini.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = CategoriaResource.URI_RESOURCE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class CategoriaResource {
    protected static final String URI_RESOURCE = "/api/categorias";

}
