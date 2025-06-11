import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Biblioteca biblioteca = getBiblioteca();

        while (true) {

            System.out.println("Gostaria de ler os livros? (sim/nao)");

            String opcao = scan.nextLine().toLowerCase();

            if (opcao.equals("sim")) {
                List<Livro> livrosDiponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDiponiveis.isEmpty()) {
                    System.out.println("Não há livros disponiveis");
                } else {
                    for (Livro livro : livrosDiponiveis) {
                        System.out.println(livro.getId() + " - " + livro.getTitulo());
                    }
                }

                System.out.println("Qual livro deseja emprestar?");
                int id = scan.nextInt();
                scan.nextLine();

                Livro livroSelecionado = biblioteca.buscarLivroPorId(id);

                if (livroSelecionado == null || !livroSelecionado.isDisponivel()) {
                    System.out.println("Livro não disponivel");
                } else {
                    System.out.println("Digite seu nome:");
                    String nome = scan.nextLine();

                    biblioteca.emprestarLivro(livroSelecionado, nome);
                    System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado ao " + nome);
                }

            } else if (opcao.equals("nao")) {
                System.out.println("Encerrando o programa");
                break;
            } else {
                System.out.println("Opcao invalida");
            }
        }
    }

    private static Biblioteca getBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
        Autor autor2 = new Autor(2, "J.R.R. Tolkien", new Date());

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "O Senhor dos Anéis: A Sociedade do Anel", autor2);
        Livro livro3 = new Livro(3, "Harry Potter e a Câmara Secreta", autor1);

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        return biblioteca;
    }
}