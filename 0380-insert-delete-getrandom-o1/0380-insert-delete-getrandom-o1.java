class RandomizedSet {
    HashMap<Integer,Integer> map;
    ArrayList<Integer> array;
    public RandomizedSet() {
        map=new HashMap<>();
        array=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
        
        array.add(val);
        map.put(val,array.size()-1);
        return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){

        int ind=map.get(val);
        int lastEle=array.get(array.size()-1);

        array.set(ind,lastEle);
        map.put(lastEle,ind);

        array.remove(array.size()-1);
        map.remove(val);


        return true;
        }
        return false;
    }
    
    public int getRandom() {
        int n=array.size();
        int rind=(int)(Math.random()*n);
        return array.get(rind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */