package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._03JavaAdvancedRegularExam17June2023._03AutomotiveRepairShop.automotiveRepairShop;

public class Main {
    public static void main(String[] args) {
        //Initialize the repository (RepairShop)
        RepairShop repairShop = new RepairShop(5);

//Initialize entity (Vehicle)
        Vehicle vehicle1 = new Vehicle("1HGCM82633A123456", 50000, "Oil leakage");

//Print Vehicle
        System.out.println(vehicle1); // Damage: Oil leakage, Vehicle: 1HGCM82633A123456 (50000 km)

//Add Vehicle
        repairShop.addVehicle(vehicle1);

//Remove Vehicle
        System.out.println(repairShop.removeVehicle("1HGCM82633A123459")); // false
        System.out.println(repairShop.removeVehicle("1HGCM82633A123456")); // true

        Vehicle vehicle2 = new Vehicle("5YJSA1CN7DFP12345", 80000, "Overheating issue");
        Vehicle vehicle3 = new Vehicle("JM1GJ1W56F1234567", 120000, "Coolant leakage");
        Vehicle vehicle4 = new Vehicle("2C3CDXAT4CH123456", 95000, "Timing belt failure");
        Vehicle vehicle5 = new Vehicle("WAUZZZ8K9FA123456", 66000, "Cylinder misfire");
        Vehicle vehicle6 = new Vehicle("1G1BL52P3RR123456", 150000, "Transmission failure");
        Vehicle vehicle7 = new Vehicle("JTDKB20U993123456", 65000, "Piston damage");


//Add More Vehicles
        repairShop.addVehicle(vehicle2);
        repairShop.addVehicle(vehicle3);
        repairShop.addVehicle(vehicle4);
        repairShop.addVehicle(vehicle5);

//Get Count
        System.out.println(repairShop.getCount()); //4

        repairShop.addVehicle(vehicle6);
        repairShop.addVehicle(vehicle7);

//Get Count
        System.out.println(repairShop.getCount()); //5


//Get LowestMileage
        System.out.println(repairShop.getLowestMileage()); //Damage: Cylinder misfire, Vehicle: WAUZZZ8K9FA123456 (66000 km)

//Report
        System.out.println(repairShop.report());
//Vehicles in the preparatory:
//Damage: Overheating issue, Vehicle: 5YJSA1CN7DFP12345 (80000 km)
//Damage: Coolant leakage, Vehicle: JM1GJ1W56F1234567 (120000 km)
//Damage: Timing belt failure, Vehicle: 2C3CDXAT4CH123456 (95000 km)
//Damage: Cylinder misfire, Vehicle: WAUZZZ8K9FA123456 (66000 km)
//Damage: Transmission failure, Vehicle: 1G1BL52P3RR123456 (150000 km)

    }
}
