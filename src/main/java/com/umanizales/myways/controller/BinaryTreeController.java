package com.umanizales.myways.controller;

import com.umanizales.myways.controller.dto.RouteDTO;
import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.model.Driver;
import com.umanizales.myways.model.Route;
import com.umanizales.myways.service.BinaryTreeService;
import com.umanizales.myways.service.BusService;
import com.umanizales.myways.service.DriverService;
import com.umanizales.myways.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "myways")
@Validated
public class BinaryTreeController {
    @Autowired
    private BinaryTreeService binaryTreeService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private BusService busService;
    @Autowired
    private RouteService routeService;

    @PostMapping("/createRoutes")
    public @ResponseBody
    ResponseEntity<?> addRoute(@Valid @RequestBody Route route) throws BinaryTreeException {
        return binaryTreeService.addRoute(route);
    }


    @GetMapping ("/preorder")
    public @ResponseBody
    ResponseEntity<?> listStudentsPreOrder() throws DataNotFoundException
    {
        return binaryTreeService.listRoutes(1);
    }

    @GetMapping ("/listDrivers")
    public @ResponseBody
    ResponseEntity<?> listDrivers() throws DataNotFoundException
    {
        return driverService.listDrivers();
    }
    @GetMapping ("/listBusses")
    public @ResponseBody
    ResponseEntity<?> listBusses() throws DataNotFoundException
    {
        return busService.listBusses();
    }

    @GetMapping("listRoutesById/{id}")
    public @ResponseBody
    ResponseEntity<?> listRoutesById(@PathVariable char id) throws  DataNotFoundException
    {
        return binaryTreeService.listRoutesById(id);
    }
    @GetMapping("findBussesById/{id}")
    public @ResponseBody
    ResponseEntity<?> findBussesById(@PathVariable int id) throws  DataNotFoundException
    {
        return busService.findBussesById(id);
    }

    @PostMapping ("/fillRoutes")
    public @ResponseBody
    ResponseEntity<?> fillStudent(@Valid @RequestBody List<Route> routes) throws BinaryTreeException
    {
        return binaryTreeService.fillRoutes(routes);
    }
    @PostMapping ("/assignRoutes")
    public @ResponseBody
    ResponseEntity<?> assingRoutes(@Valid @RequestBody RouteDTO ids) throws DataNotFoundException
    {
        return routeService.assingRoutes(ids.getBusId(), ids.getRouteId());
    }
}