package com.restaurantbookingapi;

import com.restaurantbookingapi.entities.Student;
import com.restaurantbookingapi.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RestaurantBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBookingApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student maria = new Student(
                    "Maria",
                    "Jones",
                    "maria.jones@upc.pe_*",
                    21
            );
            Student maria2 = new Student(
                    "Maria2",
                    "Jones2",
                    "maria.jones2@upc.pe_*",
                    25
            );
            Student ahmed = new Student(
                    "Amhed",
                    "Ali",
                    "amed.ali@upc.pe_*",
                    30
            );
            //studentRepository.saveAll(List.of(maria, ahmed, maria2));

            System.out.println("****** Select email: amed.ali@upc.pe ");
            studentRepository
                    .findStudentByEmail("amed.ali@upc.pe")
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Student Notfound")
                    );

            System.out.println("******* Select  First Name: Maria, Age Greater: 21 ");
            studentRepository
                    .selectStudentWhereFirstNameAndDAgeGreaterOrEquals(
                            "Maria",
                            21
                    ).forEach(System.out::println);

            System.out.println("******* Select (Native) First Name: Maria, Age Greater: 21 ");
            studentRepository
                    .selectStudentWhereFirstNameAndDAgeGreaterOrEqualsNative(
                            "Maria",
                            21
                    ).forEach(System.out::println);

            System.out.println("********  Deleting Maria 2");
            System.out.println(studentRepository.deleteStudentById(3l));
        };
    }

}
