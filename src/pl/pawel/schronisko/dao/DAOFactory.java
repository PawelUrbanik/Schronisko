package pl.pawel.schronisko.dao;

public abstract class DAOFactory {
    public abstract AnimalDAO getAnimalDAO();
    public abstract UserDAO getUserDAO();
    public abstract FavoritesDAO getFavoritesDAO();
}
