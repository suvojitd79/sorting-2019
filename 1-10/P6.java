public class Solution {
    
    public int solve(int[] A) {
        return mergeSort(A, 0, A.length-1);
    }
    
    public int mergeSort(int[] A, int start,int end){
        
        if(start >= end) return 0;
        
        int mid = start + (end-start)/2;
        int k = mergeSort(A,start,mid) + mergeSort(A,mid+1,end);
        
        for(int i=start,j=mid+1;i<=mid;i++){
            while(j <= end && A[i]/2.0 > A[j]) j++;
            k += (j-(mid+1));
        }
        
        Arrays.sort(A,start,end+1);
        return k;
    }
}
