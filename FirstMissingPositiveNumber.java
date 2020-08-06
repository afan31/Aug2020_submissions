class Solution {
  public int firstMissingPositive(int[] nums) {
    int n = nums.length;
    for(int i = 0; i < nums.length; i++){
      int correctPos = nums[i]-1; // number 3 goes to index 2
      while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[correctPos]){
        //swap two numbers
        int temp = nums[i];
        nums[i] = nums[correctPos];
        nums[correctPos] = temp;
        // update correctPos
        correctPos = nums[i]-1; // now nums[i] has changed, and we need to check again till nums[i] == nums[correctPos]
      }
    }
    
    for (int i= 0; i < n; i++){
      if (i+1 != nums[i]){
        return i+1;
      }
    }
    return n+1;
  }
}