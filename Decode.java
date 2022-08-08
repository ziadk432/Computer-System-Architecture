public class Decode{
    DataMemory DataMemory;

    int opcode = 0;  // bits 15:12

    int rs = 0;      // bits 11:6              --- > ADDRESS OF REGISTER 
    int rt = 0;      // bit 5:0                --- > ADDRESS OF REGISTER

    int valueRS = 0;                        // --- > VALUE IN REGISTER 1
    int valueRT = 0;                        // --- > VALUE IN REGISTER 2
    
    public Decode(Instruction instruction, DataMemory DataMem){
            this.DataMemory = DataMem;
            this.opcode=Integer.parseInt(instruction.data, 2) & 0b1111000000000000;
            this.opcode=opcode>>12;

            rs=Integer.parseInt(instruction.data,2)&0b0000111111000000;
	        rs=rs>>6;

            rt=Integer.parseInt(instruction.data,2)&0b0000000000111111;

        if(instruction.type == "R"){

            if(instruction.Register1Signed == true || DataMem.DataMem.get(rs).signed == true){
                this.valueRS = Integer.parseInt(DataMem.DataMem.get(rs).data, 2) * -1;
                DataMem.DataMem.get(rs).signed = true;
            }
            else{
                this.valueRS = Integer.parseInt(DataMem.DataMem.get(rs).data, 2);
            }
            if(instruction.Register2Signed == true || DataMem.DataMem.get(rt).signed == true){
                this.valueRT = Integer.parseInt(DataMem.DataMem.get(rt).data, 2) * -1;
                DataMem.DataMem.get(rt).signed = true;
            }
            else{
                this.valueRT = Integer.parseInt(DataMem.DataMem.get(rt).data, 2);
            }
        }
        else if (instruction.type == "I"){

            if(instruction.Register1Signed == true){
                this.valueRS = Integer.parseInt(DataMem.DataMem.get(rs).data, 2) * -1;
                DataMem.DataMem.get(rs).signed = true;
            }
            else{
                this.valueRS = Integer.parseInt(DataMem.DataMem.get(rs).data, 2);
            }
            if(instruction.Register2Signed == true){
                this.rt = rt *-1;
                this.valueRT = rt;
            }
            else{
                this.valueRT = rt;
            }
        }



    // Printings
    
    System.out.println("opcode = "+opcode);
    System.out.println("rs = "+rs);
    System.out.println("rt = "+rt);
    System.out.println("value[rs] = "+valueRS);
    System.out.println("value[rt] = "+valueRT);
    
    }
    public static void main(String[] args) {
        String [] x = new String[2048];
        x[90] = "hello";
        System.out.println(x[90]);
    }
}