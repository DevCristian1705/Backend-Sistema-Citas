package com.sisCitas.service;

import com.sisCitas.persistence.entity.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor save(Doctor doctor);
    Doctor update(Doctor doctor);
    List<Doctor> ListAll();
    Long  delete(Long iddoctor);
}
