package com.bebestlang.bebest.mapper.subject;

import com.bebestlang.bebest.dto.subject.SubjectDto;
import com.bebestlang.bebest.modal.subject.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectDto subjectDto);

    SubjectDto toSubjectDto(Subject subject);
}
