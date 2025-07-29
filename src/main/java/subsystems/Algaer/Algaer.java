package subsystems.Algaer;




import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.GlobalConstants;
import frc.robot.GlobalConstants.*;
import subsystems.Manager.ManagerStates;

import org.littletonrobotics.junction.Logger;
import org.team7525.subsystem.Subsystem;

import edu.wpi.first.math.controller.PIDController;


public class Algaer extends Subsystem<ManagerStates>{

    AlgaerIO io;




    public Algaer() {
        super("algaer", ManagerStates.IDLE);
        switch (GlobalConstants.ROBOT_MODE) {
            case REAL:
                io = new AlgaerIOTalonFX();
                break;
            case SIM:
                io = new AlgaerIOSim();
                break;
            default:
                throw new IllegalArgumentException("Invalid Algaer type: " + GlobalConstants.ROBOT_MODE);
        }
    }


    @Override
    protected void runState() {
        Logger.recordOutput("Algaer/state", getState());

        io.setSpeed(getState().getwheelSpeed());
        io.setPivotAngle(getState().getpivotPosition());
    }


}
