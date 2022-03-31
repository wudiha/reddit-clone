package com.wudi.redditclone.model;


import com.wudi.redditclone.enums.VoteEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;
    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId",referencedColumnName = "postId")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
    private VoteEnum voteType;
}
