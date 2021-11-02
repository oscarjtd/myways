package com.umanizales.myways.service;

import com.umanizales.myways.aplicationdto.ResponseBinaryTreeDTO;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.model.BinaryTree;
import com.umanizales.myways.model.Bus;
import com.umanizales.myways.model.BusRoute;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    BusRoute busRoute = new BusRoute();
    public ResponseEntity<ResponseBinaryTreeDTO> assingRoutes(int BusId, char RouteId) throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(busRoute.assignRoutes(BusId,RouteId),"Successful!",
                null),HttpStatus.OK);

    }
}