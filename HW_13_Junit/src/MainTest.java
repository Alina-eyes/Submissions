import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    public static enum ExampleLists {
        LIST_WITH_YOUNG_PEOPLE(
            List.of(
                new User("Alex", "Bloom", 15),
                new User("Alice", "Broom", 25)
            ),
            20
        ),
        LIST_WITH_ADULTS(
            List.of(
                new User("Beata", "Bloom", 33),
                new User("Dorota", "Bloom", 20),
                new User("Fryderyk", "Chopin", 66)
            ),
            39.666666666666664
        );

        ExampleLists(List<User> users, double precalculatedAgeAverage) {
            this.users = users;
            this.precalculatedAgeAverage = precalculatedAgeAverage;
        }
        List<User> users;
        double precalculatedAgeAverage;
    }

    private List<User> LIST_OF_OLD_USERS;
    @BeforeEach
    void before() {
        LIST_OF_OLD_USERS = new ArrayList<User>(
            List.of(
                    new User("George", "Duda", 60),
                    new User("Peter", "Singer", 80),
                    new User("Bob", "Big", 70)
            )
        );
    }
    @AfterEach
    void after() {
        LIST_OF_OLD_USERS = null;
    }

    @Test
    void sortByAgeIntoNewCollectionTest1() {
        List<User> sortedList = Main.sortByAgeIntoNewCollection(ExampleLists.LIST_WITH_ADULTS.users);
        assertTrue(sortedList.get(0).getAge() < sortedList.get(1).getAge());
        assertEquals(sortedList.get(0).getFirstName(), "Dorota");
    }

    @ParameterizedTest
    @EnumSource(ExampleLists.class)
    void sortByAgeIntoNewCollection_Test2(ExampleLists list) {
        List<User> sortedList = Main.sortByAgeIntoNewCollection(list.users);
        assertEquals(sortedList.size(), list.users.size());
        assertTrue(sortedList.get(0).getAge() < sortedList.get(1).getAge());
    }

    @RepeatedTest(10)
    void sortByAgeIntoNewCollection_Test3() {
        List<User> sortedList = Main.sortByAgeIntoNewCollection(ExampleLists.LIST_WITH_ADULTS.users);
        assertTrue(sortedList.get(0).getAge() < sortedList.get(1).getAge());
    }

    @Test
    void calculateAverageAge_Test1() {
        ExampleLists ex = ExampleLists.LIST_WITH_ADULTS;
        double average = Main.calculateAverageAge(ex.users);
        assertEquals(average, ex.precalculatedAgeAverage);
    }

    @ParameterizedTest
    @EnumSource(ExampleLists.class)
    void calculateAverageAge_Test2(ExampleLists list) {
        double average = Main.calculateAverageAge(list.users);
        assertEquals(average, list.precalculatedAgeAverage);
    }

    @RepeatedTest(10)
    void calculateAverageAge_Test3() {
        ExampleLists ex = ExampleLists.LIST_WITH_YOUNG_PEOPLE;
        double average = Main.calculateAverageAge(ex.users);
        assertEquals(average, ex.precalculatedAgeAverage);
    }


    @RepeatedTest(10)
    void sortByFirstNameInPlace_Test1() {
        List<User> list = LIST_OF_OLD_USERS;
        Main.sortByFirstNameInPlace(list);
        assertEquals("Bob", list.get(0).getFirstName());
    }

    @ParameterizedTest
    @EnumSource(ExampleLists.class)
    void sortByFirstNameInPlace_Test2(ExampleLists ex) {
        // Copy the list to make sure the sorting method doesn't change the original one
        List<User> list = new ArrayList<>(ex.users);
        Main.sortByFirstNameInPlace(list);
        assertTrue(list.get(0).getFirstName().compareTo(list.get(1).getFirstName()) < 0);
    }

    @Test
    void sortByFirstNameInPlace_Test3() {
        // Copy the list to make sure the sorting method doesn't change the original one
        List<User> list = new ArrayList<>(ExampleLists.LIST_WITH_YOUNG_PEOPLE.users);
        Main.sortByFirstNameInPlace(list);
        assertEquals("Alex", list.get(0).getFirstName());
    }


    @Test
    void areThereAnyUsersWithLastNameStartingWithSorA_Test1() {
        assertFalse(Main.areThereAnyUsersWithLastNameStartingWithSorA(ExampleLists.LIST_WITH_YOUNG_PEOPLE.users));
    }

    @ParameterizedTest
    @EnumSource(ExampleLists.class)
    void areThereAnyUsersWithLastNameStartingWithSorA_Test2(ExampleLists ex) {
        assertFalse(Main.areThereAnyUsersWithLastNameStartingWithSorA(ex.users));
    }

    @RepeatedTest(10)
    void areThereAnyUsersWithLastNameStartingWithSorA_Test3() {
        assertTrue(Main.areThereAnyUsersWithLastNameStartingWithSorA(LIST_OF_OLD_USERS));
    }

    @Test
    void areAllUsersOver18_Test1() {
        boolean areAllUsersOver18 = Main.areAllUsersOver18(ExampleLists.LIST_WITH_YOUNG_PEOPLE.users);
        assertFalse(areAllUsersOver18);
    }

    @ParameterizedTest
    @EnumSource(ExampleLists.class)
    void areAllUsersOver18_Test2(ExampleLists ex) {
        boolean areAllUsersOver18 = Main.areAllUsersOver18(ex.users);
        List<User> fromYoungestToOldest = Main.sortByAgeIntoNewCollection(ex.users);
        assertEquals(areAllUsersOver18, fromYoungestToOldest.get(0).getAge() >= 18);
    }

    @RepeatedTest(10)
    void areAllUsersOver18_Test3() {
        boolean areAllUsersOver18 = Main.areAllUsersOver18(ExampleLists.LIST_WITH_ADULTS.users);
        assertTrue(areAllUsersOver18);
    }
}