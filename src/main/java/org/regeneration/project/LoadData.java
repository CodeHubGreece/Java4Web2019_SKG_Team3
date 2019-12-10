package org.regeneration.project;

import org.regeneration.project.models.*;
import org.regeneration.project.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Date;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(PasswordEncoder passwordEncoder, CitizenRepository citizenRepository,
                                   DoctorRepository doctorRepository, SpecialitiesRepository specialitiesRepository,
                                   AppointmentRepository appointmentRepository) {
        return args -> {
            Speciality dermatologist = new Speciality("Dermatologist");
            Speciality neurologist = new Speciality("Neurologist");
            Speciality gynecologist = new Speciality("Gynecologist");
            Speciality pathologist = new Speciality("Pathologist");
            Speciality pediatrist = new Speciality("Pediatrist");
            Speciality psychiatrist = new Speciality("Psychiatrist");
            Speciality surgeon = new Speciality("Surgeon");
            specialitiesRepository.saveAll(Arrays.asList(dermatologist, neurologist, gynecologist,
                    pathologist, pediatrist, psychiatrist, surgeon));

            User userCitizenA = new User(
                    "CitizenA",
                    "LastName",
                    "citizenA@gmail.com",
                    "citizenA",
                    passwordEncoder.encode("citizen"),
                    "CITIZEN");
            Citizen citizenA = new Citizen("12345678901", "1234567890", userCitizenA);
            User userCitizenB = new User(
                    "CitizenB",
                    "LastName",
                    "citizenB@gmail.com",
                    "citizenB",
                    passwordEncoder.encode("citizen"),
                    "CITIZEN");
            Citizen citizenB = new Citizen("12345678901", "1234567890", userCitizenB);
            User userCitizenC = new User(
                    "CitizenC",
                    "LastName",
                    "citizenC@gmail.com",
                    "citizenC",
                    passwordEncoder.encode("citizen"),
                    "CITIZEN");
            Citizen citizenC = new Citizen("12345678901", "1234567890", userCitizenC);
            citizenRepository.saveAll(Arrays.asList(citizenA, citizenB, citizenC));

            User userDoctorA = new User(
                    "DoctorA",
                    "LastName",
                    "doctorA@gmail.com",
                    "doctorA",
                    passwordEncoder.encode("doctor"),
                    "DOCTOR");
            Doctor doctorA = new Doctor(dermatologist, userDoctorA);

            User userDoctorB = new User(
                    "DoctorB",
                    "LastName",
                    "doctorB@gmail.com",
                    "doctorB",
                    passwordEncoder.encode("doctor"),
                    "DOCTOR");
            Doctor doctorB = new Doctor(gynecologist, userDoctorB);

            User userDoctorC = new User(
                    "DoctorC",
                    "LastName",
                    "doctorC@gmail.com",
                    "doctorC",
                    passwordEncoder.encode("doctor"),
                    "DOCTOR");
            Doctor doctorC = new Doctor(neurologist, userDoctorC);
            doctorRepository.saveAll(Arrays.asList(doctorA, doctorB, doctorC));

            Appointment appointmentA = new Appointment(
                    new Date("2019/11/23"), citizenA, doctorB,
                    "Some description A", "A couple of notes A");
            Appointment appointmentB = new Appointment(
                    new Date("2019/09/14"), citizenC, doctorA,
                    "Some description B", "A couple of notes B");
            Appointment appointmentC = new Appointment(
                    new Date("2020/02/10"), citizenB, doctorC,
                    "Some description C", "A couple of notes C");
            appointmentRepository.saveAll(Arrays.asList(appointmentA, appointmentB, appointmentC));
        };
    }
}
