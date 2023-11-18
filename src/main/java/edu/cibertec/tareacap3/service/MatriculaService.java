package edu.cibertec.tareacap3.service;

import edu.cibertec.tareacap3.dao.AuditoriaDAO;
import edu.cibertec.tareacap3.dao.MatriculaDAO;
import edu.cibertec.tareacap3.dao.entity.AuditoriaEntity;
import edu.cibertec.tareacap3.dao.entity.MatriculaEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaDAO matriculaDAO;

    @Autowired
    private AuditoriaDAO auditoriaDAO;

    public List<MatriculaEntity> listaTodas() {
        return matriculaDAO.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void grabarMatricula(MatriculaEntity me) {
        matriculaDAO.save(me);
        AuditoriaEntity ae = new AuditoriaEntity(0,new Date(Calendar.getInstance().getTimeInMillis()),
                me.getUsuario(), "Insertando Matricula " + me.getIdMatricula());
        auditoriaDAO.save(ae);
    }
}
