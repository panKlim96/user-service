package ru.teachbase.go;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = UserServiceApplication.class)
@ActiveProfiles("test")
public class BaseTest {
}
