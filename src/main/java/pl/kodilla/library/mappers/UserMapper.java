package pl.kodilla.library.mappers;

import org.springframework.stereotype.Service;
import pl.kodilla.library.domain.User;
import pl.kodilla.library.dto.UserDto;

@Service
public class UserMapper {

    public User mapUserDtoToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getSecondName(),
                userDto.getCreated(),
                userDto.getUserBorrows());
    }

    public UserDto mapUserDtoToUser(final User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getSecondName(),
                user.getCreated(),
                user.getUserBorrows());
    }
}
