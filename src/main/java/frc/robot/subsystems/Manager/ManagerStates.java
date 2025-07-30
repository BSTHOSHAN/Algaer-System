package frc.robot.subsystems.Manager;
import org.team7525.subsystem.SubsystemStates;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.Algaer.AlgaerStates;
import frc.robot.subsystems.Manager.ManagerStates;

  
public enum ManagerStates implements SubsystemStates {
    IDLE(AlgaerStates.IDLE),
    INTAKING(AlgaerStates.INTAKING),
    SHOOTING(AlgaerStates.SHOOTING);



    private AlgaerStates algaerStates;

    ManagerStates(AlgaerStates algaerStates) {
        this.algaerStates = algaerStates;
    }
    public AlgaerStates getAlgaerStates() {
        return algaerStates;
    }
    public double getpivotPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getpivotPosition'");
    }
    public double getwheelSpeed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getwheelSpeed'");
    }
    
    
}
