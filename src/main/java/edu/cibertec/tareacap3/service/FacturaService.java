package edu.cibertec.tareacap3.service;

import edu.cibertec.tareacap3.dao.FacturaDAO;
import edu.cibertec.tareacap3.dao.entity.FacturaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaDAO facturaDAO;

    public List<FacturaEntity> listarFacturas() {
        return facturaDAO.findAll();
    }

    public void grabarFactura(FacturaEntity factura) {
        facturaDAO.save(factura);
    }
}
