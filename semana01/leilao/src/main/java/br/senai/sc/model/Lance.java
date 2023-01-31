package br.senai.sc.model;

public class Lance implements Comparable<Lance> {

    private double valor;
    private Usuario usuario;

    public Lance() {
    }

    public Lance(double valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int compareTo(Lance outro) {
        if (this.valor > outro.valor) {
            return -1;
        } else if (this.valor < outro.valor) {
            return 1;
        }

        return 0;
    }
}
