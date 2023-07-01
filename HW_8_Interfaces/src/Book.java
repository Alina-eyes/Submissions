public class Book implements Printable {

    private String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Printing the book with the title " + this.title);
    }
    public static void printBooks(Printable[] printable) {
        for (Printable pr : printable) {
            if (pr instanceof Book) {
                Book book = (Book) pr;
                System.out.println(book.title);
            }
        }

    }
}
