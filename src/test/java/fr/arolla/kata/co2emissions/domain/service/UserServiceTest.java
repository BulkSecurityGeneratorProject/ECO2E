package fr.arolla.kata.co2emissions.domain.service;

import fr.arolla.kata.co2emissions.Application;
import fr.arolla.kata.co2emissions.domain.User;
import fr.arolla.kata.co2emissions.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@PropertySource("resources/application.properties")
@IntegrationTest
@Transactional
public class UserServiceTest {
    @Inject
    private UserRepository userRepository;

    @Test
    public void testEquals_Error() {
        String login = "admin";

        User user = userRepository.findOneByLogin(login).get();

        System.out.println("result: " + user);
    }
}
