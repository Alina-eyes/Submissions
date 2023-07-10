import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Printable brochure = () -> {
            System.out.println("Printing a brochure!");
        };
        brochure.print();

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Alex", "Red", 22));
        users.add(new User("Alice", "Savy", 27));
        users.add(new User("Alexander", "Grey", 29));
        users.add(new User("Althea", "Pink", 2));
        users.add(new User("Alan", "Apple", 33));
        users.add(new User("Alice", "Bloom", 44));
        users.add(new User("Alphonse", "Pink", 5));
        users.add(new User("Albert", "Bloom", 22));
        users.add(new User("Alina", "Silver", 9));
        users.add(new User("Alice", "Yellow", 36));

        List<User> ageSortedUsers = users.stream()
            .sorted((u1, u2) -> ((Integer) u1.getAge()).compareTo(u2.getAge()))
            .collect(Collectors.toList());

        System.out.println("Age sorted users: " + ageSortedUsers);

        int sumOfAllAges = users.stream()
            .map(user -> user.getAge())
            .reduce(0, (sum, userAge) -> sum + userAge);

        double averageAge = (double) sumOfAllAges / users.size();
        System.out.println("Average age is: " + averageAge);

        List<User> usersWithLastNameSorA = users.stream()
            .filter(user -> user.getLastName().startsWith("S") || user.getLastName().startsWith("A"))
            .collect(Collectors.toList());

        System.out.println("Users whose last names start with S or A: " + usersWithLastNameSorA);
        System.out.println("Are there users whose last names start with S or A? " + (usersWithLastNameSorA.size() > 0 ? "yes" : "no"));

        List<User> underageUsers = users.stream()
            .filter(user -> user.getAge() < 18)
            .collect(Collectors.toList());

        System.out.println("Users whose age is less than 18: " + underageUsers);
        System.out.println("Are all users 18+? " + (underageUsers.size() == 0 ? "yes" : "no"));

        // Sort the list in place without creating a new one
        Collections.sort(
            users,
            (u1, u2) -> {
                int nameComparison = u1.getFirstName().compareTo(u2.getFirstName());
                if (nameComparison == 0) {
                    return ((Integer) u1.getAge()).compareTo(u2.getAge());
                }
                return nameComparison;
            }
        );

        System.out.println("Users sorted by firstName with age as a tie-breaker: " + users);
    }
}