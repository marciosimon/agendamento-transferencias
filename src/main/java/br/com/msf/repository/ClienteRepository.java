package br.com.msf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.msf.model.Cliente;

/**
 * Repositorio de Cliente
 * 
 * @author Márcio Simon
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    /**
     * Retorna uma lista de clientes filtrando pelo nome
     *  
     * @param name
     * @return lista de clientes
     */
    public List<Cliente> findByNome(@Param("name") String name);
	
    /**
     * Retorna o nome do cliente atraves do id.
     * 
     * @param id
     * @return cliente do id passado como parâmetro.
     */   
    @Query("SELECT c.nome FROM Cliente c where c.id = :id") 
    public Cliente findNomeById(@Param("id") Long id);

    /**
     * Retorna o nome do cliente atraves do cpf.
     * 
     * @param id
     * @return cliente do id passado como parâmetro.
     */   
    @Query("SELECT c.nome FROM Cliente c where c.cpf = :cpf") 
    public Cliente findNomeByCpf(@Param("cpf") String cpf);

    /**
     * Retorna uma lista de clientes filtrando pelo nome e ja trazendo ordenada.
     *  
     * @param name
     * @return lista de clientes
     */
    public List<Cliente> findByNomeOrderByNome(@Param("name") String name);
}
