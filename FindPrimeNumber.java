import java.util.List;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class FindPrimeNumber {

  public int solution(String numbers) {
    int answer = 0;
    System.out.println(numbers);

    int[] list = new int[numbers.length()];

    for (int i = 0; i < numbers.length(); i++) {
      list[i] = Character.getNumericValue(numbers.charAt(i));
    }

    for (int i = 0; i < list.length; i++) {
      //int targetNum = permutation(list, 0, list.length, i+1);
      //System.out.println("targetNum : " + targetNum);
      permutation(list, 0, list.length, i+1);

    }

    return answer;
  }

  public boolean findPrimeNumber(int num) {
    boolean result = true;

    if(num%2 == 0) {
      result = num == 2 ? true : false;
    } else {
      int sqrt =  (int)Math.ceil(Math.sqrt(num));

      for(int i=3; i<sqrt; i+=2) {
        if(num % i == 0) {
          result = false;
          break;
        }
      }
    }

    return result;
  }

  public void permutation(int[] arr, int depth, int n, int r) {
    //System.out.println("depth : " + depth);
    //System.out.println("r : " + r);
    if (depth == r) {
        //print(arr, r);
        String result = Arrays.toString(arr).replace(", ","").replace("[","").replace("]","").substring(0, r);
        System.out.print(Integer.parseInt(result));
    }

    for (int i=depth; i<n; i++) {
        swap(arr, depth, i);
        permutation(arr, depth + 1, n, r);
        //swap(arr, depth, i);
    }
  }
  
  public void swap(int[] arr, int depth, int i) {
      System.out.println("depth : " + depth);
      System.out.println("i : " + i);
      int temp = arr[depth];
      arr[depth] = arr[i];
      arr[i] = temp;
  }

  // 배열 출력
  public void print(int[] arr, int r) {
      for (int i = 0; i < r; i++)
          System.out.print(arr[i] + " ");
      System.out.println();
  }
}