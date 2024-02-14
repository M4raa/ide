import java.util.Scanner;

public class MainRefactorizado {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
    public static int[] generarPrimos (int max)
    {
        if (max>=2){
            int vecL = max + 1;
            boolean[] esPrimo = new boolean[vecL];
            for (int i = 0; i < vecL; i++)
                esPrimo[i] = true;
            esPrimo[0] = esPrimo[1] = false;
            for (int i = 0; i < Math.sqrt(vecL)+1 ; i++) {
                if (esPrimo[i]) {
                    for (int j = 2 * i; j < vecL; j += i) {
                        esPrimo[j] = false;
                    }
                }
            }
            int primos = cuentaPrimos(esPrimo);
            return rellenarVector(primos,esPrimo);
        } else {
            return new int[0];
        }

    }
    public static int cuentaPrimos(boolean[] esPrimo){
        int cuenta = 0;
        for (int i=0; i<esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }
    public static int[] rellenarVector(int cuenta, boolean[] esPrimo){
        int[] primos = new int[cuenta];
        for (int i=0, j=0; i< esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }
}
