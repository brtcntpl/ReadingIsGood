package com.getir.readingisgood.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private Set<String> role = new HashSet<>();
}
