import java.util.Scanner;

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
    
    public int lerInt(String texto) {
        int result;
        System.out.println(texto);
        result = scr.nextInt();
        System.out.println();
        return result;
    }

    public double lerDouble(String texto) {
        System.out.println(texto);
        return scr.nextDouble();
    }

    public double lerEpsilon()
    {
        int value = this.lerInt("Qual o expoente do Épsilon da sua função? \n 1x10^-");

        return 1 * Math.pow(10, -value);
    }

    public static void main(String[] args) {
        int exp, contador, min, max, nmin = 0, a = 0;
        double epsl;
        double result;
        boolean parada = true;
    
        Main func = new Main();
    
        min = func.lerInt("Qual Mínimo de Valores?");
    
        if(min < 0){
            nmin = Math.abs(min) + 1;
        }else{
            nmin = min + 1;
        }
    
        max = func.lerInt("Qual Máximo de Valores?");
        exp = 1 + func.lerInt("Qual o valor máximo do seu expoente?");
        epsl = func.lerEpsilon();

        
        double[] valores = new double[max + nmin];
        double[] valoresDeX = new double[exp];
        double[] variacoes = new double[11];
        double[] dominioB = new double[22];
        double[] dominioA = new double[22];
    
        /*Alimentando Array*/
        for (contador = 0; contador < valores.length; contador++){
            valores[contador] = min;
            min++;
        }
    
        /* Pegando os valores dos expoentes */
        if (exp <= 11) {
            for (contador = 0; contador < valoresDeX.length; contador++){
                System.out.println("Insira o valor do x^" + contador);
                valoresDeX[contador] = scr.nextDouble();
                System.out.println();                  
            }
            func.valoresDeX = valoresDeX; // atribuindo o array de expoentes à variável da classe Main
        } else {
            System.out.println("O expoente deve ser menor que 11");
            System.exit(0); 
        }  
    
        /*Printando o valor dos expoentes*/
        for (contador = 0; contador < valoresDeX.length; contador++){
            System.out.println("x^" + contador + " = " + valoresDeX[contador]);
        }
    
        /* Calculando "X" das Funções */
        for (contador = 0; contador < valores.length; contador++){
            result = func.calcularFuncao(valores[contador]);
            variacoes[contador] = result;
            System.out.println(variacoes[contador]);
        }
    
        // Capturando Intervalos
        for (contador = 1; contador < variacoes.length; contador++) {
            if ((variacoes[contador] > 0 && variacoes[contador - 1] < 0) || (variacoes[contador] < 0 && variacoes[contador - 1] > 0) || (variacoes[contador] == 0 && variacoes[contador - 1] < 0) || (variacoes[contador] < 0 && variacoes[contador - 1] == 0)) {
                if(variacoes[contador]>= 0 && variacoes[contador-1]<= 0){
                    dominioA[a] = valores[contador];
                    dominioB[a] = valores[contador-1];
                    ++a;
                }else if(variacoes[contador]<= 0 && variacoes[contador-1] >= 0){
                    dominioA[a] = valores[contador-1];
                    dominioB[a] = valores[contador];
                    ++a;
                }
                
                
            }    
        }

        System.out.println("-------------------------------------------------------------------------------------");

        
        /*Print dos Arrays*/

            for(int alet =0 ; alet < dominioA.length; alet++){
            if(dominioA[alet]== 0.0 && dominioB[alet]== 0.0){
            }else{
                System.out.println("{ " + dominioA[alet] + " ; " + dominioB[alet] + " }");  
                System.out.println();

                double xa = dominioA[alet];
                double xb = dominioB[alet];
                double valor, media = (xa+xb)/2;
                double comparacao = 1;

                while(comparacao>epsl) {
                    comparacao = Math.abs(xa-xb);
                    media = (xa+xb) / 2;
                    valor = func.calcularFuncao(media);
                    if(valor > 0){
                        xa = media;
                    }else if(valor < 0){
                        xb = media;
                    }
                    System.out.println("Comparação: " + comparacao);
                    System.out.println(media);
                }
                
            }
        }
    }
}