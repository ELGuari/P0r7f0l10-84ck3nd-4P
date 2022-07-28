package api.ServiceImpl;

import api.Entity.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {

    public List<Skill> listSkill();
    public Optional<Skill> getOne(Long id);
    public void saveSkill (Skill habilidad);
    public void deleteSkill (Long id);
    public boolean existSkilltById (Long id);

}
