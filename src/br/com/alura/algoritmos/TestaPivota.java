package br.com.alura.algoritmos;

public class TestaPivota {

    public static void main(String[] args) {
        Nota gui = new Nota("Guilherme", 7.0);

        Nota[] notasDaSala = {
                new Nota("Andre", 4.0),
                new Nota("Carlos", 8.5),
                new Nota("Ana", 10.0),
                new Nota("Jonas", 3.0),
                new Nota("Juliana", 6.7),
                new Nota("Lucia", 9.3),
                new Nota("Paulo", 9.0),
                new Nota("Mariana", 5.0),
                gui,
        };

        quebraNoPivo(notasDaSala, 0, notasDaSala.length);
        for (Nota nota: notasDaSala) {
            System.out.println(nota.getAluno() + " - " + nota.getValor());
        }
    }

    private static void quebraNoPivo (Nota[] notas, int inicio, int termino) {
        Nota pivo = notas[termino - 1];
        int menores = 0;

        for (int i = 0; i < termino - 1; i++) {
            if (notas[i].getValor() < pivo.getValor()) {
                troca(notas, i, menores);
                menores++;
            }
        }

        troca(notas, termino - 1, menores);
    }

    private static void troca (Nota[] notas, int de, int para){
        Nota nota1 = notas[de];
        Nota nota2 = notas[para];
        notas[de] = nota2;
        notas[para] = nota1;
    }
}
