import java.util.ArrayList;;
public class DataMemory {
    ArrayList<Register> DataMem;

    public DataMemory(){
        DataMem = new ArrayList<>();
    }

    public void addDataMem(Register register){
        if(DataMem.size() < 2048 ){ //&& register.data.length() == 8
            DataMem.add(register);
        }
        else{
            System.out.println("Data Memory is full!");
        }
    }

    public void populateDataMemory(){
        for(int i = 0; i < 66; i ++){
            if (i < 64){
                Register x = new Register("R"+i, "01110010");
                addDataMem(x);
            }
            // else if(i == 63){
            //     Register x = new Register("R63", "11111111");
            //     addDataMem(x);
            // }
            else if (i == 64){
                Register x = new Register("R64", "00000000");
                addDataMem(x);
            }            
            else if (i == 65){
                Register x = new Register("R65", "00000000");
                addDataMem(x);
            }
            
        }
    }
}
