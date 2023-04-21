package ru.timutkin.cmcapi.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.timutkin.cmcapi.dto.Cryptocurrency;
import ru.timutkin.cmcapi.mapper.CryptocurrencyMapper;
import ru.timutkin.cmcapi.repository.CryptocurrencyRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class Consumer {

    CryptocurrencyRepository cryptocurrencyRepository;

    CryptocurrencyMapper cryptocurrencyMapper;

    @Transactional
    @RabbitListener(queues = {"${spring.rabbitmq.queuename}"})
    public void consume(List<Cryptocurrency> cryptocurrencies) {
        cryptocurrencyRepository.saveAllAndFlush(
                cryptocurrencies.stream()
                        .map(cryptocurrencyMapper::dtoToEntity)
                        .toList()
        );
    }
}
