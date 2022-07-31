package api.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name ="project")
public class Project {

    /**PRIMARY KEY**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**DEMAS COLUMNAS**/

    @Column
    private String projectName;
    @Column
    private String projectDescription;
    @Column
    private String fecha;
    @Column
    private String projectUrlImg;
    @Column
    private String linkRepositorio;
    @Column
    private String linkWeb;



    /**CONSTRUCTOR**/

    public Project() {
    }

    public Project(String projectName, String projectDescription, String projectUrlImg, String linkRepositorio, String linkWeb, String fecha) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectUrlImg = projectUrlImg;
        this.linkRepositorio = linkRepositorio;
        this.linkWeb = linkWeb;
        this.fecha = fecha;
    }

    /**RELACION CON TABLA PERSONA**/

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "id_persona")
    @ToString.Exclude
    private Persona persona;

}