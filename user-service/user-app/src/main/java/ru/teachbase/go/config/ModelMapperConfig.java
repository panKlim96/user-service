package ru.teachbase.go.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.teachbase.go.model.AccountDto;
import ru.teachbase.go.model.AccountEntity;
import ru.teachbase.go.model.UserDto;
import ru.teachbase.go.model.UserEntity;
import ru.teachbase.go.model.UserResponse;

import static java.util.Objects.nonNull;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(AccountEntity.class, AccountDto.class)
                .addMappings(mapper -> mapper.map(src -> src.getUserEntity().getId(), AccountDto::setUserId));
//        ДЛЯ ЦИКЛИЧЕСКИХ ЗАВИСИМОСТЕЙ
//        modelMapper.addMappings(new PropertyMap<UserEntity, UserDto>() {
//            @Override
//            protected void configure() {
//                skip(destination.getAccounts());
//            }
//        });

        modelMapper.createTypeMap(UserEntity.class, UserResponse.class)
                .addMappings(mapper -> mapper.using(converterUser(modelMapper, UserDto.class))
                        .map(src -> src, UserResponse::setUser));

        return modelMapper;
    }

    private <S, D> Converter<S, D> converter(ModelMapper modelMapper, Class<D> dstClass) {
        return context -> nonNull(context) ? modelMapper.map(context.getSource(), dstClass) : null;
    }

    private Converter<UserEntity, UserDto> converterUser(ModelMapper modelMapper, Class<UserDto> dstClass) {
        return context -> nonNull(context) ? modelMapper.map(context.getSource(), dstClass) : null;
    }
}
