//import java.math.BigInteger;

public class StatusRegister {
    String name;
    String data;
    boolean C;
    boolean V;
    boolean S;
    boolean N;
    boolean Z;

    public StatusRegister(String name, String data){
        this.name = name;
        this.data = data;

        C = false;
        V = false;
        S = false;
        N = false;
        Z = false;

        
    }
    // DEC TO BIN -->>    new BigInteger("10").toString(2)

    public void PrintStatus(){
        System.out.println("C: " + C + " V: " + V + " N: " + N + " S: " + S + " Z: " + Z);
    }

    public void Status(){
        int x = Integer.parseInt(data, 2);

      //  String x = new BigInteger(data).toString(2);
        System.out.println(x);


        int temp = x & 0b00000001;
        if(temp == 1){
            this.Z = true;
        }

        temp = x & 0b00000010;
        if(temp == 2){
            this.S = true;
        }

        temp = x & 0b00000100;
        if(temp == 4){
            this.N = true;
        }

        temp = x & 0b00001000;
        if(temp == 8){
            this.V = true;
        }
 
        temp = x & 0b00010000;
        if(temp == 16){
            this.C = true;
        }
        PrintStatus();
    }

    public static void main(String[] args) {
      //  StatusRegister abc = new StatusRegister("r1", "00011111");
      //  abc.Status(abc);
    }
}
