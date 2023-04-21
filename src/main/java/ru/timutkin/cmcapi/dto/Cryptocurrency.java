package ru.timutkin.cmcapi.dto;

import lombok.*;
import java.util.Date;

@Data
public class Cryptocurrency {
    Date date;
    String name;
    String price;
}
