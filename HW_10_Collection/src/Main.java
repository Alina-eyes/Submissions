import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Random rn = new Random();

        Collection<Integer> originalNumbers = new ArrayList<>();
        for (int i=0; i<100; ++i) {
            originalNumbers.add(rn.nextInt(50));
        }

        Collection<Integer> deduplicatedNumbers = deduplicate(originalNumbers);

        System.out.println(Arrays.toString(originalNumbers.toArray()));
        System.out.println(Arrays.toString(deduplicatedNumbers.toArray()));

        int difference = originalNumbers.size() - deduplicatedNumbers.size();
        System.out.println("The number of deleted duplicates is: " + difference);

        int[] testCases = new int[] { 3, 5, 6, 7, 31, 17, 91, 55, 23, 223, 233, 895 };
        for (boolean useArrayList: new boolean[] { true, false }) {
            System.out.println("Simulating circle with " + (useArrayList ? "ArrayList" : "LinkedList"));
            long timeStart = System.currentTimeMillis();
            for (int test: testCases) {
                // `simulateCircleNaive` is a slow version, not leveraging fast LinkedList removals
                // int ans1 = simulateCircleNaive(test * 150, useArrayList);
                int ans2 = simulateCircleFast(test * 150, useArrayList);
                // if (ans1 != ans2) throw new Exception("BROKEN!");
            }
            long timeEnd = System.currentTimeMillis();
            System.out.println("The test took " + (timeEnd - timeStart) + "ms");
        }

        // The removal of an element from a LinkedList can be much faster since it can be done in the O(1) time
        // Each removal in the ArrayList requires it to compact all the remaining elements which can be O(n)
        // in the worst case scenario (n being the size of the array).

        // This is why the `simulateCircleFast` method is much faster when using the LinkedList
        // The `simulateCircleNaive` doesn't leverage the O(1) removal time in LinkedList since it removes
        // each element by index. That require the LinkedList to traverse all the elements making the removal
        // by index O(n) too.

        // So in conclusion LinkedList can be much faster but it needs to be carefully implemented with
        // iterator removals that are O(1) in the LL.
    }

    public static int simulateCircleNaive(int N, boolean useArrayListInsteadOfLinkedList) {
        List<Integer> numbers = useArrayListInsteadOfLinkedList ? new ArrayList<>() : new LinkedList<>();
        for (int i=1; i <= N; ++i) {
            numbers.add(i);
        }

        int indexToRemove = 0;
        while (numbers.size() > 1) {
            numbers.remove(indexToRemove);
            indexToRemove = indexToRemove + 1;
            indexToRemove = indexToRemove % numbers.size();
        }

        return numbers.get(0);
    }

    public static int simulateCircleFast(int N, boolean useArrayListInsteadOfLinkedList) {
        List<Integer> numbers = useArrayListInsteadOfLinkedList ? new ArrayList<>() : new LinkedList<>();
        for (int i=1; i <= N; ++i) {
            numbers.add(i);
        }

        var itr = numbers.iterator();
        itr.next();
        while (numbers.size() > 1) {
            itr.remove();
            // We call the .next() twice to skip over one element
            // If the iterator has ran out, we need to reset it back to the start
            if (!itr.hasNext()) {
                itr = numbers.iterator();
            }
            itr.next();
            if (!itr.hasNext()) {
                itr = numbers.iterator();
            }
            itr.next();
        }

        return numbers.get(0);
    }

    public static Collection<Integer> deduplicate(Collection<Integer> numbers) {
        Collection<Integer> deduplicatedNumbers = new ArrayList<>();
        Set<Integer> numbersInTheCollection = new HashSet<>();
        for (int num: numbers) {
            if (!numbersInTheCollection.contains(num)) {
                deduplicatedNumbers.add(num);
                numbersInTheCollection.add(num);
            }
        }
        return deduplicatedNumbers;
    }
};