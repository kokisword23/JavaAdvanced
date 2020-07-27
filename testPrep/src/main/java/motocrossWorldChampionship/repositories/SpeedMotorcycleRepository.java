package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.SpeedMotorcycle;

import java.util.Collection;

public class SpeedMotorcycleRepository extends BaseRepository<SpeedMotorcycle> {
    @Override
    public SpeedMotorcycle getByName(String name) {
        for (SpeedMotorcycle model : this.getModels()) {
            if (model.getModel().equals(name)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<SpeedMotorcycle> getAll() {
        return this.getModels();
    }

    @Override
    public void add(SpeedMotorcycle model) {
        this.getModels().add(model);
    }

    @Override
    public boolean remove(SpeedMotorcycle model) {
        return this.getModels().remove(model);
    }
}
