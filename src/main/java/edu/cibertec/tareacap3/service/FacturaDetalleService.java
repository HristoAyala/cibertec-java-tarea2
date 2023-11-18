package edu.cibertec.tareacap3.service;

import edu.cibertec.tareacap3.dao.FacturaDetalleDAO;
import edu.cibertec.tareacap3.dao.entity.FacturaDetalleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaDetalleService {

    @Autowired
    private FacturaDetalleDAO facturaDetalleDAO;

    public void grabarFacturaDetalle(FacturaDetalleEntity facturaDetalle) {
        facturaDetalleDAO.save(facturaDetalle);
    }
}
