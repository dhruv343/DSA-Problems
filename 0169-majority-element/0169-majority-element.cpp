#include <bits/stdc++.h>
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n=nums.size();
        sort(nums.begin(),nums.end());
        int maxe=0;
        int majele=-1;
        int count=1;
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
                if(count>maxe){
                    maxe=count;
                    majele=nums[i];
                }
                
            }
            else{
                
                count=1;
            }
        }
        return majele;
    }
};