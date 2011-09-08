package gameserver.dataholders;

import gameserver.model.templates.shield.ShieldTemplate;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author blakawk
 *
 */
@XmlRootElement(name = "shields")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShieldData
{
	@XmlElement(name = "shield")
	private List<ShieldTemplate> shieldTemplates;
	
	public int size ()
	{
		return shieldTemplates.size();
	}

	public List<ShieldTemplate> getSchieldTemplates()
	{
		return shieldTemplates;
	}
}
