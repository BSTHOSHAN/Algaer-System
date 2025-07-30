package frc.robot.subsystems.Algaer;
import org.team7525.subsystem.SubsystemStates;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.subsystems.Manager.ManagerStates;

  
public enum AlgaerStates implements SubsystemStates {
    IDLE(0, 0),
    INTAKING(1, 190),
    SHOOTING(-1, 190);
    private ManagerStates Currentstate;
  
    private final int targetSpeed;
    private final int targetPosition;
    private AlgaerStates(int targetSpeed, int targetPosition) {
        this.targetSpeed = targetSpeed;
        this.targetPosition = targetPosition;
    } 
    public double getTargetSpeed() {
        return targetSpeed;
    }
    public double getTargetPosition() {
        return targetPosition;
    }
    
}
