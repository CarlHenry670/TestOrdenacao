import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static List<Integer> mergeSort(List<Integer> lista) {
        int tamanho = lista.size();

        if (tamanho < 2) {
            return lista;
        }

        int meio = tamanho / 2;

        List<Integer> listaEsquerda = new ArrayList<>(lista.subList(0, meio));
        List<Integer> listaDireita = new ArrayList<>(lista.subList(meio, tamanho));

        mergeSort(listaEsquerda);
        mergeSort(listaDireita);

        merge(lista, listaEsquerda, listaDireita);

        return lista;
    }

    private static void merge(List<Integer> lista, List<Integer> listaEsquerda, List<Integer> listaDireita) {
        int tamanhoListaEsquerda = listaEsquerda.size();
        int tamanhoListaDireita = listaDireita.size();

        int indiceListaEsquerda = 0;
        int indiceListaDireita = 0;
        int indiceLista = 0;

        while (indiceListaEsquerda < tamanhoListaEsquerda && indiceListaDireita < tamanhoListaDireita) {
            if (listaEsquerda.get(indiceListaEsquerda) <= listaDireita.get(indiceListaDireita)) {
                lista.set(indiceLista, listaEsquerda.get(indiceListaEsquerda));
                indiceListaEsquerda++;
            } else {
                lista.set(indiceLista, listaDireita.get(indiceListaDireita));
                indiceListaDireita++;
            }

            indiceLista++;
        }

        while (indiceListaEsquerda < tamanhoListaEsquerda) {
            lista.set(indiceLista, listaEsquerda.get(indiceListaEsquerda));
            indiceListaEsquerda++;
            indiceLista++;
        }

        while (indiceListaDireita < tamanhoListaDireita) {
            lista.set(indiceLista, listaDireita.get(indiceListaDireita));
            indiceListaDireita++;
            indiceLista++;
        }
    }

    public static void quickSort(List<Integer> lista) {
        Stack<Integer> pilha = new Stack<>();
        pilha.push(0);
        pilha.push(lista.size() - 1);

        while (!pilha.isEmpty()) {
            int fim = pilha.pop();
            int inicio = pilha.pop();

            int indicePivo = particionar(lista, inicio, fim);

            if (indicePivo - 1 > inicio) {
                pilha.push(inicio);
                pilha.push(indicePivo - 1);
            }

            if (indicePivo + 1 < fim) {
                pilha.push(indicePivo + 1);
                pilha.push(fim);
            }
        }
    }

    private static int particionar(List<Integer> lista, int inicio, int fim) {
        int pivo = lista.get(fim);
        int indicePivo = inicio - 1;

        for (int indiceAtual = inicio; indiceAtual < fim; indiceAtual++) {
            if (lista.get(indiceAtual) <= pivo) {
                indicePivo++;
                trocarElementos(lista, indicePivo, indiceAtual);
            }
        }

        trocarElementos(lista, indicePivo + 1, fim);

        return indicePivo + 1;
    }

    private static void trocarElementos(List<Integer> lista, int indiceA, int indiceB) {
        int temp = lista.get(indiceA);
        lista.set(indiceA, lista.get(indiceB));
        lista.set(indiceB, temp);
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
