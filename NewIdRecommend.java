// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

// https://programmers.co.kr/learn/courses/30/lessons/72410
class NewIdRecommend {
    public String solution(String new_id) {
        String answer = "";
        char[] charArray = new_id.toLowerCase().toCharArray();

        int dotCount = 0;
        for(char c : charArray) {
          if(
            Character.isLowerCase(c) == true || 
            Character.isDigit(c) == true ||
            c == '-' || c == '_' || c == '.'
          ) {
            if(c == '.') {
              if(dotCount == 0) {
                answer += c;
              }
              dotCount++;
            } else {
              dotCount = 0;
              answer += c;
            }
          }
        }  

        if(answer.startsWith(".")) {
          answer = answer.substring(1);
        }

        if(answer.endsWith(".")) {
          answer = answer.substring(0, answer.length()-1);
        }

        if("".equals(answer)) {
          answer = "a";
        }

        if(answer.length() > 15) {
          answer = answer.substring(0, 15);
        }

        if(answer.endsWith(".")) {
          answer = answer.substring(0, answer.length()-1);
        }

        if(answer.length() <= 2) {
          int length = answer.length();
          String appendStr = answer.substring(length-1, length);

          while(true) {
            answer = answer.concat(appendStr);
            if(answer.length() == 3) {
              break;
            }
          }
        }
        
        return answer;
    }
}