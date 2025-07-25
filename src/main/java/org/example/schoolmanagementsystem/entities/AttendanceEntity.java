// AttendanceEntity.java
package org.example.schoolmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.schoolmanagementsystem.entities.administration.StudentEntity;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attendance")
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    @JsonBackReference
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subject;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "present", nullable = false, length = 10)
    private boolean present;

    @Column(name = "notes", length = 255)
    private String notes;
}
