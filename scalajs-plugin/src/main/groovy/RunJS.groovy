import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.TaskAction

/**
 * Created by Guillaume on 09.03.2016.
 */
class RunJSTask extends Exec {
    String description = "Runs the generated js file.\n" +
            "Depends on addMainExec.\n" + "Needs Node.js on PATH."
    File toExec

    @TaskAction
    def runJS() {
        def exec = Os.isFamily(Os.FAMILY_WINDOWS) ? 'cmd' : 'node'
        executable = exec

        args = exec == 'cmd' ? ['/C', 'node', toExec] : [toExec]
    }
}