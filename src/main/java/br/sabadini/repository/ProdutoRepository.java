package br.sabadini.repository;

import br.sabadini.entity.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository implements RepositoryBase<Produto, String> {

    private List<Produto> produtos = new ArrayList<>();

    @Override
    public Produto salvar(Produto entidade) {
        produtos.add(entidade);
        return entidade;
    }

    @Override
    public Optional<Produto> procurarPorId(String id) {
        return this.produtos
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public Boolean removerPorId(String id) {
        Optional<Produto> produto = this.procurarPorId(id);
        if(produto.isPresent()) {
            this.produtos = this.produtos
                    .stream()
                    .filter(p -> !p.getId().equals(id))
                    .collect(Collectors.toList());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean editar(String id, Produto entidade) {
        Optional<Produto> produto = this.procurarPorId(id);
        if(produto.isPresent()) {
            Produto resutado = produto.get();
            resutado.setNome(entidade.getNome());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Produto> todos() {
        return this.produtos;
    }
}
