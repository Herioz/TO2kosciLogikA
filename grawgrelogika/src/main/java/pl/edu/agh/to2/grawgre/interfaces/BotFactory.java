package pl.edu.agh.to2.grawgre.interfaces;

import pl.edu.agh.to2.grawgre.model.Configuration;

import java.util.List;

/**
 * Created by luke on 06.01.17.
 */
public interface BotFactory {

    List<Bot> makeBots(Configuration configuration);

}
