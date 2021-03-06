package com.joelenpastva.Assignment5;

import com.joelenpastva.Assignment5.models.Planet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetController {
    @RequestMapping("/planets")
    public List<Planet> planets()
    {
        return DataStore.listPlanets();
    }

    @GetMapping("/planets/{id}")
    public Planet getPlanetById(@PathVariable(value = "id") int planetId) {
        return DataStore.findPlanetById(planetId);
    }

    @PostMapping("/planets/")
    public Planet createPlanet(@RequestBody Planet planetToAdd) {
        return DataStore.savePlanet(planetToAdd);
    }

    @PutMapping("/planets/{id}")
    public Planet updateExistingPlanet(@PathVariable(value = "id") int planetId,@RequestBody Planet planetToUpdate) {
        return DataStore.updatePlanet(planetId, planetToUpdate);
    }

    @DeleteMapping(value = "/planets/{id}")
    public void delete(@PathVariable(value = "id") int planetId) {
        DataStore.deletePlanet(planetId);
    }
}
