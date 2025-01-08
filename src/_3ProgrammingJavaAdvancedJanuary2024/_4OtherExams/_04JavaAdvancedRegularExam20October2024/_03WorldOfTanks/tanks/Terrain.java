package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._04JavaAdvancedRegularExam20October2024._03WorldOfTanks.tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public String addTank(Tank tank) {
        if (!this.tanks.isEmpty()) {
            Tank currentTank = this.getTankByBrandAndModel(tank.getBrand(), tank.getModel());
            if (currentTank != null) {
                return "Tank with this brand and model already exists!";
            }
        }

//        for (Tank currentTank : this.tanks) {
//            if (currentTank.getBrand().equals(tank.getBrand()) && currentTank.getModel().equals(tank.getModel())) {
//                return "Tank with this brand and model already exists!";
//            }
//        }

        if (this.type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        this.tanks.add(tank);

        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model) {
        Tank currentTank = this.getTankByBrandAndModel(brand, model);

        if (currentTank != null) {
            this.tanks.remove(currentTank);
            return true;
        }

//        for (Tank tank : this.tanks) {
//            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
//                this.tanks.remove(tank);
//                return true;
//            }
//        }

        return false;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<String> tankList = new ArrayList<>();
        for (Tank tank : this.tanks) {
            if (tank.getBarrelCaliber() > barrelCaliber) {
                tankList.add(tank.getBrand());
            }
        }

        if (tankList.isEmpty()) {
            return "There are no tanks with the specified caliber.";
        }

        return String.format("Tanks with caliber more than %dmm: %s", barrelCaliber, String.join(", ", tankList));
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        for (Tank tank : this.tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                return tank;
            }
        }

        return null;
    }

    public String getTheMostArmoredTank() {
        Tank tank = null;
        for (Tank currentTank : this.tanks) {
            if (tank == null) {
                tank = currentTank;
            } else {
                if (currentTank.getArmor() > tank.getArmor()) {
                    tank = currentTank;
                }
            }
        }

        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                tank.getBrand(),
                tank.getModel(),
                tank.getArmor());
    }

    public int getCount() {
        return this.tanks.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.tanks.isEmpty()) {
            stringBuilder.append(String.format("There are no tanks in the %s.", this.type.toLowerCase()));
        } else {
            stringBuilder.append(String.format("Tanks located in the %s:", this.type.toLowerCase())).append(System.lineSeparator());
            for (Tank tank : this.tanks) {
                stringBuilder.append(String.format("-- %s %s", tank.getBrand(), tank.getModel())).append(System.lineSeparator());
            }
        }

        return stringBuilder.toString().trim();
    }


}
