package com.sisCitas.serviceImpl;

import com.sisCitas.persistence.entity.Doctor;
import com.sisCitas.persistence.entity.Usuario;
import com.sisCitas.persistence.repository.DoctorRepository;
import com.sisCitas.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Doctor save(Doctor doctor) {
        doctor.setIsactivo(true);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        doctor.setIsactivo(true);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> ListAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Long delete(Long iddoctor) {
        Long rpta = 0L;
        Doctor c = doctorRepository
                .findById(iddoctor)
                .orElseThrow(EntityNotFoundException::new);
        c.setIsactivo(false);
        rpta = doctorRepository.save(c) != null ? iddoctor : 0L;
        return rpta;
    }
}
