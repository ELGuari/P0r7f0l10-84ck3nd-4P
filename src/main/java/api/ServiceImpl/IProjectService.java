package api.ServiceImpl;

import api.Entity.Project;

import java.util.List;
import java.util.Optional;

public interface IProjectService {

    /**METODOS PARA LOS PROJECTS**/

    public List<Project> listProject();
    public Optional<Project> getOne(Long id);
    public void saveProject (Project proyecto);
    public void deleteProject (Long id);
    public boolean existProjectById (Long id);
}
