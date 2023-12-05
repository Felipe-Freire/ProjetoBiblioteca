package eng.controle;

import eng.fabricas.FabricaLivro;
import eng.fabricas.FabricaUsuario;
import eng.fabricas.TipoUsuario;
import eng.itens.Livro;
import eng.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CarregarDados {
    public static void carregarDados() {
        Sistema sistema = Sistema.getInstance();

        Livro livro1 = FabricaLivro.criarLivro("100", "Engenharia de Software", "AddisonWesley", new ArrayList<>(List.of("Ian Sommervile")), 6, 2000);
        Livro livro2 = FabricaLivro.criarLivro("101", "UML – Guia do Usuário", "Campus", new ArrayList<>(List.of("Grady Booch", "James Rumbaugh", "Ivar Jacobson")),7, 2000);
        Livro livro3 = FabricaLivro.criarLivro("200", "Code Complete", "Microsoft Press", new ArrayList<>(List.of("Steve McConnell")), 2, 2014);
        Livro livro4 = FabricaLivro.criarLivro("201", "Agile Software Development, Principles, Patterns, and Practices", "Pratice Hall", new ArrayList<>(List.of("Robert Martin")), 1, 2002);
        Livro livro5 = FabricaLivro.criarLivro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", new ArrayList<>(List.of("Martin Fowler")), 1, 1999);
        Livro livro6 = FabricaLivro.criarLivro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", new ArrayList<>(List.of("Norman Fenton", "James Bieman")), 3, 2014);
        Livro livro7 = FabricaLivro.criarLivro("400", "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", new ArrayList<>(List.of("Erich Gamma,", "Richard Helm", "Ralph Johnson", "John Vlissides")), 1, 1994);
        Livro livro8 = FabricaLivro.criarLivro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", new ArrayList<>(List.of("Martin Fowler")), 3, 2003);

        livro1.adicionarExemplar("01");
        livro1.adicionarExemplar("02");
        livro2.adicionarExemplar("03");
        livro3.adicionarExemplar("04");
        livro4.adicionarExemplar("05");
        livro5.adicionarExemplar("06");
        livro5.adicionarExemplar("07");
        livro7.adicionarExemplar("08");
        livro7.adicionarExemplar("09");

        sistema.adicionarLivro(livro1);
        sistema.adicionarLivro(livro2);
        sistema.adicionarLivro(livro3);
        sistema.adicionarLivro(livro4);
        sistema.adicionarLivro(livro5);
        sistema.adicionarLivro(livro6);
        sistema.adicionarLivro(livro7);
        sistema.adicionarLivro(livro8);

        // Registrando usuarios
        Usuario usuario1 = FabricaUsuario.criarUsuario("123", "Joao da Silva", TipoUsuario.ALUNO_GRADUACAO);
        Usuario usuario2 = FabricaUsuario.criarUsuario("456","Luiz Fernando Rodrigues", TipoUsuario.ALUNO_POS_GRADUACAO);
        Usuario usuario3 = FabricaUsuario.criarUsuario("789", "Pedro Paulo", TipoUsuario.ALUNO_GRADUACAO);
        Usuario usuario4 = FabricaUsuario.criarUsuario("100", "Carlos Lucena", TipoUsuario.PROFESSOR);

        sistema.adicionarUsuario(usuario1);
        sistema.adicionarUsuario(usuario2);
        sistema.adicionarUsuario(usuario3);
        sistema.adicionarUsuario(usuario4);

    }
}
