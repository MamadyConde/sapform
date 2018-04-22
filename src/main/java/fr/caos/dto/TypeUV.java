package fr.coas.dto;


import javax.xml.bind.annotation.XmlRootElement;

import fr.caos.metier.TypeSession_M;

import java.util.List;

/**
 * @author YANNICK
 * @date 2 mars 2018
 * @version 1.0.0
 *
 */

@XmlRootElement(name="typeuv") //for Jersey

public class TypeUV {

    private String nomTypeUV;
    private int effectifMax;
    private int effectifMin;
    private List<String> prerequis;

    //explicit constructor required by the JAX-RS system
    public TypeUV() {}

    //constructor
    public TypeUV(String nomTypeUV, int effectifMax, int effectifMin, List<String> prerequis) {
        this.nomTypeUV = nomTypeUV;
        this.effectifMax = effectifMax;
        this.effectifMin = effectifMin;
        this.prerequis = prerequis;
    }

    // Second constructor wich turns a SessionUV_M to a SessionUV DTO - Quentin
    public TypeUV(TypeSession_M T){
        this.nomTypeUV = T.getIntitule();
        this.effectifMax = T.getEffectifMax();
        this.effectifMin = T.getEffectifMin();
        List<TypeSession_M> list_prereq_metier= T.getList_typePrereq();
        for (int i = 0; i < list_prereq_metier.size(); i++) {
            prerequis.add(list_prereq_metier.get(i).getIntitule());
        }
    }

    //getters and setters
    /**
     * @return the nomTypeUV
     */
    public String getNomTypeUV() {
        return nomTypeUV;
    }

    /**
     * @param nomTypeUV the nomTypeUV to set
     */
    public void setNomTypeUV(String nomTypeUV) {
        this.nomTypeUV = nomTypeUV;
    }

    /**
     * @return the effectifMax
     */
    public int getEffectifMax() {
        return effectifMax;
    }

    /**
     * @param effectifMax the effectifMax to set
     */
    public void setEffectifMax(int effectifMax) {
        this.effectifMax = effectifMax;
    }

    /**
     * @return the effectifMin
     */
    public int getEffectifMin() {
        return effectifMin;
    }

    /**
     * @param effectifMin the effectifMin to set
     */
    public void setEffectifMin(int effectifMin) {
        this.effectifMin = effectifMin;
    }

    /**
     * @return the prerequis
     */
    public List<String> getPrerequis() {
        return prerequis;
    }

    /**
     * @param prerequis the prerequis to set
     */
    public void setPrerequis(List<String> prerequis) {
        this.prerequis = prerequis;
    }

}

