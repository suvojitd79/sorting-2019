import java.util.*;
public class P4{
	
	/*

	f(x,y,z) = (x+y) * (y+z) iff x <=y && z <= y else 0

	*/


	// O(x*(logy + logz))
	public int upper_bound(ArrayList<Integer> x, int num){

		int l = 0;
		int h = x.size();

		while(l<h){

			int mid = l + (h-l)/2;

			if(x.get(mid) <= num) l = mid + 1;
			else h = mid;

		}	

		return l;
	} 


	public int solve(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> z){

		int mod = 1000000007;

		Collections.sort(x);
		Collections.sort(z);

		int[] prefixSumX = new int[x.size()];
		Arrays.fill(prefixSumX, 0);

		int[] prefixSumZ = new int[z.size()];
		Arrays.fill(prefixSumZ, 0);


		prefixSumX[0] = x.get(0);
		for(int i=1;i<x.size();i++)
				prefixSumX[i] = prefixSumX[i-1] + x.get(i);


		prefixSumZ[0] = z.get(0);	
		for(int i=1;i<z.size();i++)
				prefixSumZ[i] = prefixSumZ[i-1] + z.get(i);

		long ans = 0;	

		for(int i=0;i<y.size();i++){

			int num = y.get(i);	

			int xNum = upper_bound(x, num);

			if(xNum == 0) continue;

			int zNum = upper_bound(z, num);

			if(zNum == 0) continue;


			ans += ( (prefixSumX[xNum-1] + (xNum * num)) * (prefixSumZ[zNum-1] + (zNum * num)) );

			ans %= mod;
		}	

		return (int) (ans % mod);

	}


	public static void main(String... args){

    	ArrayList<Integer> x = new ArrayList<>(Arrays.asList(1,4,5));
    	ArrayList<Integer> y = new ArrayList<>(Arrays.asList(2,3));
    	ArrayList<Integer> z = new ArrayList<>(Arrays.asList(2,1,3));

    	System.out.println(new P4().solve(x,y,z));


	}



}