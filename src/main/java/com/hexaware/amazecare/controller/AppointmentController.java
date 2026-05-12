package com.hexaware.amazecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.amazecare.dto.ResponseMessageDto;
import com.hexaware.amazecare.enums.Appointment_Status;
import com.hexaware.amazecare.exceptions.ResourceNotFoundException;
import com.hexaware.amazecare.model.Appointment;
import com.hexaware.amazecare.service.AppointmentService;
import com.hexaware.amazecare.service.DoctorService;
import com.hexaware.amazecare.service.PatientService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	
	/**
	 * Books a new appointment after verifying both patient and doctor exist.
	 * If any reference is invalid, a readable error message is sent to the client.
	 */
	@PostMapping("/appointment/book")
	public ResponseEntity<?>bookAppointment(@RequestBody Appointment appointment,ResponseMessageDto dto){
		int docId=appointment.getDoctor().getId();
		int patientId=appointment.getPatient().getId();
		
		// Validate the patient first so we can fail early with a useful message.
		try {
			patientService.validate(patientId);
		}catch(ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		// Validate the doctor before persisting the appointment.
		try {
			doctorService.validate(docId);
		}catch(ResourceNotFoundException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}
		// New appointments are always created in BOOKED state.
		appointment.setStatus(Appointment_Status.BOOKED);
		appointment=appointmentService.addAppointment(appointment);
		
		return ResponseEntity.ok(appointment);	
	}

	/**
	 * Lists every appointment record.
	 */
	@GetMapping("/appointment/allAppointment")
	public List<Appointment> getAllAppointment(){
		return appointmentService.getAllAppointment();
	}

	/**
	 * Updates appointment workflow state using the status query parameter.
	 */
	@PutMapping("/appointment/update/{id}")
	public Appointment updateAppointment(@RequestParam String status,@PathVariable int  id) {
		Appointment appointment=null;
		appointment=appointmentService.getAppointment(id);
		Appointment_Status astatus=Appointment_Status.valueOf(status);
		appointment.setStatus(astatus);
		return appointmentService.addAppointment(appointment);
	}
}
