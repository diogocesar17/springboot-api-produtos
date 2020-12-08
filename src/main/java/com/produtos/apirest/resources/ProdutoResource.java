package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um único produto")
    public Produto listaProdutoUnico( @PathVariable(value = "id") long id ) {
        return produtoRepository.findById(id);

    }

    @PostMapping("/incluirProduto")
    @ApiOperation(value="Salva um produto")
    public Produto incluirProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/deletaProduto")
    @ApiOperation(value="Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/atualizaProduto")
    @ApiOperation(value="Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
       return produtoRepository.save(produto);
    }
}
