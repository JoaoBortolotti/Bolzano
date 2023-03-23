import java.util.*;

public class Main {
    private static Scanner scr = null;
    
    public static void main(String[] args) {
        scr = new Scanner(System.in);
        int a =0;
        int x = 0;
        System.out.println("Qual o maior expoente da sua função?");
        int exp = scr.nextInt();
        int[] valor = new int[exp];
        
        if (exp <= 11) {
            for (int i = 0; i <= exp; i++) {
                System.out.println("Insira o valor do x^" + i);
                valor[i] = scr.nextInt() +(x^i);
                System.out.println("x^" + i + " = " + valor[i]);
            }

        } else {
            System.out.println("O expoente deve ser menor ou igual a 10");
        }
    }
}