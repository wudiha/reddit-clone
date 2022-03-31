package com.wudi.redditclone.repo;

import com.wudi.redditclone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Long> {
}
