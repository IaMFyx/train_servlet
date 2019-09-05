package com.ucar.training.entity;


public class Goods {



  private int id;
  private String goodName;
  private String goodDesc;
  private double goodPrice;
  private int goodInventory;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }


  public String getGoodDesc() {
    return goodDesc;
  }

  public void setGoodDesc(String goodDesc) {
    this.goodDesc = goodDesc;
  }


  public double getGoodPrice() {
    return goodPrice;
  }

  public void setGoodPrice(double goodPrice) {
    this.goodPrice = goodPrice;
  }


  public int getGoodInventory() {
    return goodInventory;
  }

  public void setGoodInventory(int goodInventory) {
    this.goodInventory = goodInventory;
  }
}
