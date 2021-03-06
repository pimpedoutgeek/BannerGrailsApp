package mrhaki.grails

import grails.util.Environment
import org.springframework.boot.Banner
import org.springframework.boot.ansi.AnsiColor

/**
 * Created by david on 11/20/16.
 */
import org.springframework.boot.ansi.AnsiOutput
import org.springframework.boot.ansi.AnsiStyle

import static grails.util.Metadata.current as metaInfo
/**Configuration
 5
 * Class that implements Spring Boot Banner
 * interface to show information on application startup.
 */
class GrailsBanner implements Banner {
/**
 * ASCCI art Grails 3.1 logo built on
 * http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
 */
    private static final String BANNER = $/
  ________             .__.__         ________      ____
 /  _____/___________  |__|  |   _____\_____  \    /_   |
/   \  __\_  __ \__  \ |  |  |  /  ___/ _(__  <     |   |
\    \_\  \  | \// __ \|  |  |__\___ \ /       \    |   |
 \______  /__|  (____  /__|____/____  >______  / /\ |___|
        \/           \/             \/       \/  \/
/$
    @Override
    void printBanner(
            org.springframework.core.env.Environment environment,
            Class<?> sourceClass,
            PrintStream out) {
// Print ASCII art banner with color yellow.
        out.println AnsiOutput.toString(AnsiColor.BRIGHT_YELLOW, BANNER)
// Display extran infomratio about the application.
        row 'App version', metaInfo.getApplicationVersion(), out
        row 'App name', metaInfo.getApplicationName(), out
        row 'Grails version', metaInfo.getGrailsVersion(), out
        row 'Groovy version', GroovySystem.version, out
        row 'JVM version', System.getProperty('java.version'), out
        row 'Reloading active', Environment.reloadingAgentEnabled, out
        row 'Environment', Environment.current.name, out
        out.println()
    }
    private void row(final String description, final value, final PrintStream out) {
        out.print AnsiOutput.toString(AnsiColor.DEFAULT, ':: ')
        out.print AnsiOutput.toString(AnsiColor.GREEN, description.padRight(16))
        out.print AnsiOutput.toString(AnsiColor.DEFAULT, ' :: ')
        out.println AnsiOutput.toString(AnsiColor.BRIGHT_CYAN, AnsiStyle.FAINT, value)
    }
}