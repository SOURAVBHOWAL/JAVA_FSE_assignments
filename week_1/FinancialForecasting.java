import java.util.*;

public class FinancialForecasting {

    public static List<Double> forecast(List<Double> revenueData, int monthsToForecast, int windowSize) {
        List<Double> forecast = new ArrayList<>();
        int dataSize = revenueData.size();

        for (int i = 0; i < monthsToForecast; i++) {
            int start = Math.max(0, dataSize - windowSize);
            List<Double> window = revenueData.subList(start, dataSize);

            double sum = 0;
            for (double val : window) {
                sum += val;
            }

            double avg = sum / window.size();
            forecast.add(avg);
            revenueData.add(avg);
            dataSize++;
        }

        return forecast;
    }

    public static void main(String[] args) {
        List<Double> pastRevenue = Arrays.asList(
            10000.0, 12000.0, 11000.0, 13000.0, 12500.0, 14000.0,
            15000.0, 15500.0, 16000.0, 15800.0, 16500.0, 17000.0
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of months to forecast: ");
        int months = scanner.nextInt();

        System.out.print("Enter moving average window size: ");
        int windowSize = scanner.nextInt();

        List<Double> forecastedRevenue = forecast(new ArrayList<>(pastRevenue), months, windowSize);

        System.out.println("Forecasted Revenue:");
        for (int i = 0; i < forecastedRevenue.size(); i++) {
            System.out.printf("Month %d: %.2f\n", i + 1, forecastedRevenue.get(i));
        }
    }
}
