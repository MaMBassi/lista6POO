package br.inatel.poo.lista;

import java.util.ArrayList;
import java.util.List;

public class Categorias {

    public static List<Jogo> filtraPlataforma(List<Jogo> jogos, int plataforma){
        Plataformas plataformas;
        List<Jogo> listaPlataforma = new ArrayList<>();
        switch (plataforma){
            case 1:
                plataformas = Plataformas.PS4;
                jogos.stream().filter((j ->
                                j.getPlatform().equals(plataformas.name()))).
                                forEach(j -> listaPlataforma.add(j));
                break;
            case 2:
                plataformas = Plataformas.Wii;
                jogos.stream().filter((j -> j.getPlatform().equals(plataformas.name()))).
                        forEach(j -> listaPlataforma.add(j));
                break;
            default:
                break;
        }
        return listaPlataforma;
    }

    public  List<Jogo> filtraPublisher(List<Jogo> jogos, int publisher){
        Publishers publishers;
        List<Jogo> listaPublisher = new ArrayList<>();
        switch (publisher){
            case 1:
                publishers = Publishers.Nintendo;
                jogos.stream().filter((jogo -> jogo.getPublisher().equals(publishers.name()))).
                        forEach(jogo -> listaPublisher.add(jogo));
                break;
            case 2:
                publishers = Publishers.Activision;
                jogos.stream().filter((jogo -> jogo.getPublisher().equals(publishers.name()))).
                        forEach(jogo -> listaPublisher.add(jogo));
                break;
            default:
                break;
        }
        return listaPublisher;
    }
}
