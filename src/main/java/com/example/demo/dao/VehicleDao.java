package com.example.demo.dao;

import com.example.demo.model.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface VehicleDao {

    // Create a new register
    boolean insertVehicle(Vehicle vehicle);

    // Gets all the registers
    List<Vehicle> selectAllVehicles();

    // Get one register
    Optional<Vehicle> selectVehicleById(int id);

    // Update a register
    boolean updateVehicle(int id, Vehicle vehicleToBeUpdated);

    // Delete a register
    boolean deleteVehicle(int id);
}
