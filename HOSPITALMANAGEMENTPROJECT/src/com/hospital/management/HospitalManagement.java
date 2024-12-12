package com.hospital.management;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagement
{
	public  static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		Scanner scanner = new Scanner(System.in);
	
			try(Connection connection = DatabaseService.getConnection()) 
			{
				Patient patient = new Patient(connection);
				Doctor doctor = new Doctor(connection);
				BookAppointment appointment= new BookAppointment(connection, patient, doctor);
				while(true)
				{
					System.out.println("Hospital Management System");
					System.out.println("1.Add Patient");
					System.out.println("2.Add Doctors");
					System.out.println("3.View Patients");
					System.out.println("4.View Doctors");
					System.out.println("5.Book Appointment");
					
					System.out.println("Enter our choice:");
					
					int choice = scanner.nextInt();
					
					switch (choice)
					{
					case 1: 
						patient.addPatient();
						break;
					case 2: 
						doctor.addDoctor();
						break;
					case 3: 
						patient.viewPatients();
						break;
					case 4: 
						doctor.viewDoctors();
						break;
					case 5: 
						appointment.bookappointment();
						break;
					case 6: 
						scanner.close();
						return;
					default:
						System.out.println("please enter valid choice");
						break;
					}
				}
			}
		}
	
	}
