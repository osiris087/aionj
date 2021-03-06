/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */
package chatserver;

import org.apache.log4j.Logger;

import chatserver.AionEngineCS;
import chatserver.configs.Config;
import chatserver.network.netty.NettyServer;
import chatserver.utils.Util;

import commons.services.LoggingService;
import commons.utils.AEInfos;


/**
 * @author ATracer
 */
public class ChatServer
{
	private static final Logger log = Logger.getLogger(ChatServer.class);
	
    public static void main(String[] args)
    {
    	long start = System.currentTimeMillis();
		
    	
        LoggingService.init();
		log.info("Logging Initialized.");
		AionEngineCS.infoCS();
        Util.printSection("Configurations");
		Config.load();
        
		Util.printSection("NettyServer");
        new NettyServer();	

        Util.printSection("System");
        AEInfos.printAllInfos();
        
        Util.printSection("ChatServerLog");
        log.info("Total Boot Time: " + (System.currentTimeMillis() - start) / 1000 + " seconds.");
    }
}
