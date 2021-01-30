package cl.jrios.service;

import java.util.List;

import cl.jrios.dto.EntidadFiltradoDTO;
import cl.jrios.model.Entidad;

public interface IEntidadService extends ICRUD<Entidad>{

	List<Entidad> filtrar(EntidadFiltradoDTO obj);
}
