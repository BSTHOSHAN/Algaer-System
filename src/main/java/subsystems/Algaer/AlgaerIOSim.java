package subsystems.Algaer;

import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;



public class AlgaerIOSim implements AlgaerIO {
    SingleJointedArmSim armSim;
    FlywheelSim flywheelSim;
    PIDController speedController;
    PIDController pivotController;


public AlgaerIOSim () {
    speedController = new PIDController(0.1, 0, 0);
    pivotController = new PIDController(0.1, 0, 0);
}

@Override 
public void setSpeed(double speed) {
    flywheelSim.setInputVoltage(speedController.calculate(flywheelSim.getAngularVelocityRPM(), speed));
}
@Override
public void setPivotAngle(double angle) {
    armSim.setInputVoltage(pivotController.calculate(armSim.getAngleRads(), angle));
}
@Override
public boolean getGamePiece() {
    return true;
}
}