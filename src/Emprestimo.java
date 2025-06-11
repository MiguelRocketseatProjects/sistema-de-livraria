import java.util.Date;

public class Emprestimo {
    private int id;
    private static int contadorId = 1;
    private Livro livro;
    private String nomeUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isAtivo() {
        return ativo;
    }
}
