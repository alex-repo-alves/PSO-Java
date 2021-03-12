
import java.util.Random;

public class Teste {

    public static void main(String[] args) {
        double[] particlePosition = { 200000,  1 };
        double somatorio = 0;
        double produtorio = 0;
        double f = 0;
        for(int i = 0; i<particlePosition.length; i++){
                somatorio = somatorio + Math.pow(particlePosition[i], 2);
            }
            produtorio = Math.cos(particlePosition[0]/(Math.sqrt(1)));
            for(int i = 1; i<particlePosition.length; i++){
                produtorio = produtorio * Math.cos(particlePosition[i]/(Math.sqrt(i+1)));
            }
            f = (1/4000)*somatorio - produtorio + 1;
            
            System.out.println(f);
        //matriz(601, 1000);
        //double[][] x = new double[5][5];
        //System.out.println(x[0].length);

    }

    public static double[][] matriz(int tamMatriz, double maxXY) {// tamMatriz deve ser ímpar por causa do 0
        double unidade = maxXY / ((tamMatriz - 1) / 2);
        int x = 0;
        int y = ((tamMatriz - 1) / 2);
        long[] particlePosition = new long[2];
        double pior = 100;
        double melhor = 0;

        double[][] matriz = new double[tamMatriz][tamMatriz];
        for (int i = 0; i < tamMatriz; i++) {
            x = -((tamMatriz - 1) / 2);
            for (int j = 0; j < tamMatriz; j++) {
                particlePosition[0] = (long) (x * unidade);
                particlePosition[1] = (long) (y * unidade);
                matriz[i][j] = new LolFitnessFunction().getFitness(particlePosition);
                //System.out.print(matriz[i][j]+" ");
                x++;
                if (matriz[i][j] < pior) {
                    pior = matriz[i][j];
                }
                if (matriz[i][j] > melhor) {
                    melhor = matriz[i][j];
                }

            }
            y--;
            //System.out.println("");
        }
        /*
        double[][] matrizNormal = new double[tamMatriz][tamMatriz];
        
        Principal p = new Principal(x);
        int contador = 0;
        double media = p.getMediaAritmetica(matriz);
        double desvio = p.getDesvioPadrao(matriz);
        for (int i = 0; i < tamMatriz; i++) {
            for (int j = 0; j < tamMatriz; j++) {
                matrizNormal[i][j] = (matriz[i][j]-media)/desvio;
                
                if (matrizNormal[i][j]<pior){
                    pior = matrizNormal[i][j];
                }
                if (matrizNormal[i][j]>melhor){
                    melhor = matrizNormal[i][j];
                }
                double novobestfitness = 0;
                if (novobestfitness < matrizNormal[i][j]) {
                    novobestfitness = matrizNormal[i][j];
                  
                }
                contador++;
            }
        }
        System.out.println("Pior: "+(long)pior+" "+pior);
        System.out.println("Melhor: "+(long)melhor+" "+melhor);
        System.out.println("melhor-pior: "+(long)(melhor-pior));
        System.out.println("Zero: "+(((pior+6.04949632633156+6)/6.04949632633156)/1.0672302736416044));
        System.out.println("Max: "+(((melhor+6.04949632633156)/6.04949632633156)/1.0672302736416044));
        return matrizNormal;

         */

        System.out.println("Pior: " + (long) pior + " " + pior);
        System.out.println("Melhor: " + (long) melhor + " " + melhor);
        System.out.println("melhor-pior: " + (long) (melhor - pior));
        System.out.println("Zero: " + ((pior + 1000000) / 1001620.0));
        System.out.println("Max: " + ((melhor + 1000000) / 1001620.0));
        return matriz;
    }

    public static double log(double base, double valor) {
        return Math.log(valor) / Math.log(base);
    }
}
