package br.sabadini.repository;

import br.sabadini.entity.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements RepositoryBase<Categoria, String> {
    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public Categoria salvar(Categoria entidade) {
        return null;
    }

    @Override
    public Optional<Categoria> procurarPorId(String id) {
        return null;
    }

    @Override
    public Boolean removerPorId(String id) {
        return null;
    }

    @Override
    public Boolean editar(String id, Categoria entidade) {
        return null;
    }

    @Override
    public List<Categoria> todos() {
        return null;
    }
}
