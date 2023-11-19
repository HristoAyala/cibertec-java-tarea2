package edu.cibertec.tareacap3.controller;

import edu.cibertec.tareacap3.dao.entity.FacturaDetalleEntity;
import edu.cibertec.tareacap3.dao.entity.FacturaEntity;
import edu.cibertec.tareacap3.service.FacturaDetalleService;
import edu.cibertec.tareacap3.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@SessionAttributes("facturaList")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @RequestMapping("facturaCrear")
    private ModelAndView facturaCrear() {
        ModelAndView mv = new ModelAndView("factura", "facturaBean", buildFacturaEntity());
        return mv;
    }

    @RequestMapping("facturaGrabar")
    private ModelAndView facturaGrabar(@ModelAttribute("facturaBean") FacturaEntity entity) {
        facturaService.grabarFactura(populateFacturaEntity(entity));
        ModelAndView mv = new ModelAndView("factura", "facturaBean", buildFacturaEntity());
        return mv;
    }

    public FacturaEntity buildFacturaEntity(){
        FacturaEntity factura = new FacturaEntity();

        for (int i = 0; i < 3; i++) {
            FacturaDetalleEntity detalle = new FacturaDetalleEntity();
            factura.addFacturaDetalle(detalle);
        }
        return factura;
    }

    public FacturaEntity populateFacturaEntity(FacturaEntity entity){
        FacturaEntity factura = new FacturaEntity();
        factura.setNumero(entity.getNumero());
        factura.setCliente(entity.getCliente());
        factura.setMonto(entity.getMonto());
        factura.setFecha(entity.getFecha());
        factura.setMoneda(entity.getMoneda());

        for (int i = 0; i < entity.getDetalles().size(); i++) {
            FacturaDetalleEntity detalle = entity.getDetalles().get(i);
            factura.addFacturaDetalle(detalle);
        }
        return factura;
    }


}
