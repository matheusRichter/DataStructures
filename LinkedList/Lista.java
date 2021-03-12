public class Lista {
    No primeiro;
    No ultimo;
    int tamanho = 0;

    public Lista() {
    }

    public boolean vazia() {
        if (primeiro == null) {return true;} // se o primeiro nó estiver vazio retorna verdadeiro
        else{return false;} // se o primeiro nó não estiver vazio retorna falso
    }

    // se a lista estiver vazia, adiciona um item no primeiro nó
    // se a lista não estiver vazia, adiciona um nó na sequência com o item 'info'
    public void insere_primeiro(int info){
        if(vazia()) {
            primeiro = new No();     // faz com que a variável 'primeiro' vire um novo nó
            ultimo = primeiro;       // cria uma referência de 'último' no primeiro nó
            No novo = new No();      // cria um novo nó que será adicionado como próximo
            novo.setNumero(info);    // altera o valor do nó para o valor de 'info'
            novo.setProximo(null);   // faz o nó referenciar como próximo o valor 'null'
            ultimo.setProximo(novo); // faz a variável 'ultimo' assumir como 'próximo' o valor do nó 'novo'
            ultimo = novo;           // faz o nó novo virar o nó 'ultimo'
            tamanho++;               // almenta uma unidade no tamanho da lista
        }else
            {
            No novo = new No();      // cria um novo nó
            novo.setNumero(info);    // altera o valor do nó de 'null' para o valor de 'info'
            novo.setProximo(primeiro.getProximo()); // altera o valor de 'proximo' do novo nó para o valor de 'proximo' do primeiro nó
            primeiro.setProximo(novo);  // altera o valor de 'proximo' do primeiro nó para uma referêmcia do novo nó
            tamanho++;               // almenta uma unidade no tamanho da lista
        }
    }

    // insere um valor na lista em uma posição 'x' indicada
    public void insere_depois(int x,int info){
        if(!vazia()) {
            No novo = new No();                      // cria um novo nó
            novo.setNumero(info);                    // altera o valor do nó para o valor de 'info'
            No percorre = primeiro.getProximo();     // a variável percorre assume o valor de 'proximo' do nó para percorrer a lista
            while (novo.getProximo() == null){
                if(percorre.getNumero() == x){
                    novo.setProximo(percorre.getProximo());
                    percorre.setProximo(novo);
                    tamanho++;                        // aumenta o tamano da lista em uma unidade
                    break;
                }else if(percorre.getProximo() == null){
                    System.err.println("Nó não encontrado"); // menssagem de erro
                    System.exit(1);
                }
                percorre = percorre.getProximo();  //faz a varável 'percorre' avançar para o próximo nó
            }
        }else {
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
        }
    }

    // insere um item no final da lista
    public void insere_ultimo(int info){
        if(vazia()){
            primeiro = new No();     // faz com que a variável 'primeiro' vire um novo nó
            ultimo = primeiro;       // cria uma referência de 'último' no primeiro nó
            No novo = new No();      // cria um novo nó que será adicionado como próximo
            novo.setNumero(info);    // altera o valor do nó para o valor de 'info'
            novo.setProximo(null);   // faz o nó referenciar como próximo o valor 'null'
            ultimo.setProximo(novo); // faz a variável 'ultimo' assumir como próximo o valor do nó 'novo'
            ultimo = novo;           // faz o nó novo virar o nó 'ultimo'
            tamanho++;               // almenta uma unidade no tamanho da lista
        }else{
            No novo = new No();      // cria um novo nó
            novo.setNumero(info);    // altera o valor do nó de 'null' para o valor de 'info'
            novo.setProximo(null);   // faz com que a variavel 'proximo' de novo assuma o valor 'null'
            ultimo.setProximo(novo); // faz a variável 'ultimo' assumir como 'próximo' o valor do nó 'novo'
            ultimo = novo;           // faz o nó novo virar o nó 'ultimo'
            tamanho++;               // almenta uma unidade no tamanho da lista
        }
    }

    // insere um item na lista de forma ordenada, após um elemento menor, mas antes de um elemento maior
    public void insere_ordenado(int info){
        if(!vazia()){
            No novo = new No();
            novo.setNumero(info);
            No percorre = primeiro.getProximo();
            while (novo != null){
                if(percorre.getProximo() == null){
                    novo.setProximo(null);
                    ultimo.setProximo(novo);
                    ultimo = novo;
                    tamanho++;
                    break;
                }else if(info <= percorre.getProximo().getNumero()){
                    novo.setProximo(percorre.getProximo());
                    percorre.setProximo(novo);
                    tamanho++;
                    break;
                }
                percorre = percorre.getProximo();
            }
        }else{
            primeiro = new No();
            ultimo = primeiro;
            No novo = new No();
            novo.setNumero(info);
            novo.setProximo(null);
            ultimo.setProximo(novo);
            ultimo = novo;
            tamanho++;
        }
    }

    // mostra todos os elementos da lista
    public void mostra_lista(){
        if(!vazia()){
            No percorre = primeiro.getProximo(); // variável que percorre a lista
            while (percorre != null){
                System.out.print(percorre.getNumero()); // mostra o atual item da lista
                percorre = percorre.getProximo(); // faz a variável  'percorre' avançar para o próxima nó
            }
        }else{
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
        }

    }

    // mostra o último elemento da lista
    public int ultimo_elemento(){
        if(!vazia()){
            No percorre = primeiro.getProximo(); // variável que percorre a lista
            while (percorre != null){
                // verifica se o próximo elemento da lista tem valor 'null'
                if(percorre.getProximo() == null){
                    return percorre.getNumero(); // retorna o último elemento antes do valor 'null'
                }
                percorre = percorre.getProximo(); // faz a variável  'percorre' avançar para o próxima nó
            }
        }else{
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
        }
        return 0;
    }

    // retira o primeiro elemento da lista
    public int retira_primeiro(){
        // verifica se a lista não está vazia
        if(!vazia()) {
            No remove = primeiro.getProximo(); // variável que recebe o primeiro nó da lista
            if (primeiro.getProximo() == null) {
                System.out.println("Primeiro elemento removido: " + remove.getNumero());
                int x = remove.getNumero();
                ultimo = primeiro;
                ultimo.setProximo(null);
                remove = null;
                tamanho--;
                return x;
            }else{
                System.out.println("Primeiro elemento removido: " + remove.getNumero());
                int x = remove.getNumero();
                primeiro.setProximo(remove.getProximo());
                remove.setProximo(null);
                remove = null;
                return x;
            }
        }else{
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
            return 0;
        }
    }

    // retira um elemento qualquer da lista
    public int retira_depois(int info){
        if(!vazia()) {
            No remove = primeiro.getProximo();
            No sentinela = primeiro;
            while (remove != null) {
                if (remove.getNumero() == info) {
                    if (remove.getProximo() == null) {
                        System.out.println("Elemento removido: " + remove.getNumero());
                        int x = remove.getNumero();
                        ultimo = sentinela;
                        ultimo.setProximo(null);
                        remove = null;
                        tamanho--;
                        return x;
                    } else {
                        System.out.println("Elemento removido: " + remove.getNumero());
                        int x = remove.getNumero();
                        sentinela.setProximo(remove.getProximo());
                        remove.setProximo(null);
                        remove = null;
                        tamanho--;
                        return x;
                    }
                }else if(remove.getProximo() == null){
                    System.err.println("Nó não encontrado"); //menssagem de erro
                    System.exit(1);
                }
                remove = remove.getProximo();
                sentinela = sentinela.getProximo();
            }
            System.gc();
        }else{
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
        }
        return 0;
    }

    // retira o último elemento da lista
    public int retira_ultimo(){
        if(!vazia()) {
            No remove = primeiro.getProximo();
            No sentinela = remove.getProximo();
            while (remove != null) {
                if (sentinela.getProximo() == null) {
                    System.out.println("Ultimo elemento removido: " + sentinela.getNumero());
                    int x = sentinela.getNumero();
                    ultimo = remove;
                    ultimo.setProximo(null);
                    sentinela = null;
                    tamanho--;
                    return x;
                }
                remove = remove.getProximo(); // faz a variável 'remove' avançar para o próximo nó
                sentinela = sentinela.getProximo(); // faz a variável 'sentinela' avançar para o próximo nó
            }
        }else{
            System.err.println("Lista vazia!"); // menssgem de erro
            System.exit(1);
            return 0;
        }
        return 0;
    }
}