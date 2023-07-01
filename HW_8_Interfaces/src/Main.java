public class Main {
    public static void main(String[] args) {
        Printable[] allPrintables = {
            new Book("Harry Potter"),
            new Magazine(2008, "Penthouse"),
            new Magazine(1976, "Bazaar"),
            new Book("Crime and punishment")
        };

        for (Printable printable : allPrintables) {
            printable.print();
        }

        System.out.println("All magazine names:");
        Magazine.printMagazines(allPrintables);

        System.out.println("All book titles:");
        Book.printBooks(allPrintables);

    }
}