package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.exception.NoSuchDbTypeExpetion;

public abstract class DAOFactory {
    public static final int MYSQL_DAO_FACTORY = 1;
    public abstract AnimalDAO getAnimalDAO();
    public abstract UserDAO getUserDAO();
    public abstract ContactDAO getContactDAO();
    public abstract ContactAnimalDAO getContactAnimalDAO();
    public abstract FavoritesDAO getFavoritesDAO();

    public static DAOFactory getDAOFactory()
    {
        DAOFactory factory = null;
        try
        {
            factory = getDAOFactory(MYSQL_DAO_FACTORY);
        } catch (NoSuchDbTypeExpetion noSuchDbTypeExpetion) {
            noSuchDbTypeExpetion.printStackTrace();
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbTypeExpetion
    {
        switch (type)
        {
            case MYSQL_DAO_FACTORY:
                return new MysqlDAOFactory();
            default:
                throw new NoSuchDbTypeExpetion();

        }
    }
}
