package bo.edu.uasb.service;

import bo.edu.uasb.domain.Editorial;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Editorial.
 */
public interface EditorialService {

    /**
     * Save a editorial.
     *
     * @param editorial the entity to save
     * @return the persisted entity
     */
    Editorial save(Editorial editorial);

    /**
     * Get all the editorials.
     *
     * @return the list of entities
     */
    List<Editorial> findAll();


    /**
     * Get the "id" editorial.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Editorial> findOne(Long id);

    /**
     * Delete the "id" editorial.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
