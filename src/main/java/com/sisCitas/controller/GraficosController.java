package com.sisCitas.controller;

import com.sisCitas.dto.GraficoDoctoresDto;
import com.sisCitas.dto.GraficosCitasDto;
import com.sisCitas.service.GraficosService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/graficos")
@RequiredArgsConstructor
public class GraficosController {

    private final GraficosService graficosService;

    @GetMapping("/citas")
    @ApiOperation("Get list - lista total de citas por estado")
    public List<GraficosCitasDto> getcitasestados() {
        return graficosService.GrafCitas();
    }

    @GetMapping("/doctores")
    @ApiOperation("Get list - lista total de citas por doctores")
    public List<GraficoDoctoresDto> getPersonas(@RequestParam(value="FInicio", required = false) String FInicio, @RequestParam(value="FFin", required = false) String FFin) {
        return graficosService.GrafDoctores(FInicio, FFin);
    }
}
