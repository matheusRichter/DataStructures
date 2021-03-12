public class No {
    private int numero; // valor atribuido ao nó
    private No proximo; // referência ao próximo nó

    public No() {
    }

    public int getNumero() {return numero;} //retorna o número que está no nó atual

    public No getProximo() {
        return proximo;
    } // retorna o nó que está na sequência

    public void setNumero(int numero) {
        this.numero = numero;
    } // altera o número que está no nó atual

    public void setProximo(No proximo) {
        this.proximo = proximo;
    } // altera o número do nó que está na sequência

}
