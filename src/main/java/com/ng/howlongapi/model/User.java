package com.ng.howlongapi.model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    private Date createTime;
}