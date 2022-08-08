import java.math.BigInteger;
public class Instruction {

    String inst = "IF";
    String data;
    String type;

    boolean Register1Signed = false;
    boolean Register2Signed = false;

    public Instruction(String data){
        this.data = data;
    }
    
    public static String Add(Register R1, Register R2){
      //  System.out.println(Integer.parseInt(R1.data, 2));
       // System.out.println(Integer.parseInt(R1.data, 2));

        int temp = Integer.parseInt(R1.data, 2) + Integer.parseInt(R2.data, 2);
        String checker = new BigInteger(Integer.toString(temp)).toString(2);

      //  if(data.substring(3,4))

        

        //int index = checker.length() - 4;
        String a = checker.substring(0, 1);
        System.out.println(checker);
        System.out.println(a);
        if(checker.substring(0, 1) == "1"){
            return "true";
        }
        else{
            return "false";
        }
    }

    public static void main(String[] args) {
        //Register R1 = new Register("R1", "1000");
        //Register R2 = new Register("R2", "1111");
       // System.out.print(Add(R1,R2));
       // Add(R1, R2);
    }


}
