package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.computers;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.BaseProduct;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.components.Component;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.common.constants.ExceptionMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component component1 : this.components) {
            if (component1.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        for (Component component : this.components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                this.components.remove(component);
                return component;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peripheral1 : this.peripherals) {
            if (peripheral1.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        for (Peripheral peripheral : this.peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                this.peripherals.remove(peripheral);
                return peripheral;
            }
        }
        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public double getPrice() {
        double price = 0;
        price += super.getPrice();
        for (Component component : this.components) {
            price += component.getPrice();
        }
        for (Peripheral peripheral : this.peripherals) {
            price += peripheral.getPrice();
        }
        return price;
    }

    @Override
    public double getOverallPerformance() {
        double sum = 0;
        for (Component component : this.components) {
            sum += component.getOverallPerformance();
        }
        double average = 0;
        if (!this.components.isEmpty()) {
            average = sum / this.components.size();
        }
        return super.getOverallPerformance() + average;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(System.lineSeparator());
        stringBuilder.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size())).append(System.lineSeparator());
        for (Component component : this.components) {
            stringBuilder.append(String.format("  %s", component.toString())).append(System.lineSeparator());
        }
        double sum = 0;
        for (Peripheral peripheral : this.peripherals) {
            sum += peripheral.getOverallPerformance();
        }
        double average = sum / this.peripherals.size();
        if (this.peripherals.isEmpty()) {
            average = 0.00;
        }
        stringBuilder.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), average)).append(System.lineSeparator());
        for (Peripheral peripheral : this.peripherals) {
            stringBuilder.append(String.format("  %s", peripheral.toString())).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
