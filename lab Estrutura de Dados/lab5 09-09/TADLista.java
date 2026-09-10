package tadlista;

public class TADLista {

    public static void main(String[] args) throws Exception {
        Lista ranking = new Lista(10);
        
        ranking.add(new Gamer("Alice", 1500));
        ranking.add(new Gamer("Bob", 2800));
        ranking.add(new Gamer("Carlos", 900));
        ranking.add(new Gamer("Diana", 3500));
        ranking.add(new Gamer("Eduardo", 2100));
        
        System.out.println("=== 3. Lista de Scores (Ordenada Decrescente) ===");
        ranking.mostraLista();
        
        System.out.println("=== 4. Primeiro Lugar ===");
        Gamer primeiro = ranking.get(0);
        System.out.println("Campeão: " + primeiro.getName() + " com " + primeiro.getScore() + " pontos.\n");
        
        System.out.println("=== 5. Removendo o jogador da 3ª posição ===");
        Gamer removido = ranking.get(2);
        ranking.remove(2);
        System.out.println("Jogador removido: " + removido.getName() + "\n");
        
        System.out.println("=== 6. Lista de Scores Atualizada ===");
        ranking.mostraLista();
    }
}