package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<Livro>livros;

    public Biblioteca(List<Livro> livros, String nome) {
        this.livros = new ArrayList<>();
        this.nome = nome;
    }

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        if(livro == null) {
            throw new ArgumentoInvalidoException("aaa");
        }

        if (livro.getTitulo() == null || livro.getTitulo().isBlank() || livro.getTitulo().isEmpty()){
            throw new ArgumentoInvalidoException("aaa");
        }

        if (livro.getAutor() == null || livro.getAutor().isBlank() || livro.getAutor().isEmpty()){
            throw new ArgumentoInvalidoException("aaa");
        }

        if (livro.getDataPublicacao()== null){
            throw new ArgumentoInvalidoException("aaa");
        }

        livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("aaa");
        }

        Livro livroRemover = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo.trim())) {
                livroRemover = livro;
                break;
            }
        }

        if (livroRemover == null) {
            throw new LivroNaoEncontradoException("aaa");
        }

        livros.remove(livroRemover);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("aaa");
        }

        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }

        throw new LivroNaoEncontradoException("aaa");
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        if (ano == null || ano < 0) {
            throw new ArgumentoInvalidoException("aaa");
        }
        List<Livro> livrosAteAno = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosAteAno.add(livro);
            }
        }

        return livrosAteAno;
    }



}
