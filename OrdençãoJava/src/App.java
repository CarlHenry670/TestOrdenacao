import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Tamanho da lista
        int tamanhoLista = 100;

        // Criar a lista original não ordenada
        List<Integer> numerosNaoOrdenados = PreencherAleatorio.criarLista(tamanhoLista);

        // Teste com o Merge Sort
        testarOrdenacao("bubblesor", new ArrayList<>(numerosNaoOrdenados));

        // Teste com o Selection Sort
        testarOrdenacao("Selection Sort", new ArrayList<>(numerosNaoOrdenados));

        // Teste com o Insertion Sort
        testarOrdenacao("Insertion Sort", new ArrayList<>(numerosNaoOrdenados));

        // Teste com o Merge Sort
        testarOrdenacao("Merge Sort", new ArrayList<>(numerosNaoOrdenados));

        // Teste com o Quick Sort
        testarOrdenacao("Quick Sort", new ArrayList<>(numerosNaoOrdenados));

        // Teste com o Counting Sort
        testarOrdenacao("Counting Sort", new ArrayList<>(numerosNaoOrdenados));

    }

    private static void testarOrdenacao(String metodo, List<Integer> numeros) {
        Cronometro cronometro = new Cronometro();
        cronometro.iniciar();

        // Escolha do método de ordenação
        switch (metodo) {
            case "bubblesor":
                Dados.bubbleSort(numeros);
                break;
            case "Selection Sort":
                Dados.selectionSort(numeros);
                break;
            case "Insertion Sort":
                Dados.insertionSort(numeros);
                break;
            case "Merge Sort":
                Dados.mergeSort(numeros);
                break;
            case "Quick Sort":
                Dados.quickSort(numeros);
                break;
            case "Counting Sort":
                Dados.countingSort(numeros);
                break;
        }

        long tempoDecorrido = cronometro.parar();

        System.out.println("Método de ordenação: " + metodo);
        System.out.println("Lista ordenada: " + numeros);
        System.out.println("Tempo decorrido: " + cronometro.obterTempo(tempoDecorrido));
        System.out.println("******************************************************");
    }
}
