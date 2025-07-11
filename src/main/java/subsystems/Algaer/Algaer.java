package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<ManagerStates>{
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(1, 0., 0);
    PIDController WheelPID = new PIDController(1, 0., 0);
    private final XboxController controller;
    AlgaerStates Currentstate = AlgaerStates.IDLE;
    public Algaer() {
        super("algaer", ManagerStates.IDLE);
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
        controller = new XboxController(0);
        addTrigger(ManagerStates.IDLE, ManagerStates.SHOOTING, controller::getAButtonPressed);
        addTrigger(ManagerStates.IDLE, ManagerStates.INTAKING, controller::getBButtonPressed);
        addTrigger(ManagerStates.SHOOTING, ManagerStates.IDLE, controller::getAButtonReleased);
        addTrigger(ManagerStates.INTAKING, ManagerStates.IDLE, controller::getBButtonReleased);
    }

    @Override
    protected void runState() {
        
    }


    @Override
    public void stateInit() {
        Currentstate = AlgaerStates.IDLE; // Initialize to IDLE state
        PivotPID.reset();
        WheelPID.reset();
    }

}
