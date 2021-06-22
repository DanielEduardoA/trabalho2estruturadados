Trabalho apresentado para a disciplina Estrutura de dados pelos alunos: Daniel Eduardo Costa de Almeida e Ângelo Gabriel Lopes

A classe ProdutoService é uma classe a implementação que contém a lógica de negócio relacionado ao produto. Contém os métodos: 
* cadastrarProduto método que lê do teclado o nome do produto
* cadastrarPeca método que lê do teclado o nome da peça, q sua quantidade. Caso a peça possua mais componentes e realizada uma chamada recursiva para cadastrar os componentes da peça e o valor da peça e calculado utilizando o valor de cada peça que é componente da peça multiplicando pela quantidade de cada peça que é componente da peça e caso a peça não possua componentes é lido do teclado o valor da peça
* calcularCustoTotal método que calcula o custoTotal do produto. Caso a arvore só possua um nó o custo total é o valor armazenado neste nó.  Caso contrário o custo total do produto é calculado através do somatório dos valores dos nos internos já previamente calculados multiplicando pela quantidade 
* possuiComponentes método que lê do teclado se a peça possui ou não componentes
* cadastrarComponentes método que cadastra componentes para uma peça enquanto o usuário digitar que a peça possui mais componentes.
* calcularValor método calcula o custo total através do somatório dos valores dos nos internos já previamente calculados multiplicando pela quantidade de peças
* lerValorPeca método que lê do teclado o valor da peça
    
    
A classe ArvoreGenerica é a classe de modelo que contém o nó raiz.

A classe Nó é a classe de modelo que contém o dado que será armazenado este campo é do tipo Object para possibilitar armazenador dados genéricos que podem ser do tipo Peca ou Produto e uma lista de nós representa os nós filhos. Esta lista de filhos pode ter um número variável de nós. Esta classe além dos métodos get e set tem os métodos efolha que valida se um nó folha, ou seja, quando ele não possui filhos, o método temfilhos que verifica se um nó tem nós filhos, método buscarDescendentesSemFilhos que traz todos os nós folhas da árvore.

A classe Peça é a classe de modelo que contém os dados do nome da peça, valor da peça e quantidade.

A classe Produto é a classe de modelo que contém os dados do nome do produto, custo total.

A classe main contém os métodos: 
* adicionarNos este método chama o método cadastrarPeca da classe ProdutoService enquanto o usuário digitar que um produto possui mais componentes
* calcularCustoTotal este método chama o método calcularCustoTotal da classe ProdutoService ProdutoService para calcular o custo total do produto.
* listarFolhas este método lista todos os nós folhas da árvore.
