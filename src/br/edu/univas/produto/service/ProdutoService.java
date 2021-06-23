package br.edu.univas.produto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.univas.produto.model.No;
import br.edu.univas.produto.model.Peca;
import br.edu.univas.produto.model.Produto;

public class ProdutoService {

    private Scanner scanner = new Scanner(System.in);

    public Produto cadastrarProduto() {
        Produto produto = new Produto();
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        produto.setNome(nome);
        return produto;
    }

    public No cadastrarPeca() {
        Peca peca = new Peca();
        List<No> componentes = new ArrayList<>();
        double valor = 0;

        System.out.println("Digite o nome da peça: ");
        String nome = scanner.nextLine();
        peca.setNome(nome);

        System.out.println("Digite a quantidade de peças: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        peca.setQuantidade(quantidade);

        if (possuiComponentes(nome)) {
            componentes = cadastrarComponentes(nome);
            valor = calcularValor(componentes);
        } else {
            valor = lerValorPeca();
        }

        peca.setValor(valor);
        return new No(peca, componentes);
    }

    public double calcularCustoTotal(No no) {
        double valor = 0;
        if (no.eFollha()) {
            valor = no.getPeca().getValor();
        } else {
            valor = calcularValor(no.getFilhos());
        }
        return valor;
    }
    
    public boolean possuiComponentes(String nome) {
        System.out.println(nome + " possui componentes S(sim) ou N(Não): ");
        String compostaPorSubPecas = scanner.next();
        scanner.nextLine();
        return compostaPorSubPecas.equalsIgnoreCase("S");
    }

    private List<No> cadastrarComponentes(String nomePeca) {
        List<No> componentes = new ArrayList<>();
        do {
            No componente = cadastrarPeca();
            componentes.add(componente);
        } while (possuiComponentes(nomePeca));

        return componentes;
    }

    private double calcularValor(List<No> nos) {
        double valor = 0;
        for (No filho : nos) {
            Peca peca = filho.getPeca();
            valor += peca.getValor() * peca.getQuantidade();
        }
        return valor;
    }

    private double lerValorPeca() {
        System.out.println("Digite o valor de peça: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    
}