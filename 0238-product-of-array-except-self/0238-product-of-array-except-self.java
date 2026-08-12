class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 1;

        // Store left product
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        int right = 1;

        // Multiply by right product
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }

        return ans;
    }
}