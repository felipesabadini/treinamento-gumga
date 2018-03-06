package br.sabadini.dto.conversor;

import br.sabadini.dto.CategoriaDTO;
import br.sabadini.entity.Categoria;


public class CategoriaParaCategoriaDTO implements SuperConversor<Categoria, CategoriaDTO> {

    @Override
    public CategoriaDTO apply(Categoria categoria) {
        return new CategoriaDTO(categoria.getId());
    }
}
