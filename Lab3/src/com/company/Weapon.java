package com.company;

enum WeaponType{
    Sword,Halebard,Axe;
}
public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;
    private double profitFactor;
    Weapon(){}
    Weapon(WeaponType type){
        this.type=type;
    }
    Weapon(WeaponType type,double weight,double value) {
        this.type=type;
        this.weight=weight;
        this.value=value;
        this.profitFactor=profitFactor();
    }
    public void setName(WeaponType otherName){
        type=otherName;
    }
    public void setWeight(double otherWeight) {
       weight=otherWeight;
       profitFactor=profitFactor();
    }
    public void setValue(double otherValue){
        value=otherValue;
        profitFactor=profitFactor();
    }
    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public double getWeight() {

        return weight;
    }
   @Override
    public double getValue(){

        return value;
   }

}
