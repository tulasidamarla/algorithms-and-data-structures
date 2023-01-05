### Optimal merge pattern

- Given n number of sorted files, the task is to find the minimum computations done to reach the Optimal Merge Pattern.
- When two or more sorted files are to be merged altogether to form a single file, the minimum computations are done to reach this file are known as Optimal Merge Pattern.

- Solution
  - If more than 2 files need to be merged then it can be done in pairs. 
    - For example, if need to merge 4 files A, B, C, D. First Merge A with B to get X1, merge X1 with C to get X2, merge X2 with D to get X3 as the output file.
  - If we have two files of sizes m and n, the total computation time will be m+n. Here, we use the greedy strategy by merging the two smallest size files among all the files present.
    
- Approach
  - Node represents a file with a given size also given nodes are greater than 2
  - Add all the nodes in a priority queue (Min Heap).{pq.poll = file size}
  - Initialize count = 0 // variable to store file computations.
  - Repeat while (size of priority Queue is greater than 1)
    - int weight = pq.poll(); pq.pop;//pq denotes priority queue, remove 1st smallest and pop(remove) it out
    - weight+=pq.poll()  && pq.pop(); // add the second element and then pop(remove) it out
    - count +=weight;
    - pq.add(weight) // add this combined cost to priority queue;  
  - count is the final answer

- Code
  
```
import java.util.PriorityQueue;
import java.util.Scanner;
 
public class OptimalMergePatterns {
 
    // Function to find minimum computation
    static int minComputation(int size, int files[])
    {
 
        // create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        for (int i = 0; i < size; i++) {
 
            // add sizes to priorityQueue
            pq.add(files[i]);
        }
 
        // variable to count total computations
        int count = 0;
 
        while (pq.size() > 1) {
 
            // pop two smallest size element
            // from the min heap
            int temp = pq.poll() + pq.poll();
 
            // add the current computations
            // with the previous one's
            count += temp;
 
            // add new combined file size
            // to priority queue or min heap
            pq.add(temp);
        }
 
        return count;
    }
 
    public static void main(String[] args)
    {
 
        // no of files
        int size = 6;
 
        // 6 files with their sizes
        int files[] = new int[] { 2, 3, 4, 5, 6, 7 };
 
        // total no of computations
        // do be done final answer
        System.out.println("Minimum Computations = "
                           + minComputation(size, files));
    }
}
```