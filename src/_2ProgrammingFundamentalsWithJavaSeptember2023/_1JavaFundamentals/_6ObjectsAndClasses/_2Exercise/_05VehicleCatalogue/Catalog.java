package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._05VehicleCatalogue;

public class Catalog {
    private String typeOfVehicle;
    private String model;
    private String color;
    private int horsepower;
    public Catalog(String typeOfVehicle, String model, String color, int horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }
    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public int getHorsepower() {
        return horsepower;
    }

}
