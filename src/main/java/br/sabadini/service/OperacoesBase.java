package br.sabadini.service;

import java.util.List;
import java.util.Optional;

/**
 * Created by gumgait on 06/03/18.
 */
public interface OperacoesBase<T, ID> {
    T salvar(T entidade);
    Optional<T> procurarPorId(ID id);
    Boolean removerPorId(ID id);
    Boolean editar(ID id, T entidade);
    List<T> todos();
}
