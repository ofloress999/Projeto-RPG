package personagens;

public class Mago extends Personagem{
    private int mana;

    public Mago(String nome) {
        super(nome, 90, 25, 4, 1, 1);
        this.mana = 120;
    }

    @Override
    public String mostrarStatus() {
        return String.format(
                """
                Nome: %s
                Vida: %d
                Dano base: %d
                Defesa: %d
                Mana: %d
                """, nome, vida, danoBase, defesa, mana
        );
    }

    @Override
    public int ataqueBasico() {
        if (vida > 0 && mana >= 10) {
            System.out.println("Você atacou o inimigo!");
            System.out.println("Seu golpe causou: " + getDanoBase() + " de dano");
            this.mana -= 10;
            return getDanoBase();
        } else {
            if (vida <= 0) {
                System.out.println("Você esta morto!");
            } else if (mana < 10) {
                System.out.println("Você não tem mana suficiente!");
            }
        }
        return 0;
    }

    @Override
    public int usarSkill() {
        int danoSkillFinal = danoBase * 2;
        if (vida > 0 && mana >= 35 && getCooldownSkill() == 0) {
            System.out.printf("%s usou BOLA DE FOGO!", getNome());
            System.out.println();
            System.out.printf("Sua habilidade causou: " + danoSkillFinal + " de dano %n");
            this.mana -= 35;
            this.cooldownSkill = 2;
            return danoSkillFinal;
        } else if (getCooldownSkill() > 0) {
            System.out.println("Skill disponivel em " + getCooldownSkill() + " Rounds");
        } else {
            if (vida <= 0) {
                System.out.println("Você esta morto!");
            } else if (mana < 35) {
                System.out.println("Você não tem mana suficiente!");
            }
        }
        return 0;
    }

    @Override
    public void recuperarRecurso() {
        if (vida > 0 && mana < 120) {
            System.out.println("Recuperando 40 de mana!");

            mana += 40;
            if(mana > 120) {
                mana = 120;
            }

        } else {
            if (mana >= 120) {
                System.out.println("Sua mana está cheia!");
            } else if (vida <= 0) {
                System.out.println("Você esta morto!");
            }
        }
    }

}
