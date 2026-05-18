import personagens.Arqueiro;
import personagens.Guerreiro;
import personagens.Mago;
import personagens.Personagem;
import sistema.SistemaBatalha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");
        System.out.print("Escolha sua classe: ");
        int escolhaClasse = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Crie o nome do seu personagem: ");
        String nomePersonagem = scanner.nextLine();

        Personagem jogador = null;
        Personagem inimigo = new Guerreiro("Thor"); // Inimigo fixo para teste

        if (escolhaClasse == 1) {
            jogador = new Guerreiro(nomePersonagem);
            System.out.println();
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Classe: Guerreiro");
        } else if (escolhaClasse == 2) {
            jogador = new Mago(nomePersonagem);
            System.out.println();
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Classe: Mago");
        } else if (escolhaClasse == 3) {
            jogador = new Arqueiro(nomePersonagem);
            System.out.println();
            System.out.println("Nome: " + jogador.getNome());
            System.out.println("Classe: Arqueiro");
        }

        System.out.println();
        SistemaBatalha sistemaBatalha = new SistemaBatalha(jogador, inimigo);
        sistemaBatalha.iniciarBatalha();



        scanner.close();
    }
}
