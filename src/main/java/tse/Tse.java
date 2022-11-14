package tse;

import candidato.Candidato;
import candidato.IdadeComparator;
import candidato.VotoComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Tse {
    private ArrayList<Candidato> candidatos;

    public Tse(ArrayList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Candidato listaMaisVotado() {
        return listaPorVoto().get(0);
    }

    public Candidato listaMenosVotado() {
        ArrayList<Candidato> lista = listaPorVoto();
        return lista.get(lista.size()-1);
    }

    public Candidato listaMaisNovo() {
        ArrayList<Candidato> lista = listaPorIdade();
        return lista.get(lista.size()-1);
    }

    public Candidato listaMaisVelho() {
        return listaPorIdade().get(0);
    }

    public int totalDeVotos() {
        return somaVotos();
    }

    public float mediaDeVotos() {
        return somaMedia(calculaMedia());
    }

// UI
//    private StringBuilder calculaMedia() {
//        StringBuilder strVotos = new StringBuilder("Média de Votos\n\n");
//        for (Candidato candidato : candidatos) {
//            double votos = (candidato.getVotos() * 100f) / somaVotos();
//            strVotos.append(candidato.getNome()).append(String.format(" %.2f", votos)).append("\n");
//        }
//        return strVotos;
//    }

    private List<Float> calculaMedia() {
        List<Float> votos = new ArrayList<>();
        for (Candidato candidato : candidatos)
            votos.add((candidato.getVotos() * 100f) / somaVotos());
        return votos;
    }

    private float somaMedia(List votos) {
        float totalVotos = 0;
        for (Object voto : votos)
            totalVotos += (float) voto;
        return totalVotos;
    }

    private int somaVotos() {
        int total = 0;
        for (Candidato candidato : candidatos)
            total += candidato.getVotos();
        return total;
    }

    private ArrayList<Candidato> listaPorVoto() {
        return ordena(candidatos, new PriorityQueue<>(1, comparator(0)));
    }

    private ArrayList<Candidato> listaPorIdade() {
        return ordena(candidatos, new PriorityQueue<>(1, comparator(1)));
    }

    private ArrayList<Candidato> ordena(ArrayList<Candidato> candidatos, PriorityQueue<Candidato> queue) {
        for (Candidato candidato : candidatos)
            queue.add(candidato);
        return passaParaArray(queue);
    }

    private ArrayList<Candidato> passaParaArray(PriorityQueue<Candidato> queue) {
        ArrayList<Candidato> temp = new ArrayList<>();
        while (!queue.isEmpty())
            temp.add(queue.poll());
        return temp;
    }

    private Comparator<Candidato> comparator(int cod) {
        Comparator<Candidato> comparador;
        switch (cod) {
            case 1 -> comparador = new IdadeComparator();
            default -> comparador = new VotoComparator();
        }
        return comparador;
    }
}
