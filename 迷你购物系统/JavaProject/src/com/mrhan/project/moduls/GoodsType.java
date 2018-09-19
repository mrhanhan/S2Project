package com.mrhan.project.moduls;
/**
 * 商品类型
 * @author MrHanHao
 *
 */
public class GoodsType {
	private int id;
	private String name;
	
	public GoodsType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public GoodsType( String name) {
		super();
	
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", name=" + name + "]";
	}
	
	
}
