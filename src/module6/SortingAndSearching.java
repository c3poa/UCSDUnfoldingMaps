package module6;

public class SortingAndSearching {

	public static void main(String[] args) {
		
		int[] arr = { 76, 2, 13, 90, 21, 17};
		
		/*	Selection Sort
		 * for(int i = 0; i < arr.length-1; i++) {
			int smallest = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[smallest]) {
					swap(arr, j, smallest);
				}
			}
		}*/
		
		//Insertion Sort
//		int currInd;
//		for(int i = 0; i < arr.length; i++) {
//			currInd = i;
//			while(currInd > 0 && arr[currInd] < arr[currInd-1]) {
//				swap(arr, currInd, currInd-1);
//				currInd--;
//			}
//		}
//		
		//Binary Search
		

	}

	private static void swap(int[] arr, int i, int smallest) {
		int min = arr[i];
		arr[i] = arr[smallest];
		arr[smallest] = min;
	}

}
