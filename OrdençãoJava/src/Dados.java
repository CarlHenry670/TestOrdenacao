import java.util.ArrayList;
import java.util.List;

public class Dados {

    // bubblesort
    public static List<Integer> bubbleSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int auxiliar = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, auxiliar);
                }
            }
        }

        return lista;
    }

    // selesctionsort
    public static List<Integer> selectionSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 0; i < tamanho - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (lista.get(j) < lista.get(menor)) {
                    menor = j;
                }
            }
            int auxiliar = lista.get(menor);
            lista.set(menor, lista.get(i));
            lista.set(i, auxiliar);
        }

        return lista;

    }

    //insertionsort
    public static List<Integer> insertionSort(List<Integer> lista) {
        int tamanho = lista.size();

        for (int i = 1; i < tamanho; ++i) {
            int chave = lista.get(i);
            int j = i - 1;

            while (j >= 0 && lista.get(j) > chave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chave);
        }

        return lista;
    }

     //mergesort
     public static List<Integer> mergeSort(List<Integer> lista) {
        int tamanho = lista.size();

        if (tamanho < 2) {
            return lista;
        }

        int meio = tamanho / 2;
        List<Integer> esquerda = lista.subList(0, meio);
        List<Integer> direita = lista.subList(meio, tamanho);

        return merge(mergeSort(esquerda), mergeSort(direita));
    }

    private static List<Integer> merge(List<Integer> esquerda, List<Integer> direita) {
        int tamanhoEsquerda = esquerda.size();
        int tamanhoDireita = direita.size();
        int i = 0;
        int j = 0;
        List<Integer> lista = new ArrayList<>();

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda.get(i) <= direita.get(j)) {
                lista.add(esquerda.get(i));
                i++;
            } else {
                lista.add(direita.get(j));
                j++;
            }
        }

        while (i < tamanhoEsquerda) {
            lista.add(esquerda.get(i));
            i++;
        }

        while (j < tamanhoDireita) {
            lista.add(direita.get(j));
            j++;
        }

        return lista;
    }

     //quicksort
     public static List<Integer> quickSort(List<Integer> lista) {
        int tamanho = lista.size();

        if (tamanho < 2) {
            return lista;
        }

        int pivo = lista.get(0);
        List<Integer> menores = new ArrayList<>();
        List<Integer> maiores = new ArrayList<>();

        for (int i = 1; i < tamanho; i++) {
            if (lista.get(i) <= pivo) {
                menores.add(lista.get(i));
            } else {
                maiores.add(lista.get(i));
            }
        }

        List<Integer> listaOrdenada = quickSort(menores);
        listaOrdenada.add(pivo);
        listaOrdenada.addAll(quickSort(maiores));

        return listaOrdenada;
    }

        //countingsort
        public static List<Integer> countingSort(List<Integer> lista) {
            int tamanho = lista.size();
    
            if (tamanho < 2) {
                return lista;
            }
    
            int maior = lista.get(0);
            int menor = lista.get(0);
    
            for (int i = 1; i < tamanho; i++) {
                if (lista.get(i) > maior) {
                    maior = lista.get(i);
                } else if (lista.get(i) < menor) {
                    menor = lista.get(i);
                }
            }
    
            int[] auxiliar = new int[maior - menor + 1];
    
            for (int i = 0; i < tamanho; i++) {
                auxiliar[lista.get(i) - menor]++;
            }
    
            int j = 0;
            for (int i = menor; i <= maior; i++) {
                while (auxiliar[i - menor] > 0) {
                    lista.set(j, i);
                    j++;
                    auxiliar[i - menor]--;
                }
            }
    
            return lista;
        }


}
