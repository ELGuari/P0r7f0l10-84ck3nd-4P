package api.Controllers;


import api.Dto.Mensaje;
import api.Entity.Persona;
import api.Entity.Skill;
import api.Repositories.PersonaRepository;
import api.ServiceImpl.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin
public class SkillController {

    @Autowired
    private ISkillService skillServ;

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/details")
    public List<Skill> getSkill(){
        return skillServ.listSkill();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create/{id}")
    public String createSkill (@RequestBody Skill habilidad,
                               @PathVariable Long id){
        Persona persona =personaRepository.getById(id);
        persona.getSkills().add(habilidad);

        skillServ.saveSkill(habilidad);
        return "Skill Creada Correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarSkill(@PathVariable Long id){
        skillServ.deleteSkill(id);
        return "Skill Eliminada Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Skill habilidad){
        Skill dom_skill = skillServ.getOne(id).get();

        dom_skill.setNameSkill(habilidad.getNameSkill());
        dom_skill.setLevelSkill(habilidad.getLevelSkill());

        skillServ.saveSkill(dom_skill);
        return new ResponseEntity(new Mensaje("Skill Actualizada"), HttpStatus.OK);
    }
}
