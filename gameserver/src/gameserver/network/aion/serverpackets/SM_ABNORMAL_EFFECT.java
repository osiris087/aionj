package gameserver.network.aion.serverpackets;

import gameserver.network.aion.AionConnection;
import gameserver.network.aion.AionServerPacket;
import gameserver.skill.model.Effect;

import java.nio.ByteBuffer;
import java.util.Collection;



/**
 * @author ATracer
 */
public class SM_ABNORMAL_EFFECT extends AionServerPacket
{	
	private int effectedId;
	private int abnormals;
	private Collection<Effect> effects;
	
	public SM_ABNORMAL_EFFECT(int effectedId, int abnormals,  Collection<Effect> effects)
	{
		this.effects = effects;
		this.abnormals = abnormals;
		this.effectedId = effectedId;
	}

	@Override
	protected void writeImpl(AionConnection con, ByteBuffer buf)
	{
		writeD(buf, effectedId); 
		writeC(buf, 1); //unk isdebuff
		writeD(buf, 0); //unk
		writeD(buf, abnormals); //unk
		writeD(buf, 0);//unk 2.5

		writeH(buf, effects.size()); //effects size
		
		for(Effect effect : effects)
		{
			writeH(buf, effect.getSkillId()); 
			writeC(buf, effect.getSkillLevel());
			writeC(buf, effect.getTargetSlot()); 
			writeD(buf, effect.getElapsedTime());
		}

		// some more unknown data is added in 2.0
	}
}