public class DuplicateRemover {
	
	/* Remove all duplicates in the source array.
	 * No additional storage (i.e. array, arraylist, etc.) should be used as buffer
	 * Primitive type variables can be used
	 * Limit its running time in O(N)
	 */
	
	public static int apply(int[] data, int n) {
		int prev = -1;
		int i=0, j;
		while (i < n) {
			if (data[i] == prev)
				data[i] = -1;
			else
				prev = data[i];
			i++;
		}
		
		i = j = 0;
		while(j < n) {
			if (data[j] != -1) {
				data[i] = data[j];
				i++;
				j++;
			} else {
				j++;
			}
		}
		
		return i;
	}
	
	public static void print(int[] data, int n) {
		for (int i=0; i<n; i++) {
			System.out.print(data[i] + "\t");
			if (i%10 == 9)
				System.out.println();
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int[] data = { 3, 7, 9, 13, 14, 16, 19, 23, 24, 25, 26, 28, 31, 32,
				33, 33, 34, 36, 40, 41, 41, 42, 44, 47, 51, 54, 55, 56, 57, 58,
				59, 60, 64, 65, 69, 71, 73, 75, 76, 79, 82, 82, 86, 86, 88, 90,
				91, 92, 96, 98, 102, 104, 108, 109, 109, 112, 112, 113, 117,
				120, 121, 125, 126, 126, 126, 129, 131, 131, 133, 133, 136, 138 };
		
		System.out.println(String.format("Original data (%d):", data.length));
		print(data, data.length);
		
		int n = apply(data, data.length);
		
		System.out.println(String.format("Duplidates Removed data (%d):", n));
		print(data, n);
	}
	

}
