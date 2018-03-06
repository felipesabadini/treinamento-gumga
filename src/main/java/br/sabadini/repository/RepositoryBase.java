package br.sabadini.repository;

import br.sabadini.service.OperacoesBase;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBase<T, ID> extends OperacoesBase<T, ID> {

}
