package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import java.util.Collection;

public class RacerRepository extends BaseRepository<Race> {
    public RacerRepository() {
        super();
    }

    @Override
    public Race getByName(String name) {
        for (Race race : this.getModels()) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection<Race> getAll() {
        return this.getModels();
    }

    @Override
    public void add(Race model) {
        this.getModels().add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.getModels().remove(model);
    }
}
