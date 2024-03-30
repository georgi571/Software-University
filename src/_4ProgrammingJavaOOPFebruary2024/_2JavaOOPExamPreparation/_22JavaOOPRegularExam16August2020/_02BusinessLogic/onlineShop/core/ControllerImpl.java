package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.components.*;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.computers.Computer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.computers.DesktopComputer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.computers.Laptop;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.common.constants.ExceptionMessages.*;
import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._22JavaOOPRegularExam16August2020._02BusinessLogic.onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (isComputerIdExist(this.computers, id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        this.computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (!isComputerIdExist(this.computers, computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (isPeripheralIdExist(this.peripherals, id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral;
        if (peripheralType.equals("Headset")) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Keyboard")) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Monitor")) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Mouse")) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                computer.addPeripheral(peripheral);
                this.peripherals.add(peripheral);
            }
        }
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!isComputerIdExist(this.computers, computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral = null;
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                peripheral = computer.removePeripheral(peripheralType);
                this.peripherals.remove(peripheral);
            }
        }
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (!isComputerIdExist(this.computers, computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (isComponentIdExist(this.components, id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Component component;
        if (componentType.equals("CentralProcessingUnit")) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("Motherboard")) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("PowerSupply")) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("RandomAccessMemory")) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("SolidStateDrive")) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("VideoCard")) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                computer.addComponent(component);
                this.components.add(component);
            }
        }
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!isComputerIdExist(this.computers, computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Component component = null;
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                component = computer.removeComponent(componentType);
                this.computers.remove(component);
            }
        }
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (!isComputerIdExist(this.computers, id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = null;
        for (Computer computer1 : this.computers) {
            if (computer1.getId() == id) {
                computer = computer1;
                break;
            }
        }
        this.computers.remove(computer);
        return String.format("%s", computer);
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> lessBudget = new ArrayList<>();
        for (Computer computer1 : this.computers) {
            if (computer1.getPrice() <= budget) {
                lessBudget.add(computer1);
            }
        }
        Computer computer = null;
        for (Computer computer1 : lessBudget) {
            if (computer == null) {
                computer = computer1;
            } else if (computer.getOverallPerformance() < computer1.getOverallPerformance()) {
                computer = computer1;
            }  else if (computer.getOverallPerformance() == computer1.getOverallPerformance()) {
                if (computer.getPrice() > computer1.getPrice()) {
                    computer = computer1;
                }
            }
        }
        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        this.computers.remove(computer);
        return String.format("%s", computer);
    }

    @Override
    public String getComputerData(int id) {
        if (!isComputerIdExist(this.computers, id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        for (Computer computer : this.computers) {
            if (computer.getId() == id) {
                return String.format("%s", computer);
            }
        }
        return null;
    }

    private boolean isComputerIdExist(List<Computer> computers, int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isComponentIdExist(List<Component> components, int id) {
        for (Component component : components) {
            if (component.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isPeripheralIdExist(List<Peripheral> peripherals, int id) {
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
