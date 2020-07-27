package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import java.util.Collection;

public class PowerMotorcycleRepository extends BaseRepository<PowerMotorcycle> {


    @Override
    public PowerMotorcycle getByName(String name) {
        return null;
    }

    @Override
    public Collection<PowerMotorcycle> getAll() {
        return this.getModels();
    }

    @Override
    public void add(PowerMotorcycle model) {
        this.getModels().add(model);
    }

    @Override
    public boolean remove(PowerMotorcycle model) {
        return this.getModels().remove(model);
    }
}
