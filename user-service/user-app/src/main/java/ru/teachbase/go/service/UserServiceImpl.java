package ru.teachbase.go.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.teachbase.go.model.PageUserResponse;
import ru.teachbase.go.model.UserCriteriaFilter;
import ru.teachbase.go.model.UserEntity;
import ru.teachbase.go.model.UserRequest;
import ru.teachbase.go.model.UserResponse;
import ru.teachbase.go.repository.UserRepository;
import ru.teachbase.go.repository.specification.UserSpecification;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @NonNull
    private UserRepository userRepository;
    @NonNull
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void createUser(UserRequest userRequest) {
        //userRequest.getUser().setAccounts(null);
       // userRepository.save(modelMapper.map(userRequest.getUser(), UserEntity.class));
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);

//        boolean flag = true;
//        while (flag){
//
//        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserById(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        UserResponse userResponse = modelMapper.map(userEntity.get(), UserResponse.class);

        return userResponse;
    }

    @Override
    public void updateUser(UserRequest userRequest) {
//        Optional<UserEntity> user = userRepository.findById(userRequest.getUser().getId());
//        if (user.isPresent()) {
//            if (nonNull(userRequest.getUser().getEmail())) {
//                user.get().setEmail(userRequest.getUser().getEmail());
//            }
//            if (nonNull(userRequest.getUser().getPassword())) {
//                user.get().setPassword(userRequest.getUser().getPassword());
//            }
//            if (nonNull(userRequest.getUser().getDateOfBirth())) {
//                user.get().setDateOfBirth(userRequest.getUser().getDateOfBirth());
//            }
//        }
    }

    @Override
    @Transactional(readOnly = true)
    public PageUserResponse getUserByFilter(@NotNull UserCriteriaFilter userCriteriaFilter) {
        Specification<UserEntity> specification = new UserSpecification(userCriteriaFilter);
        PageRequest pageRequest = PageRequest.of(userCriteriaFilter.getPageNumber(),
                userCriteriaFilter.getPageSize(),
                null);
        return modelMapper.map(userRepository.findAll(specification, pageRequest), PageUserResponse.class);
    }
}
