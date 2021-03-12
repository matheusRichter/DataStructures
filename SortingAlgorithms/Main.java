import java.util.*;

public class Main {
    public static void main(String[] args){
        Sorting s = new Sorting();
        Random r = new Random();

        System.out.print("Digite um número: ");
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // array desordenado
        int[] um = new int[t];
        for (int i = 0; i < um.length; i++){
            int randomNumber = r.nextInt((t*t));
            um[i] = randomNumber;
        }
        int dois[]   = um;
        int tres[]   = um;
        int quatro[] = um;
        int cinco[]  = um;
        int seis[]   = um;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // array decrescente:
        int inverso[] = um;
        Arrays.sort(inverso);
        int um_inverso[] = new int[t];
        for (int i = um.length - 1; i >= 0; i--)
            um_inverso[i] = inverso[(t - 1)-i];
        int[] dois_inverso   = um_inverso;
        int[] tres_inverso   = um_inverso;
        int[] quatro_inverso = um_inverso;
        int[] cinco_inverso  = um_inverso;
        int[] seis_inverso   = um_inverso;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // array parcialmente ordenado:
        int parcial[] = um;
        Arrays.sort(parcial, (int)parcial.length/4, (int)parcial.length/2);
        int dois_parcial[] = parcial;
        int tres_parcial[] = parcial;
        int quatro_parcial[] = parcial;
        int cinco_parcial[] = parcial;
        int seis_parcial[] = parcial;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // desordenado:
        long inicio = System.currentTimeMillis();
        s.quick(um);
        long fim = System.currentTimeMillis();
        float quick = (fim - inicio)/1000f;

        long inicio2 = System.currentTimeMillis();
        s.shell(dois);
        long fim2 = System.currentTimeMillis();
        float shell = (fim2 - inicio2)/1000f;

        long inicio3 = System.currentTimeMillis();
        s.heap(tres);
        long fim3 = System.currentTimeMillis();
        float heap = (fim3 - inicio3)/1000f;

        long inicio4 = System.currentTimeMillis();
        s.bitonic(quatro);
        long fim4 = System.currentTimeMillis();
        float bitonic = (fim4 - inicio4)/1000f;

        long inicio5 = System.currentTimeMillis();
        s.radix(cinco);
        long fim5 = System.currentTimeMillis();
        float radix = (fim5 - inicio5)/1000f;

        long inicio6 = System.currentTimeMillis();
        s.pancake(seis);
        long fim6 = System.currentTimeMillis();
        float pancake = (fim6 - inicio6)/1000f;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // ordem decrescente:
        long inicio7 = System.currentTimeMillis();
        s.quick(um_inverso);
        long fim7 = System.currentTimeMillis();
        float quick2 = (fim7 - inicio7)/1000f;

        long inicio8 = System.currentTimeMillis();
        s.shell(dois_inverso);
        long fim8 = System.currentTimeMillis();
        float shell2 = (fim8 - inicio8)/1000f;

        long inicio9 = System.currentTimeMillis();
        s.heap(tres_inverso);
        long fim9 = System.currentTimeMillis();
        float heap2 = (fim9 - inicio9)/1000f;

        long inicio10 = System.currentTimeMillis();
        s.bitonic(quatro_inverso);
        long fim10 = System.currentTimeMillis();
        float bitonic2 = (fim10 - inicio10)/1000f;

        long inicio11 = System.currentTimeMillis();
        s.radix(cinco_inverso);
        long fim11 = System.currentTimeMillis();
        float radix2 = (fim11 - inicio11)/1000f;

        long inicio12 = System.currentTimeMillis();
        s.pancake(seis_inverso);
        long fim12 = System.currentTimeMillis();
        float pancake2 = (fim12 - inicio12)/1000f;

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // parcialmente ordenado:
        long inicio13 = System.currentTimeMillis();
        s.quick(parcial);
        long fim13 = System.currentTimeMillis();
        float quick3 = (fim13 - inicio13)/1000f;

        long inicio14 = System.currentTimeMillis();
        s.shell(dois_parcial);
        long fim14 = System.currentTimeMillis();
        float shell3 = (fim14 - inicio14)/1000f;

        long inicio15 = System.currentTimeMillis();
        s.heap(tres_parcial);
        long fim15 = System.currentTimeMillis();
        float heap3 = (fim15 - inicio15)/1000f;

        long inicio16 = System.currentTimeMillis();
        s.bitonic(quatro_parcial);
        long fim16 = System.currentTimeMillis();
        float bitonic3 = (fim16 - inicio16)/1000f;

        long inicio17 = System.currentTimeMillis();
        s.radix(cinco_parcial);
        long fim17 = System.currentTimeMillis();
        float radix3 = (fim17 - inicio17)/1000f;

        long inicio18 = System.currentTimeMillis();
        s.pancake(seis_parcial);
        long fim18 = System.currentTimeMillis();
        float pancake3 = (fim18 - inicio18)/1000f;
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // tabela:
        System.out.println("Desordenado");
        System.out.println("    quick   : " + quick);
        System.out.println("    shell   : " + shell);
        System.out.println("    heap    : " + heap);
        System.out.println("    bitonic : " + bitonic);
        System.out.println("    radix   : " + radix);
        System.out.println("    pancake : " + pancake);

        System.out.println("Ordem decrescente");
        System.out.println("    quick   : " + quick2);
        System.out.println("    shell   : " + shell2);
        System.out.println("    heap    : " + heap2);
        System.out.println("    bitonic : " + bitonic2);
        System.out.println("    radix   : " + radix2);
        System.out.println("    pancake : " + pancake2);

        System.out.println("Parcialmente ordenado");
        System.out.println("    quick   : " + quick3);
        System.out.println("    shell   : " + shell3);
        System.out.println("    heap    : " + heap3);
        System.out.println("    bitonic : " + bitonic3);
        System.out.println("    radix   : " + radix3);
        System.out.println("    pancake : " + pancake3);
    }
}