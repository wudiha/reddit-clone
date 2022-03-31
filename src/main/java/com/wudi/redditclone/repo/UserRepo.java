package com.wudi.redditclone.repo;

import com.wudi.redditclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
