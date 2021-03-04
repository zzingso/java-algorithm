import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42862
class Sportsware {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n - lost.length;

    List<Integer> resultList = new ArrayList<Integer>(Collections.nCopies(n, 0));
    List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
    List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

    List<Integer> dupList = reserveList.stream().filter(x -> lostList.contains(x))
.collect(Collectors.toList());

    if(dupList.size() > 0) {
      for(Integer dup : dupList) {
        answer++;
        reserveList.remove((Integer)dup);
        lostList.remove((Integer)dup);
      }
    }

    for (int i = 0; i < lostList.size(); i++) {
      Integer lostStudent = lostList.get(i);

      if(reserveList.contains(lostStudent-1)) {
        answer++;
        reserveList.remove((Integer)(lostStudent-1));
        continue;
      }

      if(reserveList.contains(lostStudent+1)) {
        answer++;
        reserveList.remove((Integer)(lostStudent+1));
        continue;
      }
    }

    return answer;
  }
}