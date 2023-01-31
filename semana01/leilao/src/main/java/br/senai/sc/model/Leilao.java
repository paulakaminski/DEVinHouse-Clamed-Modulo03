package br.senai.sc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leilao {

    private Date dataInicio;
    private Date dataTermino;
    private List<Lance> lances;

    public Leilao() {
    }

    public Leilao(Date dataInicio, Date dataTermino) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.lances = new ArrayList<>();
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public void adiciona(Lance lance) {
        Lance ultimoLance = new Lance();

        if (!lances.isEmpty()) {
            ultimoLance = lances.get(lances.size() - 1);
        }

        if (ultimoLance.getUsuario() == lance.getUsuario()) {
            throw new IllegalArgumentException("Não é permitido realizar dois lances consecutivos.");
        }

        for (Lance currentLance : lances) {
            if (currentLance.getUsuario() == lance.getUsuario() && currentLance.getValor() == lance.getValor()) {
                throw new IllegalArgumentException("Não é permitido realizar dois lances iguais.");
            }
        }

        this.lances.add(lance);
    }

    public void remove(Lance lance) {
        this.lances.remove(lance);
    }

}
