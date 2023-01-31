package br.senai.sc.main;

import br.senai.sc.model.Avaliador;
import br.senai.sc.model.Lance;
import br.senai.sc.model.Leilao;
import br.senai.sc.model.Usuario;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Usuario paula = new Usuario("Paula", 30, "083.942.239-31");

        Lance l1 = new Lance(200, paula);
        Lance l2 = new Lance(300, paula);
        Lance l3 = new Lance(400, paula);

        Leilao leilao = new Leilao(new Date(2023/01/18), new Date(2023/01/20));

        leilao.adiciona(l3);
        leilao.adiciona(l2);
        leilao.adiciona(l1);

        Avaliador avaliador = new Avaliador();

        avaliador.avalia(leilao);

        double maiorValorEsperado = 400.0;
        double menorValorEsperado = 200.0;

        System.out.println(maiorValorEsperado = avaliador.getMaiorLance());
        System.out.println(menorValorEsperado = avaliador.getMenorLance());

    }
}
