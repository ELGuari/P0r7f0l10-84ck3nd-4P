package api.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "skill")
public class Skill {

    /**PRIMARY KEY**/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Long idSkill;

    /**Demas columnas**/
    @Column
    public String nameSkill;
    @Column
    public Integer levelSkill;


    /**CONSTRUCTOR**/

    public Skill() {
    }

    public Skill(String nameSkill, Integer levelSkill) {
        this.nameSkill = nameSkill;
        this.levelSkill = levelSkill;
    }

    /**RELACION CON TABLA PERSONA**/
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "id_persona")
    private Persona persona;
}