package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.BaseComponent;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;


public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
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
        if (components.contains(component.getId())) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        Component component = components.stream()
                .filter(p -> p.getClass().getSimpleName().equals(componentType)).findFirst().orElse(null);
        if (component == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            Component component1 = components.get(i);
            if (component1.getClass().getSimpleName().equals(componentType)){
                index = i;
                break;
            }
        }
        return components.remove(index);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.contains(peripheral.getId())) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType)).findFirst().orElse(null);
        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral1 = peripherals.get(i);
            if (peripheral1.getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;
            }
        }
        return peripherals.remove(index);
    }

    @Override
    public double getOverallPerformance() {
        double compPerformanceAvSum = components.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0);
        return compPerformanceAvSum + super.getOverallPerformance();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + components.stream().mapToDouble(Component::getPrice).sum()
                + peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator());
        sb.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, components.size()));
        sb.append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ")
                    .append(component.toString()).append(System.lineSeparator());
        }
        sb.append(String.format(" " + COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)));
        sb.append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ")
                    .append(peripheral.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
