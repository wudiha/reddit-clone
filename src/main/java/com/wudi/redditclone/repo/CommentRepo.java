package com.wudi.redditclone.repo;

import com.wudi.redditclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
