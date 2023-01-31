package br.senai.sc.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class AvaliadorTeste {

    private Usuario usuario1;
    private Usuario usuario2;
    private Lance l1;
    private Lance l2;
    private Lance l3;
    private Lance l4;
    private Lance l5;
    private Leilao leilao;
    private Date dataInicio = new Date(2023/01/18);
    private Date dataTermino = new Date(2023/01/20);
    private Avaliador avaliador;

    @BeforeEach
    public void setup() {
        usuario1 = new Usuario("paula", 30, "999.999.999-99");
        usuario2 = new Usuario("marcel", 29, "999.999.999-99");
        l1 = new Lance(200, usuario1);
        l2 = new Lance(300, usuario2);
        l3 = new Lance(400, usuario1);
        l4 = new Lance(150, usuario2);
        l5 = new Lance(500, usuario1);
        leilao = new Leilao(dataInicio, dataTermino);
        avaliador = new Avaliador();
    }

    @Test
    public void deveEncontrarOMaiorEMenorLance() {
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);

        avaliador.avalia(leilao);

        Assertions.assertEquals(400, avaliador.getMaiorLance(), "O teste falhou pois o maior lance não pode ser encontrado corretamente.");
        Assertions.assertEquals(200, avaliador.getMenorLance(), "O teste falhou pois o menor lance não pode ser encontrado corretamente.");
    }

    @Test
    public void naoDeveAvaliarLeilaoSemLances() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> avaliador.avalia(leilao), "O teste falhou pois a exceção não foi lançacada.");
    }

//    Ex 3 - Teste dos 3 maiores lances
    @Test
    public void deveEncontrarOsTresMaioresLances() {
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        leilao.adiciona(l5);

        List<Lance> tresMaiores = avaliador.getTresMaiores(leilao);

        Assertions.assertEquals(tresMaiores.size(), 3, "O teste falhou pois o tamanho da lista não equivale ao valor esperado.");

        Assertions.assertEquals(tresMaiores.get(0).getValor(), 500, "O teste falhou pois o primeiro maior valor encontrado não corresponde ao esperado.");
        Assertions.assertEquals(tresMaiores.get(1).getValor(), 400, "O teste falhou pois o segundo maior valor encontrado não corresponde ao esperado.");
        Assertions.assertEquals(tresMaiores.get(2).getValor(), 300, "O teste falhou pois o terceiro maior valor encontrado não corresponde ao esperado.");
    }

    //    Ex 5 - Teste dos três menores lances
    @Test
    public void deveEncontrarOsTresMenoresLances() {
        leilao.adiciona(l1);
        leilao.adiciona(l2);
        leilao.adiciona(l3);
        leilao.adiciona(l4);
        leilao.adiciona(l5);

        List<Lance> tresMenores = avaliador.getTresMenores(leilao);

        Assertions.assertEquals(tresMenores.size(), 3, "O teste falhou pois o tamanho da lista não equivale ao valor esperado.");

        Assertions.assertEquals(tresMenores.get(0).getValor(), 150, "O teste falhou pois o primeiro maior valor encontrado não corresponde ao esperado.");
        Assertions.assertEquals(tresMenores.get(1).getValor(), 200, "O teste falhou pois o segundo maior valor encontrado não corresponde ao esperado.");
        Assertions.assertEquals(tresMenores.get(2).getValor(), 300, "O teste falhou pois o terceiro maior valor encontrado não corresponde ao esperado.");
    }

//    Ex 7 - Teste do leilão de único lance
    @Test
    public void verfificaSeMaiorLanceEMenorLanceSaoIguais() {
        leilao.adiciona(l1);

        Assertions.assertTrue(avaliador.avalia(leilao), "O teste falhou pois o menor e maior lances não são iguais.");
    }

    @AfterEach
    public void tearDown() {
        usuario1 = null;
        usuario2 = null;
        l1 = null;
        l2 = null;
        l3 = null;
        l4 = null;
        l5 = null;
        leilao = null;
        avaliador = null;
    }

}
