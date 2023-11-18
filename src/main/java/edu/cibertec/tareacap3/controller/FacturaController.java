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
        ModelAndView mv = new ModelAndView("factura", "facturaBean", new FacturaEntity());
        /*mv.addObject("newFactura", new FacturaEntity());
        mv.addObject("detalleList", new ArrayList<FacturaDetalleEntity>());*/
        //mv.addObject("facturaDetalleBean", new FacturaDetalleEntity());
        return mv;
    }

    @RequestMapping("facturaGrabar")
    private ModelAndView facturaGrabar(@ModelAttribute("facturaBean") FacturaEntity entity) {
        facturaService.grabarFactura(entity);
        ModelAndView mv = new ModelAndView("factura", "facturaBean", new FacturaEntity());
        //mv.addObject("facturaDetalleBean", new FacturaDetalleEntity());
        return mv;
    }
}
