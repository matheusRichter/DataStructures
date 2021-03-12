public class Pilha {

    int maximo; String[] pilha; int topo;

    public Pilha(int tamanho){
        this.maximo = tamanho; this.pilha = new String[maximo]; this.topo = -1;
    }

    String topo( ){return pilha[topo];}         // mostra elemento no topo da pilha

    boolean vazia() {return topo == -1;}          // verifica se a pilha está vazia

    boolean cheia() {return topo == maximo -1;}   // verifica se a pilha está cheia

    void empilha(String n) {pilha[++topo] = n;}   // adiciona um elemento à pilha

    String desempilha() {return pilha[topo--];}   // retira o elemento que está no topo da pilha

    //mostra todas as posições da pilha, mesmo que estejam vazios
    void mostrar(){
        for (int i = 0; i < this.pilha.length; i++) {System.out.print(this.pilha[i]+", ");}
        System.out.println("\n");
    }
}