package WorkingWithAbstraction_greedyTimesEx06;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentQuantity;
    private boolean isGoldAdded;

    //    gold
    private long totalGold;
    //    gems
    private long totalGems;
    private Map<String, Long> gems;
    //cash
    private long totalCash;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentQuantity = 0;
        this.totalGold = 0;
        this.totalGems = 0;
        this.gems = new HashMap<>();
        this.totalCash = 0;
        this.cash = new HashMap<>();
        this.isGoldAdded = false;
    }

    public void addCash(String currency, long quantity) {
//        има ли място
//        добявяме си парите в мапа
//        увеличаваме общата сума на парите
//        увеличаваме текущото количество
        if (hasFreeSpace(quantity) && this.totalGems >= this.totalCash + quantity) {
//            мога да добавям пари
            if (!this.cash.containsKey(currency)) {
                this.cash.put(currency, quantity);
            } else {
                this.cash.put(currency, this.cash.get(currency) + quantity);
            }
            this.totalCash += quantity;
            this.currentQuantity += quantity;
        }
    }

    public void addGems(String gem, long quantity) {
        if (hasFreeSpace(quantity) && this.totalGems + quantity <= this.totalGold) {
//            мога да добавям gems
            if (!this.gems.containsKey(gem)) {
                this.gems.put(gem, quantity);
            } else {
                this.gems.put(gem, this.gems.get(gem) + quantity);
            }
            this.totalGems += quantity;
            this.currentQuantity += quantity;
        }
    }

    public void addGold(long quantity) {
        if (hasFreeSpace(quantity)) {
//            мога да добавям gold
            this.totalGold += quantity;
            this.currentQuantity += quantity;
            isGoldAdded = true;
        }
    }

    private boolean hasFreeSpace(long quantity) {
        return this.currentQuantity + quantity <= this.capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isGoldAdded) {
            sb.append("<Gold> $").append(this.totalGold).append(System.lineSeparator());
            sb.append("##Gold - ").append(this.totalGold).append(System.lineSeparator());
        }
        if (this.gems.size() > 0) {
            sb.append("<Gem> $").append(this.totalGems).append(System.lineSeparator());
            this.gems.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##").append(entry.getKey()).append(" - ").append(entry.getValue()).append(System.lineSeparator());
            });
        }
        if (this.cash.size() > 0) {
            sb.append("<Cash> $").append(this.totalCash).append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((f, s) -> {
                int result = s.getKey().compareTo(f.getKey());
                if (result == 0) {
                    result = f.getValue().compareTo(s.getValue());
                }
                return result;
            }).forEach(entry -> {
                sb.append("##").append(entry.getKey()).append(" - ").append(entry.getValue()).append(System.lineSeparator());
            });
        }
        return sb.toString().trim();
    }
}

