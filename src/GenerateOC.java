import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ressay on 10/12/17.
 */
public class GenerateOC
{
    static public class Instruction
    {
        String inst;
        String op1;
        String op2;

        public Instruction(String inst, String op1, String op2) {
            this.inst = inst;
            this.op1 = op1;
            this.op2 = op2;
        }

        public Instruction(String inst, String op1) {
            this.inst = inst;
            this.op1 = op1;
            this.op2 = null;
        }

        @Override
        public String toString()
        {
            return inst + " " + op1 + " " + ((op2 == null)?"":op2);
        }
    }
    Quads quads;
    LinkedList<Instruction> insts = new LinkedList<>();
    HashMap<String,InstGen> map = new HashMap<>();

    HashMap<Integer,Integer> mapNumbers = new HashMap<>(); // map quad number to its first instruction number, this ll be helpful in jumps

    public GenerateOC(Quads quads) {
        map.put("=",new InstGen.Mov());
        map.put("*",new InstGen.Mul());
        map.put("/",new InstGen.Div());
        map.put("+",new InstGen.Add());
        map.put("-",new InstGen.Sub());
        map.put("BR",new InstGen.Br());
        map.put("BLE",new InstGen.Ble());
        map.put("BGE",new InstGen.Bge());
        map.put("END",new InstGen.End());
        this.quads = quads;
    }

    public LinkedList<Instruction> generateCode()
    {
        LinkedList<Instruction> jmpInsts = new LinkedList<>();

        for(int i=0;i<quads.size();i++)
        {
            Instruction[] inst = getInstruction(quads.getQuad(i));
            // map quad number to the number of first instruction of that quad
            mapNumbers.put(i,insts.size());

            for (int j=0;j<inst.length;j++) {
                insts.add(inst[j]);

                // keep jmp instructions in list to update etiqs later
                if(isJumpInst(inst[j].inst))
                   jmpInsts.add(inst[j]);
            }
        }

        // setup jumps etiqs
        for (int i=0;i<jmpInsts.size();i++)
            jmpInsts.get(i).op1 = ""+mapNumbers.get(Integer.parseInt(jmpInsts.get(i).op1));

        showText("******************************************************",TextDisplayer.COMPILERTEXTS);
        for (int i=0;i<insts.size();i++)
        {
            showText(i + "- "+ insts.get(i),TextDisplayer.COMPILERTEXTS);
        }
        showText("******************************************************",TextDisplayer.COMPILERTEXTS);

        return insts;
    }

    Instruction[] getInstruction(Quad quad)
    {
        return map.get(quad.get(0)).getInstruction(quad);
    }

    private boolean isJumpInst(String inst)
    {
        String[] jmps = {"JMP","JLE","JGE"};
        for (int i=0;i<jmps.length;i++)
            if(inst.compareTo(jmps[i]) == 0)
                return true;
        return false;
    }

    private void showText(String text, int typeOfText)
    {
        TextDisplayer.getInstance().showText(text,typeOfText,TextDisplayer.CODEGEN);
    }
}
