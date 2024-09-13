package com.hampcode.service.impl;

import com.hampcode.model.entity.Appointment;
import com.hampcode.repository.AppointmentRepository;
import com.hampcode.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Appointment getOne(Integer id) {
        return appointmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Transactional
    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Transactional
    @Override
    public Appointment update(Integer id, Appointment appointment) {
        Appointment doc = appointmentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
        doc.setId_availability(appointment.getId_availability());
        return appointmentRepository.save(doc);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }
}
