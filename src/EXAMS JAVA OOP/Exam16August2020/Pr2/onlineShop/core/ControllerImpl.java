package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.LinkedHashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer, Product> products;
    private Map<Integer, Peripheral> peripherals;
    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;

    public ControllerImpl() {
        this.products = new LinkedHashMap<>();
        this.peripherals = new LinkedHashMap<>();
        this.computers = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }


        computers.put(computer.getId(), computer);
        return String.format(ADDED_COMPUTER, id);
    }


    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price,
                                double overallPerformance, String connectionType) {
        Computer computer = computers.values().stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        Peripheral peripheral;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (peripherals.containsKey(peripheral)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, peripheralType,
                    computer.getClass().getSimpleName(), computerId));
        } else {
            peripherals.put(peripheral.getId(), peripheral);
            computers.get(computerId).addPeripheral(peripheral);
            return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
        }
    }


    @Override
    public String removePeripheral(String peripheralType, int computerId) {

            if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }


    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model,
                               double price, double overallPerformance, int generation) {
        Computer computer = computers.values().stream().filter(c -> c.getId() == computerId).findFirst().orElse(null);
        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;

            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        if (components.containsKey(component)) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, componentType,
                    computer.getClass().getSimpleName(), computerId));
        } else {
            components.put(component.getId(), component);
            computers.get(computerId).addComponent(component);
            return String.format(ADDED_COMPONENT, componentType, id, computerId);
        }

    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Component component = computers.get(computerId).removeComponent(componentType);
        peripherals.remove(component.getId());
        return String.format(REMOVED_PERIPHERAL, componentType, component.getId());
    }


    @Override
    public String buyComputer(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = computers.values().stream()
                .sorted((f, s) -> Double.compare(s.getOverallPerformance(), f.getOverallPerformance()))
                .limit(1).filter(c -> c.getPrice() <= budget)
                .findFirst().orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        computers.remove(computer.getId());
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {

        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = computers.values().stream().filter(c -> c.getId()
                == (id)).findFirst().orElse(null);
        if (computer == null) {
            return null;
        }
        return computer.toString();
    }
}

