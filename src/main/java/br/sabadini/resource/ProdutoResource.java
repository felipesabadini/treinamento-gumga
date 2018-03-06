package br.sabadini.resource;

import br.sabadini.dto.ProdutoDTO;
import br.sabadini.dto.conversor.ProdutoParaProdutoDTO;
import br.sabadini.entity.Produto;
import br.sabadini.exception.EntidadeNaoEncontrada;
import br.sabadini.service.ServiceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(
        value = ProdutoResource.URI_RESOURCE,
//        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
)
public class ProdutoResource {

    protected static final String URI_RESOURCE = "/api/produtos";

    @Autowired
    private ServiceBase<Produto, String> produtoService;
    @Autowired
    private ProdutoParaProdutoDTO produtoParaProdutoDTO;


    @RequestMapping
    public ResponseEntity todos() {
        return ResponseEntity.ok(produtoParaProdutoDTO.apply(produtoService.todos()));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity porId(@PathVariable String id) {
        Optional<Produto> produto = produtoService.procurarPorId(id);
        if(produto.isPresent()) {
            return ResponseEntity.ok(produtoParaProdutoDTO.apply(produto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removerPorId(@PathVariable String id) {

        Boolean resultado = this.produtoService.removerPorId(id);
        if(resultado) {
            return ResponseEntity.noContent().build();
        }

        throw new EntidadeNaoEncontrada(String.format("Você não pode remover a entidade Produto com o id %s, por que ela não existe na base de dados.", id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity editarPorId(@PathVariable String id, @RequestBody ProdutoDTO produtoDTO) {
        Boolean resultado = this.produtoService.editar(id, new Produto(produtoDTO.getNome()));

        if(resultado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity criar(@RequestBody ProdutoDTO produtoDTO) {

        final Produto produto = new Produto(produtoDTO.getNome());
        this.produtoService.salvar(produto);
        return ResponseEntity
                .created(URI.create(String.format("%s/%s", ProdutoResource.URI_RESOURCE, produto.getId())))
                .body(produto);
    }

//    @XmlRootElement(name = "produtos")
//    public class ProdutoDTOList {
//        List<ProdutoDTO> produtoDTOS;
//
//        private ProdutoDTOList(List<ProdutoDTO> produtoDTOS) {
//            this.produtoDTOS = produtoDTOS;
//        }
//
//        @XmlAttribute(name = "produto")
//        public List<ProdutoDTO> getProdutoDTOS() {
//            return produtoDTOS;
//        }
//
//        public void setProdutoDTOS(List<ProdutoDTO> produtoDTOS) {
//            this.produtoDTOS = produtoDTOS;
//        }
//    }
//
//    @RequestMapping(value = "/{idProduto}/categorias/{idCategoria}", method = RequestMethod.PUT)
//    public ResponseEntity addCategoria(@PathVariable String idProduto, @PathVariable String idCategoria) {
//        return null;
//    }
//
//    @RequestMapping(value = "/{id}/categorias", method = RequestMethod.POST)
//    public ResponseEntity addCategoria2() {
//        return null;
//    }


//        new Produto(nome, new BigDecimal(10.00), new BigDecimal(10.00), new ArrayList<>());
//        Categoria.build().builder();
//        Produto.build().nome().valorVenda().valorCusto().builder()
//
//        Produto produto = Produto.build()
//                .nome(nome)
//                .valorVenda(new BigDecimal(10.00))
//                .valorCusto(new BigDecimal(11.11))
//                .builder();

}
