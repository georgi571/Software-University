package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.computers;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.BaseProduct;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.components.Component;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.models.products.peripherals.Peripheral;

import java.util.Collections;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._01HighQualityStructure.onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
    }


    @Override
    public double getOverallPerformance() {
        double sum = 0;
        sum += super.getOverallPerformance();
        for (Component component : this.components) {
            sum += component.getOverallPerformance();
        }
        return sum;
    }

    @Override
    public double getPrice() {
        double sum = 0;
        sum += super.getPrice();
        for (Component component : this.components) {
            sum += component.getPrice();
        }
        for (Peripheral peripheral : this.peripherals) {
            sum += peripheral.getPrice();
        }
        return sum;
    }

    @Override
    public List<Component> getComponents() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return Collections.unmodifiableList(peripherals);
    }

    @Override
    public void addComponent(Component component) {
        for (Component componentToCheck : this.components) {
            if (componentToCheck.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), componentToCheck.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), 0));
        }
        for (Component component : this.components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), 0));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peripheralToCheck : this.peripherals) {
            if (peripheralToCheck.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), peripheralToCheck.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), 0));
        }
        for (Peripheral peripheralToCheck : this.peripherals) {
            if (peripheralToCheck.getClass().getSimpleName().equals(peripheralType)) {
                return peripheralToCheck;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), 0));
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s", super.toString())).append(System.lineSeparator());
        info.append(String.format(" Components (%d):", this.components.size())).append(System.lineSeparator());
        for (Component component : this.components) {
            info.append(String.format("  %s", component.toString())).append(System.lineSeparator());
        }

        return super.toString();
    }
}
