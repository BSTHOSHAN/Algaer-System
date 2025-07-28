package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;



import Manager.ManagerStates;
import edu.wpi.first.wpilibj.XboxController;
import subsystems.Algaer.GlobalConstants.*;

import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<ManagerStates>{

    AlgaerIO io;




    public Algaer() {
        super("algaer", ManagerStates.IDLE);
        switch GlobalConstants.ROBOT_MODE {
            case SIM:
                io = new AlgaerIOSim();
                break;
        
            case:
                io = new AlgaerIOReal();
                break;
        }    
    }


    @Override
    protected void runState() {
        Logger.recordOutput("Algaer/state", getState());

        io.setSpeed(getState().getwheelSpeed());
        io.setPivotAngle(getState().getpivotPosition());
    }


}
