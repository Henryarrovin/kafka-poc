package app.web.user.service.impl;

import app.web.user.service.LocationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Override
    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void cabLocation(String location) {
        System.out.println(location);
    }

}
