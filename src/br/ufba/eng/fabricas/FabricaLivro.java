package br.ufba.eng.fabricas;

import br.ufba.eng.itens.ILivro;
import br.ufba.eng.itens.Livro;

import java.util.ArrayList;

public class FabricaLivro {
    public static ILivro criarLivro(String codigo, String titulo, String editora, ArrayList<String> autores, int edicao, int anoPublicacao, int quantidadeTotal){
        return new Livro(codigo, titulo, editora, autores, edicao, anoPublicacao, quantidadeTotal);
    }
}
