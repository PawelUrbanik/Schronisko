package pl.pawel.schronisko.dao;

public class MysqlDAOFactory extends DAOFactory {
    @Override
    public AnimalDAO getAnimalDAO() {
        return new AnimalDAOImpl();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public ContactDAO getContactDAO() {
        return new ContactDAOImpl();
    }

    @Override
    public ContactAnimalDAO getContactAnimalDAO() {
        return new ContactAnimalDAOImpl();
    }

    @Override
    public FavoritesDAO getFavoritesDAO() {
        return new FavoritesDAOImpl();
    }
}
