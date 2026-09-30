package it.melani.thread;

public class Lavoratore implements Runnable {
    private final Contatore contatore;
    private final String nome;

    public Lavoratore(Contatore contatore, String nome) {
        this.contatore = contatore;
        this.nome = nome;
    }

    @Override
    public void run() {
        while (contatore.incrementa(nome)) {
            try {
                int pausa = 100 + (int) (Math.random() * 401);
                Thread.sleep(pausa);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nome + " è stato interrotto.");
                break;
            }
        }
    }
}

