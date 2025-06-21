import java.util.*;

public class EcommerceSearch {
    public static List<String> searchProducts(List<String> products, String keyword) {
        List<String> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();
        for (String product : products) {
            if (product.toLowerCase().contains(lowerKeyword)) {
                result.add(product);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> products = Arrays.asList(
            "Apple iPhone 15", "Samsung Galaxy S24", "Sony Headphones",
            "Asus Laptop", "Apple MacBook Pro", "Dell Monitor"
        );

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        List<String> results = searchProducts(products, keyword);

        if (results.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            System.out.println("Matching products:");
            for (String product : results) {
                System.out.println("- " + product);
            }
        }
    }
}
