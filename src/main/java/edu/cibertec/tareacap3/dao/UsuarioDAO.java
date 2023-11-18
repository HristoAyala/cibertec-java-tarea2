package edu.cibertec.tareacap3.dao;

import edu.cibertec.tareacap3.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, String> {

    public UsuarioEntity findByUsuarioAndClave(String usuario, String clave);

}
