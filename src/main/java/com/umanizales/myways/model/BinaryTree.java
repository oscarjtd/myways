package com.umanizales.myways.model;

import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BinaryTree {
    private Node root;

    public void createRoutes(Route data) throws BinaryTreeException {
        if (root == null) {
            root = new Node(data);
        } else {
            root.createRoutes(data);
        }
    }

    public List<Route> listRoutes(int which) throws DataNotFoundException {
        if (root == null) {
            throw new DataNotFoundException("There is no routes to list");
        } else {
            switch (which) {
                case 1:
                    return root.listRoutesPreOrder();
            }
            throw new DataNotFoundException("No data to show");
        }
    }
    public List<Route> listRoutesById (char id) throws DataNotFoundException
    {

        if (root != null)
        {
            return root.listRoutesById(id);
        }

        throw new DataNotFoundException("No data found");
    }

}
