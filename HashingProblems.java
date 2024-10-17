/*
 * *** KAIA KARU / COMP 272 001 ***
 *
 * This HashingProblems object contains three methods / problems that you must
 * complete utilize the HashMap object within the Java's Collection Framework Library.
 *
 * The three methods / problems you need to solve are:
 *  - getAverage
 *  - odd
 *  - twoSums
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class HashingProblems {

    /*
     * Method getAverage()
     *
     * This method accepts two parameters. The first is a HashMap object, while the second
     * is an array of integers. This method must compute the average of the values for each
     * 'key' that is found in BOTH the HashMap and the array.
     *
     * For example, if only the keys 1 and 2 from the array are present in the HashMap, and
     * lets say their values were 10 and 20, respectively, then the average is calculated
     * as (10+20)/2 = 15. Lets also say the keys ‘7’ and ‘8’ are in the array, but those keys
     * are not present in the HashMap. That means their corresponding values in the HashMap
     * are not included in the average calculation.
     */

    public double getAverage(HashMap<Integer, Integer> map, int[] array) {

        /*
         * ADD YOUR CODE HERE - DO NOT FORGET TO ADD YOU NAME AT TOP OF FILE
         *
         * Note: if NO values found in common between the HashMap and supplied array,
         * returning 0.0 is NOT correct, as that is not the average value. Whereas
         * returning 0.0/0.0 IS correct (which would return a non-number).
         */

        // initialize variables sum (total of values in HashMap),
        // and count (how many keys in the array are also in the HashMap)
        double sum = 0;
        int count = 0;

        // loop through each key in the array
        for (int key : array) {
            // if the key is in the HashMap, add the value to sum and increment the count by 1
            if (map.containsKey(key)) {
                sum += map.get(key);
                count++;
            }
        }
        // if the count is 0, no keys are shared between array and HashMap
        if (count == 0) {
            return 0.0 / 0.0; // return non-number
        }
        return sum / count;
    }


    /*
     * Method odd()
     *
     * This method accepts a HashMap object, and returns an ArrayList object with the
     * values of the corresponding keys that are odd.
     */

    public ArrayList<String> odd(HashMap<Integer, String> map) {

        ArrayList<String> result = new ArrayList<>();

        /*
         * ADD YOUR CODE HERE
         *
         * Hint: Consider iterating over the HashMap using the keySet method.
         */

        // iterate over each key using keySet() which returns set of keys in the map
        for (Integer key : map.keySet()) {
            // if key is odd, add the value to the list of results
            if (key % 2 != 0) {
                result.add(map.get(key));
            }
        }


        return result;
    }


    /*
     * Method twoSums()
     *
     * You ARE to solve this problem in time complexity O(n). The submittals will be spot checked.
     *
     * Problem statement:
     * Suppose you are given an integer array containing the values [1,4,5,7,8,9] along with the
     * value k=4, where k is the difference between two array elements. How many times does k appear
     * in that list?
     *
     * With the above numbers, it will be three times:
     *    k = 4
     *    (5 - 1) = k
     *    (8 - 4) = k
     *    (9 - 5) = k
     *    k appears 3 times.
     *
     * All combinations must be considered. But, any other combination of the numbers in the array
     * results in a difference value that is not equal to k (k=4 in this case).
     *
     * This can be solved using nested for-loops, checking all combinations of the values in the array.
     * But the time complexity would be O(n^2).
     *
     * In order to solve this problem in O(n) complexity, utilize a HashMap (or a HashSet).
     *
     * You are two solve this using a HashMap (or you can use a HashSet, which is implemented
     * using HashMap). To solve this, you should populate the HashMap (or HashSet) based on
     * the array (this will be complexity time on the order of 'n'). After populating the HashMap,
     * consider a for-loop that does a lookup (probe) of the HashMap (or HashSet) on each iteration
     * of the loop. This will also have a complexity on the order of 'n', as the hashing probes are a
     * constant time complexity (after removing any constant based on collisions).
     *
     * This will result in a time complexity of O(n) for the overall method.
     *
     * NOTE: Solving using a HashMap or HashSet is fine (either is okay). HashSet may be easier to code?
     */

    public int twoSums(int[] numbers, int k) {

        /*
         * ADD YOUR CODE HERE
         */

        HashSet<Integer> set = new HashSet<>();
        // count variable for how many times 'k' occurs
        int count = 0;

        // loop through each number in the array
        for (int num : numbers) {
            // if the hashSet has an element when added to k = num
            if (set.contains(num - k)) {
                count++; // valid pair, increment count by 1
            }

            // if the hashSet has an element when subtracted from k = num
            if (set.contains(num + k)) {
                count++; // valid pair, increment count by 1
            }

            // add the current num to the HashSet
            set.add(num);
        }

        return count;
    }

} /* end class HashingProblems */