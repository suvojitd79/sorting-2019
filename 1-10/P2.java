public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        
        
        if(B==0 || B > A.size()) return 0;
        
        int ans = Integer.MAX_VALUE;
        
        Collections.sort(A);
        
        for(int i=0,j=B-1;j<A.size();i++,j++){
            ans = Math.min(ans, A.get(j)-A.get(i));
        }
        return ans;
    }
}
