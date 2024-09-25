class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> answerList=new ArrayList<>();

        for(int i=0;i<strs.length;i++){

            char[] charArray=strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStrs=new String(charArray);

            if(!map.containsKey(sortedStrs)){
                map.put(sortedStrs,new ArrayList<>());
            }
            
            map.get(sortedStrs).add(strs[i]);
            
        }

        for(List<String> list:map.values()){
            answerList.add(list);
        }

        return answerList;
    }
}