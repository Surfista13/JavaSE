package fr.eni.parcauto.dal;

import fr.eni.parcauto.dal.sqlserver.VoitureDAOSqlServerimpl;

public class DAOFactory {

    //Méthode permettant d'instancier un objet VoitureDAOSqlServerimpl pour casser la dependance entre la DAL et la BLL
    public static VoitureDAO getVoitureDao() {
        return new VoitureDAOSqlServerimpl();
    }

}
