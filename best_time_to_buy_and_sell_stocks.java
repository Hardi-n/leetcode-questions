/*
 * 121. Best Time to Buy and Sell Stock
 * Easy
 * Topics
 * Companies
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you
 * must buy before you sell.
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */


 class Solution {
    public int maxProfit(int[] prices) {
        // Check if the prices array is null or has less than 2 elements
        // In such cases, it's impossible to make any profit, so return 0
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize the lowest price as the first element in the array
        int lowest = prices[0];
        int index_of_lowest = 0;  // Track the index of the lowest price

        // Iterate through the prices array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // Update the lowest price and its index if a lower price is found
            if (lowest > prices[i]) {
                lowest = prices[i];
                index_of_lowest = i;
            }
            // Else, keep the current lowest price (this else block can be removed as it's redundant)
            else {
                lowest = lowest;
            }
        }

        // Initialize the maximum price as the lowest price found
        int max = prices[index_of_lowest];
        int index_of_max = index_of_lowest;  // Track the index of the maximum price

        // Iterate through the array from the next element after the lowest price
        for (int i = index_of_lowest + 1; i < prices.length; i++) {
            // Update the maximum price and its index if a higher price is found
            if (max < prices[i]) {
                max = prices[i];
                index_of_max = i;
            }
        }

        // If the lowest price is at or after the highest price, return 0 as no profit can be made
        if (index_of_lowest >= index_of_max) {
            return 0;
        }

        // Return the difference between the maximum and lowest price as the profit
        return max - lowest;
    }
}


/*
 * Initial Check:

java
Copy code
if (prices == null || prices.length < 2) {
    return 0;
}
Purpose: This part checks if the prices array is null (i.e., not provided) or has less than 2 elements.
Why: If the array is empty or contains only one price, it’s impossible to make a transaction, so the function returns 0 immediately.
Finding the Lowest Price:

java
Copy code
int lowest = prices[0];
int index_of_lowest = 0;
Initialization: The first element of the array is assumed to be the lowest price initially, and index_of_lowest tracks its position.
java
Copy code
for (int i = 1; i < prices.length; i++) {
    if (lowest > prices[i]) {
        lowest = prices[i];
        index_of_lowest = i;
    }
}
Purpose: This loop iterates through the array to find the lowest price.
How: It compares each price with the current lowest. If a lower price is found, it updates lowest and the index_of_lowest.
Result: After this loop, you know the lowest price and its position in the array.
Finding the Maximum Price After the Lowest:

java
Copy code
int max = prices[index_of_lowest];
int index_of_max = index_of_lowest;
Initialization: The code sets max to the lowest price initially. It assumes that the highest price will come after the lowest price.
java
Copy code
for (int i = index_of_lowest + 1; i < prices.length; i++) {
    if (max < prices[i]) {
        max = prices[i];
        index_of_max = i;
    }
}
Purpose: This loop searches for the maximum price that occurs after the lowest price.
How: It compares each price after the lowest price and updates max if a higher price is found. The index of this maximum price is stored in index_of_max.
Checking Profit Feasibility:

java
Copy code
if (index_of_lowest >= index_of_max) {
    return 0;
}
Purpose: This check ensures that the maximum price occurs after the lowest price.
Why: If the maximum price is before or at the same index as the lowest price, no valid transaction (buying before selling) can be made, so the function returns 0.
Return the Maximum Profit:

java
Copy code
return max - lowest;
Purpose: This returns the difference between the maximum price and the lowest price, which represents the maximum profit you can achieve by buying at the lowest price and selling at the highest price after that.
Example Walkthrough:
For the input prices = [7, 1, 5, 3, 6, 4]:

Finding Lowest Price:

Start with lowest = 7.
Iterate through the array:
At index 1: lowest updates to 1.
The lowest price is found at index 1.
Finding Maximum Price After Lowest:

Start with max = 1 (price at index 1).
Iterate through the array starting from index 2:
At index 2: max updates to 5.
At index 4: max updates to 6.
The maximum price after the lowest price is 6.
Calculate Profit:

Return max - lowest = 6 - 1 = 5.
Thus, the maximum profit is 5.

Time Complexity:
O(n): The code iterates through the prices array twice—once to find the lowest price and once to find the maximum price after the lowest. Therefore, the time complexity is linear with respect to the size of the array.
Space Complexity:
O(1): The code uses a constant amount of extra space for variables (lowest, index_of_lowest, max, index_of_max), making the space complexity constant.
This code efficiently calculates the maximum profit from stock prices by identifying the best day to buy and the best day to sell within the given constraints.
 */