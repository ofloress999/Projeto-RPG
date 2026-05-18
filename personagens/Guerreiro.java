package personagens;

public class Guerreiro extends Personagem {
    private int raiva;

    public Guerreiro(String nome) {
        super(nome, 150, 18, 12, 1, 1);
        this.raiva = 100;
    }

    @Override
    public String mostrarStatus() {
        return String.format(
                """
                Nome: %s
                Vida: %d
                Dano base: %d
                Defesa: %d
                Raiva: %d
                """, nome, vida, danoBase, defesa, raiva
        );
    }

    @Override
    public int ataqueBasico() {
            if (vida > 0 && raiva >= 10) {
                System.out.println("Você atacou o inimigo!");
                System.out.println("Seu golpe causou: " + getDanoBase() + " de dano");
                this.raiva -= 10;
                this.raiva += 5;
                return getDanoBase();
            } else {
                    if (vida <= 0) {
                        System.out.println("Você esta morto!");
                    } else if (raiva < 10) {
                        System.out.println("Você não tem raiva suficiente!");
                    }
            }
            return 0;
    }

    @Override
    public int usarSkill() {
        int danoSkillFinal = danoBase * 2;
        if (vida > 0 && raiva >= 35 && getCooldownSkill() == 0) {
            System.out.printf("%s usou GOLPE BRUTAL!", getNome());
            System.out.println();
            System.out.printf("Seu golpe causou: " + danoSkillFinal + " de dano %n");
            this.raiva -= 35;
            this.cooldownSkill = 2;
            return danoSkillFinal;
        } else if (getCooldownSkill() > 0) {
            System.out.println("Skill disponivel em " + getCooldownSkill() + " Rounds");
        } else {
            if (vida <= 0) {
                System.out.println("Você esta morto!");
            } else if (raiva < 35) {
                System.out.println("Você não tem raiva suficiente!");
            }
        }
        return 0;
    }

    @Override
    public void recuperarRecurso() {
        if (vida > 0 && raiva < 100) {
                System.out.println("Recuperando 25 de raiva!");

                raiva += 25;
                if(raiva > 100) {
                    raiva = 100;
                }

        } else {
            if (raiva >= 100) {
                System.out.println("Sua raiva está cheia!");
            } else if (vida <= 0) {
                System.out.println("Você esta morto!");
            }
        }
    }



}
