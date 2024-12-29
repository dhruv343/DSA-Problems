class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();

        for(String str:strs){
                 
            char[] arr=str.toCharArray();

            Arrays.sort(arr);

            String sortedStr=new String(arr);

            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        List<List<String>> answer=new ArrayList<>();

        for(List<String> list:map.values()){
            answer.add(new ArrayList<>(list));
        }

        return answer;
    }
}