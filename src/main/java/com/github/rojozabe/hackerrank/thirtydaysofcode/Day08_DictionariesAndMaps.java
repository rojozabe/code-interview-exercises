package hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import utils.FileHelper;

public class Day08_DictionariesAndMaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = FileHelper.readFile("./src/test/java/com/github/rojozabe/hackerrank/thirtydaysofcode/Day8_DictionariesAndMaps.txt");
        int n = Integer.parseInt(br.readLine().trim());
        Map<String, Integer> phoneBook = new HashMap<String, Integer>(n);

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split("\\s+");
            String name = s[0];
            int phone = Integer.parseInt(s[1]);
            phoneBook.put(name, phone);
        }

        while(br.ready()) {
            String lookupName = br.readLine().trim();
            if (phoneBook.containsKey(lookupName)) {
                System.out.printf("%s=%d\n", lookupName, phoneBook.get(lookupName));
            } else {
                System.out.println("Not found");
            }
            
            
        }
        br.close();        
    }
}