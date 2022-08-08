import java.lang.management.OperatingSystemMXBean;

public class Execute {
    
    InstructionMemory instructionMemory;
    DataMemory dataMemory;
    int result;
    RealDataMemory realDataMemory;

    public Execute(InstructionMemory instructionMemory, DataMemory dataMemory, RealDataMemory realDataMemory){
        this.instructionMemory = instructionMemory;
        this.dataMemory = dataMemory;
        this.realDataMemory = realDataMemory;
    }

    // public void checker(int result){

    //     String check = Integer.toBinaryString(result);

    //     while(check.length() < 8){
    //         check = "0" + check;
    //     }

    //     if(check.length() >= 8){
    //         dataMemory.DataMem.get(64).C = true;
    //     }
    //     else{
    //         dataMemory.DataMem.get(64).C = false;
    //     }

    //     if(result == 0){
    //         dataMemory.DataMem.get(64).Z = true;
    //     }
    //     else{
    //         dataMemory.DataMem.get(64).Z = false;
    //     }

    //     if(result < 0){
    //         dataMemory.DataMem.get(64).N = true;
    //     }
    //     else{
    //         dataMemory.DataMem.get(64).N = false;
    //     }

    // }

    public void ExecuteR(Register A, Register B, int operand, int rs, int rt){

        int operandA;
        int operandB;

        if(A.signed == true){
             operandA = Integer.parseInt(A.data,2) * -1;
        }
        else{
             operandA = Integer.parseInt(A.data,2);
        }

        if(B.signed == true){
             operandB = Integer.parseInt(B.data,2) * -1;
        }
        else{
             operandB = Integer.parseInt(B.data,2);
        }

        String res;

        switch(operand){
	      
            case 0 :
                result = (operandA + operandB);
                System.out.println(result + " =  " + operandA + " + " + operandB);
                dataMemory.DataMem.get(64).checker(result, operandA, operandB);
                dataMemory.DataMem.get(64).Status();
                if(result < 0){
                    result = result*-1;
                    dataMemory.DataMem.get(rs).signed = true;
                }
                else{
                    dataMemory.DataMem.get(rs).signed = false;
                }
                res = Integer.toBinaryString(result);
                while(res.length()<8){
                    res = "0" + res;
                }
                dataMemory.DataMem.get(rs).data = res;
                
              break;
          case 1 :
                result = (operandA - operandB);
                System.out.println(result + " =  " + operandA + " - " + operandB);
              //  dataMemory.DataMem.get(64).checker(result, operandA, operandB);
              //  dataMemory.DataMem.get(64).Status();
                if(result < 0){
                    result = result*-1;
                    dataMemory.DataMem.get(rs).signed = true;
                }
                else{
                    dataMemory.DataMem.get(rs).signed = false;
                }
                res = Integer.toBinaryString(result);
                while(res.length()<8){
                    res = "0" + res;
                }
                dataMemory.DataMem.get(rs).data = res;

              break;
          case 2 :

                result = (operandA * operandB);
                System.out.println(result + " =  " + operandA + " x " + operandB);
            //   dataMemory.DataMem.get(64).checker(result, operandA, operandB);
            //  dataMemory.DataMem.get(64).Status();
                if(result < 0){
                    result = result*-1;
                    dataMemory.DataMem.get(rs).signed = true;
                }
                else{
                    dataMemory.DataMem.get(rs).signed = false;
                }
                res = Integer.toBinaryString(result);
                while(res.length()<8){
                    res = "0" + res;
                }
                dataMemory.DataMem.get(rs).data = res;
            
              break;
          case 6 :

                result = (operandA ^ operandB);
                System.out.println(result + " =  " + operandA + " ^ " + operandB);
            //    dataMemory.DataMem.get(64).checker(result, operandA, operandB);
            //    dataMemory.DataMem.get(64).Status();
                if(result < 0){
                    result = result*-1;
                    dataMemory.DataMem.get(rs).signed = true;
                }
                else{
                    dataMemory.DataMem.get(rs).signed = false;
                }
                res = Integer.toBinaryString(result);
                while(res.length()<8){
                    res = "0" + res;
                }
                dataMemory.DataMem.get(rs).data = res;
            
              break;
              
          case 19 :        // WTF IS THIS???

              

              break;

        }
    }

    public void ExecuteI(int operand, int operandA, int Immediate, Register A){


        String res;

        switch(operand){
            
            case 3:  

                if (Immediate < 0){
                    Immediate = Immediate * - 1;
                    dataMemory.DataMem.get(operandA).signed = true;
                }
                else{
                    dataMemory.DataMem.get(operandA).signed = false;
                }

                String imm = Integer.toBinaryString(Immediate);

                for(int i = 0; i < 8; i++){
                    if(imm.length() < 8){
                        imm = "0" + imm;
                    }
                }
                dataMemory.DataMem.get(operandA).data = imm;
                 System.out.println("Register Data changed to -- > " + Immediate);

            break;
            case 4: 

                    if(Integer.parseInt(dataMemory.DataMem.get(operandA).data, 2) == 0){
                        dataMemory.DataMem.get(65).counter+=  Immediate;
                        res = Integer.toBinaryString(dataMemory.DataMem.get(65).counter);

                    for(int i = 0; i < 16; i++){
                        if(res.length() < 8){
                            res = "0" + res;
                        }
                    }
                    dataMemory.DataMem.get(65).data = res;
                    }


                    // int x = dataMemory.DataMem.get(65).counter;
                    // x = x + Immediate + 1;

                    // res = Integer.toBinaryString(x);

                    // for(int i = 0; i < 16; i++){
                    //     if(res.length() < 8){
                    //         res = "0" + res;
                    //     }
                    // }

                    // System.out.print(x);

                    // dataMemory.DataMem.get(65).counter = x;
                    // dataMemory.DataMem.get(65).data = res;


            break;
            case 5: 

                int temp = Integer.parseInt(dataMemory.DataMem.get(operandA).data, 2) & Immediate;
                res = Integer.toBinaryString(temp);

                for(int i = 0; i < 8; i++){
                    if(res.length() < 8){
                        res = "0" + res;
                    }
                }

                dataMemory.DataMem.get(operandA).data = res;

            break;
            case 8:

                result = (Integer.parseInt(dataMemory.DataMem.get(operandA).data, 2) << Immediate);

                res = Integer.toBinaryString(result);

                for(int i = 0; i < 8; i++){
                    if(res.length() < 8){
                        res = "0" + res;
                    }
                }

                dataMemory.DataMem.get(operandA).data = res;

            break;
            case 9:

            result = (Integer.parseInt(dataMemory.DataMem.get(operandA).data, 2) >> Immediate);

                res = Integer.toBinaryString(result);

                for(int i = 0; i < 8; i++){
                    if(res.length() < 8){
                        res = "0" + res;
                    }
                }

                dataMemory.DataMem.get(operandA).data = res;

            break;
            case 10:

                //dataMemory.DataMem.get(operandA).data = dataMemory.DataMem.get(Immediate).data;

                dataMemory.DataMem.get(operandA).data = realDataMemory.RealDataMem[Immediate];
                if(realDataMemory.RealFlag[Immediate] == true){
                    dataMemory.DataMem.get(operandA).signed = true;
                }
                else{
                    dataMemory.DataMem.get(operandA).signed = false;
                }

            break;
            case 11:

                realDataMemory.RealDataMem[Immediate] = dataMemory.DataMem.get(operandA).data;
                if(dataMemory.DataMem.get(operandA).signed == true){
                    realDataMemory.RealFlag[Immediate] = true;
                }
                else{
                    realDataMemory.RealFlag[Immediate] = false;
                }
                

        break;
        }

    }
}
