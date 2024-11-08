package com.spring.AmazeCare.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String resultDescription;
    private Date generatedOn;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "labOperator_id")
    private LabOperator labOperator;

    @ManyToOne
    @JoinColumn(name = "testAndScans_id")
    private TestAndScans testAndScans;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public Date getGeneratedOn() {
		return generatedOn;
	}

	public void setGeneratedOn(Date generatedOn) {
		this.generatedOn = generatedOn;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LabOperator getLabOperator() {
		return labOperator;
	}

	public void setLabOperator(LabOperator labOperator) {
		this.labOperator = labOperator;
	}

	public TestAndScans getTestAndScans() {
		return testAndScans;
	}

	public void setTestAndScans(TestAndScans testAndScans) {
		this.testAndScans = testAndScans;
	}

  
}
