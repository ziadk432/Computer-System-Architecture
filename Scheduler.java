import java.io.IOException;
public class Scheduler{

    InstructionMemory x = new InstructionMemory();
    DataMemory dataMemory = new DataMemory();
    RealDataMemory realDataMemory = new RealDataMemory();

    int cycles = 1;
    int PC = 0;

    boolean IF_flag = false;
    boolean ID_flag = false;
    boolean EX_flag = false;

    boolean fetch_bool = false;

    int opcode = 0;  
    int rs = 0;      
    int rt = 0;      
    int valueRS = 0;
    int valueRT = 0;

    public Scheduler(InstructionMemory instructionMemory, DataMemory dataMemory){

    this.x = instructionMemory;
    this.dataMemory = dataMemory;

    Schedule();
    }

    public void Schedule(){
        PC = dataMemory.DataMem.get(65).counter;
        for(int j = 0; j <  3 + ((x.InsMemory.size()-1) * 1); j++){    //  3 + ((n − 1) ∗ 1)
       //     while(PC < 3 + ((x.InsMemory.size()-1) * 1)){
            PC = dataMemory.DataMem.get(65).counter;


            for(int i = 0; i < 3; i++){
                PC = dataMemory.DataMem.get(65).counter;
                if(PC + i > x.InsMemory.size()-1){

                }
                else{
                    Instruction inst = x.InsMemory.get(PC + i);
                    int hi = PC + i + 1;
                    if(EX_flag == false && inst.inst == "EX"){
                        EX_flag = true;
                        x.InsMemory.get(PC+i).inst = "DONE";
                        
                        System.out.println("Executing Execute() on Instruction -->> " + hi + " <<--       " + "<<Cycle " + cycles + ">>");

                        fetch_bool = true;

                        //   execute();

                        System.out.println("---------------------------------------------");


                        Execute execute = new Execute(x, dataMemory, realDataMemory);

                        if(inst.type.equals("I")){

                            execute.ExecuteI(opcode, rs, rt, dataMemory.DataMem.get(rs));
                            dataMemory.DataMem = execute.dataMemory.DataMem;
                            dataMemory.DataMem.get(65).counter = execute.dataMemory.DataMem.get(65).counter;
                            realDataMemory.RealDataMem = execute.realDataMemory.RealDataMem;

                        }
                        else if (inst.type.equals("R")){
                            execute.ExecuteR(dataMemory.DataMem.get(rs), dataMemory.DataMem.get(rt), opcode, rs, rt);
                        }

                        System.out.println("---------------------------------------------");
                        System.out.println("");

                        System.out.println("!!! Instruction -->> " + hi + " <<-- is DONE !!!");
                        System.out.println("");

                        //   execute();
                    }
    
                    else if(ID_flag == false && inst.inst == "ID"){

                        System.out.println("Executing Decode() on Instruction -->> " + hi + " <<--       " + "<<Cycle " + cycles + ">>");

                        x.InsMemory.get(PC+i).inst = "EX";
                        ID_flag = true;

                        //  decode();

                        System.out.println("---------------------------------------------");
                        Decode decode = new Decode(x.InsMemory.get(PC+i), dataMemory);

                        this.dataMemory = decode.DataMemory;

                        this.opcode = decode.opcode;
                        this.valueRS = decode.valueRS;
                        this.valueRT = decode.valueRT;
                        this.rt = decode.rt;
                        this.rs = decode.rs;

                        System.out.println("---------------------------------------------");
                        System.out.println("");

                        //  decode();
                    }
    
                    else if(IF_flag == false && inst.inst == "IF"){

                        System.out.println("Executing Fetch() on Instruction -->> " + hi + " <<--       " + "<<Cycle " + cycles + ">>");
                        x.InsMemory.get(PC+i).inst = "ID";

                        IF_flag = true;

                        System.out.println("---------------------------------------------");
                        System.out.println("Program counter is pointing at ==> " + hi);
                        System.out.println("---------------------------------------------");
                        System.out.println("");
                        
                    }

                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");

                }    
            }

            if(fetch_bool == true){
                //fetch();
                dataMemory.DataMem.get(65).counter++;
            }

            fetch_bool = false;
            IF_flag = false;
            ID_flag = false;
            EX_flag = false;
            cycles++;

            }
        }

    public static void main(String[] args) throws IOException {
        
        Interpreter x = new Interpreter("C:\\Users\\Ziad\\Apps\\Visual Studio Code\\Projects\\CA Project\\textfile.txt");
        DataMemory dataMemory = new DataMemory();
        dataMemory.populateDataMemory();
        Scheduler ab = new Scheduler(x.InsMem, dataMemory);
        
    }
}