package simulation.model;

import db.data.ISeasonFactory;

public class Season extends ParentObj{

    public Season(){}

    public Season(int id){
        setId(id);
    }

    public Season(int id, ISeasonFactory factory) throws Exception {
        setId(id);
        factory.loadSeasonById(id, this);
    }

    public void addSeason(ISeasonFactory addSeasonFactory) throws Exception {
        addSeasonFactory.addSeason(this);
    }

}