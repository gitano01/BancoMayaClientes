package com.bncmy.clientes.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bncmy.clientes.model.Clientes;


public interface ClientesRepositoryInterface extends JpaRepository<Clientes,Long>{

    @Query(value="select c.id as clienteid,c.fecha_crea, c.fecha_mod, c.datospersonales_id,c.estatus,\r\n"
    		+ "dp.nombre,dp.apellido_pat,dp.apellido_mat,dm.id as domicilioid, dm.calle,dm.colonia,dm.cod_postal,dm.delegacion,dm.estado,dm.ciudad,dm.pais from clientes c \r\n"
    		+ "join datospersonales dp ON c.datospersonales_id = dp.id join domicilio dm ON dm.id = dp.domicilio_id" +
            " where c.id = ?", nativeQuery = true)
    public Map<String, Object> findClienteById(Long id)throws Exception;

    @Query(value = "CALL AddClient(:clientData, @newClientId , @successMessage)", nativeQuery = true)
    public String createCliente(@Param("clientData") String inputObject);
    
    @Query(value="select c.id as clienteid,c.fecha_crea, c.fecha_mod, c.datospersonales_id,c.estatus,\r\n"
    		+ "dp.nombre,dp.apellido_pat,dp.apellido_mat,dm.id as domicilioid, dm.calle,dm.colonia,dm.cod_postal,dm.delegacion,dm.estado,dm.ciudad,dm.pais from clientes c \r\n"
    		+ "join datospersonales dp ON c.datospersonales_id = dp.id join domicilio dm ON dm.id = dp.domicilio_id ", nativeQuery = true)
    public List<Map<String, Object>> findClientes()throws Exception;
    

	
}
