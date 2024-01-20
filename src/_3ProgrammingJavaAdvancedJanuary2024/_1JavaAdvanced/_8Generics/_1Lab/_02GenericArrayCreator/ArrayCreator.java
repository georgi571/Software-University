package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._8Generics._1Lab._02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T item) {
        T[] arr = (T[])Array.newInstance(item.getClass(), length);
        Arrays.fill(arr, item);
        return arr;
    }
}
