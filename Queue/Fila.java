public class Fila {

    private int maximo;
    private int[] fila;
    private int fim;
    private int inicio;
    private int contador;

    public Fila(int tamanho){
        this.maximo = tamanho;
        this.fila = new int[maximo];
        this.fim = -1;
        this.inicio = 0;
        this.contador = 0;
    }

    // mostra o primeiro elemento da fila
    public int primeiro(){
        if(vazia()){
            System.out.println("Fila vazia, não é possivel verificar");
            System.exit(1);
        }
        return fila[inicio];
    }

    public int ultimo(){
        if(vazia()){
            System.out.println("Fila vazia, não é possivel verificar");
            System.exit(1);
        }
        return fila[fim];
    }


    // verifica se a fila está vazia
    public boolean vazia(){
        return tamanho() == 0;
    }

    // verifica se a fila está cheia
    public boolean cheia(){
        return tamanho() == maximo;
    }

    // adiciona um elemento no final fila
    public void adicionar(int item)
    {
        if(cheia()){
            System.out.println("fila cheia, impossivel adicionar");
            System.exit(1);
        }
        fim = (fim + 1) % maximo;
        fila[fim] = item;
        contador ++;
    }

    // retira o elemento que está na frente da fila
    public void retirar(){
        if(vazia()){
            System.out.println("fila esta vazia, impossivel remover");
            System.exit(1);
        }
        inicio = (inicio + 1) % maximo;
        contador --;
        System.out.println("item removido: " + fila[inicio]);
    }

    // mostra o tamanho da fila
    public int tamanho(){
        return contador;
    }

    // mostra todos os elementos da fila
    public void mostrar(){
        System.out.print("[");
        for (int i = 0; i < fila.length; i++) {System.out.print(fila[i]+", ");}
        System.out.println("]");
    }

    // a partir de duas filas ordenadas, cria uma terceira fila ordenado com os elementos das anteriores
    public void merge(Fila a,Fila b, Fila c){
        while (!c.cheia()){
            if(a.vazia()){
                c.adicionar(b.primeiro());
            }
            else if(b.vazia()){
                c.adicionar(a.primeiro());
            }
            else if(a.primeiro() < b.primeiro()){
                System.out.println("Remove o número da fila a");
                c.adicionar(a.primeiro());
                a.retirar();
            }
            else{
                System.out.println("Remove o número da fila b");
                c.adicionar(b.primeiro());
                b.retirar();
            }
        }
    }
}
