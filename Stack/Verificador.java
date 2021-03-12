public class Verificador {

    Pilha pilha;
    public Verificador(Pilha pilha){this.pilha = pilha;}

    boolean expressao(String expressao){
        for (int i = 0; i < expressao.length(); i++){

            // verifica na expressao se há delimitadores e adiciona-os à pilha
            if(expressao.charAt(i) == '{' || expressao.charAt(i) == '(' || expressao.charAt(i) == '['){
                pilha.empilha(String.valueOf(expressao.charAt(i)));
            }

            //compara os delimitadores de abertura que foram adicionados à pilha com os de fechamento da expressao
            else if(expressao.charAt(i) == ')' || expressao.charAt(i) == ']' || expressao.charAt(i) == '}'){
                pilha.mostrar();
                if(this.pilha.vazia()){return false;}
                else if(expressao.charAt(i) == ')' && pilha.topo().equals("(")) {pilha.desempilha(); continue;}
                else if(expressao.charAt(i) == ']' && pilha.topo().equals("[")) {pilha.desempilha(); continue;}
                else if(expressao.charAt(i) == '}' && pilha.topo().equals("{")) {pilha.desempilha(); continue;}
                return false;
            }
        }
        if(this.pilha.vazia()) return true;
        return false;
    }
}