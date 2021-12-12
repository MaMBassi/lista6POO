package br.inatel.poo.lista;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {

    public List<Jogo> lerArquivo(Path caminho) {
        List<Jogo> jogos = new ArrayList<>();

        try {
            Reader reader = Files.newBufferedReader(caminho);
            CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Jogo.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            jogos = csvToBean.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jogos;
    }
}
