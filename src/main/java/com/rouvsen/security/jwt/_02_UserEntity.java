package com.rouvsen.security.jwt;

//Register (qeydiyyatdan kecmek) ucun istifade edecik

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rouvsen.data.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

//lombok
@Getter
@Setter

//JPA
@Entity
@Table(name = "user")
public class _02_UserEntity extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

}
