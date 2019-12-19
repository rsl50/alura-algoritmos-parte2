package br.com.alura.algoritmos;

public class Nota {
    private final String aluno;
    private final double valor;

    public Nota(String aluno, double valor) {
        this.aluno = aluno;
        this.valor = valor;
    }

    public String getAluno() {
        return aluno;
    }

    public double getValor() {
        return valor;
    }
}
