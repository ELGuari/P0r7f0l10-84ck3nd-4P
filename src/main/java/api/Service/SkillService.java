package api.Service;


import api.Entity.Skill;
import api.Repositories.SkillRepository;
import api.ServiceImpl.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements ISkillService {

    @Autowired
    SkillRepository skillRepo;


    @Override
    public List<Skill> listSkill(){

        return skillRepo.findAll();
    }

    @Override
    public Optional<Skill> getOne(Long id) {

        return skillRepo.findById(id);
    }

    @Override
    public void saveSkill(Skill habilidad) {
        skillRepo.save(habilidad);

    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);

    }

    @Override
    public boolean existSkilltById(Long id) {
        return skillRepo.existsById(id);
    }
}
