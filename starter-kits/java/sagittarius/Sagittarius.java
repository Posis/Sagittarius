/**
 * Sagittarius - Java Starter Kit
 * Copyright 2013 WillyG Productions
 * @Authors: William Gaul
 */
package sagittarius;

import java.util.HashMap;
import java.io.PrintStream;

public class Sagittarius {

    private SagittariusLinkClient link;
    private String SagPass;
    private HashMap<String, Module> modules;
    private static PrintStream logStream = System.out;
    private static final String LOG_TAG = "Sagittarius";

    public enum ELogLevel {

        LOG_None, LOG_Error, LOG_Warn, LOG_Info, LOG_Debug;
    }
    private static ELogLevel logLevel = ELogLevel.LOG_Debug;
    
    private Sagittarius() {
        // Private for singleton model
        this.link = null;
        this.SagPass = "";
        this.modules = new HashMap<String, Module>();
    }

    /**
     * Private inner class as per the Initialization-on-demand Holder Idiom.
     * See: http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom
     * This method is both lazy and thread-safe.
     */
    private static class SagittariusHolder {
        public static final Sagittarius INSTANCE = new Sagittarius();
    }
    
    public static Sagittarius getInstance() {
        return SagittariusHolder.INSTANCE;
    }
    
    public void Initialize(String AppID, String Pass) {
        this.link = new SagittariusLinkClient(AppID);
        this.SagPass = Pass;
    }

    public void RegisterModule(Module m) {
        modules.put(m.getID(), m);
    }

    public Module GetModule(String ID) {
        Module ret = modules.get(ID);
        if (ret == null) {
            LogWarn("GetModule() - module with ID " + ID + " does not exist");
        }
        return ret;
    }
    
    public void SubmitRequest(SagRequest sr) {
        if (link == null) {
            LogError("SubmitRequest() - did you forget to initialize Sagittarius?");
            return;
        }
        link.TransmitRequest(sr);
    }

    /**
     * CALLBACK FUNCTIONS
     */
    public void OnResponseReceived(String ModuleID, String ActionID, SagResponse resp) {
        if (ModuleID.equals("builtin")) {
            BuiltInOnResponseReceived(ActionID, resp);
            return;
        }
        GetModule(ModuleID).OnResponseReceived(ActionID, resp);
    }
    
    private void BuiltInOnResponseReceived(String ActionID, SagResponse resp) {
        // @TODO: Make more robust
        if (ActionID.equals("mail")) {
            LogInfo("Mail successfully sent!");
        }
    }

    /**
     * MAIL
     */
    public void SendMail(String receiver, String subject, String message, String sender) {
        SagRequest mail = new SagRequest().setDestination("/mail").setModuleInfo("builtin", "mail");
        mail.addURLPair("recv", receiver, false);
        mail.addURLPair("subj", subject, false);
        mail.addURLPair("mesg", message, false);
        if (!sender.equals("")) {
            mail.addURLPair("send", sender, false);
        }
        SubmitRequest(mail);
    }

    /**
     * LOG FUNCTIONS
     */
    public static void SetLogStream(PrintStream ps) {
        logStream = ps;
    }

    public static void SetLogLevel(ELogLevel ll) {
        logLevel = ll;
    }

    private static void log(String msg, String cat, String level) {
        logStream.println("[" + cat + "] " + level + ": " + msg);
    }

    public static void LogError(String msg) {
        LogError(msg, LOG_TAG);
    }

    public static void LogError(String msg, String cat) {
        if (logLevel.ordinal() > 0) {
            log(msg, cat, "ERROR");
        }
    }

    public static void LogWarn(String msg) {
        LogWarn(msg, LOG_TAG);
    }

    public static void LogWarn(String msg, String cat) {
        if (logLevel.ordinal() > 1) {
            log(msg, cat, "WARN");
        }
    }

    public static void LogInfo(String msg) {
        LogInfo(msg, LOG_TAG);
    }

    public static void LogInfo(String msg, String cat) {
        if (logLevel.ordinal() > 2) {
            log(msg, cat, "INFO");
        }
    }

    public static void LogDebug(String msg) {
        LogDebug(msg, LOG_TAG);
    }

    public static void LogDebug(String msg, String cat) {
        if (logLevel.ordinal() > 3) {
            log(msg, cat, "DEBUG");
        }
    }
    
    public String encrypt(String pt) {
        return Encryption.Encrypt(pt, SagPass);
    }

    public String decrypt(String ct) {
        return Encryption.Decrypt(ct, SagPass);
    }
}