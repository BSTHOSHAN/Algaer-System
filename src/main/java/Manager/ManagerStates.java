package Manager;
import org.team7525.subsystem.SubsystemStates;

import com.ctre.phoenix6.hardware.TalonFX;

import Manager.ManagerStates;
import edu.wpi.first.math.controller.PIDController;
import subsystems.Algaer.AlgaerStates;

  
public enum ManagerStates implements SubsystemStates {
    IDLE(AlgaerStates.IDLE),
    INTAKING(AlgaerStates.INTAKING),
    SHOOTING(AlgaerStates.SHOOTING);

    private AlgaerStates algaerStates;

    ManagerStates(AlgaerStates algaerStates) {
        this.algaerStates = algaerStates;
    }
    public AlgaerStates getAlgaerStates() {
        return algaerStates;
    }
    
    
}
