package com.springboot.gameplay.models.repository;

import com.springboot.gameplay.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
  @Transactional
  @Modifying
  @Query("update Cliente c set c.estado=?1 where c.id=?2")
    public void updateEstado(boolean estado, Long id);
}
