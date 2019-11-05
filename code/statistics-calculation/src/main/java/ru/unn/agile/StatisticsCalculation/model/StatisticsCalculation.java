package ru.unn.agile.StatisticsCalculation.model;

public final class StatisticsCalculation {
    public static double calculateExpectedValue(final Number[] values,
                                                final Double[] probabilities) {
        DistributionChecker.validate(values, probabilities);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += values[i].doubleValue() * probabilities[i];
        }
        return result;
    }

    public static double calculateDispersion(final Number[] values,
                                             final Double[] probabilities) {
        double result = 0.0;
        double expectedValue = calculateExpectedValue(values, probabilities);
        if (values.length == 2) {
            result = probabilities[0]*(values[0].doubleValue()-expectedValue)*(values[0].doubleValue()-expectedValue)
                    + probabilities[1]*(values[1].doubleValue()-expectedValue)*(values[1].doubleValue()-expectedValue);
        }
        return result;
    }

    private StatisticsCalculation() { }
}
