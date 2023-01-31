package br.senai.sc.model;

import java.util.Collections;
import java.util.List;

public class Avaliador {

    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public List<Lance> getTresMaiores(Leilao leilao) {
        List<Lance> lancesDoLeilao = leilao.getLances();
        Collections.sort(lancesDoLeilao);
        return lancesDoLeilao.subList(0, 3);
    }

    public List<Lance> getTresMenores(Leilao leilao) {
        List<Lance> lancesDoLeilao = leilao.getLances();
        lancesDoLeilao.sort(Collections.reverseOrder());
        return lancesDoLeilao.subList(0, 3);
    }

    public boolean avalia(Leilao leilao) {
        List<Lance> lancesDoLeilao = leilao.getLances();
        boolean lancesIguais = false;

        if (lancesDoLeilao.isEmpty()) {
            throw new IllegalArgumentException("Lista de lances vazia");
        }

        for (Lance lance : lancesDoLeilao) {
            if (lance.getValor() > maiorLance) {
                maiorLance = lance.getValor();
            }
            if (lance.getValor() < menorLance) {
                menorLance = lance.getValor();
            }
        }

        if (menorLance == maiorLance) {
            lancesIguais = true;
        }

        return lancesIguais;
    }
}
