package com.wudi.redditclone.repo;

import com.wudi.redditclone.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubredditRepo extends JpaRepository<Subreddit,Long> {
}
