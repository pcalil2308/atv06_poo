
package test.java.br.com.minhaempresa;

import main.java.br.com.minhaempresa.Estoque;
import main.java.br.com.minhaempresa.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class EstoqueTest {

    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
    }

    @Test
    void testAdicionarProduto() {
        Produto produto = new Produto("Produto1", 10.0);
        assertTrue(estoque.adicionarProduto(produto), "Deve permitir adicionar um novo produto.");
    }

    @Test
    void testAdicionarProdutoDuplicado() {
        Produto produto = new Produto("Produto1", 10.0);
        estoque.adicionarProduto(produto);

        assertFalse(estoque.adicionarProduto(produto), "Não deve permitir adicionar produtos duplicados.");
    }

    @Test
    void testRemoverProdutoExistente() {
        Produto produto = new Produto("Produto1", 10.0);
        estoque.adicionarProduto(produto);

        assertTrue(estoque.removerProduto("Produto1"), "Deve remover um produto existente.");
    }

    @Test
    void testRemoverProdutoNaoExistente() {
        assertFalse(estoque.removerProduto("ProdutoInexistente"), "Não deve remover um produto que não existe.");
    }

    @Test
    void testBuscarProdutoExistente() {
        Produto produto = new Produto("Produto1", 10.0);
        estoque.adicionarProduto(produto);

        assertNotNull(estoque.buscarProduto("Produto1"), "Deve retornar um produto existente.");
    }

    @Test
    void testBuscarProdutoNaoExistente() {
        assertNull(estoque.buscarProduto("ProdutoInexistente"), "Deve retornar null para produto não existente.");
    }

    @Test
    void testListarProdutos() {
        Produto produto1 = new Produto("Produto1", 10.0);
        Produto produto2 = new Produto("Produto2", 20.0);
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);

        Set<Produto> produtos = estoque.listarProdutos();
        assertEquals(2, produtos.size(), "A listagem deve conter todos os produtos adicionados.");
        assertTrue(produtos.contains(produto1), "A listagem deve conter Produto1.");
        assertTrue(produtos.contains(produto2), "A listagem deve conter Produto2.");
    }
}
