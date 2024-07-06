package com.school.studentms.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentEntity {

    private long id;
    private long orgId;
    private LocalDate date;
    private double amount;
    private String isPaid;
}
