import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        AVL_int arvore = new AVL_int();
        AVL a = new AVL();

        TXT one = new TXT("C:\\TXT\\A1.txt");  // abre um arquivo
        String line = one.read();                   // lê o aquivo e gera uma string com o conteúdo
        line = line.replace(",", ";"); // substitui todas as ',' por ';'
        line = line.replace(".", ";"); // substitui todas os '.' por ';'
        line = line.replace(";", "");  // substitui todas as ';' po ''
        String[] s = line.split(" ");        // gera um vetor com as palavras do arquivo que estiverem separadas por ' '

        TXT two = new TXT("C:\\TXT\\A2.txt");
        String linha = two.read();
        linha = linha.replace(",", ";");
        linha = linha.replace(".", ";");
        linha = linha.replace(";", "");
        String[] r = linha.split(" ");

        for(String str : s){
            a.inserir(str,1);
        }
        for(String str : r){
            a.inserir(str,2);
        }
        /*
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(7);
        arvore.inserir(11);
        arvore.inserir(12);
        */
        //arvore.emordem();

        //arvore.remover(11);
        System.out.println();
        //arvore.emordem();
        System.out.println();
        a.relatorio();
    }
}