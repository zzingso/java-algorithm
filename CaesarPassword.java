// https://programmers.co.kr/learn/courses/30/lessons/12926

class CaesarPassword {
  public String solution(String s, int n) {
     String answer = "";
		char[] cArr = s.toCharArray();
		
		for(int i=0; i<cArr.length; i++) {
			int cInt = cArr[i];
			
			if(cInt == 32) {
				continue;
			}
			
			System.out.println(cInt);
			
			//upper case
			if(cInt > 64 && cInt < 91) {
				cInt = cInt + n;
				if(cInt > 90) {
					cInt = cInt - 26;
				}
				
				cArr[i] = (char)(cInt);
			}
			
			//lower case
			if(cInt > 96 && cInt < 123) {
				cInt = cInt + n;
				
				if(cInt > 122) {
					cInt = cInt - 26;
				}
				cArr[i] = (char)(cInt);
			}
		}
		
		answer = String.valueOf(cArr);
		
		return answer;
  }
}