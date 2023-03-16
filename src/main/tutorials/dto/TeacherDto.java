package com.rouvsen.tutorials.dto;

import jakarta.validation.constraints.*;
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
public class TeacherDto{

    private Long teacherId;

    @NotEmpty(message = "Ad Soyad alanini bos gecemezsiniz")
    @Size(min = 5, max = 100, message = "Size-i min 5 max 100 olmalidir")
    private String teacherNameSurname;

    @NotEmpty(message = "Email bos gecemezsiniz")
    @Email(message = "Uygun formatta Email girmediniz")
    @Size(min = 3, max = 120, message = "Size-i min 3 max 120 olmalidir")
    private String teacherEmail;

    @NotEmpty(message = "Sifreyi bos gecemezsiniz")
//    @Min(value = 18, message = "Minimum 18 yash ve ustu olmasi gerekiyor")
//    @Max(value = 50, message = "Maksimum 50 yash ve alti olmasi gerekiyor")
    @Size(min = 8, max = 64, message = "Size-i min 8 max 64 olmalidir")
    private String teacherPassword;
}