package loginserver;

import loginserver.configs.Config;
import loginserver.controller.BannedIpController;
import loginserver.network.IOServer;
import loginserver.network.ncrypt.KeyGen;
import loginserver.utils.DeadLockDetector;
import loginserver.utils.ThreadPoolManager;
import loginserver.utils.Util;

import org.apache.log4j.Logger;
import commons.database.DatabaseFactory;
import commons.database.dao.DAOManager;
import commons.services.LoggingService;
import commons.utils.AEInfos;
import commons.utils.ExitCode;


/**
 * @author -Nemesiss-
 */
public class LoginServer
{
    /**
     * Logger for this class.
     */
    private static final Logger	log = Logger.getLogger(LoginServer.class);

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    	long start = System.currentTimeMillis();
    	
        LoggingService.init();

		Config.load();

		Util.printSection("DataBase");
		DatabaseFactory.init("./config/network/database.properties");
		DAOManager.init();

        /** Start deadlock detector that will restart server if deadlock happened */
        new DeadLockDetector(60, DeadLockDetector.RESTART).start();
        ThreadPoolManager.getInstance();


        /**
         * Initialize Key Generator
         */
        try
        {
        	Util.printSection("KeyGen");
            KeyGen.init();
        }
        catch (Exception e)
        {
            log.fatal("Failed initializing Key Generator. Reason: " + e.getMessage(), e);
            System.exit(ExitCode.CODE_ERROR);
        }

        Util.printSection("GSTable");
        GameServerTable.load();
        Util.printSection("BannedIP");
        BannedIpController.load();

        // DONE! flood protector
        // TODO! brute force protector

        Util.printSection("IOServer");
        IOServer.getInstance().connect();
        Runtime.getRuntime().addShutdownHook(Shutdown.getInstance());

        Util.printSection("System");
        AEInfos.printAllInfos();
        
        Util.printSection("LoginServerLog");
        log.info("Login Server started in " + (System.currentTimeMillis() - start) / 1000 + " seconds.");
    }
}
