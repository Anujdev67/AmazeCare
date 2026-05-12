package com.hexaware.amazecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.amazecare.model.Appointment;
import com.hexaware.amazecare.repository.AppointmentRepository;

/**
 * Service layer for appointment persistence operations.
 * Keeping database access in this class helps controllers stay focused on HTTP
 * request/response handling.
 */
@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;

	/**
	 * Creates a new appointment or updates an existing one.
	 */
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	/**
	 * Returns every appointment currently stored in the database.
	 */
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	/**
	 * Fetches a single appointment by primary key.
	 */
	public Appointment getAppointment(int id) {
		return appointmentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Appointment Id Given"));
	}

}
