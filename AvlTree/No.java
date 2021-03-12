public class No {

    private String valor; // valor do nó se for string
    private int valor_;   // valor do nó se for int
    private int fator;    // fator de balanceamento do nó
    private int a1 = 0;   // quantidade de vezes que uma palavra apareceu no arquivo 1
    private int a2 = 0;   // quantidade de vezes que uma palavra apareceu no arquivo 2
    private No esquerda;  // ponteiro para o nó à esquerda
    private No direita;   // ponteiro para o nó à direita
    private No pai;       // ponteiro para o nó pai


    // contrutor para No de string
    public No(String valor){
        setValor(valor);
        setEsquerda(setDireita(setPai(null)));
    }

    // contrutor para nó de int
    public No(int valor){
        setValor_(valor);
        setEsquerda(setDireita(setPai(null)));
    }

    // retorna o valor de um nó int
    public int getValor_() {return valor_;}

    // faz um nó int receber ou ter seu valor alterado
    public void setValor_(int valor_) {this.valor_ = valor_;}

    // faz um nó string receber ou ter seu valor alterado
    public void setValor(String valor){this.valor = valor;}

    // faz o nó receber ou ter seu fator de balanceamento ser alterado
    public void setFator(int fator){this.fator = fator;}

    // faz um nó receber ou seu ponteiro para o nó à direita alterado
    public No setDireita(No direita){this.direita = direita; return direita;}

    // faz um nó receber ou seu ponteiro para o nó à esquerda alterado
    public void setEsquerda(No esquerda){this.esquerda = esquerda;}

    // faz um nó receber ou seu ponteiro para o nó pai alterado
    public No setPai(No pai) {this.pai = pai; return pai;}

    // retorna o valor de um nó string
    public String getValor(){return valor;}

    // retorna o fator de balanceamento de um nó
    public int getFator(){return fator;}

    // retorna o nó filho à direita do nó
    public No getDireita(){return direita;}

    // retorna o nó filho à esquerda do nó
    public No getEsquerda(){return esquerda;}

    // retorna o nó pai
    public No getPai() {return pai;}

    // retorna o número de vezes que a palvra de um nó string apareceu no arquivo 1
    public int getA1(){ return this.a1;}

    // faz o nó receber ou alterar o número de vezes que uma palavra apareceu no arquivo 1
    public void setA1(int n){this.a1 = n;}

    // retorna o número de vezes que a palvra de um nó string apareceu no arquivo 2
    public int getA2(){return this.a2;}

    // faz o nó receber ou alterar o número de vezes que uma palavra apareceu no arquivo 2
    public void setA2(int n){ this.a2 = n;}
}