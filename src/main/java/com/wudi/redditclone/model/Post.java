package com.wudi.redditclone.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Subreddit subreddit;
    private Integer voteCount;
    private Instant createdDate;
}
