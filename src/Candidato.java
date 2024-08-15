
public class Candidato {
    private String nome;
    private double valor;
    private String atendeu;

    public Candidato(String nome, double valor, String atendeu) {
        this.nome = nome;
        this.valor = valor;
        this.atendeu = atendeu;
    }

     // Construtor secundário com 'atendeu' não obrigatório
     public Candidato(String nome, double valor) {
        this(nome, valor, "aguardando ligação"); // Define 'atendeu' como false por padrão
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String atendeuLigacao() {
        return atendeu;
    }

    public void setAtendimento(String atendido) {
        atendeu = atendido;
    }

    @Override
    public String toString() {
        return "{nome => '" + nome + "', valor => " + valor + "}";
    }
}
