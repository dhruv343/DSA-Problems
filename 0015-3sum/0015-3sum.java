class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            HashSet<Integer> sett = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if (sett.contains(third)) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(third);
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    Collections.sort(ans);
                    set.add(ans);
                } else {
                    sett.add(nums[j]);
                }
            }
        }

        return new ArrayList(set);
    }
}