package br.ufba.eng.fabricas;

import br.ufba.eng.itens.Livro;

import java.util.ArrayList;

public class FabricaLivro {
    public static Livro criarLivro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicacao, int quantidadeTotal){
        return new Livro(codigo, titulo, editora, autores, edicao, anoPublicacao, quantidadeTotal);
    }
}
