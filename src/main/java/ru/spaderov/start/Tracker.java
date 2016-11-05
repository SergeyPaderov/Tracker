package ru.spaderov.start;

import ru.spaderov.models.*;
import java.util.*;

public class Tracker {	
	private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random();
	
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item; 
		return item;
	}
	
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
	
	public Item[] getAll() {
			Item[] result = new Item[this.position];
			for (int index = 0; index!=this.position; index++) {
				result[index] = this.items[index];
			}
			return result;
	}

	public Item comment(Item item) {
		item.setComment(this.generateId());
		this.items[position++] = item;
		return item;
	}
}