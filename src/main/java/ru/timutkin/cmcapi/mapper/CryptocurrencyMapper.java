package ru.timutkin.cmcapi.mapper;

import org.mapstruct.Mapper;
import ru.timutkin.cmcapi.entity.Cryptocurrency;

@Mapper(componentModel = "spring")
public interface CryptocurrencyMapper {

    Cryptocurrency dtoToEntity(ru.timutkin.cmcapi.dto.Cryptocurrency cryptocurrency);
}
