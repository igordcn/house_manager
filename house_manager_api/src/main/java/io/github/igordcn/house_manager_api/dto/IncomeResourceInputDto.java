package io.github.igordcn.house_manager_api.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class IncomeResourceInputDto {

    @NotBlank(message = "The field 'name' should not be null or blank!")
    private String name;

    @PositiveOrZero(message = "The field 'amount' should not be less than 0!")
    @NotNull(message = "The field 'amount' should not be null!")
    private BigDecimal amount;

    @PastOrPresent(message = "The field 'date' should not be future!")
    private LocalDate date;

    @NotNull(message = "The field 'originId' should not be null!")
    private UUID originId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getOriginId() {
        return originId;
    }

    public void setOriginId(UUID originId) {
        this.originId = originId;
    }

}
