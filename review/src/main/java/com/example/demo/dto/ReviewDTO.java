package com.example.demo.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
public class ReviewDTO {

    @NotNull
    private String authorId;

    @Min(1)
    @Max(5)
    @NotNull
    private short score;

    @NotNull
    private String productId;

    private String comment;
}
