package candidato;

import java.util.Comparator;

public class VotoComparator implements Comparator<Candidato> {
    @Override
    public int compare(Candidato o1, Candidato o2) {
        if (o1.getVotos() > o2.getVotos()) return  -1;
        else if (o1.getVotos() < o2.getVotos()) return 1;
        return 0;
    }
}
