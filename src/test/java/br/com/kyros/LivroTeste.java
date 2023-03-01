package br.com.kyros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import br.com.kyros.model.Livro;

public class LivroTeste {

    private Livro livro;

    @Before(value = "")
    public void setUp() {
        livro = new Livro();
        livro.setCodigo(1L);
        livro.setTitulo("O Senhor dos Anéis");
        livro.setAutor("J.R.R. Tolkien");
        livro.setAno_edicao("1954");
    }

    @Test
    public void testGetId() {
        assertNotNull(livro.getCodigo());
        assertEquals(1L, livro.getCodigo().longValue());
    }

    @Test
    public void testGetTitulo() {
        assertNotNull(livro.getTitulo());
        assertEquals("O Senhor dos Anéis", livro.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertNotNull(livro.getAutor());
        assertEquals("J.R.R. Tolkien", livro.getAutor());
    }

    @Test
    public void testGetAno() {
        assertNotNull(livro.getAno_edicao());
        assertEquals(1954, livro.getAno_edicao().toString());
    }

}