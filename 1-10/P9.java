public class Solution {
    
    int mod = 1000000007; 
    public int solve(int[] A) {
        
        return (int) (mergeSort(A,0,A.length-1) % mod);
        
    }
    
    public long mergeSort(int[] A, int start,int end){
        
        if(start >= end) return 0;
        int mid = start + (end-start)/2;
        long k = mergeSort(A, start,mid) + mergeSort(A, mid+1, end);
        int i = mid + 1;
        for(int j=start;j<=mid;j++){
            
            while(i<=end && A[j] > A[i]) i++;
            k += (i-(mid+1));
            k %= mod;
        }
        Arrays.sort(A,start,end+1);
        return k;
    }
    
    
}
