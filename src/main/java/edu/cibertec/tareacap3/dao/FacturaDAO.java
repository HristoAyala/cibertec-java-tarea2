package edu.cibertec.tareacap3.dao;

import edu.cibertec.tareacap3.dao.entity.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDAO extends JpaRepository<FacturaEntity, Integer> {
}
