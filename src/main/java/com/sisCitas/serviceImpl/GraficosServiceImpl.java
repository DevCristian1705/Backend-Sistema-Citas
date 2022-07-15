package com.sisCitas.serviceImpl;

import com.sisCitas.dto.GraficoDoctoresDto;
import com.sisCitas.dto.GraficosCitasDto;
import com.sisCitas.persistence.repository.GraficosRepository;
import com.sisCitas.service.GraficosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GraficosServiceImpl implements GraficosService {

    private final GraficosRepository graficosRepository;

    @Override
    public List<GraficosCitasDto> GrafCitas() {
        List<GraficosCitasDto>  gc = new ArrayList<>();
        graficosRepository.SPGraficoCitas().forEach(item -> {
            GraficosCitasDto i = GraficosCitasDto.builder()
                    .estado(item[0].toString())
                    .cantidad(Long.parseLong(item[1].toString()))
                    .build();
            gc.add(i);
        });
        return gc;
    }



    @Override
    public List<GraficoDoctoresDto> GrafDoctores(String FInicio, String FFin) {
        List<GraficoDoctoresDto>  gd = new ArrayList<>();
        graficosRepository.SPGraficoDoctores(FInicio,FFin).forEach(item -> {
            GraficoDoctoresDto i = GraficoDoctoresDto.builder()
                    .doctor(item[0].toString())
                    .cantidad(Long.parseLong(item[1].toString()))
                    .build();
            gd.add(i);
        });
        return gd;
    }


}
