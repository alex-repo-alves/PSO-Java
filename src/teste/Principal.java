package teste;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Principal extends JFrame {
    
    public static int iteracoes, particulas,enxames;
    public static double[] media, melhores, desvioPadrao;

    public Principal(int a){
        
    }
    
    public Principal() {
        setSize(800, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        iteracoes = 100;
        particulas = 100;
        enxames = 1;
        media = new double[iteracoes];
        melhores = new double[iteracoes];
        desvioPadrao = new double[iteracoes];

        Multiswarm multiswarm = new Multiswarm(enxames, particulas, new FitnessFunction());
        for (int j = 0; j < iteracoes; j++) {
            multiswarm.mainLoop();
            //System.out.println(multiswarm.getBestFitness());
            media[j] = getMediaAritmetica(multiswarm);
            melhores[j]  = multiswarm.getBestFitness();
            desvioPadrao[j] = getDesvioPadrao(multiswarm);
            
            System.out.print((j+1)+"ª iteração: ");
            for (int i = 0; i < multiswarm.getBestPosition().length; i++) {
                System.out.print(multiswarm.getBestPosition()[i] + "  ");
            }
            System.out.println("");
            System.out.println(multiswarm.getBestFitness());
            
        }
        System.out.println("");
        imprimeDados();
        //new Principal();
        

    }
    public static void imprimeDados() {
        //System.out.println("Fitness médio");
        for (int i = 0; i < iteracoes; i++) {
            System.out.print((media[i] + " ").replaceAll("\\.", ","));
        }
        System.out.println("");
        for (int i = 0; i < iteracoes; i++) {
            System.out.print((melhores[i] + " ").replaceAll("\\.", ","));
        }
        System.out.println("");
        for (int i = 0; i < iteracoes; i++) {
            System.out.print((desvioPadrao[i] + " ").replaceAll("\\.", ","));
        }
        System.out.println("\n");
    }
    
    public static double getVariancia(Multiswarm multiswarm) {
        double p1 = 1 / Double.valueOf( (particulas*enxames) - 1);
        double p2 = getSomaDosElementosAoQuadrado(multiswarm)
                - (Math.pow(getSomaDosElementos(multiswarm), 2) / Double
                .valueOf(particulas*enxames));
        return p1 * p2;
    }
    private static double getSomaDosElementos(Multiswarm multiswarm) {
        double total = 0;
        for (int counter = 0; counter < enxames; counter++) {
            for (int i = 0; i < particulas; i++) {
                total += multiswarm.getSwarms()[counter].getParticles()[i].getFitness();
            }

        }
        return total;
    }
    public static double getDesvioPadrao(Multiswarm multiswarm) {
        return Math.sqrt(getVariancia(multiswarm));
    }
    private static double getSomaDosElementosAoQuadrado(Multiswarm multiswarm) {
        double total = 0;
        for (int counter = 0; counter < enxames; counter++) {
            for (int i = 0; i < particulas; i++) {
                total += Math.pow(multiswarm.getSwarms()[counter].getParticles()[i].getFitness(),2);
            }

        }
        return total;
    }
    public static double getMediaAritmetica(Multiswarm multiswarm) {
        double total = 0;
        int contador = 0;
        for (int i = 0; i < multiswarm.getSwarms().length; i++) {
            for (int counter = 0; counter < multiswarm.getSwarms()[i].getParticles().length; counter++) {
                total = total + multiswarm.getSwarms()[i].getParticles()[counter].getFitness();
                contador++;
            }
        }
        
        return total / contador;
    }
    
    public static double getMediaAritmetica(double[][] matriz) {
        double total = 0;
        for (int counter = 0; counter < matriz.length; counter++) {
            for(int i = 0; i<matriz[0].length;i++)
            total += matriz[counter][i];
        }
        return total / (matriz.length*matriz[0].length);
    }

    public static double getDesvioPadrao(double[][] matriz) {
        return Math.sqrt(getVariancia(matriz));
    }

    public static double getVariancia(double[][] matriz) {
        double p1 = 1 / Double.valueOf((matriz.length*matriz[0].length) - 1);
        double p2 = getSomaDosElementosAoQuadrado(matriz)
                - (Math.pow(getSomaDosElementos(matriz), 2) / Double
                .valueOf(matriz.length*matriz[0].length));
        return p1 * p2;
    }
    private static double getSomaDosElementosAoQuadrado(double[][] matriz) {
        double total = 0;
        
        for (int counter = 0; counter < matriz.length; counter++) {
            for(int i = 0; i<matriz[0].length;i++)
            total += Math.pow(matriz[counter][i],2);
        }
        return total;
    }
    
    private static double getSomaDosElementos(double[][] matriz) {
        double total = 0;
        for (int counter = 0; counter < matriz.length; counter++) {
            for(int i = 0; i<matriz[0].length;i++)
            total += matriz[counter][i];
        }
        return total;
    }
    
     public static double[][] matrizF6(int tamMatriz, double maxXY) {// tamMatriz deve ser ímpar por causa do 0
        double unidade = maxXY / ((tamMatriz - 1) / 2);
        int x = 0;
        int y = ((tamMatriz - 1) / 2);
        double[] particlePosition = new double[2];
        double pior = 100;
        double melhor = 0;
        
        double[][] matriz = new double[tamMatriz][tamMatriz];
        for (int i = 0; i < tamMatriz; i++) {
            x = -((tamMatriz - 1) / 2);
            for (int j = 0; j < tamMatriz; j++) {
                particlePosition[0] = (x * unidade);
                particlePosition[1] =  (y * unidade);
                matriz[i][j] = new FitnessFunction().getFitness(particlePosition);
                //System.out.print(matriz[i][j]+" ");
                x++;
                
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
        System.out.println("Zero: "+(((pior+6.04949632633156)/6.04949632633156)/1.0672302736416044));
        System.out.println("Max: "+(((melhor+6.04949632633156)/6.04949632633156)/1.0672302736416044));
        return matrizNormal;
        */
        return matriz;
    }

    @Override
    public void paint(Graphics g) {
        int tamMat = 601;
        double maxXY = 1000;
        double[][] funcao = new double[tamMat][tamMat];
        float[][] plano = new float[tamMat][tamMat];
        g.drawRect(49, 49, tamMat + 1, tamMat + 1);
        funcao = matrizF6(tamMat, maxXY);

        for (int i = 0; i < tamMat; i++) {
            for (int j = 0; j < 50; j++) {
                g.setColor(Color.getHSBColor((float) ((0.6666667 / tamMat) * i), 1.0f, 1.0f));
                g.drawLine(tamMat + 100 + j, 50 + i, tamMat + 100 + j, 50 + i);
            }
        }
        

        for (int i = 0; i < plano.length; i++) {
            for (int j = 0; j < plano[0].length; j++) {
                plano[i][j] = (float) (0.6666667 - (((funcao[j][i]+1000000)/1001620.0) * 0.6666667));
            }
        }
        

        for (int i = 0; i < plano.length; i++) {
            for (int j = 0; j < plano[0].length; j++) {
                g.setColor(Color.getHSBColor(plano[i][j], 1.0f, 1.0f));
                g.drawLine(50 + i, 50 + j, 50 + i, 50 + j);
                if(plano[i][j]==0.0){
                    g.fillOval(50 + (int) Math.round(((tamMat / (maxXY * 2)) * 0) + 300.5) - 5, 50 + (int) Math.round(((tamMat / (maxXY * 2)) * -40) + 300.5) - 5, 10, 10);
                }
            }
        }

        //g.setColor(Color.BLACK);
        //g.fillOval(50 + (int) Math.round(((tamMat / (maxXY * 2)) * 0) + 300.5) - 5, 50 + (int) Math.round(((tamMat / (maxXY * 2)) * -40) + 300.5) - 5, 10, 10);

        /*for (int a = 0; a < pop.length; a++) {
            if (retornaXY(pop[a].cromossomo)[0] > -maxXY && retornaXY(pop[a].cromossomo)[0] < maxXY
                    && retornaXY(pop[a].cromossomo)[1] > -maxXY && retornaXY(pop[a].cromossomo)[1] < maxXY) {
                g.setColor(Color.BLACK);
                g.fillOval(50 + (int) Math.round(((tamMat / (maxXY * 2)) * retornaXY(pop[a].cromossomo)[0]) + 300.5) - 5, 50 + (int) Math.round(((tamMat / (maxXY * 2)) * -retornaXY(pop[a].cromossomo)[1]) + 300.5) - 5, 10, 10);
            }

        }
        if (retornaXY(melhor.cromossomo)[0] > -maxXY && retornaXY(melhor.cromossomo)[0] < maxXY
                && retornaXY(melhor.cromossomo)[1] > -maxXY && retornaXY(melhor.cromossomo)[1] < maxXY) {
            g.setColor(Color.WHITE);
            g.fillOval(50 + (int) Math.round(((tamMat / (maxXY * 2)) * retornaXY(melhor.cromossomo)[0]) + 300.5) - 5, 50 + (int) Math.round(((tamMat / (maxXY * 2)) * -retornaXY(melhor.cromossomo)[1]) + 300.5) - 5, 10, 10);
        }*/
    }

}
