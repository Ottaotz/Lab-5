package candidato;

public class Candidato {
    private String nome, partido;
    private int idade, votos;

    public Candidato(String nome, String partido, int idade, int votos) {
        this.nome = nome;
        this.partido = partido;
        this.idade = idade;
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIdade() {
        return idade;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", partido='" + partido + '\'' +
                ", idade=" + idade +
                ", votos=" + votos +
                '}';
    }
}
