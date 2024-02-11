package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.AddRemovable;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.Addable;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements Addable, AddRemovable, MyList {

    @Override
    public String remove() {
        return super.removeFirst();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}
