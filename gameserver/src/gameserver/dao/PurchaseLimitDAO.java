package gameserver.dao;

import gameserver.model.gameobjects.player.Player;

import commons.database.dao.DAO;


/**
 * @author ginho1
 *
 */
public abstract class PurchaseLimitDAO implements DAO
{
	@Override
	public final String getClassName()
	{
		 return PurchaseLimitDAO.class.getName();
	}

	public abstract void loadPurchaseLimit(Player player);
	public abstract void deleteAllPurchaseLimit();
	public abstract void savePurchaseLimit(Player player);
	public abstract int loadCountItem(int itemId);
}
