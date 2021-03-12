public interface FitnessFunction {

	/**
	 * Returns the fitness of a particle given its position.
	 * 
	 * @param particlePosition
	 *            the position of the particle
	 * @return the fitness of the particle
	 */
	public double getFitness(long[] particlePosition);

}