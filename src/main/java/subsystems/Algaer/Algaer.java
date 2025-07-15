package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;

import Manager.ManagerStates;
import edu.wpi.first.wpilibj.XboxController;

import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<ManagerStates>{

    public Algaer() {
        super("algaer", ManagerStates.IDLE);
        
    }
    

    @Override
    protected void runState() {
        Logger.recordOutput("Algaer/state", getState());
    }


}
