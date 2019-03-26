package hackerrank.thirtydaysofcode;

//import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//import utils.FileHelper;

public class Day26_NestedLogic {
    private static int calculatesFine(LocalDate returnedDate, LocalDate dueDate) {        
        if (returnedDate.isAfter(dueDate)){
            if (returnedDate.getYear() > dueDate.getYear()) {
                return 10000;
            } else if (returnedDate.getMonthValue() > dueDate.getMonthValue()) {
                return (int) ChronoUnit.MONTHS.between(dueDate, returnedDate) * 500;
            } else if(returnedDate.getDayOfMonth() > dueDate.getDayOfMonth()) {
                return (int) ChronoUnit.DAYS.between(dueDate, returnedDate) * 15;
            }
        }        

        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        //BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day26_NestedLogic.txt");  

        String[] rDateStr = {"23", "12", "1234"};//br.readLine().trim().split("\\s+");
        LocalDate returnedDate = LocalDate.of(Integer.parseInt(rDateStr[2]), Integer.parseInt(rDateStr[1]), Integer.parseInt(rDateStr[0]));

        String[] dDateStr = {"19", "9", "2468"};//br.readLine().trim().split("\\s+");
        LocalDate dueDate = LocalDate.of(Integer.parseInt(dDateStr[2]), Integer.parseInt(dDateStr[1]), Integer.parseInt(dDateStr[0]));

        System.out.println(calculatesFine(returnedDate, dueDate));

        
        //br.close();
    }
}