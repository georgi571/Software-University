package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.repositories;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._06JavaOOPRetakeExam18April2023._01HighQualityStructure.vehicleShop.models.vehicle.Vehicle;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class VehicleRepository implements Repository<Vehicle> {
    private Map<String, Vehicle> vehicles;
    @Override
    public Collection<Vehicle> getWorkers() {
        return Collections.unmodifiableCollection(this.vehicles.values());
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.put(vehicle.getName(), vehicle);
    }

    @Override
    public boolean remove(Vehicle vehicle) {
        if (this.vehicles.containsKey(vehicle.getName())) {
            this.vehicles.remove(vehicle.getName());
            return true;
        }
        return false;
    }

    @Override
    public Vehicle findByName(String name) {
        return this.vehicles.get(name);
    }
}
