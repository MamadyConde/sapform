package fr.caos.metier;


import java.util.ArrayList;
import java.util.List;

public class TypeSession_M {
    private String intitule;
    private int effectifMax;
    private int effectifMin;
    private List<TypeSession_M> list_typePrereq = new ArrayList<TypeSession_M>();
    private List<SessionUV_M> sessions = new ArrayList<SessionUV_M>();

    // Constructors
    public TypeSession_M() {
    }

    public TypeSession_M(String intitule, int effectifMax, int effectifMin) {
        //Note: Je n'ai pas mis le prérequis dans le cas ou ce dernier soit null.
        this.intitule = intitule;
        this.effectifMax = effectifMax;
        this.effectifMin = effectifMin;
    }


    // Getters
    public String getIntitule() {
        return this.intitule;
    }

    public int getEffectifMax() {
        return this.effectifMax;
    }

    public int getEffectifMin() {
        return this.effectifMin;
    }

    public List<TypeSession_M> getList_typePrereq() {
        return list_typePrereq;
    }

    public List<SessionUV_M> getList_sessions() {
        return sessions;
    }

    // Setters
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setEffectifMax(int max) {
        this.effectifMax = max;
    }

    public void setEffectifMin(int min) {
        this.effectifMin = min;
    }

    // ajouter une sessions à la liste de Session
    public void addSessions(SessionUV_M sessions) {
        this.sessions.add(sessions);
    }

    // ajouter des TypeSession prerequis à la liste des prerequis
    public void addTypePrereq(TypeSession_M typeSession) {
        this.list_typePrereq.add(typeSession);
    }
}


