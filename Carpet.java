import java.util.List;
import java.util.ArrayList;

// https://programmers.co.kr/learn/courses/30/lessons/42842
class Carpet {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    List<Integer> yellowComination = new ArrayList<Integer>();

    for (int i = 1; i <= yellow; i++) {
      if(yellow / i == i) {
        yellowComination.add(i);
      }

      if (yellow % i == 0) {
        yellowComination.add(i);
      }
    }

    int size = yellowComination.size();
    for (int i = 0; i < size/2; i++) {
      int height = yellowComination.get(i);
      int width = yellowComination.get(size - i - 1);

      if((2 * width) + (2 * height) + 4 == brown) {
        answer[0] = width + 2;
        answer[1] = height + 2;
        System.out.println(answer[0] + " : " + answer[1]);
        break;
      }
    }

    return answer;
  }
}