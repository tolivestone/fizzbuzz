package com.fizzbuzz.model;
import com.fizzbuzz.service.Sound;
import java.util.Optional;

//Student class will be given a number and will say either number,
//fizz, buzz or fizzbuzz depending on game rule.
// Student can only be instantiated via StudentBuilder class
public class Student implements Person {

    private final int studentId;            //required
    private final String name;              //required
    private final String lastName;          //optional
    private final Sound soundService;       //required


    private Student(final int studentId,final String name,final String lastName ,final Sound soundService) {
        this.studentId = studentId;
        this.name = name;
        this.soundService = soundService;
        this.lastName = lastName;
    }

    @Override
    public String sayNumber(int number) {
        return Optional.of(number)
                .map(num -> this.name + " -> " + num + " -> " + soundService.generate(num))
                .get();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }


    // Student builder class abstracts student creation and gives an options to set optional parameters
    public static class StudentBuilder {
        private final int studentId;
        private final String name;
        private final Sound soundService;
        private String lastName;

        public StudentBuilder(final int studentId,final String name,final Sound soundService) {
            if(studentId <= 0 || name == null || name.isEmpty() || soundService == null)
                throw new IllegalArgumentException("Incorrect argument(s) passed");

            this.studentId = studentId;
            this.name = name;
            this.soundService = soundService;
        }

        //This is optional attribute
        public StudentBuilder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Person build() {
            if(lastName == null) lastName = "";
            return new Student(studentId,name,lastName, soundService);
        }
    }
}
