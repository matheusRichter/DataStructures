import java.lang.Math;
public class Operacoes {

    // soma todos os items de uma lista
    public static int somatorio(Lista x){
        // verifica se a lista está vazia, se não estiver realiza a operação e retorna o resultado
        if(!x.vazia()){
            No percorre = x.primeiro.getProximo(); // variável que percorre a lista
            int acc = 0;                           // acumulador que armazena a soma dos itens
            while (percorre != null){
                acc += Math.pow(percorre.getNumero(),2); // operação da soma do item atual da lista ao quadrado + o valor do acumulador
                percorre = percorre.getProximo();        // faz a variávem 'percorre' avanaçar para o próximo nó
            }
            return acc;       // retorna o resultado da soma
        }else{
            System.err.println("Lista vazia!");  // menssagem de erro
            System.exit(1);
            return 0;
        }
    }

    // soma os itens de x e y multiplicados um pelo outro, desde que as duas listas tenham o mesmo tamanho
    public static int somatorio2(Lista x, Lista y){
        int acc = 0;  // acumulador que armazena o resultado da soma dos itens de 'x' e 'y' multiplicados: (x1 * y1) + ... + (xn * yn)
        // verifica se a lista 'x' está vazia e verifica se o tamanho das listas 'x' e 'y' é o mesmo
        if(!x.vazia() && x.tamanho == y.tamanho){
            No percorrex = x.primeiro.getProximo(); // variável que percorre a lista x
            No percorrey = y.primeiro.getProximo(); // variável que percorre a lista y

            while (percorrex != null){
                acc += percorrex.getNumero() * percorrey.getNumero();  // operação da soma dos itens de mesmo indicie das listas 'x' e 'y'
                percorrex = percorrex.getProximo(); // faz a variavel 'percorrex' avançar para o próximo nó
                percorrey = percorrey.getProximo(); // faz a variavel 'percorrey' avançar para o próximo nó
            }

        }else if(x.tamanho != y.tamanho){
            System.err.println("Listas de tamanho diferentes!"); // messagem de erro para tamanhos diferentes
            //System.exit(1);

        }else{
            System.err.println("Lista vazia!");  // messagem de erro para lista vazia
            System.exit(1);

        }
        return acc; // retorna o resultado da soma
    }

    // retorna o valor do cosseno das listas 'x' e 'y'
    public static double cos(Lista x, Lista y){
        return (somatorio2(x,y))/Math.sqrt(somatorio(x)*somatorio(y));
    }

    // percorre duas listas comparando os valores de cada uma, se houverem valores iguais adiciona-os em uma terceira lista
    public static Lista intersecao(Lista x, Lista y) {
        Lista lista3 = new Lista(); // nova lista que recebera os valores iguais das listas 'x' e 'y'
        // verifica se as listas 'x' e 'y' não estão vazias
        if (!x.vazia() && !y.vazia()) {
            No percorrex = x.primeiro.getProximo(); // variavel que percorre x
            No percorrey = y.primeiro.getProximo(); // variavel que percorre y
           for(int i = 1; i <= x.tamanho; i++) {
               for (int j = 1; j <= y.tamanho; j++){
                   // verifica se os valores de 'x' e 'y' são iguais
                   if(percorrex.getNumero() == percorrey.getNumero()){
                       lista3.insere_ordenado(percorrex.getNumero()); // adiciona o valor de 'x' na 'lista3' se o valor 'x' e 'y' for igual
                   }
                   percorrey = percorrey.getProximo(); // faz a variável 'percorrey' avançar para o próximo nó
               }
               percorrey = y.primeiro.getProximo(); // transforma o primeiro nó de 'y' no nó seguinte
               percorrex = percorrex.getProximo();  // faz a variável 'percorrex' avançar para o próximo nó
            }
        } else {
            System.err.println("Lista vazia!"); // menssagem de erro
            System.exit(1);
        }
        return lista3; // retorna a 'lista3'
    }
}
