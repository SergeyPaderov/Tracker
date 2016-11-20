package ru.spaderov.start;

import ru.spaderov.models.*;
import java.util.*;

public class Tracker {

    /**
     * All new values will save inside this array of items
     */

    private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random();

    /**
     * Create new item
     */

	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item; 
		return item;
	}

    /**
     * Search method of items by ID
     * @param: item - element of the list
     * @return: Searched item by ID
     */

	protected Item findById(String id) {
		Item result = null;
		for  (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

    /**
     * Search method of items by name
     * @param: item - element of the list
     * @return: Searched item by name
     */

	protected Item findByName(String name) {
		Item result = null;
		for  (Item item : items) {
			if (item != null && item.getName().equals(name)) {
				result = item;
				break;
			}
		}
		return result;
	}

    /**
     * Search method of items by description
     * @param: item - element of the list
     * @return: Searched item by description
     */

	protected Item findByDescription(String description) {
		Item result = null;
		for  (Item item : items) {
			if (item != null && item.getDescription().equals(description)) {
				result = item;
				break;
			}
		}
		return result;
	}
	
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}

    /**
     * Method shows all of items
     * @return items
     */
	public Item[] getAll() {
			Item[] result = new Item[this.position];
			for (int index = 0; index!=this.position; index++) {
				result[index] = this.items[index];
			}
			return result;
	}

    /**
     * Add comment to item
     * @param item - element of the list
     * @return - comment's item
     */

	public Item comment(Item item) {
		item.setComment(this.generateId());
		this.items[position++] = item;
		return item;
	}

    /**
     * Search and edite items by ID
     * @param: items - list of items
     */

	public void editById(Item item) {
		Item result = null;
		for(Item itm:items) {
			if(itm.equals(findById(item.getId()))) {
				result = item;
				result.setName(item.getName());
				result.setDescription(item.getDescription());
			}
		}
	}

    /**
     * Search and erase items by ID
     * @param: items - list of items
     */

	public void deleteById(String id) {

		for (int k = 0; k < items.length; k++) {
			items[k].setId("" + (k + 1));
			if (items[k].getId().equals(id)) {
				items[k].setName(null);
				items[k].setDescription(null);
			}

			for (int i = 0; i < items.length; i++) {
				for (int j = 0; j < items.length; j++) {
					if (items[j].getName() == null) {
						if ((j + 1) <= items.length - 1) {
							Item temp = items[j];
							items[j] = items[j + 1];
							items[j + 1] = temp;
						}
					}
				}

			}
		}
	}

}
