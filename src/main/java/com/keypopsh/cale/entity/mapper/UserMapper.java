package com.keypopsh.cale.entity.mapper;


import com.keypopsh.cale.entity.User;
import com.keypopsh.cale.entity.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
    static ModelMapper modelMapper = new ModelMapper();


    static public User mapToEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public static UserDto mapToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
