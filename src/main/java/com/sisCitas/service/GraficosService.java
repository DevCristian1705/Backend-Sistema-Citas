package com.sisCitas.service;

import com.sisCitas.dto.GraficoDoctoresDto;
import com.sisCitas.dto.GraficosCitasDto;

import java.util.List;

public interface GraficosService {
    List<GraficosCitasDto> GrafCitas();
    List<GraficoDoctoresDto>  GrafDoctores(String FInicio, String FFin);
}
