package com.wudi.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Comment cannot be empty")
    private String text;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId",referencedColumnName = "postID")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
    private Instant createdDate;

}
