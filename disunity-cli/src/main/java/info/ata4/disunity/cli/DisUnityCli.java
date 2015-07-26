/*
 ** 2013 July 05
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.disunity.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import info.ata4.disunity.cli.command.BundleBuildCommand;
import info.ata4.disunity.cli.command.BundleExtractCommand;
import info.ata4.disunity.cli.command.BundleInfoCommand;
import info.ata4.disunity.cli.command.BundleListCommand;
import info.ata4.disunity.cli.command.Command;
import info.ata4.disunity.cli.command.DebugAssetTest;
import info.ata4.disunity.cli.command.DebugBundleCopy;
import info.ata4.disunity.cli.command.DebugBundleMove;
import info.ata4.disunity.cli.command.ExtractCommand;
import info.ata4.disunity.cli.command.InfoCommand;
import info.ata4.disunity.cli.command.LearnCommand;
import info.ata4.disunity.cli.command.ListCommand;
import info.ata4.log.LogUtils;
import info.ata4.unity.DisUnity;
<<<<<<< HEAD

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

=======
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
import org.apache.commons.io.output.CloseShieldOutputStream;

/**
 * DisUnity command line interface.
<<<<<<< HEAD
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DisUnityCli implements Runnable {

    private static final Logger L = LogUtils.getLogger();
    private static final boolean DEBUG = true;

    private final DisUnityOptions opts = new DisUnityOptions();
    private final JCommander jc = new JCommander();

=======
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class DisUnityCli implements Runnable {
    
    private static final Logger L = LogUtils.getLogger();
    private static final boolean DEBUG = true;
    
    private final DisUnityOptions opts = new DisUnityOptions();
    private final JCommander jc = new JCommander();
    
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
    public DisUnityCli() {
        jc.setProgramName(DisUnity.getProgramName());
        jc.addObject(opts);

        // asset commands
//        jc.addCommand(new DumpCmd());
//        jc.addCommand(new DumpStructCmd());
        jc.addCommand(new ExtractCommand());
//        jc.addCommand(new ExtractRawCmd());
//        jc.addCommand(new ExtractTxtCmd());
//        jc.addCommand(new ExtractStructCmd());
        jc.addCommand(new InfoCommand());
//        jc.addCommand(new StatsCmd(out));
        jc.addCommand(new LearnCommand());
        jc.addCommand(new ListCommand());
//        jc.addCommand(new SplitCmd());
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        // bundle commands
        jc.addCommand(new BundleExtractCommand());
        jc.addCommand(new BundleBuildCommand());
        jc.addCommand(new BundleListCommand());
        jc.addCommand(new BundleInfoCommand());
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        // debug commands
        if (DEBUG) {
            jc.addCommand(new DebugAssetTest());
            jc.addCommand(new DebugBundleMove());
            jc.addCommand(new DebugBundleCopy());
        }
    }
<<<<<<< HEAD

    public void parse(String[] args) {
        jc.parse(args);

=======
    
    public void parse(String[] args) {
        jc.parse(args);
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        // display usage
        if (opts.isHelp()) {
            jc.usage();
        }
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        // increase logging level if requested
        if (opts.isVerbose()) {
            LogUtils.configure(Level.ALL);
        }
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        // only print warnings and errors to stderr if the stdout format is not
        // plain text
        if (opts.getOutputFormat() != OutputFormat.PLAINTEXT) {
            LogUtils.configure(Level.WARNING);
        }
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        L.info(DisUnity.getSignature());
    }

    @Override
    public void run() {
        if (opts.isHelp()) {
            return;
        }
<<<<<<< HEAD

=======
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        String cmdName = jc.getParsedCommand();
        if (cmdName == null) {
            jc.usage();
            return;
        }
<<<<<<< HEAD

        JCommander jcc = jc.getCommands().get(cmdName);

=======
        
        JCommander jcc = jc.getCommands().get(cmdName);
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        try (PrintWriter out = new PrintWriter(new CloseShieldOutputStream(System.out), true)) {
            Command cmd = (Command) jcc.getObjects().get(0);
            cmd.setOutputWriter(out);
            cmd.setOptions(opts);
            cmd.run();
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogUtils.configure();
<<<<<<< HEAD

        DisUnityCli cli = new DisUnityCli();
        args = new String[2];
        args[0] = "extract";
        args[1] = "/Users/shuuseiyang/Documents/workspace/unity3d/efcc/";
=======
        
        DisUnityCli cli = new DisUnityCli();
        
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
        try {
            cli.parse(args);
            cli.run();
        } catch (ParameterException ex) {
            L.log(Level.WARNING, "Parameter error: {0}", ex.getMessage());
        } catch (Throwable t) {
            L.log(Level.SEVERE, "Fatal error", t);
        }
<<<<<<< HEAD
//        File file = new File(args[1]);
//        if (file.isDirectory()) {
//            for (String filename : file.list()) {
//                args[1] = file.getAbsolutePath() + File.separator + filename;
//                try {
//                    cli.parse(args);
//                    cli.run();
//                } catch (ParameterException ex) {
//                    L.log(Level.WARNING, "Parameter error: {0}", ex.getMessage());
//                } catch (Throwable t) {
//                    L.log(Level.SEVERE, "Fatal error", t);
//                }
//            }
//
//        } else {
//            try {
//                cli.parse(args);
//                cli.run();
//            } catch (ParameterException ex) {
//                L.log(Level.WARNING, "Parameter error: {0}", ex.getMessage());
//            } catch (Throwable t) {
//                L.log(Level.SEVERE, "Fatal error", t);
//            }
//        }
    }

=======
    }
>>>>>>> 623edb4c109259c6ef4e79c4de3e04bd4b1242f2
}
