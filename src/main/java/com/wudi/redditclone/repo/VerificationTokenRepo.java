package com.wudi.redditclone.repo;

import com.wudi.redditclone.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepo extends JpaRepository<VerificationToken,Long> {
}
