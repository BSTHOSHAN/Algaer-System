package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<AlgaerStates>{
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(1, 0., 0);
    PIDController WheelPID = new PIDController(1, 0., 0);
    private final XboxController controller;
    AlgaerStates Currentstate = AlgaerStates.IDLE;
    public Algaer() {
        super("algaer", AlgaerStates.IDLE);
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
        controller = new XboxController(0);
        addTrigger(AlgaerStates.IDLE, AlgaerStates.SHOOTING, controller::getAButtonPressed);
        addTrigger(AlgaerStates.IDLE, AlgaerStates.INTAKING, controller::getBButtonPressed);
        addTrigger(AlgaerStates.SHOOTING, AlgaerStates.IDLE, controller::getAButtonReleased);
        addTrigger(AlgaerStates.INTAKING, AlgaerStates.IDLE, controller::getBButtonReleased);
    }

    @Override
    protected void runState() {
        switch (Currentstate) {
            case IDLE:
                Pivotmotor.setVoltage(0);
                Wheelmotor.setVoltage(0);
                break;
            case INTAKING:
                Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
                Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
                break;
            case SHOOTING:
                Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
                Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
                break;
        }
    }


    @Override
    public void stateInit() {
        Currentstate = AlgaerStates.IDLE; // Initialize to IDLE state
        PivotPID.reset();
        WheelPID.reset();
    }

}
