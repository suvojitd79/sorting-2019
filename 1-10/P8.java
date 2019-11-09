public class Solution {
    
    public int gcd(int x,int y){
        
        if(y==0) return x;
        
        return gcd(y, x%y);
    }
    
    public int[] solve(int[] A) {
        
        Arrays.sort(A);
        
        if(A.length>2){
            
            for(int i=2;i<A.length;i++){
                
                if(A[i] != A[i-1] + gcd(A[i-1],A[i-2])){
                    
                    return new int[]{-1};   
                    
                }
                
            }
            
            return A;
            
        }
        
        
        if(A.length == 2){
            
            if(A[0] > A[1]) {
                
                return A;
                
            }
            
            else{
                
                return new int[]{A[1],A[0]};
                
            }
            
        }
     
     return A;   
    }
    
    
}
