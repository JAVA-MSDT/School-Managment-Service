package com.bebestlang.bebest.mapper.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.dto.user.UserDto;
import com.bebestlang.bebest.modal.training.Subject;
import com.bebestlang.bebest.modal.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.TargetType;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "subjects", target = "subjects", qualifiedByName = "toSubjectSet")
    User toUser(UserDto userDto);

    @Mapping(source = "subjects", target = "subjects", qualifiedByName = "toSubjectDtoSet")
    UserDto toUserDto(User user);

    @Mapping(source = "subjects", target = "subjects", qualifiedByName = "toSubjectDtoSet")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "phoneNumber", ignore = true)
    @Mapping(target = "dateOfBirth", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "users", ignore = true)
    UserDto toUserDtoForPublicAPI(User user, @MappingTarget UserDto userDto);

    @Named("toSubjectSet")
    default Set<Subject> toSubjectSet(Set<SubjectDto> subjects) {
        if (subjects == null) {
            return Collections.emptySet();
        }
        Set<Subject> subjectSet = new HashSet<>();
        subjects.forEach(subjectDto -> {
            Subject subject = new Subject(subjectDto.getId(), subjectDto.getSubject(), subjectDto.getDescription());
            subjectSet.add(subject);
        });
        return subjectSet;
    }

    @Named("toSubjectDtoSet")
    default Set<SubjectDto> toSubjectDtoSet(Set<Subject> subjects) {
        if (subjects == null) {
            return Collections.emptySet();
        }

        Set<SubjectDto> subjectSet = new HashSet<>();
        subjects.forEach(subject -> {
            SubjectDto subjectDto = new SubjectDto(subject.getId(), subject.getSubject(), subject.getDescription());
            subjectSet.add(subjectDto);
        });
        return subjectSet;
    }
}
