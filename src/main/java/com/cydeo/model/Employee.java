package com.cydeo.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    /**
     * To validate each field we need to use javax.validation validators
     * above each field as shown below examples
     */
    /**@NotNull  - Except null, anything can be accepted,
      everything besides null, "" <- mean some string it's not null*/

     /**@NotEmpty - Except null and empty String anything can be accepted
      * it doesn't accept null and "" it considered as empty */

     /**@NotBlank - Except null, empty String and only space anything can be accepted,
                   it won't accept " " empty string characters */

    @NotBlank
    //@Size(min = 2, max = 10)
    @Pattern(regexp = "^[A-Za-z]{2,12}")
    private String firstName;
    @NotEmpty
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@DateTimeFormat(pattern = "MM-dd-yyyy") this format doesn't work because of DB date format usually uses as above format
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
