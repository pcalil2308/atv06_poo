
package main.java.br.com.minhaempresa;

import java.util.HashSet;
import java.util.Set;

public class Estoque {
    private Set<Produto> produtos = new HashSet<>();

    public boolean adicionarProduto(Produto produto) {
        return produtos.add(produto);
    }

    public boolean removerProduto(String nome) {
        Produto produto = buscarProduto(nome);
        if (produto != null) {
            produtos.remove(produto);
            return true;
        }
        return false;
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    public Set<Produto> listarProdutos() {
        return new HashSet<>(produtos);
    }
}
