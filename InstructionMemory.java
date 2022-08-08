import java.util.ArrayList;;
public class InstructionMemory {
    ArrayList<Instruction> InsMemory;

    public InstructionMemory(){
        InsMemory = new ArrayList<>();
    }

    public void addInsMem(Instruction instruction){
        if(InsMemory.size() < 1024 && instruction.data.length() == 16){
             InsMemory.add(instruction);
        }
        else{
            instruction.data = instruction.data.substring(instruction.data.length()-16,instruction.data.length());
            InsMemory.add(instruction);
            System.out.println("Instruction Memory is full!");
        }
    }
}
