package SLF4J_Logging_Framework_code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.info("Application started");

        try {
            int result = divide(10, 0);
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("An error occurred: Division by zero", e);
        }

        logger.warn("This is a warning message about low memory.");
        logger.info("Application ended");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}

