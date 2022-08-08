import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    String path;
    ArrayList<String> array;
    public ArrayList<String> str;


    public Parser(String path) {
        this.path = path;
        this.str = new ArrayList<String>();
    }

    public void getFileStr() throws IOException {
        // BufferedReader sc = new BufferedReader(new FileReader(path));
        Scanner sc = new Scanner(new File(path));
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            str.add(line);
        }
        
    }

    public ArrayList<String> getFileArr() throws IOException {
        array = new ArrayList<String>();
        Scanner sc = new Scanner(new File(path));
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            array.add(line);
        }
        return array;
        
    }

    public void printer() {
        System.out.println(str);
    }

    //array of instructions [ADD R1 R2, ADD R99 R55]


    public static void main(String[]args) throws IOException {

       int x = -5;
       String a = Integer.toBinaryString(x);
       System.out.println(a.substring(a.length()-8, a.length()));
       
    }
}

