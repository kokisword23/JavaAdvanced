package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import java.util.Collection;

public abstract class MotorcycleRepository extends BaseRepository<Motorcycle> {
    @Override
    public Motorcycle getByName(String name) {
        for (Motorcycle model : this.getModels()) {
            if (model.getModel().equals(name)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return this.getModels();
    }

    @Override
    public void add(Motorcycle model) {
        this.getAll().add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.getModels().remove(model);
    }
}
