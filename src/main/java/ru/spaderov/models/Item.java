package ru.spaderov.models;

import java.lang.*;

public class Item {
	private String id;

	public String name;

	public String description;

	private String comment;

	public long create;

	public Item() {
	}

	public Item(String name, String description, long create, String comment) {
		this.name = name;
		this.description = description;
		this.create = create;
		this.comment = comment;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public long getCreate() {
		return this.create;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setConnect(String connect) {
		this.comment = connect;
	}
}