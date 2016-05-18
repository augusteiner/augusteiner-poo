
package br.eng.augusteiner.poo.hello.social;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author José Nascimento <joseaugustodearaujonascimento@gmail.com>
 */
public class JTweet {

    private static final String PROGRAM_NAME = JTweet.class.getSimpleName();

    private static final String HELP_OPTION_LONG = "help";
    private static final String HELP_OPTION_SHORT = "h";

    private static final String STATUS_OPTION_LONG = "status";
    private static final String STATUS_OPTION_SHORT = "s";

    private static Options options = new Options();

    static {

        options.addOption(
            HELP_OPTION_SHORT,
            HELP_OPTION_LONG,
            false,
            "Exibir help");

        options.addOption(
            STATUS_OPTION_SHORT,
            STATUS_OPTION_LONG,
            true,
            "Postar tweet");
    }

    /**
     *
     * {@link http://twitter4j.org/en/configuration.html#fileconfiguration}
     *
     * @return
     */
    private static Twitter twitter() {

        // XXX Como executar .jar
        // - requisitos:
        // # arquivo de configuração twitter4j.properties
        // - bash:
        // $ java -jar jtwitter-0.1.0-RELEASE.jar

        return TwitterFactory.getSingleton();
    }

    public static void main(String[] args) {

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {

            try {

                cmd = parser.parse(
                    options,
                    args);

            } catch (UnrecognizedOptionException e) {

                System.out.println(
                    String.format(
                        "%s: unrecognized option '%s'",
                        PROGRAM_NAME,
                        e.getOption()));

                System.out.println(
                    String.format(
                        "Try '%s --help' for more information.",
                        PROGRAM_NAME));

                return;
            }

            if (cmd.hasOption(HELP_OPTION_LONG)) {

                printUsage();
            }

        } catch (ParseException e) {

            e.printStackTrace();
        }

        Twitter twitter = twitter();

        if (cmd.hasOption(STATUS_OPTION_LONG)) {

            String textoTweet = cmd.getOptionValue(STATUS_OPTION_LONG);

            try {

                Status status = twitter.updateStatus(textoTweet);

                System.out.println(String.format(
                    "Veja em: https://twitter.com/%s/status/%s",
                    twitter.showUser(twitter.getScreenName()).getName(),
                    status.getId()));
            } catch (TwitterException e) {

                e.printStackTrace();
            }
        }
    }

    private static void printUsage() {

        HelpFormatter formatter = new HelpFormatter();

        formatter.printHelp(
            PROGRAM_NAME,
            options);
    }
}
