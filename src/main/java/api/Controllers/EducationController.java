package api.Controllers;


import api.Dto.Mensaje;
import api.Entity.Education;
import api.Entity.Persona;
import api.Repositories.PersonaRepository;
import api.ServiceImpl.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/education")
@CrossOrigin
public class EducationController {

    @Autowired
    private IEducationService educServ;

    @Autowired
    PersonaRepository personaRepository;


    @GetMapping("/details")
    public List<Education> getEducation(){
        return educServ.listEducation();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createEducation (@RequestBody Education curso,
                                   @PathVariable Long id){
        Persona persona = personaRepository.getById(id);
        persona.getEducations().add(curso);
        educServ.saveEducation(curso);
        return "Education Creada Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarEducation (@PathVariable Long id){
        educServ.deleteEducation(id);
        return "Education eliminada Correctamente";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") Long id, @RequestBody Education curso){
        Education dom_curso = educServ.getOne(id).get();

        dom_curso.setTitulo(curso.getTitulo());
        dom_curso.setInstitutoName(curso.getInstitutoName());
        dom_curso.setDescriptionEducation(curso.getDescriptionEducation());
        dom_curso.setLinkCertificado(curso.getLinkCertificado());
        dom_curso.setFecha_ini(curso.getFecha_ini());

        educServ.saveEducation(dom_curso);
        return new ResponseEntity( new Mensaje("Education Actualizada"), HttpStatus.OK);
    }
}
