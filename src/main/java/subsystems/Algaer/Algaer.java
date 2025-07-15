package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;

import Manager.ManagerStates;
import edu.wpi.first.wpilibj.XboxController;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<ManagerStates>{
    TalonFX Pivotmotor = new TalonFX(1);
    TalonFX Wheelmotor = new TalonFX(2);
    PIDController PivotPID = new PIDController(1, 0., 0);
    PIDController WheelPID = new PIDController(1, 0., 0);
    private final XboxController controller = new XboxController(0); // Initialize with port 0
    AlgaerStates Currentstate = AlgaerStates.IDLE;
    public Algaer() {
        super("algaer", ManagerStates.IDLE);
        Pivotmotor.setVoltage(PivotPID.calculate(Pivotmotor.getPosition().getValueAsDouble(), Currentstate.getTargetSpeed()));
        Wheelmotor.setVoltage(WheelPID.calculate(Wheelmotor.getPosition().getValueAsDouble(), Currentstate.getTargetPosition()));
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
