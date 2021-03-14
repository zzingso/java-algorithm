class StringCompression {
  public int solution(String s) {
      s = "abcabcdede";
      //s = "abcabcabcabcdededededede";
      String tempString = "";

      int answer = s.length();
      int subLength = s.length() / 2;

      while(subLength > 0) {
        System.out.println("subLength : " + subLength);

        int dupCount = 1;

        for(int i = 1; i < s.length() / subLength; i++) {
          int startIdx = i * subLength;
          String subStr = s.substring(startIdx, startIdx + subLength);
          
          int prevStartIdx = (i - 1) * subLength;
          String prevSubStr = s.substring(prevStartIdx, prevStartIdx + subLength);
          
          System.out.println("prevSubStr : " + prevSubStr);
          System.out.println("subStr : " + subStr);
          if(prevSubStr.equals(subStr)) {
            dupCount++;
            if(i == (s.length() / subLength) - 1) {
              if(dupCount > 1) {
                tempString += String.valueOf(dupCount);
              }
              tempString += prevSubStr;
            } 
          } else {
            if(i == (s.length() / subLength) - 1) {
              if(dupCount > 1) {
                tempString += String.valueOf(dupCount);
              }
              tempString += prevSubStr;
              tempString += subStr;
            } else {  
              System.out.println("dupCount : " + dupCount);
              if(dupCount > 1) {
                tempString += String.valueOf(dupCount);
              }
              tempString += prevSubStr;
              dupCount = 1;
            }
          }
        }

        int mod = s.length() % subLength;
        if(mod > 0) {
          tempString += s.substring(s.length() - mod, s.length());
        }
        
        if("".equals(tempString)) {
          tempString = s;
        }

        if(answer > tempString.length()) {
          answer = tempString.length();
        }

        System.out.println("tempString : " + tempString);
        
        subLength--;
        tempString = "";
      }

      System.out.println("answer : " + answer);

      return answer;
  }
}