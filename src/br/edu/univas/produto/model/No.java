package br.edu.univas.produto.model;

import java.util.ArrayList;
import java.util.List;

public class No {

    private Object dado;
    private List<No> filhos;

    public No() {}

    public No(Object dado, List<No> filhos) {
        this.dado = dado;
        this.filhos = filhos;
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }

    public List<No> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<No> filhos) {
        this.filhos = filhos;
    }

    public Peca getPeca() {
        return (Peca) this.getDado();
    }

    public boolean eFollha() {
        return this.getFilhos() == null || this.getFilhos().isEmpty();
    }

    public boolean temFilhos() {
        return this.getFilhos() != null && !this.getFilhos().isEmpty();
    }

    public List<No> buscarDescendentesSemFilhos() {
        List<No> nos = new ArrayList<>();
        for (No n : this.getFilhos()) {
            if (n.temFilhos()) {
                // tem filhos, procura pelos descendentes recursivamente e adiciona na lista
                nos.addAll(n.buscarDescendentesSemFilhos());
            } else {
                // não tem filhos, adiciona na lista
                nos.add(n);
            }
        }
        return nos;
    }
}
