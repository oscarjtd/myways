package com.umanizales.myways.service;

import com.umanizales.myways.aplicationdto.ResponseBinaryTreeDTO;
import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.model.BinaryTree;
import com.umanizales.myways.model.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryTreeService {
    private BinaryTree binaryTree = new BinaryTree();

    public ResponseEntity<ResponseBinaryTreeDTO> addRoute(Route route) throws BinaryTreeException {
        binaryTree.createRoutes(route);
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(route, "Route addded succesfully", null), HttpStatus.OK);


    }
    public ResponseEntity<ResponseBinaryTreeDTO> listRoutes(int which) throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(binaryTree.listRoutes(which),"Successful!",
                null),HttpStatus.OK);

    }
    public ResponseEntity<ResponseBinaryTreeDTO> listRoutesById(char id) throws DataNotFoundException
    {
        if (binaryTree.listRoutesById(id).isEmpty())
        {
            return new ResponseEntity<>(new ResponseBinaryTreeDTO(binaryTree.listRoutesById(id), "There's no routes", null), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(binaryTree.listRoutesById(id), "Success!", null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseBinaryTreeDTO> fillRoutes(List<Route> routes) throws BinaryTreeException
    {
        // for each Boy in the List...
        for(Route route:routes)
        {
            // add Boy to the Tree
            binaryTree.createRoutes(route);
        }
        return new ResponseEntity<>(new ResponseBinaryTreeDTO(true,"successful",
                null),HttpStatus.OK);
    }
}