import java.util.Calendar;

// https://programmers.co.kr/learn/courses/30/lessons/12901

class Year2016 {
  public String solution(int m, int d) {
    Calendar c = Calendar.getInstance();
		int year = 2016;
		c.set(year, m-1, d);
		
		int dayNum = c.get(Calendar.DAY_OF_WEEK);
		String[] weekDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		return weekDay[dayNum-1];
  }
}