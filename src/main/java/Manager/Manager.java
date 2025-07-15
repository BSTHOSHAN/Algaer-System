package Manager;

import org.team7525.subsystem.Subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import subsystems.Algaer.Algaer;





public class Manager extends Subsystem<ManagerStates> {
    private final XboxController controller = new XboxController(0);
    private final Algaer alger = new Algaer();
        private Algaer algaer;
        public Manager(Algaer algaer) {
            super("manager", ManagerStates.IDLE);  
            this.algaer = algaer;
            
            addRunnableTrigger(() -> algaer.setState(ManagerStates.INTAKING), () -> controller.getAButton());
            addRunnableTrigger(() -> algaer.setState(ManagerStates.SHOOTING), () -> controller.getBButton());
            addRunnableTrigger(() -> algaer.setState(ManagerStates.IDLE),     () -> controller.getXButton());

}
        @Override
        protected void runState() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'runState'");
        }
        public static void runAllPeriodic() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'runAllPeriodic'");
        }
    }
    
