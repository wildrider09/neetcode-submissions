class Solution {
    class Pair{
        int i,j;
        double dist;
        public Pair(int i, int j, double dist){
            this.i=i;
            this.j=j;
            this.dist=dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> 
                                    Double.compare(b.dist, a.dist));
        int arr[][]= new int[k][2];
        int j=0;

        for(int i=0; i<points.length && i<k; i++)
        {
            double d = Math.sqrt(
                (points[i][0]*points[i][0])+
                (points[i][1]*points[i][1])
            );

            q.add(new Pair(points[i][0], points[i][1], d));
        }

        for(int i=k; i<points.length; i++){
            double d = Math.sqrt(
                (points[i][0]*points[i][0])+
                (points[i][1]*points[i][1])
            );

            if(q.peek().dist>d){
             q.poll();
             q.add(new Pair(points[i][0], points[i][1], d));
            }
        }

        while(!q.isEmpty()){
            arr[j][0] = q.peek().i;
            arr[j][1] = q.poll().j;
            j++; 
        }
        return arr;

    }
}
