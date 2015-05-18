import java.util.*;

public class MergeSort{

	public static void main(String[] args){
		MergeSort start = new MergeSort();
		start.go(args);
	}
	public void go(String[] args){
		// Scanner sc = new Scanner(System.in);
		// while (sc.hasNext()){
		// 
		// }
		int[] unsorted={4,64,7,8,111,24,62,124,4,7,1,4,6,1,562,14,25,63,42,13,2,4,61,62,7,8,0,-3,-17,23,4,8,9,5,1,8,4,2,12,3431,43,52,67};
		int[] sorted=mergeSort(unsorted,0,unsorted.length-1);
		for (int i=0; i<sorted.length; i++){
			System.out.print(sorted[i]+" ");
		}
	}
	public int[] mergeSort(int[] unsorted, int lo, int hi){
		int mid = ((lo+hi)/2)
;		if (lo>=hi){
			int[] baseCase=new int[1];
			baseCase[0]=unsorted[mid];
			return baseCase;
		}
		else{
			int[] leftMerge=mergeSort(unsorted, lo, mid);
			int[] rightMerge=mergeSort(unsorted,mid+1,hi);
			return merge(leftMerge,rightMerge);
		}

	
}	public int[] merge(int[] leftMerge, int[] rightMerge){
		int length=(leftMerge.length+rightMerge.length);
		int[] sorted=new int[length];
		int leftCounter=0;
		int rightCounter=0;
		for (int i=0; i<length; i++){
			if (leftMerge[leftCounter]<rightMerge[rightCounter]){
				sorted[i]=leftMerge[leftCounter];
				leftCounter++;
				if (leftCounter==leftMerge.length){
					for (int j=rightCounter; j<rightMerge.length; j++){
						sorted[++i]=rightMerge[j];
					}
					// for (int x=0; x<sorted.length; x++){
					// 	System.out.print("Sorted is "+sorted[x]+" ");
					// }
					return sorted;
				}
			}
			else{
				sorted[i]=rightMerge[rightCounter];
				rightCounter++;
				if (rightCounter==rightMerge.length){
					for (int k=leftCounter; k<leftMerge.length; k++){
						sorted[++i]=leftMerge[k];
					}
					// for (int x=0; x<sorted.length; x++){
					// 	System.out.print("Sorted is "+sorted[x]+" ");
					// }
					return sorted;
				}
			}
		}
		// for (int x=0; x<sorted.length; x++){
		// 	System.out.print("Sorted is "+sorted[x]+" ");
		// }
		return sorted;
	}
}