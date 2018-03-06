package br.sabadini.service;

import br.sabadini.repository.RepositoryBase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class ServiceBase<T, ID> implements OperacoesBase<T, ID> {

    protected RepositoryBase<T, ID> repository;

    public ServiceBase(RepositoryBase<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T salvar(T entidade) {
        return this.repository.salvar(entidade);
    }

    @Override
    public Optional<T> procurarPorId(ID id) {
        return this.repository.procurarPorId(id);
    }

    @Override
    public Boolean removerPorId(ID id) {
        return this.repository.removerPorId(id);
    }

    @Override
    public Boolean editar(ID id, T entidade) {
        return this.repository.editar(id, entidade);
    }

    @Override
    public List<T> todos() {
        return this.repository.todos();
    }
}
