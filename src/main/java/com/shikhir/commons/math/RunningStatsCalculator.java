package com.shikhir.commons.math;

/**
 *  The {@code Accumulator} class is a data type for computing the running
 *  mean, sample standard deviation, and sample variance of a stream of real
 *  numbers. It provides an example of a mutable data type and a streaming
 *  algorithm.
 *  <p>
 *  This implementation uses a one-pass algorithm that is less susceptible
 *  to floating-point roundoff error than the more straightforward
 *  implementation based on saving the sum of the squares of the numbers.
 *  This technique is due to
 *  <a href = "https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm">B. P. Welford</a>.
 *  Each operation takes constant time in the worst case.
 *  The amount of memory is constant - the data values are not stored.
 *  <p>
 *  For additional documentation, 
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class RunningStatsCalculator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)
    private double mu = 0.0;    // sample mean

    /**
     * Initializes an accumulator.
     */
    public RunningStatsCalculator() {
    }

    
    /**
     * Adds the specified data value to the accumulator.
     * @param  x the data value
     */
    public void addDataValue(long x) {
    	addDataValue((double) x);
    }
    
    
    /**
     * Adds the specified data value to the accumulator.
     * @param  x the data value
     */
    public void addDataValue(int x) {
    	addDataValue((double) x);
    }

    
    /**
     * Adds the specified data value to the accumulator.
     * @param  x the data value
     */
    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu  += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    /**
     * Returns the mean of the data values.
     * @return the mean of the data values
     */
    public double mean() {
        return mu;
    }

    /**
     * Returns the sample variance of the data values.
     * @return the sample variance of the data values
     */
    public double var() {
        if (n <= 1) return Double.NaN;
        return sum / (n - 1);
    }

    /**
     * Returns the sample standard deviation of the data values.
     * @return the sample standard deviation of the data values
     */
    public double stddev() {
        return Math.sqrt(this.var());
    }

    /**
     * Returns the number of data values.
     * @return the number of data values
     */
    public int count() {
        return n;
    }

    /**
     * Returns the zscore of the value. A Z-score is a numerical measurement used in statistics of a value's relationship to the mean 
     * (average) of a group of values, measured in terms of standard deviations from the mean. If a Z-score is 0, it indicates 
     * that the data point's score is identical to the mean score. A Z-score of 1.0 would indicate a value that is one standard 
     * deviation from the mean. Z-scores may be positive or negative, with a positive value indicating the score is above the mean 
     * and a negative score indicating it is below the mean
     * @param  x the data value for which the z-score will be computed against
     * @return the number of data values
     */    
    public double zscore(int x) {
    	return zscore((double) x);
    }

    /**
     * Returns the zscore of the value. A Z-score is a numerical measurement used in statistics of a value's relationship to the mean 
     * (average) of a group of values, measured in terms of standard deviations from the mean. If a Z-score is 0, it indicates 
     * that the data point's score is identical to the mean score. A Z-score of 1.0 would indicate a value that is one standard 
     * deviation from the mean. Z-scores may be positive or negative, with a positive value indicating the score is above the mean 
     * and a negative score indicating it is below the mean
     * @param  x the data value for which the z-score will be computed against
     * @return the number of data values
     */    
    public double zscore(long x) {
    	return zscore((double) x);
    }
    
    /**
     * Returns the zscore of the value. A Z-score is a numerical measurement used in statistics of a value's relationship to the mean 
     * (average) of a group of values, measured in terms of standard deviations from the mean. If a Z-score is 0, it indicates 
     * that the data point's score is identical to the mean score. A Z-score of 1.0 would indicate a value that is one standard 
     * deviation from the mean. Z-scores may be positive or negative, with a positive value indicating the score is above the mean 
     * and a negative score indicating it is below the mean
     * @param  x the data value for which the z-score will be computed against
     * @return the number of data values
     */    
    public double zscore(double x) {
    	double z = (x-mean())/stddev();
    	return z;
    }

    /**
     * Computes the percentage difference between the two values
     * @param x A value labeled x
     * @param y A value labeled y
     * @return percentage difference that is positive
     */
    public static double percentDifference(double x, double y) {
    	if(x>y) {
    		return  1.0 * ((x - y) / (double)x);
    	}
    
    	return  1.0 * ((y - x) / (double)y);
    }
    
    /**
     * Returns a string representation of this accumulator.
     * @return a string representation of this accumulator
     */
    public String toString() {
        return "n = " + n + ", mean = " + mean() + ", stddev = " + stddev();
    }

}

