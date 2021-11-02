package com.umanizales.myways.aplicationdto;

import com.umanizales.myways.controller.dto.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBinaryTreeDTO {

    private Object data;
    private String message;
    private List<ErrorDTO> errors;
}

