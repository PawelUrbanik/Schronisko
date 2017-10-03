package pl.pawel.schronisko.dao;

import pl.pawel.schronisko.model.Favorites;

public interface FavoritesDAO extends GenericDAO<Favorites, Long> {
    public Favorites getFavoritesByUserIdAnimalId(long userId, long animalId);
}
