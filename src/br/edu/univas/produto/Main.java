package br.edu.univas.produto;

import java.util.ArrayList;
import java.util.List;

import br.edu.univas.produto.model.ArvoreGenerica;
import br.edu.univas.produto.model.No;
import br.edu.univas.produto.model.Produto;
import br.edu.univas.produto.service.ProdutoService;

public class Main {

    private static ProdutoService service = new ProdutoService();

    public static void main(String[] args) {

        Produto produto = service.cadastrarProduto();
        No raiz = new No();
        raiz.setDado(produto);

        List<No> filhos = adicionarNos(produto.getNome());
        raiz.setFilhos(filhos);

        ArvoreGenerica arvore = new ArvoreGenerica();
        arvore.setRaiz(raiz);

        double custoTotal = calcularCustoTotal(arvore);
        System.out.println("O custo total produto é: " + custoTotal);

        System.out.println("Os nós folhas são: ");
        List<No> folhas = raiz.buscarDescendentesSemFilhos();
        listarFolhas(folhas);
    }

    private static List<No> adicionarNos(String nomeProduto) {
        List<No> nos = new ArrayList<No>();
        do {
            No no = service.cadastrarPeca();
            nos.add(no);
        } while (service.possuiComponentes(nomeProduto));
        return nos;
    }

    private static double calcularCustoTotal(ArvoreGenerica arvore) {
        return service.calcularCustoTotal(arvore.getRaiz());
    }

    private static void listarFolhas(List<No> folhas) {
        for (No no : folhas) {
            System.out.println("Peça: " + no.getPeca().getNome());
        }
    }
}