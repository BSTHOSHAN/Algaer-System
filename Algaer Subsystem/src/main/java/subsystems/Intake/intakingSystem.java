package subsystems.Intake;
import static edu.wpi.first.units.Units.Newton;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class intakingSystem {
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(0.1, 0.01, 0.001);
    PIDController WheelPID = new PIDController(0.1, 0.01, 0.001);
    IntakeStates Currentstate = IntakeStates.IDLE;
    public intakingSystem() {
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }
    public void setState(IntakeStates state) {
        this.Currentstate = state;
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }
}
