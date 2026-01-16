Problem: 3. Longest Substring Without Repeating Characters (Medium)
🧠 Problem Statement

Given a string s, find the length of the longest substring that contains no repeating characters.

⚠️ Substring means continuous characters

✍️ Examples
Example 1
Input: s = "abcabcbb"
Output: 3
Explanation: "abc"

Example 2
Input: s = "bbbbb"
Output: 1
Explanation: "b"

Example 3
Input: s = "pwwkew"
Output: 3
Explanation: "wke"

📊 Constraints

0 <= s.length <= 5 * 10⁴

Contains letters, digits, symbols, spaces

🔑 Key Idea (Important for Interviews)

👉 This is a Sliding Window problem
👉 Use two pointers to maintain a window with unique characters
👉 Expand window → if duplicate found → shrink from left

🔍 Optimal Approach: Sliding Window + HashSet ✅
💡 Intuition

Maintain a window [left → right]

Use a HashSet to track characters in current window

If character already exists → remove from left until unique

🧩 Algorithm

Initialize:

left = 0

maxLength = 0

HashSet<Character>

Move right pointer through string

If s[right] not in set:

Add it

Update maxLength

If duplicate:

Remove s[left]

Increment left

Continue until end of string

🧾 Java Code (With Comments)
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        // Right pointer moves forward
        for (int right = 0; right < s.length(); right++) {

            // If duplicate found, remove until unique
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

🧪 Dry Run (Example: "pwwkew")
Left	Right	Window	Set	Max
0	0	p	{p}	1
0	1	pw	{p,w}	2
1	2	w	{w}	2
2	3	wk	{w,k}	2
2	4	wke	{w,k,e}	3
3	5	kew	{k,e,w}	3
⏱️ Time & Space Complexity
Complexity	Value
Time	O(n)
Space	O(min(n, charset))
🚀 Optimized Approach (Using Array instead of HashSet)

✔ Faster
✔ Best for interviews

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] index = new int[128]; // ASCII characters
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, index[s.charAt(right)]);
            maxLength = Math.max(maxLength, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }

        return maxLength;
    }
}

🧠 Interview Tips

✔ Sliding window is mandatory knowledge
✔ Explain window shrinking logic clearly
✔ Mention substring vs subsequence
✔ Handle empty string case

🔥 Related Must-Practice Questions

Permutation in String

Find All Anagrams

Longest Substring with At Most Two Distinct Characters
