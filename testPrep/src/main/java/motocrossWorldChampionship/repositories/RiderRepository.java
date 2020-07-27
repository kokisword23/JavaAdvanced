package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import java.util.Collection;

public class RiderRepository extends BaseRepository<Rider> {

    @Override
    public Rider getByName(String name) {
        for (Rider rider : this.getModels()) {
            if (rider.getName().equals(name)) {
                return rider;
            }
        }
        return null;
    }

    @Override
    public Collection<Rider> getAll() {
        return this.getModels();
    }

    @Override
    public void add(Rider model) {
        this.getModels().add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.getModels().remove(model);
    }
}
