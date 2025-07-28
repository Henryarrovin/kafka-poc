package app.web.driver.service.impl;

import app.web.driver.constant.AppConstant;
import app.web.driver.service.CabLocationService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationServiceImpl implements CabLocationService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CabLocationServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void updateLocation(String location) {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
    }

}
