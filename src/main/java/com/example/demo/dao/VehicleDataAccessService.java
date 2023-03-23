package com.example.demo.dao;

import com.example.demo.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("MySQL_connection")
public class VehicleDataAccessService implements VehicleDao{

    private static List<Vehicle> MySQLDatabase = new ArrayList<>();

    @Override
    public boolean insertVehicle(Vehicle vehicle) {
        MySQLDatabase.add(new Vehicle(vehicle.getId(), vehicle.getType(), vehicle.getBrand()));
        return true;
    }

    @Override
    public List<Vehicle> selectAllVehicles() {
        return MySQLDatabase;
    }

    @Override
    public Optional<Vehicle> selectVehicleById(int id) {
        return MySQLDatabase.stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst();
    }

    @Override
    public boolean updateVehicle(int id, Vehicle vehicleToBeUpdated) {
        return selectVehicleById(id)
                .map(vehicle -> {
                    int indexOfPersonToUpdate = MySQLDatabase.indexOf(vehicle);
                    if (indexOfPersonToUpdate >= 0) {
                        MySQLDatabase.set(indexOfPersonToUpdate, new Vehicle(vehicleToBeUpdated.getId(), vehicleToBeUpdated.getType(),vehicleToBeUpdated.getBrand()));
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    @Override
    public boolean deleteVehicle(int id) {
        Optional<Vehicle> possibleVehicleToDelete = selectVehicleById(id);
        if (possibleVehicleToDelete.isEmpty()) {
            return false;
        }
        MySQLDatabase.remove(possibleVehicleToDelete.get());
        return true;
    }
}
