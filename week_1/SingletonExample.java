public class SingletonExample {

    private SingletonExample() {
        System.out.println("Singleton instance created.");
    }

    private static SingletonExample instance;

    public static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

    public void showMessage(String message) {
        System.out.println("[Singleton] " + message);
    }

    public static void main(String[] args) {
        SingletonExample obj1 = SingletonExample.getInstance();
        SingletonExample obj2 = SingletonExample.getInstance();

        System.out.println("Object 1 HashCode: " + obj1.hashCode());
        System.out.println("Object 2 HashCode: " + obj2.hashCode());

        if (obj1 == obj2) {
            System.out.println("Only one instance exists.");
        } else {
            System.out.println("Different instances exist.");
        }

        obj1.showMessage("Hello from the Singleton!");
    }
}
