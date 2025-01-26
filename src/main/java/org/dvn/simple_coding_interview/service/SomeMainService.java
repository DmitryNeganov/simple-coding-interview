package org.dvn.simple_coding_interview.service;

import lombok.extern.slf4j.Slf4j;
import org.dvn.simple_coding_interview.repo.User;
import org.dvn.simple_coding_interview.repo.UserService;
import org.dvn.simple_coding_interview.service.clients.KafkaClientService;
import org.dvn.simple_coding_interview.service.clients.LoggingClientService;
import org.dvn.simple_coding_interview.service.clients.StatisticsClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


/**
 * Service class for controller requests.
 * One of the method is to find and return User data.
 * Each request should be sent to Kafka, Logger microservice and Statistics microservice
 *
 */
@Slf4j
@Service
public class SomeMainService {

    private Logger LOGGER;

    private KafkaClientService kafkaClientService;

    private LoggingClientService loggingClientService;

    @Autowired
    private StatisticsClientService statisticsClientService;

    private UserService userService;

    private int counter;

    public SomeMainService(Logger LOGGER) {
        this.LOGGER = Logger.getLogger("SomeMainLogger");
        this.userService = new UserService();
    }

    @Autowired
    public void setKafkaClientService(KafkaClientService kafkaClientService) {
        this.kafkaClientService = kafkaClientService;
    }

    @Autowired
    public void setLoggingClientService(LoggingClientService loggingClientService) {
        this.loggingClientService = loggingClientService;
    }

    public User getUser(Long id) {
        System.out.println("Request to get user with id " + id);
        User user = new User();

        User userFromRepo = userService.getUser(id);
        if (userFromRepo == null) {
            System.out.println("ERROR: user was not found");
            return null;
        }

        user.id = userFromRepo.id;
        user.username = userFromRepo.username;
        user.password = userFromRepo.password;

        System.out.println("Sending messages to services");
        kafkaClientService.send("Request #" + counter + " for user with id " + id);
        loggingClientService.send("Request #" + counter + " for user with id " + id);
        statisticsClientService.send("Request #" + counter + " for user with id " + id);

        return user;
    }
}
