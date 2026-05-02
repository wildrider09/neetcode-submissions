class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0)
            return false;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int h : hand){
            map.put(h, 1 + map.getOrDefault(h, 0));
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());

        while(!queue.isEmpty()){
            int temp = queue.peek();
            if(!map.containsKey(temp)){
                queue.poll();
                continue;
            }

            for(int i=0; i<groupSize;  i++){
                if(map.containsKey(temp+i)){
                    if(map.get(temp+i) > 1)
                        map.put(temp + i, map.get(temp+i) - 1);
                    else if(map.get(temp+i) == 1)
                        map.remove(temp+i);
                }
                else
                    return false;
            }
        }

        return true;

        
        
    }
}
