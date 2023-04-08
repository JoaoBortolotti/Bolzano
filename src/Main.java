import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
    
private static Scanner scr = new Scanner(System.in);
private double[] valoresDeX;

    public double calcularFuncao(double resp) {
        double result = 0;
        for (int cont = 0; cont < valoresDeX.length; cont++){
            result += Math.pow(resp, cont) * valoresDeX[cont];
        }
        return result;
    }

    public static void main(String[] args) {
        int epsl, exp, contador;
        double resp, result;

        Main func = new Main();

        System.out.println("Qual valor máximo do seu expoente?");
        exp = scr.nextInt() + 1;

        System.out.println("Qual o expoente do Épsilon da sua função?");
        System.out.print("10^-");
        epsl = -scr.nextInt();

        double[] valoresDeX = new double[exp];
        double[] variacoes = new double[11];
        double[] dominio = new double[11];

        /* Pegando os valores dos expoentes */
        if (exp <= 11) {
            for (contador = 0; contador < valoresDeX.length; contador++){
                System.out.println("Insira o valor do x^" + contador);
                valoresDeX[contador] = scr.nextDouble();                  
            }
            func.valoresDeX = valoresDeX; // atribuindo o array de expoentes à variável da classe Main
        } else {
            System.out.println("O expoente deve ser menor que 11");
            System.exit(0); 
        }  

        /* Printando o valor dos expoentes */
        for (contador = 0; contador < valoresDeX.length; contador ++){
            System.out.println("x^" + contador + " = " + valoresDeX[contador]);
        }

        /* Calculando "X" das Funções */
        for (contador = 0; contador <= 10; contador++){
            resp = contador - 5;
            result = func.calcularFuncao(resp);
            variacoes[contador] = result;
        }

        /* Capturando Intervalos */
        for (int i = 1; i < variacoes.length; i++) {
            if ((variacoes[i] > 0 && variacoes[i-1] < 0) || (variacoes[i] < 0 && variacoes[i-1] > 0) || (variacoes[i] == 0 && variacoes[i-1] < 0) || (variacoes[i] < 0 && variacoes[i-1] == 0)) {
                System.out.println("[Houve troca de sinal]");
                        
            }
            System.out.println(variacoes[i]);        
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (int a = 1; a < dominio.length; a++){
            System.out.println(dominio[a]);
        }
        
    }
}

/*
res = (xa-xb)/2
res = Aplica na Função que retorna x;
If(xb > 0){
    xa = xb;
}else if(xb > 0){
    xb = x;
}


 */