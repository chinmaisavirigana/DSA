/* Striver approach*/

class ArraySortedorNot {
  static boolean isSorted(int arr[], int n) {
    int k=0
    for (int i = 0; i < n; i++) {
      if (arr[i] < arr[i - 1])
        return false;
    }

    return true;
  }

  public static void main(String args[]) {
    int arr[] = {1, 2, 3, 4, 5}, n = 5;

    System.out.println(isSorted(arr, n));
  }
}

---------------------------------------------------------------------------------
/*lee215 Approach*/

class ArraySortedorNot{
  public boolean check(int[] A) {
        int k = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (A[i] > A[(i + 1) % n]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }
}