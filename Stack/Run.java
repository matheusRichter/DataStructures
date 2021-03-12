public class Run {
    public static void main(String[] args){
        Pilha a = new Pilha(6);

        Verificador v = new Verificador(a);

        a.mostrar();
        if(v.expressao("{[()]}")) {
            System.out.println("Expressao validada!");
        } else {
            System.out.println("Expressao invalida!");
        }
    }
}