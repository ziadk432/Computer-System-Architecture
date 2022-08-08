public class Register {
    String data;
    String name;

    int counter;

    boolean C;
    boolean V;
    boolean S;
    boolean N;
    boolean Z;

    boolean signed = false;

    public Register(String name, String data){
        this.name = name;
        this.data = data;

        if(name == "R64"){         //  Status Register
            this.C = false;
            this.V = false;
            this.S = false;
            this.N = false;
            this.Z = false;
        }
        else if (name == "R65"){   // PC Register
            counter = 0;
        }

    }

    public void incrementPC(int x){
        this.counter = this.counter + x;
    }

    public void PrintStatus(){
        System.out.println("Carry (C): " + C + " OverFlow (V): " + V + " Negative (N): " + N + " Sign (S): " + S + " Zero (Z): " + Z);
    }

    public void Status(){
        int x = Integer.parseInt(data, 2);

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

    public void checker(int result, int A, int B){
        
    }
    public static void main(String[] args) {
        int R5 = -5;
        int  R6 = 5;

        int temp1 = R5 & 0b11111111;
        int temp2 = R6 & 0b11111111;
        int Carry;

        if( ((temp1 + temp2) & 0b100000000) == 0b100000000) {
            Carry = 1;
        } else {
            Carry = 0;
        }
        System.out.println(Carry);
    }

}
