package org.cap.bim.service;

import org.cap.bim.model.Category;

public interface ICategoryService
{
	public Category saveCategory(Category category);
	public Category getCategoryWithId(Integer catId);
	public Category  updateCatDescription(Integer integer,Category category);

}
