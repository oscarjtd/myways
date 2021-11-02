package com.umanizales.myways.model;

import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.service.BusService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusRoute {
    private Bus bus;
    private List<Route> route;
    /*private String date;
   /* private String state;
    public int passengers;
    public int passagevalue;*/


    public List<BusRoute> assignRoutes(int BusId, char RouteId) throws DataNotFoundException {
        List<BusRoute> assignedRoutes= new ArrayList<>();

        BinaryTree binaryTree = new BinaryTree();
        BusService busService = new BusService();


        assignedRoutes.add(new BusRoute(busService.findBusses(BusId),binaryTree.listRoutesById(RouteId)));

        return assignedRoutes;
    }
}
