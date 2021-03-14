package pe.gob.munisantanita.talleres.endpoint.secciones.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.gob.munisantanita.talleres.endpoint.categorias.service.CategoriasService;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Filtro;
import pe.gob.munisantanita.talleres.endpoint.secciones.entity.Seccion;
import pe.gob.munisantanita.talleres.endpoint.talleres.entity.TallerContenido;
import pe.gob.munisantanita.talleres.endpoint.secciones.service.SeccionesService;
import pe.gob.munisantanita.talleres.global.exceptions.ResourceFieldsException;
import pe.gob.munisantanita.talleres.global.models.Response;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/secciones")
public class SeccionesController {

    @Autowired
    private SeccionesService service;

    @Autowired
    private CategoriasService serviceCategorias;



    @GetMapping
    public Response<List<Seccion>> findAll() {
        return new Response<List<Seccion>>().setData(service.findAll());
    }

    @PostMapping("/filter")
    public Response<List<Seccion>> filter(@RequestBody Filtro filtro) throws ResourceFieldsException {
        return new Response<List<Seccion>>().setData(service.filter(filtro));
    }


    @GetMapping("/{id}")
    public Response<Seccion> findById(@Valid @PathVariable Long id) throws ResourceFieldsException {
        return new Response<Seccion>().setData(service.findById(id));
    }

    @PostMapping
    public Response<Seccion> save(@Valid @RequestBody Seccion obj) throws ResourceFieldsException {
        return new Response<Seccion>().setData(service.save(obj)).setMessage("La seccion se registro correctamente");
    }

    @DeleteMapping("/{id}")
    public Response<Seccion> delete(@Valid @PathVariable Long id) {
        service.deleteById(id);
        return new Response<Seccion>().setMessage("La seccion fue eliminado correctamente");
    }
    @PatchMapping
    public Response<Seccion> update(@Valid @RequestBody Seccion obj) throws ResourceFieldsException {
        return new Response<Seccion>().setData(service.update(obj));
    }

    @GetMapping("/categoria/{id}")
    public Response<List<Seccion>> findByIdCategoria(@PathVariable int id){
        return new Response<List<Seccion>>().setData(service.findByIdCategoria(id));
    }

}
