package org.cap.bim.service;

import org.cap.bim.model.Inventory;
import org.cap.bim.model.State;

public interface IInventoryService 
{
	public Inventory crateNewInventory(Inventory inventory);
	public Inventory findInventoryById(Integer InventoryId);
	public Inventory updatePurchasedById(Integer InventoryId,Inventory inventory);


}
