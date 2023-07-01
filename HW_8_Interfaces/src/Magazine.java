public class Magazine implements Printable {

    Magazine(int publicationYear, String name) {
        this.publicationYear = publicationYear;
        this.name = name;
    }

    private int publicationYear;
    private String name;

    @Override
    public void print() {
        System.out.println("Printing the magazine " + this.name + " from the year " + this.publicationYear);
    }
    public static void printMagazines(Printable[] printable) {
        for (Printable pr : printable) {
            if (pr instanceof Magazine) {
                Magazine magazine = (Magazine) pr;
                System.out.println(magazine.name);
            }
        }

    }
}
