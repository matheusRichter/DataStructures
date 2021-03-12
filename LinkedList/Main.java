public class Main {
    public static void main(String[] args) {
        Lista lista1 = new Lista(); // cria uma nova lista com o nome 'lista1'

        // insere itens na 'lista1'
        lista1.insere_ultimo(1); lista1.insere_ultimo(2); lista1.insere_ultimo(5); lista1.insere_ultimo(3);
        lista1.insere_ultimo(4);

        System.out.print("lista 1: ");
        lista1.mostra_lista(); // mostra a 'lista1'

        System.out.println();

        Lista lista2 = new Lista();  // cria uma nova lista com o nome 'lista2'

        // insere itens na 'lista2'
        lista2.insere_ultimo(4); lista2.insere_ultimo(5); lista2.insere_ultimo(2); lista2.insere_ultimo(3);
        lista2.insere_ultimo(1);

        System.out.print("Lista 2: ");
        lista2.mostra_lista(); // mostra a 'lista2'

        System.out.println("\n");

        System.out.println("Cosseno: " + Operacoes.cos(lista1,lista2)); // mostra o resultado da operaçã de cosseno entre 'lista1' e 'lista2'

        System.out.print("intersecao: " );
        Operacoes.intersecao(lista1,lista2).mostra_lista(); // retorna uma terceira lista com os elementos comuns entre 'lista1' e 'lista2'

    }
}
