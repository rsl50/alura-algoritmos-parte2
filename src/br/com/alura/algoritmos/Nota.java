package br.com.alura.algoritmos;

public class Nota {
    private final String aluno;
    private final double nota;

    public Nota(String aluno, double nota) {
        this.aluno = aluno;
        this.nota = nota;
    }

    public String getAluno() {
        return aluno;
    }

    public double getNota() {
        return nota;
    }
}
