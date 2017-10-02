package pl.pawel.schronisko.model;

public class Favorites {
    private long favoriteId;
    private long userId;
    private long animalId;

    public Favorites() {
    }

    public Favorites(Favorites favorites)
    {
        this.setFavoriteId(favorites.getFavoriteId());
        this.setUserId(favorites.getUserId());
        this.setAnimalId(favorites.getAnimalId());
    }

    public Favorites(long favoriteId, long userId, long animalId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.animalId = animalId;
    }

    public long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(long animalId) {
        this.animalId = animalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Favorites favorites = (Favorites) o;

        if (favoriteId != favorites.favoriteId) return false;
        if (userId != favorites.userId) return false;
        return animalId == favorites.animalId;
    }

    @Override
    public int hashCode() {
        int result = (int) (favoriteId ^ (favoriteId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (animalId ^ (animalId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "favoriteId=" + favoriteId +
                ", userId=" + userId +
                ", animalId=" + animalId +
                '}';
    }
}
