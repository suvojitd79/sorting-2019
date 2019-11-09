public class Solution {
    
    int b,c;
    public int solve(int[] A, int B, int C) {
        b = B;
        c = C;
        int[] cache = new int[A.length+1];
        cache[0] = 0;
        for(int i=0;i<A.length;i++) cache[i+1] = cache[i] + A[i];
        return mergeSort(cache, 0, cache.length);
    }
    
    public int mergeSort(int[] cache, int start, int end){
        
        int mid = start + (end-start)/2;
        
        if(mid == start) return 0;    
        
        int k = mergeSort(cache,start,mid) + mergeSort(cache,mid,end);
        
        int i,j;

        i = j = mid;
        
        for(int i1=start;i1<=mid-1;i1++){
            
            while(i<end && cache[i]-cache[i1] < b) i++;
            while(j<end && cache[j]-cache[i1] <= c) j++;
            k += (j-i);

        }
        
        Arrays.sort(cache, start, end);
        
        return k;
    }
    
}
