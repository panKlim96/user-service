package ru.teachbase.go.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import ru.teachbase.go.BaseTest;

@SpringBootTest
@RequiredArgsConstructor
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserServiceImplTest extends BaseTest {

//    @BeforeAll
//    public static void initTest() throws SQLException {
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8083")
//                .start();
//    }
//    @Autowired
//    UserService userService;
//
//    @Test
//    @Order(1)
//    void createUser() {
//        UserDto userDto = new UserDto();
//        AccountDto accountDto = new AccountDto();
//        accountDto.setId(5);
//        accountDto.setBalance(BigDecimal.valueOf(3434.43));
//        List<AccountDto> accountDtoList = new ArrayList<>();
//        accountDtoList.add(accountDto);
//        userDto.setId(5);
//        userDto.setAccounts(accountDtoList);
//        userDto.setName("Астраханцев Илья Владимирович");
//        userDto.setEmail("astrahan@bk.ru");
//        userDto.setPassword("asdaso23ed");
//        userDto.dateOfBirth(LocalDate.of(2002, 11, 3));
//        UserRequest userRequest = new UserRequest();
//        userRequest.setUser(userDto);
//        userService.createUser(userRequest);
//    }
//
//    @Test
//    @Order(2)
//    void testMyDBOperation() {
//        //some db operations like save and get
//        while(true) {
//        }
//    }

//    @Test
//    void deleteUserById() {
//    }
//
//    @Test
//    void getUserById() {
//    }
//
//    @Test
//    void updateUser() {
//    }
//
//    @Test
//    void getUserByFilter() {
//    }
}