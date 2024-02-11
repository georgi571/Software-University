package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.entities;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.AddRemovable;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._07CollectionHierarchy.interfaces.Addable;

public class AddRemoveCollection extends Collection implements AddRemovable, Addable {
    @Override
    public String remove() {
        return super.removeLast();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }
}
