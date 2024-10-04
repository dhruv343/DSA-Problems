class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length-1;i++){
            int ele=-1;
            for(int j=i+1;j<nums2.length;j++){
            if(nums2[i]<nums2[j]){
                ele=nums2[j];
                break;
            }
            }       
            map.put(nums2[i],ele);    
        }
        map.put(nums2[nums2.length-1],-1);
        
        for(int i=0;i<nums1.length;i++){
           
            nums1[i]=map.get(nums1[i]);
        }

        return nums1;
    }
}