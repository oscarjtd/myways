package com.umanizales.myways.service;

import com.umanizales.myways.aplicationdto.ResponseBinaryTreeDTO;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.model.Bus;
import com.umanizales.myways.model.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {

    DriverService driverService = new DriverService();

    private List<Bus> busses;

    public BusService(){
        busses = new ArrayList<>();
        busses.add(new Bus(1,15, "aaa",driverService.findDrivers(1)));
        busses.add(new Bus(2,25, "abc",driverService.findDrivers(2)));
        busses.add(new Bus(3,30, "bbb",driverService.findDrivers(3)));
    }

    public Bus findBusses(int id) {
        Bus bus = new Bus();
        for(Bus b : busses) {
            if(b.getId() == id) {
                bus = b;
                break;
            }
        }
        return bus;
    }
    public List<Bus> list(){
        return busses;
    }

    public ResponseEntity<ResponseBinaryTreeDTO> listBusses() throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(list(),"Successful!",
                null), HttpStatus.OK);

    }
    public ResponseEntity<ResponseBinaryTreeDTO> findBussesById(int id) throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(findBusses(id),"Successful!",
                null), HttpStatus.OK);

    }
}
