package com.starter.app.mapper;

import com.starter.app.domain.User;
import com.starter.app.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

  UserDto.Response.Info toResponse(User user);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "status", ignore = true)
  User toEntity(UserDto.Request.Create request);
}
