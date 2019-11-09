public class Solution {
    
    private int mod = 1000000007;
    
    public int solve(ArrayList<Integer> A) {
    
        long ans = 0;
        ArrayList<Integer> cache = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                for(int k=0;k<A.size();k++){
                    int val = A.get(i) * A.get(j) + A.get(k);
                    map.put(val, map.getOrDefault(val,0) + 1);
                }
            }
        }
    
        for(int d=0;d<A.size();d++){
            
            if(A.get(d) == 0) continue; // divide by zero
        
            for(int e=0;e<A.size();e++){
                for(int f=0;f<A.size();f++){
                    int val = A.get(d) * A.get(e) + A.get(d) * A.get(f);
                    ans += map.getOrDefault(val, 0);
                    ans %= mod;
                }
            }
        }
        
        
        
        return (int)(ans % mod);
        
        
    }
    
}
