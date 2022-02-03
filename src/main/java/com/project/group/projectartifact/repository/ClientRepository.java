package com.project.group.projectartifact.repository;

import com.project.group.projectartifact.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
