
package test.java.br.com.minhaempresa;

import main.java.br.com.minhaempresa.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void testEqualsComProdutosIguais() {
        Produto p1 = new Produto("Produto1", 10.0);
        Produto p2 = new Produto("Produto1", 20.0); // mesmo nome, mas preço diferente

        assertEquals(p1, p2, "Produtos com o mesmo nome devem ser considerados iguais.");
    }

    @Test
    void testEqualsComProdutosDiferentes() {
        Produto p1 = new Produto("Produto1", 10.0);
        Produto p2 = new Produto("Produto2", 10.0);

        assertNotEquals(p1, p2, "Produtos com nomes diferentes devem ser considerados diferentes.");
    }

    @Test
    void testHashCodeComProdutosIguais() {
        Produto p1 = new Produto("Produto1", 10.0);
        Produto p2 = new Produto("Produto1", 20.0);

        assertEquals(p1.hashCode(), p2.hashCode(), "Produtos com o mesmo nome devem ter o mesmo hashCode.");
    }

    @Test
    void testCompareToComPrecosDiferentes() {
        Produto p1 = new Produto("Produto1", 10.0);
        Produto p2 = new Produto("Produto2", 20.0);

        assertTrue(p1.compareTo(p2) < 0, "Produto com preço menor deve ser menor na comparação.");
    }

    @Test
    void testCompareToComPrecosIguais() {
        Produto p1 = new Produto("Produto1", 10.0);
        Produto p2 = new Produto("Produto2", 10.0);

        assertEquals(0, p1.compareTo(p2), "Produtos com o mesmo preço devem ser iguais na comparação.");
    }
}
