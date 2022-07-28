package api.ServiceImpl;

import api.Entity.Education;

import java.util.List;
import java.util.Optional;

public interface IEducationService {
    /**METODOS**/

    public List<Education> listEducation();
    public Optional<Education> getOne(Long id);
    public void saveEducation (Education curso);
    public void deleteEducation (Long id);
    public boolean existEducationById(Long id);
}
