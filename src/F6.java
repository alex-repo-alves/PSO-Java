public class F6 implements FitnessFunction {

    @Override
    public double getFitness(long[] particlePosition) {
        double f6 = 0.5 - (Math.pow((Math.sin(Math.sqrt(Math.pow(particlePosition[0], 2) + Math.pow(particlePosition[1], 2)))), 2) - 0.5) / Math.pow((1 + 0.001 * (Math.pow(particlePosition[0], 2) + Math.pow(particlePosition[1], 2))), 2);
        return f6;
    }
}