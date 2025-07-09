package subsystems.Algaer;
import static edu.wpi.first.units.Units.Newton;


import com.ctre.phoenix6.hardware.TalonFX;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class intakingSystem extends Subsystem<AlgaerStates>{
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(1, 0., 0);
    PIDController WheelPID = new PIDController(1, 0., 0);
    AlgaerStates Currentstate = AlgaerStates.IDLE;
    public intakingSystem() {
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }

    public void setState(AlgaerStates state) {
        this.Currentstate = state;
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
    }
}
