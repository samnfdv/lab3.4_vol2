package Record;

import AbstractClass.Character;
import Intarface.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public record CelestialObject(String name,
                              String type,
                              int radius,
                              boolean atmosphere,
                              String politicalRegime)
        implements Location {
    private static final Logger logger = LogManager.getLogger(CelestialObject.class);

    @Override
    public void location(String location) {
        if (location.equals("Moon") || location.equals("Earth")) {
            logger.info("Дело было на {}", location);
        }else {
            logger.info("Незнайка и компаньоны пришли в {}", location);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CelestialObject celestialObject = (CelestialObject) o;
        return radius == celestialObject.radius &&
                atmosphere == celestialObject.atmosphere &&
                name.equals(celestialObject.name) &&
                Objects.equals(type, celestialObject.type) &&
                Objects.equals(politicalRegime, celestialObject.politicalRegime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, radius, atmosphere, politicalRegime);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name  +
                ", type=" + type +
                '}';
    }

}
