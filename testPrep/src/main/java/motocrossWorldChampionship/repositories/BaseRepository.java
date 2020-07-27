package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseRepository<T> implements Repository<T> {

    private List<T> models;

    public BaseRepository() {
        this.models = new ArrayList<>();
    }

    public List<T> getModels() {
        return models;
    }
}
