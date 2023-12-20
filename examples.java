import java.util.*;

import static common.BasePage.find;

class Scratch
{
  public static void main(final String[] args)
  {       }

  // Function to generate Fibonacci sequence up to n terms
  public static void generateFibonacci(final int n) {
    int first = 0, second = 1;
    System.out.println("Fibonacci Sequence up to " + n + " terms:");
    for (int i = 0; i < n; i++) {
      System.out.print(first + " ");
      final int next = first + second;
      first = second;
      second = next;
    }
  }

  // Function to generate prime numbers up to a given limit
  public static List<Integer> primeNumbersBruteForce(final int n) {
    final List<Integer> primeNumbers = new LinkedList<>();
    for (int i = 2; i <= n; i++) {
      if (isPrimeBruteForce(i)) {
        primeNumbers.add(i);
      }
    }
    for (final int number:primeNumbers)
    {
      System.out.print(number+ " ");
    }
    return primeNumbers;
  }
  public static boolean isPrimeBruteForce(final int number) {
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  // Function to perform bubble sort on an array
  public static void bubbleSort(final int[] arr) {
    final int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          final int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;        }      }   }  }

  // Function to reverse an array
  private static void reverseArray(int[] arr) { int start = 0;    int end = arr.length - 1;
    while (start < end) {
      // Swap elements at start and end positions
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      // Move towards the center
      start++;
      end--;    }}

  // Function to remove duplicates from an array a HashSet is a place where duplicates are not allowed
  private static int[] removeDuplicates(final int[] arr) {
    final Set<Integer> uniqueSet = new HashSet<>();
    for (final int value : arr) {  uniqueSet.add(value);    }
    final int[] resultArray = new int[uniqueSet.size()];
    int index = 0;
    for (final int value : uniqueSet) { resultArray[index++] = value;    }
    return resultArray;  }

  private static int computeSumWithRules(final int[] numbers)
  {
    int total = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (i % 2 == 0) {
        // Add numbers at even-numbered indexes
        total += numbers[i];
      } else {
        // Subtract numbers at odd-numbered indexes
        total -= numbers[i];
      }
    }
    return total;
  }

  // Write an algorithm to swap two given numbers in Java without using a temporary variable
  private static void swapNumbers(int n1, int n2)
  {
    n1 = n1 + n2;
    n2 = n1 - n2; // this will act like (a+b) - b, and now b equals a.
    n1 = n1 - n2; // this will act like (a+b) - a, and now an equals b.
    System.out.println(n1+ " " +n2);
  }

  // Linear search function
  private static int linearSearch(final int[] arr, final int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i; // Return the index if target is found
      }
    }
    return -1; // Return -1 if target is not found
  }

  // Binary search algorithm
  public static int binarySearch(final int[] arr, final int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        return mid; // Return the index if target is found
      } else if (arr[mid] < target) {
        left = mid + 1; // Search in the right half
      } else {
        right = mid - 1; // Search in the left half
      }
    }
    return -1; // Return -1 if target is not found
  }

  public static class SortingExample {
    public static void main(final String[] args) {
      // Example usage:
      final int[] numbers = {4, 2, 8, 1, 3, 7, 6};
      // Sorting the array in ascending order
      Arrays.sort(numbers);
      // Displaying the sorted array
      System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(numbers));
    }
  }

  public static class InvertSortingExample {
    public static void main(final String[] args) {
      // Example usage:
      final Integer[] numbers = {4, 2, 8, 1, 3, 7, 6}; // Integer wrapper class for sorting in descending order
      // Sorting the array in descending order
      Arrays.sort(numbers, Collections.reverseOrder());
      // Displaying the sorted array
      System.out.println("Sorted Array in Descending Order: " + Arrays.toString(numbers));
    }
  }

  public void selectSubMenuEl(final String elem)
  {
    switch (elem)
    {
      case "Email Validation":
        break;
      case "Solutions":
        // code block
        break;
      default:
        // code block
    }
  }

  public HashMap<String, String> getFilterListRequestParams(final String filterFile)
  {
    String[] urls = new String[0];
    for (final String entry : filterListLogsEntries)
    {
      if (entry.contains(filterFile))
      {
        urls = entry.split(" ");
      }
    }
    int index = 0;
    for (int i = 0; i < urls.length; i++)
    {
      if (urls[i].contains(filterFile))
      {
        index = i;
        break;
      }
    }
    final String[] x = urls[index].split("[?]");
    filterListUrl = x[0];
    final String[] listOfParams = x[1].split("[&]");
    final HashMap<String, String> queryParams = new HashMap<String, String>();
    for (final String part : listOfParams)
    {
      final String[] params = part.split("=");
      queryParams.put(params[0], params[1]);
    }
    return queryParams;
  }

  // Function to find minimum and maximum elements of an array
  private static void findMinMax(final int[] arr) {
    // Check if the array is empty
    if (arr == null || arr.length == 0) {
      System.out.println("Array is empty.");
      return;
    }
    // Initialize min and max with the first element of the array
    int min = arr[0];
    int max = arr[0];
    // Iterate through the array to find min and max
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
      if (arr[i] > max) {
        max = arr[i];
      }
    }}


}