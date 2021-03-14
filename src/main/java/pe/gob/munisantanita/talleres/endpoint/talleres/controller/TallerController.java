package pe.gob.munisantanita.talleres.endpoint.talleres.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.Taller;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.endpoint.talleres.service.TalleresService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/talleres")
public class TallerController {

    @Autowired
    private TalleresService service;

    @GetMapping
    public Response<List<Taller>> findAll() {
        return new Response<List<Taller>>().setData(service.findAll());
    }


    @GetMapping("/{id}")
    public Response<Taller> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Taller> save(@Valid @RequestBody Taller obj) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Taller> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Taller>().setMessage("La seccion fue eliminado correctamente");
    }

    @PatchMapping
    public Response<Taller> update(@Valid @RequestBody Taller obj) throws ResourceFieldsException {
        return new Response<Taller>().setData(service.update(obj));
    }


    @GetMapping("/contenido/{id}/{idContenido}")
    public Response<List<TallerContenido>> finByIdTallerTipo(@PathVariable int id, @PathVariable int idContenido ){
        return new Response<List<TallerContenido>>().setData(service.finByIdTallerTipo(id, idContenido));
    }


}
