package br.edu.univas.produto.model;

public class ArvoreGenerica {

    private No raiz;

    public ArvoreGenerica() {
        raiz = new No();
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

}