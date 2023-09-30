package com.truongbn.security.repository;


import com.truongbn.security.dao.request.Keypass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeypassRepository extends JpaRepository<Keypass, Long> {
    List<Keypass> findByEnterpriseId(Long postId);
}
