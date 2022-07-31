package api.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "education")
public class Education {

    /**PRIMARY KEY**/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**DEMAS COLUMNAS**/

    @Column
    private String titulo;
    @Column
    private String institutoName;
    @Column
    private String fecha_ini;
    @Column
    private String linkCertificado;
    @Column
    private String descriptionEducation;

    /**CONSTRUCTOR**/

    public Education() {
    }

    public Education(String titulo, String institutoName, String descriptionEducation, String linkCertificado, String fecha_ini, String fecha_fin) {
        this.titulo = titulo;
        this.institutoName = institutoName;
        this.descriptionEducation = descriptionEducation;
        this.linkCertificado = linkCertificado;
        this.fecha_ini = fecha_ini;
    }

    /**RELACION CON TABLA PERSONA**/
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "id_persona")
    @ToString.Exclude
    private Persona persona;

}