import java.util.*;

class Solution{
static int partition(int[] arr, int l, int r) {
    
    int f = arr[r] ;
	int i = l;

	for (int j = l; j <= r - 1; j++) {
		if (arr[j] <= f) {
		    int temp=arr[i];
		    arr[i]=arr[j];
		    arr[j]=temp;
			i++;
		}
	}
	int temp=arr[i];
        arr[i]=arr[r];
        arr[r]=temp;
	return i;
}

static int kth_Smallest_Element(int[] arr,int l,int r, int k) {
    if (k <= r - l + 1 && k > 0) {

		int ind = partition(arr, l, r);


		if (ind - l == k - 1) {
			return arr[ind];
		}
		if (ind - l > k - 1) {
			return kth_Smallest_Element(arr, l, ind - 1, k);
		}


		return kth_Smallest_Element(arr, ind + 1, r, k - ind + l - 1);
	}
	return Integer.MAX_VALUE;
}

public static void main(String args[]) {

    int arr[]={12,3,5,7,4,19,26};

    int n = arr.length, k = 1;
    System.out.println("Kth Smallest element is "+kth_Smallest_Element(arr, 0,n-1,k));
    }
}
