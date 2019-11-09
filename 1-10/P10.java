public class Solution {
    
    class Seat{
        int row,width;
        Seat(int row,int width){
            this.row = row;
            this.width = width;
        }
    }
    
    public int[] solve(int[] A, String B) {
        
        ArrayList<Seat> seats = new ArrayList();
        
        int[] ans = new int[B.length()];
        
        for(int i=0;i<A.length;i++) seats.add(new Seat(i+1, A[i]));
        
        Collections.sort(seats,  new Comparator<Seat>(){
            public int compare(Seat x,Seat y){
                return x.width - y.width;
            }    
        });
        
        
        int i = 0;
        
        for(int i1=0;i1<B.length();i1++){
            
            if(B.charAt(i1) == '0'){
                    ans[i1] = seats.get(i).row;
                    seats.add(seats.get(i));
                    i += 1;
            }else{
                Seat seat = seats.get(seats.size()-1);
                ans[i1] = seat.row; 
                seats.remove(seats.size()-1);
            }
            
        }
        
        return ans;
    }
    
    
}
