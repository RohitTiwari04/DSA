class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }

        for(char ch : t.toCharArray()){
            if(map.containsKey(ch) == false){
                return false;
            }else if(map.get(ch) == 1){
                map.remove(ch);
            }else{
                map.put(ch , map.get(ch) -1);
            }
        }
        return map.size() == 0;
    }
}