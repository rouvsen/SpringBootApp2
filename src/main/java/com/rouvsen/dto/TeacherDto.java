package com.rouvsen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class TeacherDto {
    private String teacherNameSurname;
    private String teacherEmail;
    private String teacherPassword;
}
