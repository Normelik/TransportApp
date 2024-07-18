package com.transport.backend.repositories;

import com.transport.backend.models.Window;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindowRepository extends JpaRepository<Window, Long> {
}
