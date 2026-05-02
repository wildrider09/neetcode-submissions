class Solution {
    class Pair{
        int i;
        int j;
        public Pair(int i,int j){
            this.i =i;
            this.j =j;
        }
    };

    public void islandsAndTreasure(int[][] mat) {

        int visited[][]= new int[mat.length][mat[0].length];
        int move[]= {0,1,0,-1,0};
        int dist = 0;
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]== 0){
                    q.add(new Pair(i,j));
                    visited[i][j]= -1;
                }
            }
        }

        while(!q.isEmpty()){
            int count = q.size();
            for(int i=0; i<count; i++){
                Pair p = q.peek(); q.remove();
                mat[p.i][p.j] = dist;

                for(int k=0;k<4;k++){
                    if(mat.length> p.i+move[k] && p.i+move[k]>-1 &&
                        mat[0].length> p.j+move[k+1] && p.j+move[k+1]>-1 &&
                        visited[p.i+move[k]][p.j+move[k+1]]!=-1 &&
                        mat[p.i+move[k]][p.j+move[k+1]]!=-1){
                            visited[p.i+move[k]][p.j+move[k+1]] = -1;
                            q.add(new Pair(p.i+move[k], p.j+move[k+1]));
                    }
                }
            }
            dist++;
        }  
    }
}
