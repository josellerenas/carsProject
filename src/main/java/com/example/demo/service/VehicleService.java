package com.example.demo.service;

import com.example.demo.dao.VehicleDao;
import com.example.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleDao vehicleDao;

    @Autowired
    public VehicleService(@Qualifier("MySQL_connection") VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public boolean insertVehicle(Vehicle newVehicle) {
        return vehicleDao.insertVehicle(newVehicle);
    }

    public List<Vehicle> selectAllVehicles() {
        return vehicleDao.selectAllVehicles();
    }

    public Optional<Vehicle> selectVehicleById(int id) {
        return vehicleDao.selectVehicleById(id);
    }

    public boolean updateVehicle(int id, Vehicle vehicleToBeUpdated) {
        return vehicleDao.updateVehicle(id, vehicleToBeUpdated);
    }

    public boolean deleteVehicle(int id) {
        return vehicleDao.deleteVehicle(id);
    }
}
