/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        int n = intervals.size();
        int start[] = new int[n];
        int end[] = new int[n];

        for(int i=0; i<intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0, ans = 0, sp = 0, ep= 0;

        while(sp<n){
            if(start[sp]<end[ep]){
                count ++;
                ans = Math.max(ans, count);
                sp ++;
            }
            else if(start[sp]>=end[ep]){
                count --;
                ep++;
            }
        }

        return ans;

    }
}
