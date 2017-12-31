import java.util.LinkedList;

/**
 * Created by ressay on 10/12/17.
 */
public class InstGen
{
    public GenerateOC.Instruction[] getInstruction(Quad quad)
    {
        return null;
    }
    GenerateOC gen;

    public InstGen(GenerateOC gen) {
        this.gen = gen;
    }

    GenerateOC.Instruction[] getInAcc(GenerateOC.Ope op1, GenerateOC.Ope op2,int arraySize)
    {
        GenerateOC.Instruction[] insts = gen.getInAcc(op1,op2);

        GenerateOC.Instruction[] tab = new GenerateOC.Instruction[arraySize+((insts==null)?0:insts.length)];
        if(insts!=null)
        for (int i=0;i<insts.length;i++)
            tab[i] = insts[i];
        return tab;
    }

    //******************************** Instructions ***********************************

    static public class Mov extends InstGen
    {
        public Mov(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new GenerateOC.Instruction("MOV",quad.get(3),"AX");
            return tab;
        }
    }

    static public class Add extends InstGen
    {
        public Add(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope(quad.get(2));
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new GenerateOC.Instruction("ADD","AX",op2.str);
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Sub extends InstGen
    {
        public Sub(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new GenerateOC.Instruction("SUB","AX",quad.get(2));
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Mul extends InstGen
    {
        public Mul(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope(quad.get(2));
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new GenerateOC.Instruction("MUL","AX",op2.str);
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Div extends InstGen
    {
        public Div(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,1);
            tab[tab.length-1] = new GenerateOC.Instruction("DIV","AX",quad.get(2));
            gen.setAcc(quad.get(3));
            return tab;
        }
    }

    static public class Br extends InstGen
    {
        public Br(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[1];
            tab[0] = new GenerateOC.Instruction("JMP",quad.get(3));
            return tab;
        }
    }
    static public class Ble extends InstGen
    {
        public Ble(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JLE",quad.get(3));
            return tab;
        }
    }

    static public class Bge extends InstGen
    {
        public Bge(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JGE",quad.get(3));
            return tab;
        }
    }

    static public class Bg extends InstGen
    {
        public Bg(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JG",quad.get(3));
            return tab;
        }
    }

    static public class Bl extends InstGen
    {
        public Bl(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JL",quad.get(3));
            return tab;
        }
    }

    static public class Be extends InstGen
    {
        public Be(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JE",quad.get(3));
            return tab;
        }
    }

    static public class Bne extends InstGen
    {
        public Bne(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Ope op1 = new GenerateOC.Ope(quad.get(1)),op2 = new GenerateOC.Ope("");
            GenerateOC.Instruction[] tab = getInAcc(op1,op2,2);
            tab[tab.length-2] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[tab.length-1] = new GenerateOC.Instruction("JNE",quad.get(3));
            return tab;
        }
    }

    static public class End extends InstGen
    {
        public End(GenerateOC gen) {
            super(gen);
        }

        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[2];
            tab[0] = new GenerateOC.Instruction("MOV","AX","4C00H");
            tab[1] = new GenerateOC.Instruction("INT","21H");
            return tab;
        }
    }
}
