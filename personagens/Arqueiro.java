package personagens;

public class Arqueiro extends Personagem {
    private int energia;

    public Arqueiro(String nome) {
        super(nome, 110, 16, 7, 1, 1);
        this.energia = 100;
    }

    @Override
    public String mostrarStatus() {
        return String.format(
                """
                Nome: %s
                Vida: %d
                Dano base: %d
                Defesa: %d
                Energia: %d
                """, nome, vida, danoBase, defesa, energia
        );
    }

    @Override
    public int ataqueBasico() {
        if (vida > 0 && energia >= 10) {
            System.out.println("Você atacou o inimigo!");
            System.out.println("Seu golpe causou: " + getDanoBase() + " de dano");
            this.energia -= 10;
            return getDanoBase();
        } else {
            if (vida <= 0) {
                System.out.println("Você esta morto!");
            } else if (energia < 10) {
                System.out.println("Você não tem energia suficiente!");
            }
        }
        return 0;
    }

    @Override
    public int usarSkill() {
        int danoSkillFinal = danoBase * 2;
        if (vida > 0 && energia >= 35 && getCooldownSkill() == 0) {
            System.out.printf("%s usou CHUVA DE FLECHAS!", getNome());
            System.out.println();
            System.out.printf("Sua habilidade causou: " + danoSkillFinal + " de dano %n");
            this.energia -= 35;
            this.cooldownSkill = 2;
            return danoSkillFinal;
        } else if (getCooldownSkill() > 0) {
            System.out.println("Skill disponivel em " + getCooldownSkill() + " Rounds");
        } else {
            if (vida <= 0) {
                System.out.println("Você esta morto!");
            } else if (energia < 35) {
                System.out.println("Você não tem energia suficiente!");
            }
        }
        return 0;
    }

    @Override
    public void recuperarRecurso() {
        if (vida > 0 && energia < 100) {
            System.out.println("Recuperando 30 de energia!");

            energia += 30;
            if(energia > 100) {
                energia = 100;
            }

        } else {
            if (energia >= 100) {
                System.out.println("Sua energia está cheia!");
            } else if (vida <= 0) {
                System.out.println("Você esta morto!");
            }
        }
    }



}
