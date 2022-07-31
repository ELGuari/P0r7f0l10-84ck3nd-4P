package api.Service;


import api.Entity.Persona;
import api.Repositories.PersonaRepository;
import api.ServiceImpl.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personRepo;

    @Override
    public List<Persona> listPersona() {
        return personRepo.findAll();
    }

    @Override
    public Optional<Persona> getOne(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public void savePersona(Persona perso) {
        personRepo.save(perso);

    }

    @Override
    public void deletePersona(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    public boolean existPersonabyId(Long id) {
        return personRepo.existsById(id);
    }


}
