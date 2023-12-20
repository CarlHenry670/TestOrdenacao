import java.util.List;
import java.util.Random;

public class PreencherAleatorio {
    private static final Random geradorAleatorio = new Random();

    public static List<Integer> criarLista(int tamanho) {
        List<Integer> lista = new java.util.ArrayList<Integer>();

        for (int i = 0; i < tamanho; i++) {
            int numeroAleatorio = geradorAleatorio.nextInt(50);
            lista.add(numeroAleatorio);
        }

        return lista;
    }
}
