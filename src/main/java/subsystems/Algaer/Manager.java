package subsystems.Algaer;

import org.team7525.subsystem.Subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;





public class Manager extends ManagerBase {
    private final XboxController controller = new XboxController(0);
    private final Algaer alger = new Algaer();
        private Algaer algaer;
        public Manager(Algaer algaer) {
            this.algaer = algaer;
            
            addRunnableTrigger(() -> algaer.setState(AlgaerStates.INTAKING), () -> controller.getAButton());
            addRunnableTrigger(() -> algaer.setState(AlgaerStates.SHOOTING), () -> controller.getBButton());
            addRunnableTrigger(() -> algaer.setState(AlgaerStates.IDLE),     () -> controller.getXButton());

}
    }
    
