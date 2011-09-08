package usercommands;

import gameserver.model.gameobjects.player.Player;
import gameserver.model.gameobjects.stats.modifiers.Executor;
import gameserver.utils.PacketSendUtility;
import gameserver.utils.chathandlers.UserCommand;
import gameserver.world.World;

import java.util.ArrayList;
import java.util.List;



/**
 * @author Sylar
 *
 */
public class GMList extends UserCommand
{
	public GMList ()
	{
		super("gmlist");
	}
	
	@Override
	public void executeCommand(Player player, String params)
	{
		final List<Player> admins = new ArrayList<Player>();
		World.getInstance().doOnAllPlayers(new Executor<Player>(){
			
			@Override
			public boolean run(Player object)
			{
				if(object.getAccessLevel() > 0)
				{
					admins.add(object);
				}
				return true;
			}
		}, true);
		
		if(admins.size() > 0)
		{
			PacketSendUtility.sendMessage(player, admins.size() + " GM(s) online :");
			for(Player a : admins)
			{
				PacketSendUtility.sendMessage(player, a.getName());
			}
		}
		else
			PacketSendUtility.sendMessage(player, "No GM is online currently.");
		
	}

}
