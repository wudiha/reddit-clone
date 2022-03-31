package com.wudi.redditclone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name should not be empty")
    private String name;
    @NotBlank(message = "Description should not be empty")
    private String description;
    @OneToMany(fetch = LAZY)
    private List<Post> posts;
    @ManyToOne(fetch = LAZY)
    private User user;
    private Instant createdDate;

}
