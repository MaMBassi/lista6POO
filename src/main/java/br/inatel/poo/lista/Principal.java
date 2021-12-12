package br.inatel.poo.lista;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Path caminho = Paths.get("vendas-games.csv");
        List<Jogo> listaJogos = new ArrayList<>();
        List<Jogo> listaEscolha = new ArrayList<>();

        Categorias categorias = new Categorias();

        int escolha;
        int opcao;

        System.out.println("===MENU===");
        System.out.println("Escolha uma opção: ");
        System.out.println("1- Listar os Jogos filtrando por Plataformas.");
        System.out.println("2- Listar os Jogos filtrando por Publishers.");
        escolha = sc.nextInt();
        System.out.println("");

        LeituraArquivo leitura = new LeituraArquivo();
        listaJogos = leitura.lerArquivo(caminho);

        switch (escolha){
            case 1:

                System.out.println("Escolha uma Plataforma: ");
                System.out.println("1- PS4.");
                System.out.println("2- Wii.");
                opcao = sc.nextInt();
                listaEscolha = categorias.filtraPlataforma(listaJogos,opcao);
                break;
            case 2:
                System.out.println("Escolha um Publisher: ");
                System.out.println("1- Nintendo.");
                System.out.println("2- Activision.");
                opcao = sc.nextInt();
                listaEscolha = categorias.filtraPublisher(listaJogos,opcao);
                break;
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        try {
            System.out.println("==Jogos==");
            listaEscolha.forEach(j -> System.out.println(j.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
