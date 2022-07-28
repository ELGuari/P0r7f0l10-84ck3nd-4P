package api.ServiceImpl;

import api.Entity.Experience;

import java.util.List;
import java.util.Optional;

public interface IExperienceService {

    /**METODOS**/
    List<Experience> listExperience();
    public Optional<Experience> getOne (Long id);
    public void saveExperience(Experience job);
    void deleteExperience (Long id);
    public boolean existExperienceById (Long id);
}
