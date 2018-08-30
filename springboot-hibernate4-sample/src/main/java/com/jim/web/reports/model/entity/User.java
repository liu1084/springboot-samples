package com.jim.web.reports.model.entity;

import com.jim.web.reports.config.EnumPosition;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name = "r_users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Email
    private String email;

    private String username;
    private String password;
    private String salt;
    private String mobileNumber;
    private EnumPosition position;
}
