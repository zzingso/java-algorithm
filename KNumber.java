import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42748

class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for(int[] intArr : commands) {
        	
        	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        	
        	for(int i = intArr[0]-1; i < intArr[1]; i++) {
        		pQueue.add(array[i]);
        	}
        	
        	for(int j = 0; j < intArr[2]; j++) {
        		if(j == intArr[2] - 1) {
        			answer[index] = pQueue.poll();
        			index++;
        		} else {
        			pQueue.poll();
        		}
        	}
        }
        
        return answer;
    }
}