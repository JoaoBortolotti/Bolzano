import java.util.Scanner;

public class Main {
    
    private static Scanner scr = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Qual valor máximo do seu expoente?");
        int exp = scr.nextInt() + 1;

        System.out.println("Qual o expoente do Épsilon da sua função?");
        System.out.print("10^-");
        int epsl = scr.nextInt();
        epsl = -epsl;
        
        double valor[] = new double[exp];
        double variacoes[] = new double[11];
        
        /*Pegando os valores dos expoentes*/
        if(exp <= 11){
            for (int i = 0; i < valor.length; i++){
                System.out.println("Insira o valor do x^" + i);
                valor[i] = scr.nextDouble();                  
            }
        }else{
            System.out.println("O expoente deve ser menor que 11");
            System.exit(0); 
        }  

        /*Printando o valor dos expoentes*/
        for (int i = 0; i < valor.length ; i ++){
            System.out.println("x^" + i + " = " + valor[i]);
        }

        /*Calculando "X" das Funções*/
        for(int x = 0; x <= 10; x++){
            int a = x-5;
            double resultado = 0;
            for (int i = 0; i < valor.length; i++){
                resultado += Math.pow(a, i) * valor[i];
            }
            variacoes[x] = resultado;
            System.out.println("Valor de x = " + a + " : " + variacoes[x]);
        }

        /*Capturando Intervalos */
    }
}
