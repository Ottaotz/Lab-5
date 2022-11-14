package candidato;

import java.util.Comparator;

public class IdadeComparator implements Comparator<Candidato> {
    @Override
    public int compare(Candidato o1, Candidato o2) {
        if (o1.getIdade() > o2.getIdade()) return -1;
        else if (o1.getIdade() < o2.getIdade()) return 1;
        return 0;
    }
}
