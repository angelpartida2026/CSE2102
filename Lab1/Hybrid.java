public class Hybrid implements ElectricInterface, GasolineInterface {

    private double gasMPG;
    private double MpgE;
    private double miles;
    private double gallons;
    private double kWh;

    private final double MPG_E = 33.7;
    private final double CostPerGallon = 3.5;
    private final double CostPerkWh = 0.24;


    public double calcGasMPG() {
        gasMPG = miles/gallons;
        return gasMPG;
    }

    public double calcMPGe() {
        MpgE = (miles/kWh) * MPG_E;
        return  MpgE;
    }

    public void setMilesfromGas(double miles) {
        this.miles = miles;
    }

    public void setGallonsfromGas(double gallons) {
        this.gallons = gallons;
    }

    public void setElectricMiles(double totalElectricMiles) {
        miles =  totalElectricMiles;
    }

    public void setTotalkWh(double totalkWh) {
        kWh = totalkWh;
    }

    public double calculateGasCost(double miles) {
        double gallonsNeeded = miles / calcGasMPG();
        return gallonsNeeded * CostPerGallon;
    }

    public double calculateElectricCost(double miles) {
        double kWhNeeded = (miles / calcMPGe()) * MPG_E;
        return kWhNeeded * CostPerkWh;
    }

    public double calculateHybridCost(double miles, double gasFraction) {
        double Miles_G = miles * gasFraction;
        double Miles_E = miles * (1 - gasFraction);

        double gasCost = calculateGasCost(Miles_G);
        double electricCost = calculateElectricCost(Miles_E);

        return gasCost + electricCost;
    }

    public double calculateAverageMpg() {
        return (calcGasMPG() + calcMPGe()) / 2;
    }

}
