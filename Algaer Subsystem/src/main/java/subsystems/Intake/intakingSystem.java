package subsystems.Intake;
import static edu.wpi.first.units.Units.Newton;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class intakingSystem {
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(0.1, 0.01, 0.001); // you usually don't use an I term on these mechanisms
    PIDController WheelPID = new PIDController(0.1, 0.01, 0.001); // There is usually not steady state error
    IntakeStates Currentstate = IntakeStates.IDLE; // follow camelcase ex: currentState. (first word lowercase, preceding words cap)
    public intakingSystem() { // this is a constructor
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed())); //these two should be a periodic method
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }
    public void setState(IntakeStates state) { //setState should only change the state value
        this.Currentstate = state;
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }
}
