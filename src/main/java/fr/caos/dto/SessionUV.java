package fr.coas.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import fr.caos.metier.SessionUV_M;

/**
 * @author YANNICK
 * @date 23 févr. 2018
 * @version 1.0.0
 *
 */

@XmlRootElement(name="sessionuv") //for Jersey

public class SessionUV{

    private String idSessionUV;
    private String intitule;
    private String typeUV;
    private List<String> dates;

    //explicit constructor required by the JAX-RS system
    public SessionUV() {}

    //constructor
    public SessionUV(String idSessionUV, String intitule, String typeUV, List<String> dates) {
        this.idSessionUV = idSessionUV;
        this.intitule = intitule;
        this.typeUV = typeUV;
        this.dates = dates;
    }

    // Second constructor wich turns a SessionUV_M to a SessionUV DTO - Quentin
    public SessionUV(SessionUV_M S){
        this.idSessionUV = S.getIdSessionUV();
        this.intitule = S.getIntituleSessionUV();
        this.typeUV = S.getTypeUV().getIntitule();
        this.dates = S.getDates();
    }

//getters and setters
    /**
     * @return the idSessionUV
     */
    public String getIdSessionUV() {
        return idSessionUV;
    }

    /**
     * @param idSessionUV the idSessionUV to set
     */
    public void setIdSessionUV(String idSessionUV) {
        this.idSessionUV = idSessionUV;
    }

    /**
     * @return the intitule
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * @param intitule the intitule to set
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * @return the typeUV
     */
    public String getTypeUV() {
        return typeUV;
    }

    /**
     * @param typeUV the typeUV to set
     */
    public void setTypeUV(String typeUV) {
        this.typeUV = typeUV;
    }

    /**
     * @return the dates
     */
    public List<String> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<String> dates) {
        this.dates = dates;
    }

}
