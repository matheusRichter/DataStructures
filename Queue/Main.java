public class Main {
    public static void main(String[] args){
        Fila a = new Fila(4);
        Fila b = new Fila(5);

        a.adicionar(12); a.adicionar(35); a.adicionar(52); a.adicionar(64);

        b.adicionar(5); b.adicionar(15); b.adicionar(23); b.adicionar(55); b.adicionar(75);

        a.mostrar();
        b.mostrar();

        Fila c = new Fila(a.tamanho() + b.tamanho());
        c.merge(a,b,c);
        c.mostrar();
    }
}