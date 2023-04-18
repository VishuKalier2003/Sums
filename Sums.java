/* You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k...
Define a pair (u, v) which consists of one element from the first array and one element from the second array...
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums...
* Eg 1: nums1 = [1,7,11]          nums2 = [2,4,6]               Output = {(1,2), (1,4), (1,6)}
* Eg 2: nums1 = [1,1,2]           nums2 = [1,2,3]               Output = {(1,1), (1,1)}
 */
import java.util.*;
public class Sums 
{
    public List<List<Integer>> KSmallestPairs(int nums1[], int nums2[], int k)
    {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();   // Creating a nested list...
        int i = 0, j = 0, count = 0;     // variables declared...
        while((i != nums1.length - 1) && (j != nums2.length))   // While the end of the arrays are not reached...
        {
            List<Integer> lst1 = new ArrayList<Integer>();
            lst1.add(0, nums1[i]);    // Adding index and element...
            lst1.add(1, nums2[j]);    // Adding index and element...
            if(nums1[i + 1] > nums2[j])
                j++;    // If next element in first array is greater, increment 2nd array counter...
            else if(nums1[i + 1] <= nums2[j])
                i++;    // If next element in second array is greater, increment 1st array counter...
            lst.add(count, lst1);
            if(count == k - 1)    // When count is equal to the number of pairs...
                break;
            count++;
        }
        return lst;    // Return the nested list...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n, m;
        System.out.print("Enter length of first array (sorted) : ");
        n = sc.nextInt();
        int nums1[] = new int[n];
        for(int i = 0; i < nums1.length; i++)
        {
            System.out.print("Enter data : ");
            nums1[i] = sc.nextInt();
        }
        System.out.print("Enter length of second array (sorted) : ");
        m = sc.nextInt();
        int nums2[]= new int[m];
        for(int i = 0; i < nums2.length; i++)
        {
            System.out.print("Enter data : ");
            nums2[i] = sc.nextInt();
        }
        System.out.print("Enter the value of k : ");
        n = sc.nextInt();
        Sums sums = new Sums();    // Object creation...
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        answer = sums.KSmallestPairs(nums1, nums2, n);      // Function calling...
        for(int i = 0; i < answer.size(); i++)
            System.out.print("["+answer.get(i).get(0)+", "+answer.get(i).get(1)+"], ");
        System.out.println();
        sc.close();
    }
}


// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :-
 * The only trick here is the updation of pointer of both arrays, since both arrays are already sorted the pointers will be incremented in a simultaneous and orderly fashion...
 * One way is to check the next proceeding element in an array whose pointer we want to increment...
 */