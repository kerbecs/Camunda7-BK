package com.camunda7.camunda7;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String xml;
}
