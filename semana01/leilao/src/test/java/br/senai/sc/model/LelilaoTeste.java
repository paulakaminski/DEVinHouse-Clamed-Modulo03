package br.senai.sc.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LelilaoTeste {

    private Usuario usuario1;
    private Usuario usuario2;
    private Lance l1;
    private Lance l2;
    private Lance l3;
    private  Lance l4;
    private Leilao leilao;
    private Date dataInicio = new Date(2023/01/18);
    private Date dataTermino = new Date(2023/01/20);

    @BeforeEach
    public void setup() {
        usuario1 = new Usuario("paula", 30, "999.999.999-99");
        usuario2 = new Usuario("marcel", 29, "999.999.999-99");
        l1 = new Lance(200, usuario1);
        l2 = new Lance(300, usuario1);
        l3 = new Lance(250, usuario2);
        l4 = new Lance(250, usuario2);
        leilao = new Leilao(dataInicio, dataTermino);
    }

//    Ex 1 - Teste dos lances consecutivos e Ex 4 - Teste de lances consecutivos
    @Test
    public void naoDevePermitirLancesConsecutivos() {
        leilao.adiciona(l1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> leilao.adiciona(l2), "O teste falhou pois a exceção não foi lançacada.");
    }

//    Ex 2 - Teste dos lances iguais e Ex 6 - Teste de lances iguais
    @Test
    public void naoDevePermitirLancesIguais() {
        leilao.adiciona(l3);
        Assertions.assertThrows(IllegalArgumentException.class, () -> leilao.adiciona(l4), "O teste falhou pois a exceção não foi lançacada.");
    }

    @AfterEach
    public void tearDown() {
        usuario1 = null;
        usuario2 = null;
        l1 = null;
        l2 = null;
        l3 = null;
        l4 = null;
        leilao = null;
    }

}
