import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    private static List<User> sortByAgeIntoNewCollection(List<User> users) {
        return users.stream()
            .sorted((u1, u2) -> ((Integer) u1.getAge()).compareTo(u2.getAge()))
            .collect(Collectors.toList());

    }

    private static double calculateAverageAge(List<User> users) {
        int sumOfAllAges = users.stream()
            .map(user -> user.getAge())
            .reduce(0, (sum, userAge) -> sum + userAge);

        double averageAge = (double) sumOfAllAges / users.size();
        return averageAge;
    }

    private static void sortByFirstNameInPlace(List<User> users) {
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
    }

    private static boolean areThereAnyUsersWithLastNameStartingWithSorA(List<User> users) {
        return users.stream()
            .anyMatch(user -> user.getLastName().startsWith("S") || user.getLastName().startsWith("A"));
    }

    private static boolean areAllUsersOver18(List<User> users) {
        return users.stream().allMatch(user -> user.getAge() >= 18);
    }
}