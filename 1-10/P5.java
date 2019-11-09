public class Solution {
    
    private int[] ans;
    public int[] solve(int[] A) {
        
        ans = new int[A.length];
        Arrays.fill(ans, 0);
        int[] index = new int[A.length];
        for(int i=0;i<A.length;i++) index[i] = i;
        mergeSort(A,index,0,A.length-1);    
        return ans;
    }
    
    public void mergeSort(int[] A,int[] index, int start, int end){
        
        if(start >= end) return;
     
        int mid = start + (end-start)/2;
        
        mergeSort(A,index,start,mid);
        mergeSort(A,index,mid+1,end);
        merge(A,index,start,end);   
    }
    
    
    public void merge(int[] A,int[] index, int start,int end){
        
        int[] new_index = new int[end-start+1];
        int mid = start + (end-start)/2;
        int left_index = start;
        int right_index = mid+1;
        int count = 0;
        int k = 0;
        
        while(left_index <= mid && right_index <= end){
            
            if(A[index[right_index]] < A[index[left_index]]){
                new_index[k] = index[right_index];
                count++;
                right_index++;
            }else{
                new_index[k] = index[left_index];
                ans[index[left_index]]+= count;
                left_index++;
            }
            k++;
        }
        
        
        while(left_index <= mid){
            new_index[k] = index[left_index];
            ans[index[left_index]] += count;
            left_index++;
            k++;
        }
        
        while(right_index <= end){
            new_index[k] = index[right_index];
            right_index++;
            k++;
        }
        
        for(int i=start;i<=end;i++)
            index[i] = new_index[i-start];
        
    }
    
    
}
