package com.company.springapp.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HelloDto {

    private final String message;

}
