package io.github.igordcn.house_manager_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record IncomeDto(String name, BigDecimal amount, LocalDate date, UUID originId) {

}
