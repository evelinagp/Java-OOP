package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private AstronautRepository astronauts;
    private PlanetRepository planets;
    int countExploredPlanets;


    public ControllerImpl() {
        this.astronauts = new AstronautRepository();
        this.planets = new PlanetRepository();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;

            default:
                throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }

        this.astronauts.add(astronaut);
        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }


    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        List<String> itemsList = Arrays.asList(items);
        planet.getItems().addAll(itemsList);
        this.planets.add(planet);
        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautForRemove = astronauts.findByName(astronautName);
        if (this.astronauts.getModels().stream().noneMatch(astronaut -> astronaut.getName().equals(astronautName))) {
            throw new IllegalArgumentException(String.format(ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronauts.remove(astronautForRemove);
        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        //всички с кислород над 60
        List<Astronaut> suitableAstronauts = this.astronauts.getModels().stream()
                .filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        int countBeforeMission = suitableAstronauts.size();
        Mission mission = new MissionImpl();
        Planet planet = this.planets.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        countExploredPlanets++;
        int countAfterMission = suitableAstronauts.size();
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, countBeforeMission - countAfterMission);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(REPORT_PLANET_EXPLORED, countExploredPlanets)).append(System.lineSeparator());
        sb.append(REPORT_ASTRONAUT_INFO).append(System.lineSeparator());
        for (Astronaut model : astronauts.getModels()) {
            sb.append(String.format(REPORT_ASTRONAUT_NAME, model.getName())).append(System.lineSeparator());
            sb.append(String.format(REPORT_ASTRONAUT_OXYGEN, model.getOxygen())).append(System.lineSeparator());
            if (model.getBag().getItems().size() != 0) {
                Collection<String> items = model.getBag().getItems();
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, String.join(", ",items))).append(System.lineSeparator());
            } else {
                sb.append(String.format(REPORT_ASTRONAUT_BAG_ITEMS, "none")).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}



