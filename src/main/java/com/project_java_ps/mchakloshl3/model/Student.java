package com.project_java_ps.mchakloshl3.model;

// Importy
import jakarta.persistence.*;

// Klasa encji dla Studenta
@Entity
@Table(name = "students")  // Nazwa tabeli w bazie danych
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")  // Kolumna przechowująca imię studenta
    private String firstName;

    @Column(name = "last_name")  // Kolumna przechowująca nazwisko studenta
    private String lastName;

    @Column(name = "email")  // Kolumna przechowująca email studenta
    private String email;

    @Column(name = "enrollment_date")  // Kolumna przechowująca datę zapisu studenta
    private String enrollmentDate;

    @Column(name = "password")  // Kolumna przechowująca hasło studenta
    private String password;

    @Column(name = "faculties")  // Kolumna przechowująca wydział, na którym jest zapisany student
    private String faculties;

    @Column(name = "enrolled")  // Kolumna przechowująca status zapisu studenta
    private boolean enrolled;

    // Konstruktory, gettery, settery, itp.

    public Student() {
    }

    public Student(String firstName, String lastName, String email, String enrollmentDate, String password, String faculties, boolean enrolled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.enrollmentDate = enrollmentDate;
        this.password = password;
        this.faculties = faculties;
        this.enrolled = enrolled;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculties() {
        return faculties;
    }

    public void setFaculties(String faculties) {
        this.faculties = faculties;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName +
                ", email=" + email + ", enrollmentDate=" + enrollmentDate +
                ", password=" + password + ", faculties=" + faculties + "]";
    }
}
