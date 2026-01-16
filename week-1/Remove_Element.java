Problem Statement

Given an integer array nums and an integer val, remove all occurrences of val in-place.

The order of elements may be changed

Return the number of elements not equal to val

Modify the array so that the first k elements contain valid values

Remaining elements don’t matter

✍️ Examples
Example 1
Input: nums = [3,2,2,3], val = 3
Output: 2
nums = [2,2,_,_]

Example 2
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5
nums = [0,1,4,0,3,_,_,_]

📊 Constraints

0 <= nums.length <= 100

0 <= nums[i] <= 50

0 <= val <= 100

🔍 Approach 1: Two Pointer Technique (Recommended)
💡 Idea

Use one pointer to scan the array and another to overwrite unwanted elements.

🧩 Algorithm

Initialize pointer k = 0

Traverse array from index 0

If nums[i] != val

Assign nums[k] = nums[i]

Increment k

After traversal:

First k elements are valid

Return k

🧾 Java Code (With Comments)
class Solution {
    public int removeElement(int[] nums, int val) {

        // Pointer for placing non-val elements
        int k = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // If current element is not val, keep it
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        // k represents count of elements not equal to val
        return k;
    }
}

⏱️ Time & Space Complexity
Complexity	Value
Time	O(n)
Space	O(1)
🔥 Approach 2: Swap from End (When Order Doesn’t Matter)
💡 Idea

Replace unwanted element with the last element.

🧾 Java Code (Alternative)
class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
