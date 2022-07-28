package api.Service;

import api.Entity.Education;
import api.Repositories.EducationRepository;
import api.ServiceImpl.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService implements IEducationService {

    @Autowired
    EducationRepository educRepo;


    @Override
    public List<Education> listEducation() {
        return educRepo.findAll();
    }

    @Override
    public Optional<Education> getOne(Long id) {
        return educRepo.findById(id);
    }

    @Override
    public void saveEducation(Education curso) {
        educRepo.save(curso);

    }

    @Override
    public void deleteEducation(Long id) {
        educRepo.deleteById(id);

    }

    @Override
    public boolean existEducationById(Long id) {
        return educRepo.existsById(id);
    }
}
