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
    static public class Mov extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[1];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),quad.get(3));
            return tab;
        }
    }

    static public class Add extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("ADD","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("MOV","AX",quad.get(3));
            return tab;
        }
    }

    static public class Sub extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("SUB","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("MOV","AX",quad.get(3));
            return tab;
        }
    }

    static public class Mul extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("MUL","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("MOV","AX",quad.get(3));
            return tab;
        }
    }

    static public class Div extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("DIV","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("MOV","AX",quad.get(3));
            return tab;
        }
    }

    static public class Br extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[1];
            tab[0] = new GenerateOC.Instruction("JMP",quad.get(3));
            return tab;
        }
    }
    static public class Ble extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("JLE",quad.get(3));
            return tab;
        }
    }

    static public class Bge extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[3];
            tab[0] = new GenerateOC.Instruction("MOV",quad.get(1),"AX");
            tab[1] = new GenerateOC.Instruction("CMP","AX",quad.get(2));
            tab[2] = new GenerateOC.Instruction("JGE",quad.get(3));
            return tab;
        }
    }

    static public class End extends InstGen
    {
        public GenerateOC.Instruction[] getInstruction(Quad quad)
        {
            GenerateOC.Instruction[] tab = new GenerateOC.Instruction[2];
            tab[0] = new GenerateOC.Instruction("MOV","AX","H40C0");
            tab[1] = new GenerateOC.Instruction("INT","21");
            return tab;
        }
    }
}
