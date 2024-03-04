package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.computers;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.Product;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.components.Component;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.peripherals.Peripheral;

import java.util.List;

public interface Computer extends Product {
    List<Component> getComponents();

    List<Peripheral> getPeripherals();

    void addComponent(Component component);

    Component removeComponent(String componentType);

    void addPeripheral(Peripheral peripheral);

    Peripheral removePeripheral(String peripheralType);
}