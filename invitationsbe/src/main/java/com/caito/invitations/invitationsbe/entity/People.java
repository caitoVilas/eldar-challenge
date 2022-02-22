package com.caito.invitations.invitationsbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "peoples")
@SQLDelete(sql = "UPDATE peoples SET  deleted=true WHERE id=?")
@Where(clause = "deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String surname;
    private LocalDate dateOfBird;
    @Column(length = 11)
    private String dni;
    private boolean deleted;
    private boolean invited;
}
