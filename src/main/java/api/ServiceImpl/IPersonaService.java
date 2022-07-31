package api.ServiceImpl;

import api.Entity.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {

    /**METODO PARA TRAER TODAS LAS PERSONAS**/
    public List<Persona> listPersona();

    public Optional<Persona> getOne(Long id);

    public void savePersona(Persona persona);

    public void deletePersona(Long id);

    public boolean existPersonabyId(Long id);
}
