package com.example.demo.entity;

import com.example.demo.dto.ReviewDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity
@Table(name = "REVIEW", indexes = {
        @Index(name = "IDX_REVIEW_PRODUCT_ID", columnList = "PRODUCT_ID"),
        @Index(name = "IDX_REVIEW_SCORE", columnList = "SCORE")
})
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "REVIEW_ID_SEQ")
    private long id;

    @Column(name = "AUTHOR_ID", nullable = false)
    @NotNull
    private String authorId;

    @Column(name = "REVIEWED_AT", nullable = false)
    @NotNull
    private LocalDateTime reviewedAt;

    @Column(name = "SCORE", nullable = false)
    @Min(1)
    @Max(5)
    @NotNull
    private short score;

    @Column(name = "PRODUCT_ID", nullable = false)
    @NotNull
    private String productId;

    @Column(name = "COMMENT")
    private String comment;

    public static Review fromDTO(ReviewDTO dto){
        return Review.builder()
                .authorId(dto.getAuthorId())
                .score(dto.getScore())
                .comment(dto.getComment())
                .productId(dto.getProductId())
                .reviewedAt(LocalDateTime.now())
                .build();
    }
    public static void validate(ReviewDTO dto){

    }
}
