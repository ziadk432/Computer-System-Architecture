import java.io.IOException;
import java.util.ArrayList;

public class Interpreter{

    InstructionMemory InsMem;
    String path = "C:\\Users\\Ziad\\Apps\\Visual Studio Code\\Projects\\CA Project\\textfile.txt";
    ArrayList<String> StringArr;
    Parser test = new Parser(path);
    ArrayList<Instruction> Instruct;
    

    public Interpreter(String path) throws IOException{
     //this.path = path;
     StringArr = test.getFileArr();
     interpret();
    // System.out.println(InsMem.get(0).data);
    // System.out.println(InsMem.get(1).data);
     //System.out.println(InsMem.get(2).data);
     //System.out.println(InsMem.get(3).data);
     //System.out.println(InsMem.InsMemory.get(2).data);

    }

    public void interpret() throws IOException{

       InsMem = new InstructionMemory();
        StringArr = test.getFileArr();
        
        
        for(int j = 0; j < StringArr.size(); j++){
            String [] x = StringArr.get(j).split(" ");
            String A = x [0];
            String B = x [1];
            String C = x [2];
            
            String register1 ="";
            String register2 = "";

            if(A.equals("ADD")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C.substring(1, 2));
                register2 = Integer.toBinaryString(temp);
    
                for(int i = 0; i < 6; i++){
                    if(register1.length() < 6) {
                        register1 = "0" + register1;
                    }
                    if(register2.length() < 6) {
                     register2 = "0" + register2;
                 }
                 }

                Instruction a = new Instruction("0000"+register1+register2);
                a.type = "R";

                InsMem.addInsMem(a);
            }
            else if (A.equals("SUB")) {
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C.substring(1, 2));
                register2 = Integer.toBinaryString(temp);

                for(int i = 0; i < 6; i++){
                    if(register1.length() < 6) {
                        register1 = "0" + register1;
                    }
                    if(register2.length() < 6) {
                     register2 = "0" + register2;
                 }
                 }

                Instruction a = new Instruction("0001"+register1+register2);
                a.type = "R";

                InsMem.addInsMem(a);
            }
                
            else if (A.equals("MUL")) {
                
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C.substring(1, 2));
                register2 = Integer.toBinaryString(temp);

                for(int i = 0; i < 6; i++){
                    if(register1.length() < 6) {
                        register1 = "0" + register1;
                    }
                    if(register2.length() < 6) {
                     register2 = "0" + register2;
                 }
                 }

                Instruction a = new Instruction("0010"+register1+register2);
                a.type = "R";

                InsMem.addInsMem(a);
            }
            else if (A.equals("EOR")) {
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C.substring(1, 2));
                register2 = Integer.toBinaryString(temp);

                for(int i = 0; i < 6; i++){
                    if(register1.length() < 6) {
                        register1 = "0" + register1;
                    }
                    if(register2.length() < 6) {
                     register2 = "0" + register2;
                 }
                 }

                Instruction a = new Instruction("0110"+register1+register2);
                a.type = "R";

                InsMem.addInsMem(a);
	        }
	        else if (A.equals("BR")) {
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C.substring(1, 2));
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("0111"+register1+register2);
            a.type = "R";
         
            InsMem.addInsMem(a);
	        }


            else if (A.equals("MOVI")){
                if(Integer.parseInt(C) < 0){
                    int temp = Integer.parseInt(B.substring(1, 2)); 
                    register1 = Integer.toBinaryString(temp); 

                    temp = Integer.parseInt(C) * -1; 
                    register2 = Integer.toBinaryString(temp); 

                    for(int i = 0; i < 6; i++){
                        if(register1.length() < 6) {
                            register1 = "0" + register1;
                        }
                        if(register2.length() < 6) {
                        register2 = "0" + register2;
                        }
                        }

                        Instruction a = new Instruction("0011"+register1+register2);
                        a.type = "I";
                        a.Register2Signed = true;
                        InsMem.addInsMem(a);

                        System.out.println(a.data);

                }
                else{
                    int temp = Integer.parseInt(B.substring(1, 2)); 
                    register1 = Integer.toBinaryString(temp);                

                    temp = Integer.parseInt(C);
                    register2 = Integer.toBinaryString(temp);

                    for(int i = 0; i < 6; i++){
                        if(register1.length() < 6) {
                            register1 = "0" + register1;
                        }
                        if(register2.length() < 6) {
                        register2 = "0" + register2;
                        }
                        }

                        Instruction a = new Instruction("0011"+register1+register2);
                        a.type = "I";
                        a.Register2Signed = false;
                        InsMem.addInsMem(a);
                }
            }

            else if (A.equals("BEQZ")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("0100"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }

            else if (A.equals("ANDI")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("0101"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }

            else if (A.equals("SAL")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("1000"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }

            else if (A.equals("SAR")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("1001"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }

            else if (A.equals("LDR")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("1010"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }

            else if (A.equals("STR")){
                int temp = Integer.parseInt(B.substring(1, 2)); // temp = 2
                register1 = Integer.toBinaryString(temp);                              // register 1 = 
                temp = Integer.parseInt(C);
                register2 = Integer.toBinaryString(temp);

            for(int i = 0; i < 6; i++){
                if(register1.length() < 6) {
                    register1 = "0" + register1;
                }
                if(register2.length() < 6) {
                register2 = "0" + register2;
            }
            }

            Instruction a = new Instruction("1011"+register1+register2);
            a.type = "I";
         
            InsMem.addInsMem(a);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        //InstructionMemory instmem = new InstructionMemory();

        //Interpreter x = new Interpreter("C:\\Users\\Ziad\\Apps\\Visual Studio Code\\Projects\\CA Project\\textfile.txt");
        //System.out.println(x.InsMem.InsMemory.get(0).data);
        
    }
}