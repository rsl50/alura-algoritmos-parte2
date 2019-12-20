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

        String[] nomes = {
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
        };

        /* TESTANDO QUICKSORT E BUSCA BINÁRIA PARA NOTAS */
        /*quickSort(notasDaSala, 0, notasDaSala.length);
        //int encontrei = buscaLinear(notasDaSala, 0, notasDaSala.length, 9.3); // TESTANDO BUSCA LINEAR
        //int encontrei = buscaBinaria(notasDaSala, 0, notasDaSala.length -1 , 20); // TESTANDO BUSCA BINÁRIA
        int encontrei = buscaBinaria(notasDaSala, 3.0);
        if (encontrei >= 0) {
            System.out.println("Encontrei nota em: " + encontrei + ".");
        } else {
            System.out.println("Não encontrei o valor.");
        }

        for (Nota nota : notasDaSala) {
            System.out.println(nota.getAluno() + " - " + nota.getValor());
        }*/

        /* ================================================== */
        /* ================================================== */
        /* ================================================== */

        /* TESTANDO QUICKSORT E BUSCA BINÁRIA PARA NOMES */
        quickSort(nomes, 0, nomes.length);
        int encontrei = buscaBinariaNomes(nomes, "Enzo");
        if (encontrei >= 0) {
            System.out.println("Encontrei nome em: " + encontrei + ".");
        } else {
            System.out.println("Não encontrei o nome.");
        }

        for (String nome: nomes) {
            System.out.println(nome);
        }
    }

    /* Busca linear para notas */
    private static int buscaLinear(Nota[] notas, int de, int ate, double buscar) {
        for (int i = de; i < ate; i++) {
            if (notas[i].getValor() == buscar) {
                return i;
            }
        }
        return -1;
    }

    /* Busca binária para notas */
    private static int buscaBinaria(Nota[] notas, int de, int ate, double buscar) {
        if(de > ate) {
            return -1;
        }
        int meio = (de + ate) / 2;
        Nota nota = notas[meio];
        if(buscar == nota.getValor()) {
            return meio;
        }
        if(buscar < nota.getValor()) {
            return buscaBinaria(notas, de, meio - 1, buscar);
        }
        return buscaBinaria(notas, meio + 1, ate, buscar);
    }

    /* Busca binária para notas, chamada reduzida */
    private static int buscaBinaria(Nota[] notas, double buscar) {
        return buscaBinaria(notas, 0, notas.length - 1, buscar);
    }

    /* ================================================== */
    /* ================================================== */
    /* ================================================== */

    /* Busca binária para nomes */
    private static int buscaBinariaNomes(String[] nomes, int de, int ate, String busca) {
        if(de > ate) {
            return -1;
        }
        int meio = (de + ate) / 2;
        String nome = nomes[meio];
        if(busca.compareTo(nome) == 0) {
            return meio;
        }
        if(busca.compareTo(nome) < 0) {
            return buscaBinariaNomes(nomes, de, meio - 1, busca);
        }
        return buscaBinariaNomes(nomes, meio + 1, ate, busca);
    }

    /* Busca binária para nomes, chamada reduzida */
    private static int buscaBinariaNomes(String[] nomes, String busca) {
        return buscaBinariaNomes(nomes, 0, nomes.length - 1, busca);
    }

    /* QuickSort para notas, Ordenação rápida */
    private static void quickSort(Nota[] notas, int de, int ate) {
        int elementos = ate - de; //Tamanho do trecho a ser ordenado

        if (elementos > 1) {
            int posicaoPivo = particiona(notas, de, ate);
            //System.out.println("Recursivo|de:"+de+"|ate:"+ate+"|posicaoPivo:"+posicaoPivo+"|elementos:"+elementos);
            quickSort(notas, de, posicaoPivo);
            quickSort(notas, posicaoPivo + 1, ate);
        }
    }

    /* QuickSort para nomes, Ordenação rápida */
    private static void quickSort(String[] nomes, int de, int ate) {
        int elementos = ate - de; //Tamanho do trecho a ser ordenado

        if (elementos > 1) {
            int posicaoPivo = particiona(nomes, de, ate);
            //System.out.println("Recursivo|de:" + de + "|ate:" + ate + "|posicaoPivo:" + posicaoPivo + "|elementos:" + elementos);
            quickSort(nomes, de, posicaoPivo);
            quickSort(nomes, posicaoPivo + 1, ate);
        }
    }

    /* Quebra array de notas para ordenação */
    private static int particiona(Nota[] notas, int inicio, int termino) {
        Nota pivo = notas[termino - 1];
        int menores = 0;
        for (int i = 0; i < termino - 1; i++) {
            if (notas[i].getValor() < pivo.getValor()) {
                troca(notas, i, menores);
                menores++;
            }
        }
        troca(notas, termino - 1, menores);
        return menores;
    }

    /* Quebra array de nomes para ordenação */
    private static int particiona(String[] nomes, int inicio, int termino) {
        String pivo = nomes[termino - 1];
        int menores = 0;
        for (int i = 0; i < termino - 1; i++) {
            if (nomes[i].compareTo(pivo) < 0) {
                troca(nomes, i, menores);
                menores++;
            }
        }
        troca(nomes, termino - 1, menores);
        return menores;
    }

    /* Inverte dois elementos [notas] do array */
    private static void troca(Nota[] notas, int de, int para) {
        Nota nota1 = notas[de];
        Nota nota2 = notas[para];
        notas[de] = nota2;
        notas[para] = nota1;
    }

    /* Inverte dois elementos [nomes] do array */
    private static void troca(String[] nomes, int de, int para) {
        String nome1 = nomes[de];
        String nome2 = nomes[para];
        nomes[de] = nome2;
        nomes[para] = nome1;
    }
}
