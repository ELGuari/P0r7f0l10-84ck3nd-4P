package api.Controllers;


import api.Dto.Mensaje;
import api.Entity.Persona;
import api.Entity.Project;
import api.Repositories.PersonaRepository;
import api.ServiceImpl.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private IProjectService projecServ;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/details")
    public List<Project> getProjects(){
        return projecServ.listProject();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createProject (@RequestBody Project proyecto,
                                 @PathVariable Long id){
        Persona persona = personaRepository.getById(id);
        persona.getProjects().add(proyecto);
        projecServ.saveProject(proyecto);
        return "Project Creado Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarProject(@PathVariable Long id){
        projecServ.deleteProject(id);
        return "Project Eliminado Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody Project proyecto){
        Project dom_project = projecServ.getOne(id).get();

        dom_project.setProjectName(proyecto.getProjectName());
        dom_project.setProjectDescription(proyecto.getProjectDescription());
        dom_project.setProjectUrlImg(proyecto.getProjectUrlImg());
        dom_project.setLinkRepositorio(proyecto.getLinkRepositorio());
        dom_project.setLinkWeb(proyecto.getLinkWeb());
        dom_project.setFecha(proyecto.getFecha());

       projecServ.saveProject(dom_project);
       return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }

}
