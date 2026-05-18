package sistema;

import personagens.Personagem;

import java.util.Random;
import java.util.Scanner;

public class SistemaBatalha {
    private Personagem jogador;
    private Personagem inimigo;


    public SistemaBatalha(Personagem jogador, Personagem inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void iniciarBatalha() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 0;

        System.out.println("A batalha começou!");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome() );

        while (jogador.getVida() > 0 && inimigo.getVida() > 0) {

            round++;

            System.out.println("ROUND " + round);
            System.out.println("""
                    ====================
                    1 - Ataque básico
                    2 - Usar skill
                    3 - Recuperar recurso
                    4 - Ver status
                    """);
            int opcaoMenu = scanner.nextInt();

            switch (opcaoMenu) {
                case 1:
                    int dano = jogador.ataqueBasico();
                    inimigo.receberDano(dano);
                    break;
                case 2:
                    int danoSkill = jogador.usarSkill();
                    inimigo.receberDano(danoSkill);
                    break;
                case 3:
                    jogador.recuperarRecurso();
                    break;
                case 4:
                    System.out.println(jogador.mostrarStatus());
                    continue;
                default:
                    System.out.println("Escolha invalida!");
                    continue;
            }

            // Informações STATUS FIXO
            System.out.println("Jogador 1:");
            System.out.println("Vida: " + jogador.getVida());
            System.out.println();
            System.out.println("Inimigo:");
            System.out.println("Vida: " + inimigo.getVida());

            // Turno Inimigo
            int opcaoMenuInimigo = random.nextInt(3) + 1;

            if (inimigo.getVida() <= 0) {
                System.out.println("Inimigo morreu!");
                break;
            }
            switch (opcaoMenuInimigo) {
                case 1:
                    int danoInimigo = inimigo.ataqueBasico();
                    jogador.receberDano(danoInimigo);
                    break;
                case 2:
                    int danoSkillInimigo = inimigo.usarSkill();
                    jogador.receberDano(danoSkillInimigo);
                    break;
                case 3:
                    inimigo.recuperarRecurso();
                    break;
                case 4:
                    System.out.println(inimigo.mostrarStatus());
                    continue;
                default:
                    System.out.println("Escolha invalida!");
                    continue;
            }

            // Informações STATUS FIXO
            System.out.println("Jogador 1:");
            System.out.println("Vida: " + jogador.getVida());
            System.out.println();
            System.out.println("Inimigo:");
            System.out.println("Vida: " + inimigo.getVida());

            jogador.reduzirCooldown();
            inimigo.reduzirCooldown();



        }

        if (jogador.getVida() <= 0) {
            System.out.println("Derrota");
        } else {
            System.out.println("Vitoria");
        }
    }

}
