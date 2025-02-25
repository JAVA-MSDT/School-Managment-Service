package com.bebestlang.bebest.mapper.training;

import com.bebestlang.bebest.dto.training.SubjectDto;
import com.bebestlang.bebest.modal.training.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    Subject toSubject(SubjectDto subjectDto);

    SubjectDto toSubjectDto(Subject subject);
}
