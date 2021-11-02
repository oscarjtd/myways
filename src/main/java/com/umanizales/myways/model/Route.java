package com.umanizales.myways.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class Route {
    @NotNull
    private char id;
    @NotNull
    @NotBlank
    @Size(max=50)
    private String origin;
    @NotNull
    @NotBlank
    @Size(max=50)
    private String end;


}
