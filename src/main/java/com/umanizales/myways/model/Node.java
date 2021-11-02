package com.umanizales.myways.model;

import com.umanizales.myways.exception.BinaryTreeException;
import com.umanizales.myways.exception.DataNotFoundException;
import com.umanizales.myways.service.BusService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@ToString
public class Node {
    private Route data;
    private Node left;
    private Node right;

    public Node(Route data) {
        this.data = data;

    }

    public void createRoutes(Route data) throws BinaryTreeException {
        if (data.getId() < this.getData().getId()) {
            if (this.getLeft() == null) {
                this.setLeft(new Node(data));

            } else {
                this.left.createRoutes(data);
            }
        } else if (data.getId() > this.getData().getId()) {
            if (this.getRight() == null) {
                this.setRight(new Node(data));

            } else {
                this.right.createRoutes(data);
            }

        } else {
            throw new BinaryTreeException("The route already exists");
        }

    }

    public List<Route> listRoutesPreOrder() {
        List<Route> listRoutesPreOrder = new ArrayList<>();
        listRoutesPreOrder.add(this.getData());
        if (this.getLeft() != null) {
            listRoutesPreOrder.addAll(this.getLeft().listRoutesPreOrder());
        }
        if (this.getRight() != null) {
            listRoutesPreOrder.addAll(this.getRight().listRoutesPreOrder());
        }
        // Once finished return the List
        return listRoutesPreOrder;
    }



    public List<Route> listRoutesById(char id)  {

        List<Route> listRoutesId = new ArrayList<>();

        if (this.getData().getId() == id) {
            listRoutesId.add(this.getData());
        }

        if (this.getLeft() != null) {
            listRoutesId.addAll(this.getLeft().listRoutesById(id));
        }
        if (this.getRight() != null) {
            listRoutesId.addAll(this.getRight().listRoutesById(id));
        }

        return listRoutesId;
    }


}
