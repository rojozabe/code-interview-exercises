package hackerrank.thirtydaysofcode;

public class Day21_Generics {
    private static class Printer<T> {
        public void printArray(T[] a) {
            for (T value : a) {
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {
        //BufferedReader br = FileHelper.readFile(System.in);
        @SuppressWarnings("unused")
        int n = 3;//Integer.parseInt(br.readLine().trim());
        Integer[] intArray = {1, 2, 3}; //Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        
        n = 2;//Integer.parseInt(br.readLine().trim());
        String[] stringArray = {"a", "b"}; //br.readLine().trim().split("\\s+");

        Printer<Integer> intPrinter = new Printer<Integer>();
        Printer<String> stringPrinter = new Printer<String>();
        intPrinter.printArray( intArray  );
        stringPrinter.printArray( stringArray );
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
        
        //br.close();
    }
}