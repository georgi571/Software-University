package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._1Lab._03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    public Object getRandomElement() {
        int index = new Random().nextInt(super.size());
        return super.remove(index);
    }
}
