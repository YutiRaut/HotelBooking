package oops;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        BMW bmw = new BMW();
//        main.startBMW(bmw);
        main.startCar(bmw);

        HondaCity hondaCity = new HondaCity();
//        main.startHondaCity(hondaCity);
        main.startCar(hondaCity);

        Audi audi = new Audi();
//        main.startCar(audi);
    }

    public void startCar(Vehical car){
        car.start();
    }

    public void startBMW(BMW bmw) {
        bmw.start();
    }

    public void startHondaCity(HondaCity hondaCity) {
        hondaCity.start();
    }
}
