package com.example.umc9th.domain.review.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ReviewCreateReqDTO {
    @NotBlank
    private String reviewContent;
    @NotNull
    @Min(value=0)
    @Max(value=5)
    private Double reviewScore;
    private List<String> reviewImage;
}
