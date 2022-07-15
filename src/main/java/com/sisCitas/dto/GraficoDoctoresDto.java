package com.sisCitas.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GraficoDoctoresDto {
    private String doctor;
    private Long cantidad;
}
