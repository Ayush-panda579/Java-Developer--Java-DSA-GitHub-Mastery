Problem: Two Sum (Easy)
🧠 Problem Statement

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

⚠️ Rules

Each input has exactly one solution

You cannot use the same element twice

Answer can be returned in any order

✍️ Examples
Example 1
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9

Example 2
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3
Input: nums = [3,3], target = 6
Output: [0,1]

📊 Constraints

2 <= nums.length <= 10⁴

-10⁹ <= nums[i], target <= 10⁹

Only one valid answer exists

🔍 Optimized Algorithm (Using HashMap)
💡 Idea

While traversing the array:

For each element x, calculate target - x

Check if this value already exists in a map

If yes → solution found

If not → store current value and index

🧩 Algorithm Steps

Create a HashMap to store number → index

Traverse array from left to right

For each number:

Compute complement = target - nums[i]

If complement exists in map → return indices

Else store current number with index

Guaranteed one solution → no need for extra checks

🧾 Java Code (With Comments)
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            // Check if complement already exists
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Store current number with index
            map.put(nums[i], i);
        }

        // This line will never execute (as per problem guarantee)
        return new int[] {};
    }
}

⏱️ Time & Space Complexity
Complexity	Value
Time	O(n)
Space	O(n)
🧠 Why This is Best for Interviews

✔ One-pass solution
✔ Efficient lookup using HashMap
✔ Handles negative numbers
✔ Clean and readable logic
