package br.com.alura.algoritmos;

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

        Nota[] notasDaSala = {
                new Nota("Andre", 4.0),
                new Nota("Mariana", 5.0),
                new Nota("Carlos", 8.5),
                new Nota("Paulo", 9.0),
                new Nota("Jonas", 3.0),
                new Nota("Juliana", 6.7),
                new Nota("Guilherme", 7.0),
                new Nota("Lucia", 9.3),
                new Nota("Ana", 10.0)
        };

        Nota[] outrasNotas = {
                new Nota("Jonas", 2),
                new Nota("Fernando", 2.3),
                new Nota("Ana", 7.1),
                new Nota("Guilherme", 8),
                new Nota("Alberto", 9.2),
                new Nota("Maria", 5.25),
                new Nota("Paulo", 6),
                new Nota("Enzo", 7.9),
                new Nota("Lucia", 9.8)
        };

        String[] nomes = {
                "Andressa",
                "Camila",
                "Enzo",
                "Fernando",
                "Maria",
                "Alberto",
                "Jonas",
                "Junior",
                "Paloma",
                "Paulo"
        };

        //Nota[] rank = intercala(notasDoMauricio, notasDoAlberto);
        //Nota[] rank = intercala(notasDaSala, 0, 4, notasDaSala.length);
        //Nota[] rank = intercala(outrasNotas, 0, 5, outrasNotas.length);
        //Nota[] rank = mergeSort(notasDaSala);
//        for (Nota nota: rank) {
//            System.out.println(nota.getAluno() + " - " + nota.getValor());
//        }

        String[] rank = intercala(nomes, 0, 5, nomes.length);
        for (String nome: rank) {
            System.out.println(nome);
        }
    }

    private static Nota[] intercala(Nota[] notas1, Nota[] notas2) {
        int tamanho =  notas1.length + notas2.length;
        Nota[] resultado = new Nota[tamanho];

        int atualNotas1 = 0;
        int atualNotas2 = 0;
        int atual = 0;

        while ((atualNotas1 < notas1.length) && (atualNotas2 < notas2.length)) {
            if (notas1[atualNotas1].getValor() < notas2[atualNotas2].getValor()) {
                resultado[atual] = notas1[atualNotas1];
                atualNotas1++;
            } else {
                resultado[atual] = notas2[atualNotas2];
                atualNotas2++;
            }
            atual++;
        }

        while (atualNotas1 < notas1.length) {
            resultado[atual] = notas1[atualNotas1];
            atualNotas1++;
            atual++;
        }

        while (atualNotas2 < notas2.length) {
            resultado[atual] = notas2[atualNotas2];
            atualNotas2++;
            atual++;
        }

        return  resultado;
    }

    private static Nota[] intercala(Nota[] notas, int inicio, int meio, int termino) {
        Nota[] resultado = new Nota[termino - inicio];
        int atual = 0;
        int atual1 = inicio;
        int atual2 = meio;

        while (atual1 < meio &&
                atual2 < termino) {

            Nota nota1 = notas[atual1];
            Nota nota2 = notas[atual2];

            if (nota1.getValor() < nota2.getValor()) {
                resultado[atual] = nota1;
                atual1++;
            } else {
                resultado[atual] = nota2;
                atual2++;
            }

            atual++;
        }

        while (atual1 < meio) {
            resultado[atual] = notas[atual1];
            atual1++;
            atual++;
        }

        while (atual2 < termino) {
            resultado[atual] = notas[atual2];
            atual2++;
            atual++;
        }

//        for (int contador = 0; contador < atual; contador++) {
//            notas[inicio + contador] = resultado[contador];
//        }

        atual = inicio;
        for (Nota nota : resultado) {
            notas[atual++] = nota;
        }

        return notas;
    }

    private static String[] intercala(String[] nomes, int inicio, int meio, int termino) {
        String[] resultado = new String[termino - inicio];
        int atual = 0;
        int atual1 = inicio;
        int atual2 = meio;

        while (atual1 < meio && atual2 < termino) {

            String nome1 = nomes[atual1];
            String nome2 = nomes[atual2];

            if (nome1.compareTo(nome2) < 0) {
                resultado[atual] = nome1;
                atual1++;
            } else {
                resultado[atual] = nome2;
                atual2++;
            }

            atual++;
        }

        while (atual1 < meio) {
            resultado[atual] = nomes[atual1];
            atual1++;
            atual++;
        }

        while (atual2 < termino) {
            resultado[atual] = nomes[atual2];
            atual2++;
            atual++;
        }

//        for (int contador = 0; contador < atual; contador++) {
//            nomes[inicio + contador] = resultado[contador];
//        }

        atual = inicio;
        for (String nome : resultado) {
            nomes[atual++] = nome;
        }

        return nomes;
    }

    private static Nota[] mergeSort(Nota[] notas) {
        int tamanho =  notas.length;
        Nota[] resultado = new Nota[tamanho];

        int atualNotas1 = 0;
        int atualNotas2 = tamanho / 2;
        int atual = 0;

        while ((atualNotas1 <  (tamanho / 2)) && (atualNotas2 < tamanho)) {
            if (notas[atualNotas1].getValor() < notas[atualNotas2].getValor()) {
                resultado[atual] = notas[atualNotas1++];
            } else {
                resultado[atual] = notas[atualNotas2++];
            }

            if (atual < tamanho - 1) {
                atual++;
            }
        }

        while (atualNotas1 <  (tamanho / 2)) {
            resultado[atual] = notas[atualNotas1++];
            if (atual < tamanho - 1) {
                atual++;
            }
        }

        while (atualNotas2 < tamanho) {
            resultado[atual] = notas[atualNotas2++];

            if (atual < tamanho - 1) {
                atual++;
            }
        }

        return  resultado;
    }
}
