import java.util.concurrent.TimeUnit;

public class Cronometro {
    private long tempoInicial;

    public void iniciar() {
        tempoInicial = System.currentTimeMillis();
    }

    public long parar() {
        long tempoDecorrido = System.currentTimeMillis() - tempoInicial;
        tempoInicial = 0;
        return tempoDecorrido;
    }

    public String obterTempo(long milissegundos) {
        long horas = TimeUnit.MILLISECONDS.toHours(milissegundos);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(milissegundos) % 60;
        long segundos = TimeUnit.MILLISECONDS.toSeconds(milissegundos) % 60;
        long milissegundosRestantes = milissegundos % 1000;
        String tempo = String.format("%02d:%02d:%02d.%03d", horas, minutos, segundos, milissegundosRestantes);

        return String.format(tempo);

        
    }
}