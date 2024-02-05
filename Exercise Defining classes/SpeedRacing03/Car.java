package Exercises_DefiningClasses.SpeedRacing03;

public class Car {
    //"{Model} {FuelAmount} {FuelCostFor1km}"

    private String model;
    private double fuelAmount;
    private  double consumptionFuelPerKm;
    private int distanceTraveled;

    //методи -> действия
    //getters -> осигуряват достъп до полетата
    //конструктор -> метод, чрез който ние създаваме обекти от класа


    public Car(String model, double fuelAmount, double consumptionFuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.consumptionFuelPerKm = consumptionFuelPerKm;
        this.distanceTraveled = 0;
    }

    public boolean drive (int kmDrive){
        // 1. нужно количечство гориво, за да преминем дадените км (kmDrive)
        double needFuel = kmDrive * consumptionFuelPerKm;
             if (needFuel<=this.fuelAmount){
                 //можем да изминем разстоянието
                 this.fuelAmount -= needFuel;
                 distanceTraveled += kmDrive;
                 return true;
             }
             return false;
    }

    @Override
    public String toString() {
        //дава обекта под формата на текст -> "{Model} {fuelAmount} {distanceTraveled}"
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTraveled);
    }
}
