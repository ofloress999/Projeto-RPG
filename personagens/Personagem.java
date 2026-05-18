package personagens;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int danoBase;
    protected int defesa;
    protected int nivel;
    protected int bonusDano;
    protected int cooldownSkill;

    // Constructor
    public Personagem(String nome, int vida, int danoBase, int defesa, int nivel, int bonusDano) {
        this.nome = nome;
        this.vida = vida;
        this.danoBase = danoBase;
        this.defesa = defesa;
        this.nivel = nivel;
        this.bonusDano = bonusDano;
        this.cooldownSkill = 0;
    }

    // Methods
    public abstract String mostrarStatus();

    public abstract int ataqueBasico();

    public abstract int usarSkill();

    public abstract void recuperarRecurso();

    public void receberDano(int dano) {
        int danoFinal = dano - defesa;
        if (this.defesa > dano) {
            danoFinal = 1;
            vida -= danoFinal;
        } else {
            vida -= danoFinal;
        }
    };

    public void reduzirCooldown() {
        if(cooldownSkill > 0) {
            cooldownSkill--;
        }
    }


    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getCooldownSkill() {
        return cooldownSkill;
    }

    public void setCooldownSkill(int cooldownSkill) {
        this.cooldownSkill = cooldownSkill;
    }
}
