package com.umanizales.myways.service;

import com.umanizales.myways.aplicationdto.ResponseBinaryTreeDTO;
import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.model.Driver;
import com.umanizales.myways.model.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    private List<Driver> drivers;

    public DriverService(){
        drivers = new ArrayList<>();
        drivers.add(new Driver("Oscar",1));
        drivers.add(new Driver("Nicolas",2));
        drivers.add(new Driver("Manuel",3));
    }
    public List<Driver> list(){
        return drivers;
    }
    public Driver findDrivers(int id) {
        Driver driver = new Driver();
        for(Driver t : drivers) {
            if(t.getId() == id) {
                driver = t;
                break;
            }
        }
        return driver;
    }

    public ResponseEntity<ResponseBinaryTreeDTO> listDrivers() throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(list(),"Successful!",
                null),HttpStatus.OK);

    }




}
