package playground;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;
import parsers.GameFieldBaseListener;
import parsers.GameFieldLexer;
import parsers.GameFieldParser;
import playground.parser.Game;

import java.io.IOException;

public class GameParserTest {
    /**
     * Test for creating a game instance from file with antlr4
     * @throws IOException
     */
    @Test
    public void createGameFromParsingTest() throws IOException {
        CharStream charStream = new ANTLRInputStream(getClass().getResourceAsStream("/example.field"));
        GameFieldLexer lexer = new GameFieldLexer(charStream);
        GameFieldParser parser = new GameFieldParser(new CommonTokenStream(lexer));

        parser.addErrorListener(new BaseErrorListener());
        final Game game = new Game();


        parser.addParseListener(new GameFieldBaseListener() {

            @Override
            public void exitName(GameFieldParser.NameContext ctx) {
                game.setName(ctx.STRING_VALUE().getText());
            }

            @Override
            public void exitLevel(GameFieldParser.LevelContext ctx) {
                game.setLevel(Integer.parseInt(ctx.INT_VALUE().getText()));
            }
        });

        System.out.println(game);

        parser.game();

        System.out.println(game);
    }
}
