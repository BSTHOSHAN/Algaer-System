package subsystems.Algaer;
import org.team7525.subsystem.SubsystemStates;

import com.ctre.phoenix6.hardware.TalonFX;

import Manager.ManagerStates;
import edu.wpi.first.math.controller.PIDController;

  
public enum AlgaerStates implements SubsystemStates {
    IDLE(0, 0),
    INTAKING(1, 190),
    SHOOTING(-1, 190);
    private ManagerStates Currentstate;
  
        public void setState(ManagerStates state) {
        this.Currentstate = state;
    }
    public ManagerStates getState() {
        return this.Currentstate;
    }
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
