import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Main {

  public static final String JAVA = "java";
  public static final String MAIN = "Main.java";

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    File file = new File("/home/runner/java-algorithm");
    List<File> fileList = new ArrayList<File>();
    int count = 1;

    System.out.println("\n# Choose a Program ::\n");

    for(File f: file.listFiles()){
      String fileName = f.getName();
      String ext = fileName.substring(fileName.lastIndexOf(".") + 1);

      if(JAVA.equals(ext) && !MAIN.equals(fileName)) {
        fileList.add(f);
        System.out.println(count + " : " + f.getName());
        count++;
      }
    }

    // int selectedFile = sc.nextInt();
    // System.out.println(fileList.get(selectedFile - 1).getName());


    //FindPrimeNumber f = new FindPrimeNumber();
    //System.out.println(f.solution("17"));
    //System.out.println(f.getResult("011"));

    //Carpet c = new Carpet();
    //System.out.println(c.solution(16, 9));

    // Sportsware s = new Sportsware();
    // int[] lost = {2, 6};
    // int[] reserve = {2, 6};
    // System.out.println(s.solution(7, lost, reserve));

    //NewIdRecommend id = new NewIdRecommend();
    //System.out.println(id.solution("...!@BaT#*..y.abcdefghijklm"));
    
    // StringCompression sc = new StringCompression();
    // sc.solution("");
  }
}