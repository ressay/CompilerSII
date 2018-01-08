import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ressay on 10/12/17.
 */
public class GenerateOC
{
    static public class Ope
    {
        public String str;

        public Ope(String str) {
            this.str = str;
        }
    }
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
    Ope acc = new Ope("");

    public GenerateOC(Quads quads) {
        map.put("=",new InstGen.Mov(this));
        map.put("*",new InstGen.Mul(this));
        map.put("/",new InstGen.Div(this));
        map.put("+",new InstGen.Add(this));
        map.put("-",new InstGen.Sub(this));
        map.put("BR",new InstGen.Br(this));
        map.put("BLE",new InstGen.Ble(this));
        map.put("BGE",new InstGen.Bge(this));
        map.put("BG",new InstGen.Bg(this));
        map.put("BL",new InstGen.Bl(this));
        map.put("BE",new InstGen.Be(this));
        map.put("BNE",new InstGen.Bne(this));
        map.put("END",new InstGen.End(this));
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
        String[] jmps = {"JMP","JLE","JGE","JG","JL","JE","JNE"};
        for (int i=0;i<jmps.length;i++)
            if(inst.compareTo(jmps[i]) == 0)
                return true;
        return false;
    }

    private void showText(String text, int typeOfText)
    {
        TextDisplayer.getInstance().showText(text,typeOfText,TextDisplayer.CODEGEN);
    }

    public Ope getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc.str = acc;
    }

    public Instruction[] getInAcc(Ope op1,Ope op2)
    {
        Instruction[] insts = null;
        if(op1.str.equals(acc.str)) op1.str = "AX";
        else if(!op2.str.equals("") && op2.str.equals(acc.str))
        {
            op2.str = op1.str;
        }
        else if(!acc.str.equals("") && !isNumber(acc.str))
        {
            insts = new Instruction[2];
            insts[0] = new Instruction("MOV",acc.str,"AX");
            insts[1] = new Instruction("MOV","AX",op1.str);
            acc.str = op1.str;
        }
        else
        {
            insts = new Instruction[1];
            insts[0] = new Instruction("MOV","AX",op1.str);
            acc.str = op1.str;
        }
        op1.str = "AX";
        return insts;
    }

    private boolean isNumber(String s)
    {
        for (int i=0;i<s.length();i++)
            if(s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;
        return true;
    }
}
