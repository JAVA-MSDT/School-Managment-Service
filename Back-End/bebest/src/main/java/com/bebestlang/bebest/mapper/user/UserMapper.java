package com.bebestlang.bebest.mapper.user;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.bebestlang.bebest.dto.subject.SubjectDto;
import com.bebestlang.bebest.dto.user.UserDto;
import com.bebestlang.bebest.modal.subject.Subject;
import com.bebestlang.bebest.modal.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "subjects", target = "subjects", qualifiedByName = "toSubjectSet")
    User toUser(UserDto userDto);

    @Mapping(source = "subjects", target = "subjects", qualifiedByName = "toSubjectDtoSet")
    UserDto toUserDto(User user);

    @Named("toSubjectSet")
    default Set<Subject> toSubjectSet(Set<SubjectDto> subjects) {
        if(subjects == null) {
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
        if(subjects == null) {
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
