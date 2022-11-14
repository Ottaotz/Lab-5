import org.junit.Test;
import org.junit.Before;
import candidato.Candidato;
import tse.Tse;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TseTeste {
    ArrayList<Candidato> candidatos = new ArrayList<>();
    Tse tse;
    @Before
    public void Arraycandidatos() {
        candidatos.add(new Candidato("Candidato1", "12", 68, 56789));
        candidatos.add(new Candidato("Candidato2", "19", 69, 56788));
        candidatos.add(new Candidato("Candidato3", "72", 78, 1402));
        candidatos.add(new Candidato("Candidato4", "10", 61, 7894));
        candidatos.add(new Candidato("Candidato5", "01", 58, 110589));
        candidatos.add(new Candidato("Candidato6", "28", 88, 50404));
        candidatos.add(new Candidato("Candidato7", "21", 78, 40404));
        candidatos.add(new Candidato("Candidato8", "14", 71, 7893));
        candidatos.add(new Candidato("Candidato9", "07", 86, 667));
        candidatos.add(new Candidato("Candidato10", "02", 68, 87354));
    }

    @Before
    public void criaTse() {
        tse = new Tse(candidatos);
    }

    @Test
    public void deveRetornarCandidatoMaisVotado() {
        int actual = tse.listaMaisVotado().getVotos(), expected = 110589;

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarCandidatoMenosVotado() {
        int actual = tse.listaMenosVotado().getVotos(), expected = 667;

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarCandidatoMaisNovo() {
        int actual = tse.listaMaisNovo().getIdade(), expected = 58;

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarCandidatoMaisVelho() {
        int maisVelho = tse.listaMaisVelho().getIdade(), expected = 88;

        assertEquals(expected, maisVelho);
    }

    @Test
    public void deveRetornarTotalVotos() {
        int actual = tse.totalDeVotos(), expected = 420184;

        assertEquals(expected, actual);
    }

    @Test
    public void deveRetornarMediaVotos() {
        double actual =   Math.round(tse.mediaDeVotos());
        double expected = 100;

        assertEquals(expected, actual, 0);
    }
}
