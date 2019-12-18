package br.com.alura.algoritmos;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class TestaMerge {

    public static void main(String[] args) {
        Nota[] notasDoMauricio = {
                new Nota("Andre", 4.0),
                new Nota("Mariana", 5.0),
                new Nota("Carlos", 8.5),
                new Nota("Paulo", 9.0)
        };

        Nota[] notasDoAlberto = {
                new Nota("Jonas", 3.0),
                new Nota("Juliana", 6.7),
                new Nota("Guilherme", 7.0),
                new Nota("Lucia", 9.3),
                new Nota("Ana", 10.0)
        };

        Nota[] rank = junta(notasDoMauricio, notasDoAlberto);
        for (Nota nota: rank) {
            System.out.println(nota.getAluno() + " - " + nota.getNota());
        }
    }

    private static Nota[] junta(Nota[] notas1, Nota[] notas2) {
        int tamanho =  notas1.length + notas2.length;
        Nota resultado[] = new Nota[tamanho];

        int atualNotas1 = 0;
        int atualNotas2 = 0;
        int atual = 0;

        while ((atualNotas1 < notas1.length) && (atualNotas2 < notas2.length)) {
            if (notas1[atualNotas1].getNota() < notas2[atualNotas2].getNota()) {
                resultado[atual] = notas1[atualNotas1];
                atualNotas1++;
            } else {
                resultado[atual] = notas2[atualNotas2];
                atualNotas2++;
            }

            atual++;
        }

        return  resultado;
    }
}
