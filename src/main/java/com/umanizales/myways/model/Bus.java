package com.umanizales.myways.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @NotNull
    private int id;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private int capacity;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String brand;
    @NotNull
    @NotBlank
    @Size(max = 50)
    private Driver driver;

   /* public List<Bus> addBus(Bus bus){
        List<Bus> bussesList = new ArrayList<>();
        bussesList.add(bus);

        return bussesList;
    }*/
}

