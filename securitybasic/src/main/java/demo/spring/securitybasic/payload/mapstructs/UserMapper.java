package demo.spring.securitybasic.payload.mapstructs;

import demo.spring.securitybasic.entity.User;
import demo.spring.securitybasic.payload.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "username",target = "username")
    @Mapping(source = "password",target = "password")
    User toUserEntity(UserRequest userRequest);
}
