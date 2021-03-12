public class AVL_int {

    private No raiz;

    // chama inserir(No, No)
    public void inserir(int valor){
        No no = new No(valor);
        inserirAVL(this.raiz,no);
    }

    public void inserirAVL(No atual, No novo){
        if(atual == null){                                      // verifica se 'atual' é null
            this.raiz = novo;                                   // 'raiz' recebe 'novo'
        }else{
            if(novo.getValor_() < atual.getValor_()){           // verifica se o valor de 'novo' é menor que o valor de 'atual'
                if(atual.getEsquerda() == null){                // verifica se o filho esquerdo de 'atual' é null
                    atual.setEsquerda(novo);                    // o filho esquerdo de 'atual' recebe 'novo'
                    novo.setPai(atual);                         // o 'pai' de 'novo' recebe 'atual'
                    veriBalanceamento(atual);                   // calcula o balanceamento de 'atual'
                }else{
                    inserirAVL(atual.getEsquerda(),novo);       // avança para a subárvore esquerda de 'atual'
                }
            }else if(novo.getValor_() >= atual.getValor_()){    // verifica se o valor de 'novo' é maior que o valor de 'atual'
                if(atual.getDireita() == null) {                // verifica se o filho direito de 'atual' é null
                    atual.setDireita(novo);                     // o filho direito de 'atual' recebe 'novo'
                    novo.setPai(atual);                         // o 'pai' de 'novo' recebe 'atual'
                    veriBalanceamento(atual);                   // calcula o balanceamento de 'atual'
                }else{
                    inserirAVL(atual.getDireita(),novo);        // avança para a subárvore direita de 'atual'
                }
            }
        }
    }

    public void veriBalanceamento(No atual){
        setBalanceamento(atual);                                // calcula o balanceamento de 'atual'
        int balanceamento = atual.getFator();                   // balanceamento recebe o fator de 'atual'

        if(balanceamento == -2){                                // verifiica se o balanceamento é -2
            // verifica se a altura do filho esquerdo do filho esquerdo de 'atual' é maior ou igual a do filho esquerdo do fliho direito de 'atual'
            if(altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())){
                atual = rotacaoDireita(atual);                 // 'atual' recebe a rotação simples à direita de 'atual'
            }else{
                atual = duplaRotacaoEsquerdaDireita(atual);            // 'atual' recebe a rotação dupla à esquerda de 'atual'
            }
        }else if(balanceamento == 2){                           // verifica se o balanceamento é 2
            // verifica se a altura do filho direito do filho direito de 'atual' é maior ou igual a altura do filho esquerdo do filho direito de 'atual'
            if(altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())){
                atual = rotacaoEsquerda(atual);                  // 'atual' recebe a rotação simples à esquerda de 'atual'
            }else{
                atual = duplaRotacaoDireitaEsquerda(atual);             // 'atual' recebe a rotação dupla à direita de 'atual'
            }
        }

        if(atual.getPai() != null){                             // verifica se o 'pai' de 'atual' não é null
            veriBalanceamento(atual.getPai());                  // calcula o balanceamento de 'pai' de 'atual'
        }else{
            this.raiz = atual;                                  // 'raiz' recebe 'atual'
        }
    }

    // chama removerVL(No, int)
    public void remover(int valor){
        removerAVL(this.raiz,valor);
    }

    public void removerAVL(No atual,int valor){
        if(atual == null){ // verifica se 'atual' é null
            return;
        }else{
            if(atual.getValor_() > valor){                      // verifica se o valor de 'atual' é maior que 'valor'
                removerAVL(atual.getEsquerda(),valor);          // avança para a subárvore esquerda de 'atual'
            }else if(atual.getValor_() < valor){                // verifica se o valor de 'atual' é menor que 'valor'
                removerAVL(atual.getDireita(),valor);           // avança para a subárvore direita de 'atual'
            }else if(atual.getValor_() == valor){               // verifica se o valor de 'atual' é iguala 'valor'
                removerNo(atual);                               // remove o nó 'atual'
            }
        }
    }

    public void removerNo(No remover){
        No r;

        r = sucessor(remover);                              // 'r' recebe o sucessor de 'remover'
        remover.setValor_(r.getValor_());                   // o valor de 'remover' recebe o valor de de 'r'

        No p;

        if(r.getEsquerda() != null){                            // verifica se o filho esquerdo de 'r' não é null
            p = r.getEsquerda();                                // 'p' recebe o filho esquerdo de 'r'
        }else{
            p = r.getDireita();                                 // 'p' recebe o filho direito de 'r'
        }

        if(p != null){                                          // verifica se 'p' não é de null
            p.setPai(r.getPai());                               // o 'pai' de 'p' recebe o 'pai' de 'r'
        }

        if(r.getPai() == null){                                 // verifica se o 'pai' de 'r' é null
            this.raiz = p;                                      // 'raiz' recebe 'p'
        }else{
            if(r == r.getPai().getEsquerda()){
                r.getPai().setEsquerda(p);                      // o filho esquerdo do 'pai' de 'r' recebe 'p'
            }else{
                r.getPai().setDireita(p);                       // o filho direito do 'pai' de 'r' recebe 'p'
            }
        }
        r = null;
    }

    public No rotacaoEsquerda(No inicial){
        No direita = inicial.getDireita();                     // 'direita' recebe o filho direito de 'inicial'
        direita.setPai(inicial.getPai());                      // o 'pai' de 'esquerda' recebe o 'pai' de 'inicial'

        inicial.setDireita(direita.getEsquerda());             // o filho direito de 'inicial' recebe o filho esquerdo de 'direita'

        if(inicial.getDireita() != null){                      // verifica se o filho direito de 'inicial' não é null
            inicial.getDireita().setPai(inicial);              // o 'pai' do filho direito de 'inicial' recebe 'incial'
        }

        direita.setEsquerda(inicial);                          // o filho esquerdo de 'direita' recebe 'inicial'
        inicial.setPai(direita);                               // o 'pai' de 'inicial' recebe 'direita'

        if(direita.getPai() != null){                          // verifica se o 'pai' de 'direita' não é null
            if(direita.getPai().getDireita() == inicial){      // verifica se o filho direito do 'pai' de 'direita' é igual a 'inicial'
                direita.getPai().setDireita(direita);          // o filho direito do 'pai' de 'direita' recebe
            }else if(direita.getPai().getEsquerda() == inicial){ // verifica se o filho esquerdo do 'pai' de 'direita' é igual a inicial
                direita.getPai().setEsquerda(direita);         // o filho esquerdo do 'pai' de 'direita' recebe 'direita'
            }
        }

        setBalanceamento(inicial);              // calcula o balanceamento de 'incial'
        setBalanceamento(direita);              // calcula o balanceamento de 'direita'

        return direita;

    }

    public No rotacaoDireita(No inicial) {
        No esquerda = inicial.getEsquerda();                // 'esquerda' recebe o filho esquerdo de 'inicial'
        esquerda.setPai(inicial.getPai());                  // o 'pai' de 'esquerda' recebe o 'pai' de 'inicial'

        inicial.setEsquerda(esquerda.getDireita());         // o filho esquerdo de 'inicial' recebe o filho direito de 'esquerda'

        if(inicial.getEsquerda() != null) {                 // verifica se o filho esquerdo de 'inicial' não é null
            inicial.getEsquerda().setPai(inicial);          // o 'pai' do filho esquerdo de 'inicial' recebe 'inicial'
        }

        esquerda.setDireita(inicial);                       // o filho direito de 'esquerda' recebe 'inicial'
        inicial.setPai(esquerda);                           // o 'pai' de 'inicial' recebe 'esquerda'

        if(esquerda.getPai() != null) {                     // verifica se o 'pai' de 'esquerda' não é null

            if(esquerda.getPai().getDireita() == inicial) { // verifica se o filho direito do 'pai' de esquerda é igual a 'inicial
                esquerda.getPai().setDireita(esquerda);     // o filho direito do 'pai' de 'esquerda' recebe 'esquerda'

            } else if(esquerda.getPai().getEsquerda() == inicial) { // verifica se o filho esquerdo do 'pai' de 'esquerda' é igual a 'inicial'
                esquerda.getPai().setEsquerda(esquerda);    // o filho esquerdo do 'pai' de 'esquerda' recebe 'esquerda'
            }
        }

        setBalanceamento(inicial);                  // calcula o balanceamento de 'inicial'
        setBalanceamento(esquerda);                 // calcula o balanceamento de 'esquerda'

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial){
        /*
        o filho esquerdo de 'inicial' recebe a rotação simples para a esquerda do filho esquerdo de 'inicial'
         */
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);                     // rotação simples a direita de 'inicial'
    }

    public No duplaRotacaoDireitaEsquerda(No inicial){
        /*
        o filho direito de 'inicial' recebe a rotação simples para a direita do filho direito de 'inicial'
         */
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);                    // rotação simples para a esquerda de 'inicial'
    }

    public No sucessor(No q){
        if(q.getDireita() != null){                        // verifica se o filho direito de 'q' não é null
            No r = q.getDireita();                         // 'r' recebe o filho direito de 'q'
            while(r.getEsquerda() != null){
                r = r.getEsquerda();                       // 'r' recebe o filho esquerdo de 'r'
            }
            return r;
        }else{
            No p = q.getPai();                             // 'p' recebe o 'pai' de 'q'
            while(p != null && q == p.getDireita()){
                q = p;                                     // 'q' recebe 'p'
                p = q.getPai();                            // 'p' recebe o 'pai' de 'q'
            }
            return p;
        }
    }

    // função que calcula a altura da árvore
    public int altura(No atual){
        if(atual == null){ // verifica se 'atual' é igual a null
            return -1;
        }

        // verifica se o filho esquerdo de 'arvore' é null e se o filho direito é null
        if(atual.getEsquerda() == null && atual.getDireita() == null){
            return 0;

        }else if(atual.getEsquerda() == null){             // verifica se o filho esquerdo de 'atual' é null
            return 1 + altura(atual.getDireita());         // retorna a altura do filho direito de 'atual' + 1

        }else if(atual.getDireita() == null){              // verifica se o filho direito de 'atual' é null
            return 1 + altura(atual.getEsquerda());        // retorna a altura do filho esquerdo de 'atual' + 1

        }else{
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    // função que calcula o balanceamento de um nó
    public void setBalanceamento(No no) {
        // o fator de 'no' recebe a dirença entre as altura de suas subárvores
        no.setFator(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    // função que chama encontrar(No,int)
    public boolean encontrar(int valor){

        return encontrar(this.raiz,valor);
    }

    // função que encontra um nó com determinado valor
    public boolean encontrar(No atual,int valor){
        if(atual.getValor_() == valor){                 // verifica se o valor de 'atual' é igual a 'valor'
            return true;
        }
        // verifica se 'valor' é maior que o valor de 'atual' e se o filho direito de 'atual' não é null
        if(valor > atual.getValor_() && atual.getDireita() != null){
            return encontrar(atual.getDireita(),valor); // avança para a subárvore diretia de 'altual'
        }
        // verifica se 'valor' é menor que o valor de 'atual' e se o filho esquerdo de 'atual' não é null
        else if(valor < atual.getValor_() && atual.getEsquerda() != null){
            return encontrar(atual.getEsquerda(),valor); // avança para a subárvore esquerda de 'altual'
        }
        return false;
    }

    // função que chama preordem(No)
    public void preordem(){
        No arvore = raiz;
        preordem(arvore);
    }

    // finção que mostra os elementos da árvore em pré-ordem
    public void preordem(No arvore) {
        System.out.print(arvore.getValor_() + " ");             // print de um elemento da árvore

        if (arvore.getEsquerda() != null) {                     // verifica se o filho esquerdo de 'arvore' não é null
            preordem(arvore.getEsquerda());                     // avança para a subárvore esquerda de 'arvore'
        }

        if (arvore.getDireita() != null) {                      // verifica se o filho direito de 'arvore' não é null
            preordem(arvore.getDireita());                      // avança para a subárvore direita de 'arvore'
        }
    }

    //função que chama emordem(No)
    public void emordem(){
        No arvore = raiz;
        emordem(arvore);
    }

    // função que mostra os elemetos da árvore em ordem
    public void emordem(No arvore) {
        if (arvore.getEsquerda() != null) {                     // verifica se o filho esquerdo de 'arvore' não é null
            emordem(arvore.getEsquerda());                      // avança para a subárvore esquerda de 'arvore'
        }

        System.out.print(arvore.getValor_() + " ");             // print de um elemento da árvore

        if (arvore.getDireita() != null) {                      // verifica se o filho direito de 'arvore' não é null
            emordem(arvore.getDireita());                       // avança para a subárvore direita de 'arvore'
        }
    }

    // função que chama posordem(No)
    public void posordem(){
        No arvore = raiz;
        posordem(arvore);
    }

    // função que mostra os elementos da árvore em pós-ordem
    public void posordem(No arvore) {
        if (arvore.getEsquerda() != null) {                     // verifica se o filho esquerdo de 'arvore' não é null
            posordem(arvore.getEsquerda());                     // avança para a subárvore esquerda de 'arvore'
        }

        if (arvore.getDireita() != null) {                      // verifica se o filho direito de 'arvore' não é null
            posordem(arvore.getDireita());                      // avança para a subárvore direita de 'arvore'
        }

        System.out.print(arvore.getValor_() + " ");             // print de um elemento da árvore
    }
}