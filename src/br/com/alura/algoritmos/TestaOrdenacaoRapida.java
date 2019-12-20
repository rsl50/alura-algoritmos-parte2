package br.com.alura.algoritmos;

public class TestaOrdenacaoRapida {
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

        /*String[] nomes = {
                "Maria",
                "Camila",
                "Fernando",
                "Jonas",
                "Andressa",
                "Paloma",
                "Alberto",
                "Junior",
                "Enzo",
                "Paulo"
        };*/

        quickSort(notasDaSala, 0, notasDaSala.length);
        for (Nota nota: notasDaSala) {
            System.out.println(nota.getAluno() + " - " + nota.getValor());
        }

        /*ordena(nomes, 0, nomes.length);
        for (String nome: nomes) {
            System.out.println(nome);
        }*/
    }

    private static void quickSort (Nota[] notas, int de, int ate) {
        int elementos = ate - de; //Tamanho do trecho a ser ordenado

        if (elementos > 1) {
            int posicaoPivo = particiona(notas, de, ate);
            //System.out.println("Recursivo|de:"+de+"|ate:"+ate+"|posicaoPivo:"+posicaoPivo+"|elementos:"+elementos);
            quickSort(notas, de, posicaoPivo);
            quickSort(notas, posicaoPivo + 1, ate);
        }
    }

    private static void ordena (String[] nomes, int de, int ate) {
        int elementos = ate - de; //Tamanho do trecho a ser ordenado

        if (elementos > 1) {
            int posicaoPivo = particiona(nomes, de, ate);
            System.out.println("Recursivo|de:"+de+"|ate:"+ate+"|posicaoPivo:"+posicaoPivo+"|elementos:"+elementos);
            ordena(nomes, de, posicaoPivo);
            ordena(nomes, posicaoPivo + 1, ate);
        }
    }

    private static int particiona (Nota[] notas, int inicio, int termino) {
        Nota pivo = notas[termino - 1];
        int menores = 0;

        for (int i = 0; i < termino - 1; i++) {
            if (notas[i].getValor() < pivo.getValor()) {
                troca(notas, i, menores);
                menores++;
            }
        }

        troca(notas, termino - 1, menores);

        return  menores;
    }

    private static int particiona (String[] nomes, int inicio, int termino) {
        String pivo = nomes[termino - 1];
        int menores = 0;

        for (int i = 0; i < termino - 1; i++) {
            if (nomes[i].compareTo(pivo) < 0) {
                troca(nomes, i, menores);
                menores++;
            }
        }

        troca(nomes, termino - 1, menores);

        return  menores;
    }

    private static void troca (Nota[] notas, int de, int para){
        Nota nota1 = notas[de];
        Nota nota2 = notas[para];
        notas[de] = nota2;
        notas[para] = nota1;
    }

    private static void troca (String[] nomes, int de, int para){
        String nome1 = nomes[de];
        String nome2 = nomes[para];
        nomes[de] = nome2;
        nomes[para] = nome1;
    }
}
