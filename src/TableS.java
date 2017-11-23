import java.util.ArrayList;

public class TableS
{
    static public class Element {
        public Element(String name, int nature, int type, int size) {
            this.name = name;
            this.nature = nature;
            this.type = type;
            this.size = size;
        }

        String name;
        int nature; // 0:cts 1:var
        int type; // 0:int 1:float
        int size; //size;
    }


    public ArrayList<Element> L = new ArrayList<Element>();


    public Element getElement(String name)
    {
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).name.compareTo(name)==0)
                return L.get(i);
        }
        return null;
    }

    public void addElement(Element e)
    {
        L.add(e);
    }

    public void deleteElement(String name)
    {
        for (int i = 0; i < L.size(); i++) {
            if(L.get(i).name.compareTo(name)==0)
            {
               deleteElement(L.get(i));
               return;
            }
        }
    }

    public void deleteElement(Element e)
    {
        L.remove(e);
    }


}
