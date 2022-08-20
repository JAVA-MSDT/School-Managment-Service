package com.bebestlang.bebest.dto.user;

import java.time.LocalDate;
import java.util.Set;

import com.bebestlang.bebest.dto.subject.SubjectDto;
import com.bebestlang.bebest.modal.user.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "User Dto object")
public class UserDto {

    @ApiModelProperty(value = "user id", example = "UUID4")
    private String id;

    @ApiModelProperty(value = "First Name", example = "Ahmed")
    private String firstName;

    @ApiModelProperty(value = "Middle Name", example = "Samy Bakry")
    private String middleName;

    @ApiModelProperty(value = "Last Name", example = "Mahmoud")
    private String lastName;

    @ApiModelProperty(value = "User Name", example = "loginName", notes = "Used for Login")
    private String username;

    @ApiModelProperty(value = "User Email", example = "email@domain.com", notes = "Used for Login")
    private String email;

    @ApiModelProperty(value = "User Phone", example = "+## ### ### ###")
    private String phoneNumber;

    @ApiModelProperty(value = "User Birth Date", example = "YYYY/MM/DD")
    private LocalDate dateOfBirth;

    @ApiModelProperty(value = "User Address", example = "address Object")
    private AddressDto address;

    @ApiModelProperty(value = "User role", example = "ADMIN, TEACHER, STUDENT, PARENT")
    private Role role;

    @ApiModelProperty(value = "User Subjects", example = "Set of subjects", dataType = "array")
    private Set<SubjectDto> subjects;

    @ApiModelProperty(value = "Users Set", example = "Set of Users", notes = "Could be Children for a Parent role, Students for Teacher or Teachers for Students")
    private Set<UserDto> users;

}
