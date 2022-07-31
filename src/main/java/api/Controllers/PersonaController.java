package api.Controllers;


import api.Dto.Mensaje;
import api.Entity.Persona;
import api.ServiceImpl.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/persona")
@CrossOrigin
public class PersonaController {

    @Autowired
    private IPersonaService persoServ;

    /**DETALLES DE LAS PERSONAS**/
    @GetMapping("/details")
    public List<Persona> getPersonas(){
        return persoServ.listPersona();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public String createPersona (@RequestBody Persona perso){
        persoServ.savePersona(perso);
        return "Persona Creada Correctamente";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable Long id){
        persoServ.deletePersona(id);
        return "Persona Eliminada Correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Persona perso){
        Persona dom_persona = persoServ.getOne(id).get();

        dom_persona.setName(perso.getName());
        dom_persona.setSurname(perso.getSurname());
        dom_persona.setEmail(perso.getEmail());
        dom_persona.setProfession(perso.getProfession());
        dom_persona.setLocalization(perso.getLocalization());
        dom_persona.setFecha_nac(perso.getFecha_nac());
        dom_persona.setUrl_photo(perso.getUrl_photo());
        dom_persona.setUrl_banner(perso.getUrl_banner());
        dom_persona.setAbout_me(perso.getAbout_me());

        persoServ.savePersona(dom_persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);

    }
}