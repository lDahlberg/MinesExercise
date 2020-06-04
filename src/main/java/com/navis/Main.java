package com.navis;

import com.navis.explodableItems.ExplodableItem;
import com.navis.mappers.MineMapper;
import com.navis.readers.Reader;
import com.navis.readers.impl.TextFileReader;
import com.navis.service.ExplosionService;
import com.navis.service.impl.MineExplosionService;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new TextFileReader();
        List<String> stringOfMines = reader.read(args[0]);

        MineMapper mapper = new MineMapper();
        List<ExplodableItem> mines = mapper.createMines(stringOfMines);

        ExplosionService service = new MineExplosionService();
        List<ExplodableItem> results = service.findGreatestChainReactions(mines);

        System.out.println(results);
    }
}
