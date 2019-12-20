package br.com.alura.algoritmos;

public class TesteEncontraMenores {

    public static void main(String[] args) {
        Nota gui = new Nota("Guilherme", 7.0);

        Nota[] notasDaSala = {
                new Nota("Andre", 4.0),
                new Nota("Carlos", 8.5),
                new Nota("Ana", 10.0),
                new Nota("Jonas", 3.0),
                new Nota("Juliana", 6.7),
                gui,
                new Nota("Paulo", 9.0),
                new Nota("Mariana", 5.0),
                new Nota("Lucia", 9.3),
        };

        int menores = buscaMenores(gui, notasDaSala);
        System.out.println("Número de menores:"+menores);
    }

    private static int buscaMenores (Nota busca, Nota[] notas) {
        int menores = 0;

        for (Nota nota: notas) {
            if (nota.getValor() < busca.getValor()) {
                menores++;
            }
        }

        return menores;
    }
}
