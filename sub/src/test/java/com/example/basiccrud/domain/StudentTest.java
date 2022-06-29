package com.example.basiccrud.domain;

import com.example.basiccrud.dto.StudentRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {


    @Nested
    @DisplayName("학생 객체 생성")
    class CreateStudent{

        private String studentName;
        private int studentAge;
        private String studentAddress;
        private String subjectName;
        private String professorName;
        private Professor professor;

        @BeforeEach
        void setup(){



            studentName = "김성훈";
            studentAge = 24;
            studentAddress = "수원시";
            subjectName = "컴퓨터공학과";
            professorName = "스티브잡스";


        }
        @Test
        @DisplayName("정상 케이스")
        void createNormal(){
            //given


            //when
            Student student = new Student(studentName,studentAge,studentAddress);
            //then

            assertThat(student.getStudentName()).isEqualTo("김성훈");
            assertThat(student.getStudentAge()).isEqualTo(24);
            assertThat(student.getStudentAddress()).isEqualTo("수원시");
        }

    }
}
