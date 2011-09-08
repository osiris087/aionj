package gameserver.network.aion.serverpackets;

import gameserver.network.aion.AionConnection;
import gameserver.network.aion.AionServerPacket;

import java.nio.ByteBuffer;



public class SM_INGAMESHOP_BALANCE extends AionServerPacket
{	
	public SM_INGAMESHOP_BALANCE()
	{
		
	}
	/**
	 * Update the player current currency
	 */
	@Override
	public void writeImpl(AionConnection con, ByteBuffer buf)
	{
		writeQ(buf, con.getActivePlayer().shopMoney);
	}
}
