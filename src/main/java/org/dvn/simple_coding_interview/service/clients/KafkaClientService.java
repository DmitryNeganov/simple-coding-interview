package org.dvn.simple_coding_interview.service.clients;

import org.springframework.stereotype.Service;

@Service
public class KafkaClientService implements ClientService {
    @Override
    public void send(String message) {
        //send message to kafka
    }
}
