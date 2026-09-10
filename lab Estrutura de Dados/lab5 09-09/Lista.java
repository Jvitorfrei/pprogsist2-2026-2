package tadlista;

public class Lista {

    Gamer[] vetor; // Mudado de String para Gamer
    int tamanho;   // Capacidade máxima
    int qtde;      // Qtde de elementos atual

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        vetor = new Gamer[tamanho];
        qtde = 0;
    }

    public boolean isEmpty() {
        return (qtde == 0);
    }

    public int size() {
        return qtde;
    }

    public Gamer get(int p) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!!");
        }
        if (p < 0 || p >= qtde) {
            throw new Exception("Posição inválida");
        }
        return vetor[p];
    }

    public void set(int p, Gamer novo) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!!");
        }
        if (p < 0 || p >= qtde) {
            throw new Exception("Posição inválida");
        }
        vetor[p] = novo;
    }

    public void add(Gamer novo) throws Exception {
        if (qtde == tamanho) {
            throw new Exception("A lista está cheia!! Impossível inserir");
        }
        
        int p = 0;
        while (p < qtde && vetor[p].getScore() >= novo.getScore()) {
            p++;
        }

        for (int i = qtde; i > p; i--) {
            vetor[i] = vetor[i - 1];
        }
        
        vetor[p] = novo;
        qtde++;
    }
    
    public void remove(int p) throws Exception {
        if (isEmpty())
            throw new Exception("A lista está vazia!! Impossível remover");
        if (p < 0 || p > qtde - 1) {
            throw new Exception("Posição inválida!!");
        }
        for (int i = p; i <= qtde - 2; i++) {
            vetor[i] = vetor[i + 1];
        }
        qtde--;
    }

    public int search(String nomeBusca) {
        for (int i = 0; i < qtde; i++) {
            if (vetor[i].getName().equalsIgnoreCase(nomeBusca))
                return i;
        }
        return -1;
    }
    
    public void mostraLista() {
        for (int i = 0; i < qtde; i++) {
            System.out.println((i + 1) + "º - Nome: " + vetor[i].getName() + " | Score: " + vetor[i].getScore());
        }
        System.out.println("----------------ри---");
    }
}