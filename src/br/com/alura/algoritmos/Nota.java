package br.com.alura.algoritmos;

public class Nota {
    private String aluno;
    private double nota;

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
