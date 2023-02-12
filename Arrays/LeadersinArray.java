//import java.util.*;

public class LeadersinArray {
  public static void main(String[] args) {
    int[] arr1 = {4, 7, 1, 0};
    System.out.println("The leaders of the first array are: ");
    printLeadersOptimal(arr1, arr1.length);

    int[] arr2 = {10, 22, 12, 3, 0, 6};
    System.out.println("The leaders of the second array are: ");
    printLeadersOptimal(arr2, arr2.length);
  }

  public static void printLeadersOptimal(int[] arr, int n) {
    //Choosing the right most element as the maximum
    int max = arr[n - 1];

    System.out.print(arr[n - 1] + " ");

    for (int i = n - 2; i >= 0; i--)
      if (arr[i] > max) {
        System.out.print(arr[i] + " ");
        max = arr[i];
      }

    System.out.println();
  }

}