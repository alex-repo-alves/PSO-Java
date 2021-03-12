package teste;

public class FitnessFunction {

    public double getFitness(double[] particlePosition) {
        double f = 0;
        double somatorio = 0;
        double produtorio = 0;
        double soma = 0;
        
            /*
            //Função Esfera
            for(int i = 0; i<particlePosition.length; i++){
                f = f + Math.pow(particlePosition[i], 2);
            }
            
            //Função Rosenbrock
            for(int i = 0; i<particlePosition.length-1; i++){
                f = f + (100*Math.pow(particlePosition[i+1]-Math.pow(particlePosition[i], 2), 2)+Math.pow(particlePosition[i]-1, 2));
            }
            
            //Função Griewank
            for(int i = 0; i<particlePosition.length; i++){
                somatorio = somatorio + Math.pow(particlePosition[i], 2);
            }
            produtorio = Math.cos(particlePosition[0]/(Math.sqrt(1)));
            for(int i = 1; i<particlePosition.length; i++){
                produtorio = produtorio * Math.cos(particlePosition[i]/(Math.sqrt(i+1)));
            }
            f = (1.0/4000.0)*somatorio - produtorio + 1;
            
            
            //Função Rastrigin
            for(int i = 0; i<particlePosition.length; i++){
                f = f + (Math.pow(particlePosition[i], 2)-10*Math.cos(2*Math.PI*particlePosition[i])+10);
            }
         

        //Função Ackley
        
        for (int i = 0; i < particlePosition.length; i++) {
            somatorio = somatorio + Math.pow(particlePosition[i], 2);
        }
        for (int i = 0; i < particlePosition.length; i++) {
            soma = soma + Math.cos(2 * Math.PI * particlePosition[i]);
        }
        f = -20 * Math.exp(-0.2 * Math.sqrt((1.0 / particlePosition.length) * somatorio))
                - Math.exp(1.0 / particlePosition.length * soma) + 20 + Math.exp(1);
        

        //Função Noisy Quartic
        for (int i = 0; i < particlePosition.length; i++) {
            f = f + Math.pow(particlePosition[i], 4);
        }
        f = f + Math.random();
         
        */
        //Função Zakharov
        for (int i = 0; i < particlePosition.length; i++) {
            f = f + Math.pow(particlePosition[i], 2);
        }
        for (int i = 0; i < particlePosition.length; i++) {
            somatorio = somatorio + (0.5*(i+1)*particlePosition[i]);
        }
        f = f + Math.pow(somatorio, 2);
        for (int i = 0; i < particlePosition.length; i++) {
            somatorio = somatorio + (0.5*(i+1)*particlePosition[i]);
        }
        f = f + Math.pow(somatorio, 4);
        
        /*
        //Função Hiper Elipsoide Rotacionada
        for (int i = 0; i < particlePosition.length; i++) {
            for (int j = 0; j <= i; j++) {
                f = f + Math.pow(particlePosition[j], 2);
            }
        }
        
        
        //Função Alpine
        for (int i = 0; i < particlePosition.length; i++) {
            f = f+Math.abs(particlePosition[i]*Math.sin(particlePosition[i])+(0.1*particlePosition[i]));
        }
        
        
        //Função Salomon
        for (int i = 0; i < particlePosition.length; i++) {
            somatorio = somatorio + Math.pow(particlePosition[i],2);
        }
        
        f = 1-Math.cos(2*Math.PI*Math.sqrt(somatorio))+0.1*Math.sqrt(somatorio);
        
            
            */
        return f;
    }

}
