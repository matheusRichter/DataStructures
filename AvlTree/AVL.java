/*

    Árvore AVL para String

 */

public class AVL {

    private No raiz; // varaivel que recebe a raiz da árvore

    // função de inserir, que chama a função inserirAVL
    public void inserir(String valor, int arquivo){
        No no = new No(valor);
        inserirAVL(this.raiz,no,arquivo);
    }

    //função de inserir com balanceamento
    public void inserirAVL(No atual, No novo, int arquivo){
        // 'atual' é a raiz da árvore ou sub árvore; 'novo' é o nó a ser inserido; 'arquivo' é o nº do arquivo que a palavra está
        if(atual == null){                                                  // verifica se o nó 'atual' é nulo
            this.raiz = novo;                                               // se 'atual' for nulo, raiz recebe nulo
            if (arquivo == 1) novo.setA1(novo.getA1() + 1);                 // altera a quantidade de vezez que a palvrava aparece no a1
            else if (arquivo == 2) novo.setA2(novo.getA2() + 1);            // altera a quantidade de vezez que a palvrava aparece no a2
        }
        else if (encontrar(novo.getValor()) != true){                       // verifica se o nó a ser adicionado ainda não existe na árvore
            if(novo.getValor().charAt(0) < atual.getValor().charAt(0)){     // verifica se o valor do char(0) de 'novo' for menor que o char(0) de 'atual'
                if(atual.getEsquerda() == null){                            // verifica se o nó filho à esquerda de 'atual' é null
                    atual.setEsquerda(novo);                                // faz o nó filho esquerdo de 'atual' receber o nó 'novo'
                    novo.setPai(atual);                                     // faz 'novo' receber 'atual' como pai
                    veriBalanceamento(atual);                               // verifica o balancemento de 'atual'
                    if (arquivo == 1) novo.setA1(novo.getA1() + 1);         // altera a quantidade de vezez que a palvrava aparece no a1
                    else if (arquivo == 2) novo.setA2(raiz.getA2() + 1);    // altera a quantidade de vezez que a palvrava aparece no a2
                }else{
                    inserirAVL(atual.getEsquerda(),novo, arquivo); // avança para a subárvore à esquerda
                }
            }else if(novo.getValor().charAt(0) > atual.getValor().charAt(0)){ // verifica se o valor do char(0) de 'novo' for maior que o char(0) de 'atual'
                if(atual.getDireita() == null) { // verifica se o filho direito de 'atual' é null
                    atual.setDireita(novo);
                    novo.setPai(atual);// faz atual receber 'novo' como filho direito
                    veriBalanceamento(atual);    // verifica o balanceamento de 'atual'
                    if (arquivo == 1) novo.setA1(novo.getA1() + 1); // altera a quantidade de vezez que a palvrava aparece no a1
                    else if (arquivo == 2) novo.setA2(novo.getA2() + 1); // altera a quantidade de vezez que a palvrava aparece no a2
                }else{
                    inserirAVL(atual.getDireita(),novo, arquivo); // avança para a subárvore à direita
                }
            }else{
                // O Nó ja existe
                if (arquivo == 1) atual.setA1(atual.getA1() + 1); // altera a quantidade de vezez que a palvrava aparece no a1
                else if (arquivo == 2) atual.setA2(atual.getA2() + 1); // altera a quantidade de vezez que a palvrava aparece no a2
            }
        }
    }

    // função para verificar o balanceamento do nó
    public void veriBalanceamento(No atual){
        setBalanceamento(atual); // calcula o balanceamento do nó atual
        int balanceamento = atual.getFator(); // faz 'balanceamento' receber o fator de 'atual'

        if(balanceamento == -2){ // verifica se o balanceamento de 'atual' é -2
            // verifica se a altura da subárvore esquerda é maior ou igual a da subárvore direita
            if(altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())){
                atual = rotacaoDireita(atual); // faz o nó 'atual' receber a rotação para direita de 'atual'
            }else{
                atual = duplaRotacaoEsquerdaDireita(atual); // faz o nó 'atual' receber a rotação dupla para esquerda de 'atual'
            }
        }else if(balanceamento == 2){ // verifica se o balanceamento de 'atual' é 2
            // verifica se a altura da subárvore direita é maior ou igual a da subárvore esquerda
            if(altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())){
                atual = rotacaoEsquerda(atual); // faz o nó 'atual' receber a rotação para esquerda de 'atual'
            }else{
                atual = duplaRotacaoDireitaEsquerda(atual); // faz o nó 'atual' receber a rotação dupla para direita de 'atual'
            }
        }

        if(atual.getPai() != null){ // verifica se o nó 'pai' de 'atual' não é null
            veriBalanceamento(atual.getPai()); // verifica o balanceamento do 'pai' de 'atual'
        }else{
            this.raiz = atual; // 'raiz' recebe 'atual'
        }
    }

    // função de remover, que chama a função removerAVL
    public void remover(String valor){
        removerAVL(this.raiz,valor);
    }

    // função de remover, que chama a função removerNo
    public void removerAVL(No atual,String valor){
        if(atual == null){ // verifica se o nó 'atual' é null
            return;
        }else{
            // verifica se o valor do char(0) do nó 'atual' é maior que o char(0) de 'valor'
            if(atual.getValor().charAt(0) > valor.charAt(0)){
                removerAVL(atual.getEsquerda(),valor); // avança para a subárvore esquerda de 'atual'
            }
            // verifica se o valor do char(0) do nó 'atual' é maior que o char(0) de 'valor'
            else if(atual.getValor().charAt(0) < valor.charAt(0)){
                removerAVL(atual.getDireita(),valor); // avança para a subárvore direita de atual
            }
            // verifica se o valor do char(0) do nó 'atual' é igual ao char(0) de 'valor'
            else if(atual.getValor() == valor){
                removerNo(atual); // remove o nó com 'valor'
            }
        }
    }

    // função de remover
    public void removerNo(No remover){
        No r;

        // verifica se os filhos à direita e à esquerda no nó 'remover' são null
        if(remover.getEsquerda() == null && remover.getDireita() == null){
            if(remover.getPai() == null){ // verifica se o nó 'pai' de 'remover' é null
                this.raiz = null; // faz com que 'raiz' receba null
                remover = null;   // faz com que 'remover' receba null
                return;
            }
            r = remover; // 'r' recebe 'remover'
        }else{
            r = sucessor(remover); // 'r' recebe o sucessor de 'remover'
            remover.setValor(r.getValor()); // o 'valor' de 'remover' recebe o 'valor' de 'r'
        }

        No p;

        if(r.getEsquerda() != null){ // verifica se o filho esquerdo de 'r' não é null
            p = r.getEsquerda(); // 'p' recebe o filho esquerdo de 'r'
        }else{
            p = r.getDireita(); // 'p' recebe o filho direito de 'r'
        }

        if(p != null){ // verifica se 'p' não é null
            p.setPai(r.getPai()); // o nó 'pai' de 'p' recebe o nó 'pai' de 'r'
        }

        if(r.getPai() == null){ // verifica se o 'pai' de 'r' é null
            this.raiz = p; // 'raiz' recebe p
        }else{
            if(r == r.getPai().getEsquerda()){ // verifica se 'r' é igual ao filho esquerdo de 'pai'
                r.getPai().setEsquerda(p); // o filho esquerdo do 'pai' de 'r' recebe 'p'
            }else{
                r.getPai().setDireita(p); // o filho direito do 'pai' de 'r' recebe 'p'
            }
        }
        r = null; // 'r' recebe null
    }

    // função de rotação simples para a esquerda
    public No rotacaoEsquerda(No inicial){
        No direita = inicial.getDireita(); // 'direita' recebe o filho direitor de 'inicial'
        direita.setPai(inicial.getPai());  // o 'pai' de 'direita' recebe o 'pai' de 'inicial'

        inicial.setDireita(direita.getEsquerda()); // o filho direito de 'inicial' recebe o filho esquerdo de 'direita'

        if(inicial.getDireita() != null){ // verifica se o filho direito de 'inicial' não é null
            inicial.getDireita().setPai(inicial); // o 'pai' do filho direito de 'inicial' recebe 'inicial'
        }

        direita.setEsquerda(inicial); // o filho esquerdo de 'direita' recebe 'inicial'
        inicial.setPai(direita);      // o 'pai' de inicial recebe 'direita'

        if(direita.getPai() != null){ // verifica se o 'pai' de 'direita' não é null
            if(direita.getPai().getDireita() == inicial){ // verifica se o filho direito do 'pai' de 'direita' é igual 'inical'
                direita.getPai().setDireita(direita);     // o filho direito do 'pai' de 'direita' recebe 'direita'
            }else if(direita.getPai().getEsquerda() == inicial){ // verifica se o filho esquerdo do 'pai' de 'direita' é igual 'inicial'
                direita.getPai().setEsquerda(direita); // o filho esquerdo do 'pai' de 'direita' recebe 'direita'
            }
        }

        setBalanceamento(inicial); // calcula o balanceamento de 'inicial'
        setBalanceamento(direita); // calcula o balanceamento de 'direita'

        return direita;

    }

    // função de rotação simples para a direita
    public No rotacaoDireita(No inicial) {
        No esquerda = inicial.getEsquerda(); // 'esquerda' recebe o filho esquerdo de 'inicial'
        esquerda.setPai(inicial.getPai());   // o 'pai' de 'esquerda' recebe o 'pai' de 'inicial'

        inicial.setEsquerda(esquerda.getDireita());  // o filho esquerdo de 'inicial' recebe o filho direito de 'esquerda'

        if(inicial.getEsquerda() != null) { // verifica se o filho esquerdo de 'inicial' não é null
            inicial.getEsquerda().setPai(inicial); // o 'pai' do filho esquerdo de 'inicial' recebe 'inicial'
        }

        esquerda.setDireita(inicial); // o filho direito de 'esquerda' recebe 'inicial'
        inicial.setPai(esquerda);     // o 'pai' de 'inicial' recebe 'esquerda'

        if(esquerda.getPai() != null) { // verifica se o 'pai' de 'esquerda' não é null

            if(esquerda.getPai().getDireita() == inicial) { // verifica se o filho direito do 'pai' de 'esquerda' é igual a 'inicial'
                esquerda.getPai().setDireita(esquerda); // o filho direito do 'pai' de 'esquerda' recebe 'esquerda'

            } else if(esquerda.getPai().getEsquerda() == inicial) { // verifica se o filho esquerdo do 'pai' de 'esquerda' é igual a 'inicial'
                esquerda.getPai().setEsquerda(esquerda); // o filho esquerdo do 'pai' de 'esquerda' recebe 'esquerda'
            }
        }

        setBalanceamento(inicial); // calcula o balanceamento de 'inicial'
        setBalanceamento(esquerda);// calcula o balanceamento de 'esquerda'

        return esquerda;
    }

    // finção de rotação dupla para a esquerda
    public No duplaRotacaoEsquerdaDireita(No inicial){
        /*
        o filho esquerdo de 'inicial' recebe a rotação simples para a esquerda do filho esquerdo de 'inicial'
         */
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
            return rotacaoDireita(inicial); // rotação simples a direita de 'inicial'
    }

    // finção de rotação dupla para a direita
    public No duplaRotacaoDireitaEsquerda(No inicial){
        /*
        o filho direito de 'inicial' recebe a rotação simples para a direita do filho direito de 'inicial'
         */
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial); // rotação simples para a esquerda de 'inicial'
    }

    public No sucessor(No q){
        if(q.getDireita() != null){ // verifica se o filho direito de 'q' não é null
            No r = q.getDireita();  // 'r' recebe o filho direito de 'q'
            while(r.getEsquerda() != null){
                r = r.getEsquerda(); // 'r' recebe o filho esquerdo de 'r'
            }
            return r;
        }else{
            No p = q.getPai(); // 'p' recebe o 'pai' de 'q'
            while(p != null && q == p.getDireita()){
                q = p; // 'q' recebe 'p'
                p = q.getPai(); // 'p' recebe o 'pai' de 'q'
            }
            return p;
        }
    }

    // função que calcula a altura da árvore
    public int altura(No atual){
        if(atual == null){ // verifica se 'atual' é igual a null
            return -1;
        }

        // verifica se o filho esquerdo de 'atual' é igual a null e se o filho direito de 'atual' é igual a null
        if(atual.getEsquerda() == null && atual.getDireita() == null){
            return 0;

        }else if(atual.getEsquerda() == null){ // verifica se o filho esquerdo de 'atual' é null
            return 1 + altura(atual.getDireita()); // retorna a altura do filho direito de 'atual' + 1

        }else if(atual.getDireita() == null){ // verifica se o filho direito de 'atual' é null
            return 1 + altura(atual.getEsquerda()); // retorna a altura do filho esquerdo de 'atual' + 1

        }else{
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    // função que calcula o balanceamento de um nó
   public void setBalanceamento(No no) {
       no.setFator(altura(no.getDireita()) - altura(no.getEsquerda())); // o fator de 'no' recebe a diferença as alturas de suas subárvores
   }

   // função que chama preordem(No)
   public void preordem(){
        No arvore = raiz;
        preordem(arvore);
   }

   // função que mostra os elementos da árvore em pré-ordem
   public void preordem(No arvore) {
       System.out.print(arvore.getValor() + " "); // print do valor de um nó

       if (arvore.getEsquerda() != null) { // verifica se o filho esquerdo de 'arvore' não é null
           preordem(arvore.getEsquerda()); // avança para a subárvore esquerda de 'arvore'
       }

       if (arvore.getDireita() != null) { // verifica se o filho direito de 'arvore' não é null
           preordem(arvore.getDireita()); // avança para a subárvore direita de 'arvore'
       }
   }

   // função que chama emordem(No)
   public void emordem(){
       No arvore = raiz;
       emordem(arvore);
   }

   // função que mostra o elementos da árvore em ordem
   public void emordem(No arvore) {
       if (arvore.getEsquerda() != null) { // verifica se o filho esquerdo de 'arvore' não é null
           emordem(arvore.getEsquerda()); // avança para a subárvore esquerda de 'arvore'
       }

       System.out.print(arvore.getValor() + " "); // print de um elemento da árvore

       if (arvore.getDireita() != null) { // verifica se o filho direito de 'arvore' não é null
           emordem(arvore.getDireita()); // avança para a subárvore direita de 'arvore'
       }
   }

   // função que chama posordem(No)
   public void posordem(){
        No arvore = raiz;
        posordem(arvore);
   }

   // função que mostra os elementos da árvore em pós-ordem
   public void posordem(No arvore) {
       if (arvore.getEsquerda() != null) { // verifica se o filho esquerdo de 'arvore' não é null
           posordem(arvore.getEsquerda()); // avança para a subárvore esquerda de 'arvore'
       }

       if (arvore.getDireita() != null) { // verifica se o filho direito de 'arvore' não é null
           posordem(arvore.getDireita()); // avança para a subárvore direita de 'arvore'
       }

       System.out.print(arvore.getValor() + " "); // print de um elemento da árvore
   }

   // função que mostra os elemento da árvore, o total de vezes em que aparecem e quantas vezes aparecem em cada arquivo
   public void relatorio(No arvore){
        // print de um elemento e suas aparições
       System.out.println("Palavra: " + arvore.getValor() + " | Total: " + (arvore.getA1() + arvore.getA2()) + " | Arquivo 1: " + arvore.getA1() + " | Arquivo 2: " + arvore.getA2());
       if (arvore.getEsquerda() != null) { // verifica se o filho esquerdo de 'arvore' não é null
            relatorio(arvore.getEsquerda()); // avança para a subárvore esquerda de 'arvore'
       }
       if (arvore.getDireita() != null) { // verifica se o filho direito de 'arvore' não é null
            relatorio(arvore.getDireita()); // avança para a subárvore direita de 'arvore'
       }
   }

   // função que chama relatorio(No)
   public void relatorio(){
       No arvore = raiz;
       relatorio(arvore);
   }

   // função que chama encontra(No,String)
   public boolean encontrar(String valor){

        return encontrar(this.raiz,valor);
    }

   // função que encontra um nó com determinado valor
   public boolean encontrar(No atual,String valor){
        if(atual.getValor() == valor){ // verifica se o valor de 'atual' é igual a 'valor'
            return true;
        }
        // verifica se o char(0) de 'valor' é maior que char(0) do valor de 'atual' e se o filho direito de 'atual' não é null
        if((valor.charAt(0) > atual.getValor().charAt(0)) && (atual.getDireita() != null)){
            return encontrar(atual.getDireita(),valor); // avança para a subárvore direita de 'atual'

        }
        // verifica se o char(0) de 'valor' é menor que o char(0) do valor de 'atual'
        else if(valor.charAt(0) < atual.getValor().charAt(0) && atual.getEsquerda() != null){
            return encontrar(atual.getEsquerda(),valor); // avança para a subárvore esquerda de 'atual'
        }
        return false;
   }
}