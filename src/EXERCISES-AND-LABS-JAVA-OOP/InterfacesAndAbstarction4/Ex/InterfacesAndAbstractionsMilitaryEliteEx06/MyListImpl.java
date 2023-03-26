package InterfacesAndAbstarction4.Ex.InterfacesAndAbstractionsMilitaryEliteEx06;

//    MyListImpl
public class MyListImpl extends Collection implements MyList {
    //+	remove() : String
    @Override
    public String remove() {
        return this.items.remove(0);
    }
    //+	add(String)
    @Override
    public int add(String item) {

      this.items.set(0, item);
        return 0;
    }
    //+	getUsed() : int
    @Override
    public int getUsed() {
        return this.items.size();
    }





}
