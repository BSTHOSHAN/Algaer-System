package subsystems.Intake; // name the subsystem algaer 💀
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import subsystems.Intake.IntakeStates;

  
public enum IntakeStates {

    
    IDLE(0, 0),
    INTAKING(1, 190), // when using a PID controller, don't use -1 and 1, use actual angular velocity units
    SHOOTING(-1, 190); // ex: rotations per min, radianss per second.
    private IntakeStates Currentstate; // not needed
  
        public void setState(IntakeStates state) {
        this.Currentstate = state;
    }
    public IntakeStates getState() { // not needed
        return this.Currentstate;
    }
    private final int targetSpeed;
    private final int targetPosition; // add a space between this line and the constructor
    private IntakeStates(int targetSpeed, int targetPosition) {
        this.targetSpeed = targetSpeed;
        this.targetPosition = targetPosition;
    }  // space between each method
    public double getTargetSpeed() {
        return targetSpeed;
    }   // space between each method
    public double getTargetPosition() {
        return targetPosition;
    }
    
}
