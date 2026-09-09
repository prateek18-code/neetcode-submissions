class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(char nums: s.toCharArray()){
            if(map.containsKey(nums)){
                map.put(nums, map.get(nums)+1);
            }else{
                map.put(nums, 1);
            }
        }
        for(char nums: t.toCharArray()){
            if(!map.containsKey(nums)){
                return false;
            }
            map.put(nums, map.get(nums) - 1);
            if(map.get(nums) < 0){
                return false;
            }
        }
        return true;
    }
}
