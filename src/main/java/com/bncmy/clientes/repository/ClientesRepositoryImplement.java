package com.bncmy.clientes.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public abstract class ClientesRepositoryImplement implements ClientesRepositoryInterface {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public String createCliente(String inputObject) {
        // Inicializar las variables
        Query initQuery = entityManager.createNativeQuery("SET @newClientId = 0; SET @successMessage = '';");
        initQuery.executeUpdate();

        // Llamar al procedimiento almacenado
        Query callProcedure = entityManager.createNativeQuery("CALL AddClient(:clientData, @newClientId, @successMessage)");
        callProcedure.setParameter("clientData", inputObject);
        callProcedure.executeUpdate();

        // Recuperar el valor de successMessage
        Query getSuccessMessageQuery = entityManager.createNativeQuery("SELECT @successMessage");
        return (String) getSuccessMessageQuery.getSingleResult();
    }

    public Map<String, Object> findClienteById(Long id) throws Exception{
        try {
            String sql = "SELECT c.*, dp.nombre, dp.apellido_pat, dp.apellido_mat, dm.* " +
                    "FROM clientes c " +
                    "JOIN datospersonales dp ON c.datospersonales_id = dp.datosid " +
                    "JOIN domicilio dm ON dm.domicilioid = dp.domicilio_id " +
                    "WHERE c.clienteid = :id";

            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("id", id);

            // Obtener el resultado de la consulta
            Object[] result = (Object[]) query.getSingleResult();
            if(Arrays.stream(result).count()>0){
                // Construir el Map de manera compacta
                String[] keys = {"clienteid", "datospersonales_id", "other_field",
                        "nombre", "apellido_pat", "apellido_mat",
                        "domicilioid", "calle", "numero", "colonia"};

                return IntStream.range(0, keys.length)
                        .boxed()
                        .collect(Collectors.toMap(i -> keys[i], i -> result[i]));
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public List<Map<String, Object>> findClientes() throws Exception {
        try {
            String sql = "SELECT c.*, dp.nombre, dp.apellido_pat, dp.apellido_mat, dm.* " +
                         "FROM clientes c " +
                         "JOIN datospersonales dp ON c.datospersonales_id = dp.datosid " +
                         "JOIN domicilio dm ON dm.domicilioid = dp.domicilio_id";

            Query query = entityManager.createNativeQuery(sql);

            // Obtener el resultado de la consulta
            @SuppressWarnings("unchecked")
			List<Object[]> results = query.getResultList(); // Get list of results

            if (!results.isEmpty()) {
                String[] keys = {"clienteid", "datospersonales_id", "other_field",
                                 "nombre", "apellido_pat", "apellido_mat",
                                 "domicilioid", "calle", "numero", "colonia"};

                List<Map<String, Object>> resultList = new ArrayList<>();

                for (Object[] result : results) {
                    Map<String, Object> rowMap = IntStream.range(0, keys.length)
                            .boxed()
                            .collect(Collectors.toMap(i -> keys[i], i -> result[i]));
                    resultList.add(rowMap);
                }

                return resultList;
            } else {
                return new ArrayList<>(); // Return an empty list instead of null
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    
}

