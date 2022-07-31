package api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "experience")
public class Experience {

    /**PRIMARY KEY**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**DEMAS COLUMNAS**/

    @Column
    private String jobPosition;
    @Column
    private String jobCompany;
    @Column
    private String jobLocalization;
    @Column
    private String fecha_ini;
    @Column
    private String fecha_fin;
    @Column
    private String jobDescription;


    /**CONSTRUCTOR**/
    public Experience() {
    }

    public Experience(String jobPosition, String jobCompany, String jobDescription, String jobType, String jobLocalization, String fecha_ini, String fecha_fin, String url_imgJob) {
        this.jobPosition = jobPosition;
        this.jobCompany = jobCompany;
        this.jobDescription = jobDescription;
        this.jobLocalization = jobLocalization;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }

    /**RELACION CON TABLA PERSONA**/

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "id_persona")
    @ToString.Exclude
    private Persona persona;

}