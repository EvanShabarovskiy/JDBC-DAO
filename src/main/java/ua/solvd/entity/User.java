package ua.solvd.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String passwordHash;
    private String phone;
    private Integer roleId;
}