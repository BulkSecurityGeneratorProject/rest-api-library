package bo.edu.uasb.service.impl;

import bo.edu.uasb.service.AreaService;
import bo.edu.uasb.domain.Area;
import bo.edu.uasb.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Area.
 */
@Service
@Transactional
public class AreaServiceImpl implements AreaService {

    private final Logger log = LoggerFactory.getLogger(AreaServiceImpl.class);

    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    /**
     * Save a area.
     *
     * @param area the entity to save
     * @return the persisted entity
     */
    @Override
    public Area save(Area area) {
        log.debug("Request to save Area : {}", area);
        return areaRepository.save(area);
    }

    /**
     * Get all the areas.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Area> findAll() {
        log.debug("Request to get all Areas");
        return areaRepository.findAll();
    }

    /**
     * Get one area by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Area> findOne(Long id) {
        log.debug("Request to get Area : {}", id);
        return areaRepository.findById(id);
    }

    /**
     * Delete the area by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Area : {}", id);
        areaRepository.deleteById(id);
    }

    /**
     * Save a area.
     *
     * @param area the entity to save
     * @return the persisted entity
     */
    @Override
    public Area partialSave(Area partialArea) {
        log.debug("Request to save Area : {}", partialArea);
        Optional<Area> area = areaRepository.findById(partialArea.getId());
        if (partialArea.getCode() == null) {
            partialArea.setCode(area.get().getCode());
        }
        if (partialArea.getName() == null) {
            partialArea.setName(area.get().getName());
        }
        if (partialArea.getDescription() == null) {
            partialArea.setDescription(area.get().getDescription());
        }
        if (partialArea.getBooks() == null) {
            partialArea.setBooks(area.get().getBooks());
        }
        return areaRepository.save(partialArea);
    }
}
