package br.sabadini.resource;

import br.sabadini.exception.DetalheErro;
import br.sabadini.exception.EntidadeNaoEncontrada;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControlarExcessoes {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControlarExcessoes.class);

    @ExceptionHandler(EntidadeNaoEncontrada.class)
    public ResponseEntity produtoNaoEncontrar(EntidadeNaoEncontrada produtoNaoEncontrado, WebRequest request) {
        DetalheErro detalheErro = new DetalheErro(produtoNaoEncontrado.getMessage(), request.getDescription(false));
        LOGGER.error(detalheErro.toString(), produtoNaoEncontrado);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalheErro);
    }
}
