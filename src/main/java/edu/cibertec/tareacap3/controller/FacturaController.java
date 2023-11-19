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
        facturaService.grabarFactura(buildMockFacturaEntity());
        ModelAndView mv = new ModelAndView("factura", "facturaBean", buildMockFacturaEntity());
        return mv;
    }

    public FacturaEntity buildFacturaEntity(){
        FacturaEntity fe = new FacturaEntity();

        FacturaDetalleEntity fde1 = new FacturaDetalleEntity();
        FacturaDetalleEntity fde2 = new FacturaDetalleEntity();
        FacturaDetalleEntity fde3 = new FacturaDetalleEntity();

        fde1.setFactura(fe);
        fde2.setFactura(fe);
        fde3.setFactura(fe);

        List<FacturaDetalleEntity> fdList = new ArrayList<FacturaDetalleEntity>();
        fdList.add(fde1);
        fdList.add(fde2);
        fdList.add(fde3);

        fe.setDetalles(fdList);
        return fe;
    }

    public FacturaEntity buildMockFacturaEntity(){
        FacturaEntity fe = new FacturaEntity();
        fe.setNumero("1234599");
        fe.setCliente("1234599");
        fe.setMonto(100.0);
        fe.setFecha("1234599");
        fe.setMoneda("PER");

        FacturaDetalleEntity fde1 = new FacturaDetalleEntity();

        fde1.setIdDetalle(100);
        fde1.setPrecioUnitario(10.0);
        fde1.setCantidad(100);
        fde1.setProducto("dsfsdfds");
        fde1.setParcial(100.0);

        fe.addFacturaDetalle(fde1);

        return fe;
    }
}
