package subsystems.Intake;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import subsystems.Intake.IntakeStates;

  
public enum IntakeStates {

    
    IDLE(0, 0),
    INTAKING(1, 190),
    SHOOTING(-1, 190);
    private IntakeStates Currentstate;
  
        public void setState(IntakeStates state) {
        this.Currentstate = state;
    }
    public IntakeStates getState() {
        return this.Currentstate;
    }
    private final int targetSpeed;
    private final int targetPosition;
    private IntakeStates(int targetSpeed, int targetPosition) {
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
